/**
 * Created by Max on 05.11.2016.
 */
public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String brand, int batteryCapacity) {
        super(brand);
        this.setTaxNeeded(false);
	    this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return this.brand + " - " + this.batteryCapacity + " kWh";
    }
}
