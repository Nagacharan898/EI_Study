import java.util.Scanner;

interface Beverage {
    String getDescription();
    double cost();
}

class BasicCoffee implements Beverage {
    public String getDescription() {
        return "Basic Coffee";
    }

    public double cost() {
        return 5.0;
    }
}

abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription();
    }

    public double cost() {
        return beverage.cost();
    }
}

class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double cost() {
        return super.cost() + 1.5;
    }
}

class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double cost() {
        return super.cost() + 0.5;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Beverage beverage = new BasicCoffee();
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have a Basic Coffee. Add 'milk', 'sugar', or type 'done' to finish.");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("milk")) {
            beverage = new MilkDecorator(beverage);
        } else if (choice.equalsIgnoreCase("sugar")) {
            beverage = new SugarDecorator(beverage);
        } else if (!choice.equalsIgnoreCase("done")) {
            System.out.println("Invalid choice.");
        }

        System.out.println("Final Beverage: " + beverage.getDescription());
        System.out.println("Total Cost: $" + beverage.cost());

        scanner.close();
    }
}
