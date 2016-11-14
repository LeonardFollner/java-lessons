/**
 * Created by Max on 05.11.2016.
 */
public class Garage {

    public static void main(String[] args) {
        Car audi = new Car("Audi");
        ElectricCar tesla = new ElectricCar("Tesla", 100);
        Motorcycle harley = new Motorcycle("Harley");

        System.out.println(audi);
        System.out.println("Tax needed: " + audi.isTaxNeeded());
        System.out.println("Number of wheels: " + audi.getNumberOfWheels());

        System.out.println(tesla);
        System.out.println("Tax needed: " + tesla.isTaxNeeded());
        System.out.println("Number of wheels: " + tesla.getNumberOfWheels());

        System.out.println(harley);
        System.out.println("Tax needed: " + harley.isTaxNeeded());
        System.out.println("Number of wheels: " + harley.getNumberOfWheels());
    }
}
