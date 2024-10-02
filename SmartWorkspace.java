import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface SpaceObserver {
    void onSpaceStatusChange(boolean isOccupied);
}

class CoolingSystem implements SpaceObserver {
    public void onSpaceStatusChange(boolean isOccupied) {
        System.out.println("Cooling System: " + (isOccupied ? "ON" : "OFF"));
    }
}

class LightingControl implements SpaceObserver {
    public void onSpaceStatusChange(boolean isOccupied) {
        System.out.println("Lighting: " + (isOccupied ? "ON" : "OFF"));
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

class FacilityManagement {
    private Map<Integer, Workspace> workspaces = new HashMap<>();
    private int workspaceCount = 0;

    public void addWorkspace(String workspaceName) {
        workspaceCount++;
        workspaces.put(workspaceCount, new Workspace());
        System.out.println("Workspace " + workspaceName + " added successfully.");
    }

    public void bookWorkspace(int workspaceId) {
        if (workspaces.containsKey(workspaceId)) {
            Workspace workspace = workspaces.get(workspaceId);
            workspace.setOccupied(true);
            System.out.println("Workspace " + workspaceId + " is now booked and occupied.");
        } else {
            System.out.println("Invalid workspace ID. Please try again.");
        }
    }

    public void vacateWorkspace(int workspaceId) {
        if (workspaces.containsKey(workspaceId)) {
            Workspace workspace = workspaces.get(workspaceId);
            workspace.setOccupied(false);
            System.out.println("Workspace " + workspaceId + " is now vacated.");
        } else {
            System.out.println("Invalid workspace ID. Please try again.");
        }
    }
}

public class SmartWorkspace {
    public static void main(String[] args) {
        FacilityManagement facilityManagement = new FacilityManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter workspace name to add: ");
        String workspaceName = scanner.nextLine();
        facilityManagement.addWorkspace(workspaceName);

        System.out.print("Enter the Workspace ID to book: ");
        int workspaceIdToBook = scanner.nextInt();
        facilityManagement.bookWorkspace(workspaceIdToBook);

        System.out.print("Enter the Workspace ID to vacate: ");
        int workspaceIdToVacate = scanner.nextInt();
        facilityManagement.vacateWorkspace(workspaceIdToVacate);

        scanner.close();
    }
}
