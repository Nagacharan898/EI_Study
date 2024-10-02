import java.util.Scanner;

class LegacySystem {
    public void performTask() {
        System.out.println("Performing task in the legacy system.");
    }
}

interface ModernSystem {
    void executeTask();
}

class SystemAdapter implements ModernSystem {
    private LegacySystem legacySystem;

    public SystemAdapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public void executeTask() {
        legacySystem.performTask();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        LegacySystem legacySystem = new LegacySystem();
        ModernSystem modernSystem = new SystemAdapter(legacySystem);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'perform' to execute the task or 'exit' to quit: ");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("perform")) {
            modernSystem.executeTask();
        } else {
            System.out.println("Exiting...");
        }

        scanner.close();
    }
}
