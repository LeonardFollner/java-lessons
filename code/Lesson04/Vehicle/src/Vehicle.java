/**
 * Created by Max on 05.11.2016.
 */
public abstract class Vehicle {
    private int wheels;
    protected String brand;

    private boolean taxNeeded = true;

    public boolean isTaxNeeded() {
        return taxNeeded;
    }

    public void setTaxNeeded(boolean taxNeeded) {
        this.taxNeeded = taxNeeded;
    }

    public int getNumberOfWheels() {
        return wheels;
    }

    public Vehicle(String brand, int wheels) {
        this.brand = brand;
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return this.brand;
    }
}
