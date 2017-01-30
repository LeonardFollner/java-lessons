import com.sun.corba.se.impl.oa.poa.POAImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Max Langer
 * This is the class which manages all UI related stuff of the Minesweeper game
 *
 */

public class WindowController {

    private JFrame window;
    private Minesweeper minesweeper;
    private JButton[][] fields;

    /**
     * The constructor which creates the window and its contents
     * @param x defines the number of fields in x direction
     * @param y defines the number of fields in y direction
     * @param minesweeper the minesweeper game
     * @param windowLocation the location where the window should be drawn
     */

    public WindowController(int x, int y, Minesweeper minesweeper, Point windowLocation) {
        this.minesweeper = minesweeper;

        int borderMargin = 20;
        int buttonSize = 30;

        fields = new JButton[x][y];

        // Create menu bar and items..
        MenuBar bar = new MenuBar();
        Menu menu = new Menu("File");

        MenuItem restartItem = new MenuItem("Restart Game");
        restartItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minesweeper.restartGame();
            }
        });

        MenuItem startItem = new MenuItem("Start new Game");
        startItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point windowLocation = window.getLocation();
                minesweeper.getManager().newGame(new Point(windowLocation.x + 20, windowLocation.y + 20));
            }
        });

        MenuItem saveItem = new MenuItem("Save game");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnValue = chooser.showSaveDialog(window);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File savedFile = chooser.getSelectedFile();

                    if (savedFile.exists()) {
                        System.out.println("File already exists!");
                        return;
                    }

                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(savedFile));
                        String data = minesweeper.saveGame();
                        writer.write(data, 0, data.length());
                        writer.close();
                    } catch (IOException e1) {
                        System.out.println("Something went wrong");
                    }
                }
            }
        });

        MenuItem loadItem = new MenuItem("Load game");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnValue = chooser.showOpenDialog(WindowController.this.window);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();

                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }

                    ArrayList<String> data = new ArrayList<String>();
                    String line = "";

                    while (line != null) {
                        if (!line.equals("")) {
                            data.add(line);
                        }

                        try {
                            line = reader.readLine();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }

                    Point windowLocation = window.getLocation();
                    Minesweeper game = minesweeper.getManager().newGame(new Point(windowLocation.x + 20, windowLocation.y + 20));
                    game.loadGame(data);
                }
            }
        });

        menu.add(startItem);
        menu.add(restartItem);
        menu.add(saveItem);
        menu.add(loadItem);

        bar.add(menu);

        window = new JFrame();
        window.setMenuBar(bar);
        window.setResizable(false);
        window.setTitle("Minesweeper");
        window.setLocation(windowLocation);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(borderMargin, borderMargin, borderMargin, borderMargin));
        window.add(contentPanel);

        // Calculate window size
        int width = buttonSize * x + (2 * borderMargin);
        int height = buttonSize * y + (2 * borderMargin);

        JPanel minefield = new JPanel();
        minefield.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        minefield.setLayout(new GridLayout(x, y));
        minefield.setMaximumSize(new Dimension(width, height));

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                JButton mineButton = new JButton("");
                mineButton.setMaximumSize(new Dimension(buttonSize, buttonSize));
                mineButton.setOpaque(true);
                mineButton.setPreferredSize(mineButton.getMaximumSize());
                mineButton.setBackground(Color.GRAY);

                int ii = i;
                int jj = j;

                mineButton.addMouseListener(new MouseAdapter(){
                    boolean pressed;

                    @Override
                    public void mousePressed(MouseEvent e) {
                        mineButton.getModel().setArmed(true);
                        mineButton.getModel().setPressed(true);
                        pressed = true;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        mineButton.getModel().setArmed(false);

                        if (pressed) {
                            minesweeper.clickField(ii, jj, SwingUtilities.isRightMouseButton(e));
                        }
                        pressed = false;

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        pressed = false;
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        pressed = true;
                    }
                });

                minefield.add(mineButton);
                fields[i][j] = mineButton;
            }
        }

        contentPanel.add(minefield);

        window.setSize(width, height + 22);
        contentPanel.setMaximumSize(new Dimension(width, height));

        window.setVisible(true);
    }

    /**
     * This method updates the appearance of one "Field" to match its current state in the game
     * @param field the field to be updated
     */

    public void updateField(Field field) {
        JButton button = fields[field.getPositionX()][field.getPositionY()];

        if (!button.isEnabled()) {
            return;
        }

        switch (field.getStatus()) {
            case COVERED:
                button.setIcon(null);
                break;
            case FLAGGED:
                try {
                    Image flag = ImageIO.read(getClass().getResource("resources/flag.png"));
                    flag = flag.getScaledInstance(15, 15, 0);
                    button.setIcon(new ImageIcon(flag));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case OPENED:
                if(field.getNumber() != 0) {
                    button.setText(String.valueOf(field.getNumber()));
                }

                button.setEnabled(false);
                break;
        }

        if (field.getType() == Field.Type.BOMB && field.getStatus() != Field.Status.COVERED && field.getStatus() != Field.Status.FLAGGED) {
            button.setText("B");
            button.setEnabled(false);
            button.setForeground(Color.RED);
        }
    }

    /**
     * This method closes the window
     * @return the location of the window
     */
    public Point hideWindow() {
        Point point = this.window.getLocation();
        this.window.dispose();

        return point;
    }

}
