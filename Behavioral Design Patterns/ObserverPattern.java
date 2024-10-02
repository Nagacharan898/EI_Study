import java.util.Scanner;

interface SpaceObserver {
    void onSpaceStatusChange(boolean isOccupied);
}

class CoolingSystem implements SpaceObserver {
    public void onSpaceStatusChange(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Cooling System: ON");
        } else {
            System.out.println("Cooling System: OFF");
        }
    }
}

class LightingControl implements SpaceObserver {
    public void onSpaceStatusChange(boolean isOccupied) {
        if (isOccupied) {
            System.out.println("Lighting: ON");
        } else {
            System.out.println("Lighting: OFF");
        }
    }
}

class Workspace {
    private boolean isOccupied = false;
    private SpaceObserver coolingSystem = new CoolingSystem();
    private SpaceObserver lightingControl = new LightingControl();

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
        notifyObservers();
    }

    private void notifyObservers() {
        coolingSystem.onSpaceStatusChange(isOccupied);
        lightingControl.onSpaceStatusChange(isOccupied);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Workspace conferenceRoom = new Workspace();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'occupy' to occupy the room or 'vacate' to vacate the room:");
        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("occupy")) {
            conferenceRoom.setOccupied(true);
        } else if (command.equalsIgnoreCase("vacate")) {
            conferenceRoom.setOccupied(false);
        } else {
            System.out.println("Invalid command.");
        }

        scanner.close();
    }
}
