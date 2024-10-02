import java.util.Scanner;

class LogManager {
    private static LogManager instance;

    private LogManager() {
    }

    public static LogManager getInstance() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your log message (type 'exit' to quit): ");
        String message = scanner.nextLine();

        if (!message.equalsIgnoreCase("exit")) {
            logManager.log(message);
        } else {
            System.out.println("Exiting the application.");
        }

        scanner.close();
    }
}
