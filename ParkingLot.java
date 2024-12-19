import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<ParkingSpace> spaces = new ArrayList<>();
    private String operationalHours;
    private String entranceCoordinates;
    private String exitCoordinates;
    private int availableSpaces;

    public ParkingLot(int totalSpaces, String operationalHours, String entranceCoordinates, String exitCoordinates) {
        this.operationalHours = operationalHours;
        this.entranceCoordinates = entranceCoordinates;
        this.exitCoordinates = exitCoordinates;
        this.availableSpaces = totalSpaces; // Initialize available spaces with total spaces
        for (int i = 0; i < 60; i++) {
            spaces.add(new ParkingSpace("Space" + (i + 1), "Standard", "Near entrance"));
        }
        for (int i = 60; i < 80; i++) {
            spaces.add(new ParkingSpace("Space" + (i + 1), "Compact", "Near entrance"));
        }
        for (int i = 80; i < totalSpaces; i++) {
            spaces.add(new ParkingSpace("Space" + (i + 1), "Disabled-Accessible", "Near entrance"));
        }
    }

    public ArrayList<ParkingSpace> getSpaces() {
        return spaces;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public String getExitCoordinates() {
        return exitCoordinates;
    }

    public String getOperationalHours() {
        return operationalHours;
    }

    public String getEntranceCoordinates() {
        return entranceCoordinates;
    }

    public void updateAvailableSpaces() {
        int availableCount = 0;
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied() && !space.isReserved()) {
                availableCount++;  // Increment if space is not occupied or reserved
            }
        }
        this.availableSpaces = availableCount;  // Update available spaces
    }

    public void displayAvailableSpaces() {
        System.out.println("Available Parking Spaces:");
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied() && !space.isReserved()) {
                System.out.println(space);
            }
        }
    }

    @Override
    public String toString() {
        return "Total Spaces: " + spaces.size() + "\n" +
                "Available Spaces: " + availableSpaces + "\n" +
                "Operational Hours: " + operationalHours + "\n" +
                "Entrance Coordinates: " + entranceCoordinates + "\n" +
                "Exit Coordinates: " + exitCoordinates;
    }
}
