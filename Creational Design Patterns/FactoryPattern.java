import java.util.Scanner;

interface Automobile {
    void drive();
}

class SedanCar implements Automobile {
    public void drive() {
        System.out.println("Driving a Sedan.");
    }
}

class SUVCar implements Automobile {
    public void drive() {
        System.out.println("Driving an SUV.");
    }
}

class CarFactory {
    public static Automobile getAutomobile(String automobileType) {
        if (automobileType.equalsIgnoreCase("SUV")) {
            return new SUVCar();
        } else if (automobileType.equalsIgnoreCase("Sedan")) {
            return new SedanCar();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of car you want to create (Sedan/SUV): ");
        String automobileType = scanner.nextLine();

        Automobile automobile = CarFactory.getAutomobile(automobileType);

        if (automobile != null) {
            automobile.drive();
        } else {
            System.out.println("Invalid car type. Please enter either 'Sedan' or 'SUV'.");
        }

        scanner.close();
    }
}
