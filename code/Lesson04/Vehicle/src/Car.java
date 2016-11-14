/**
 * Created by Max on 05.11.2016.
 */
public class Car extends Vehicle {
    public Car(String brand) {
        super(brand, 4);
    }

    private boolean hasAutopilot;

    public boolean hasAutopilot() {
        return this.hasAutopilot;
    }

    public void setAutopilot(boolean autopilot) {
        this.hasAutopilot = autopilot;
    }
}
