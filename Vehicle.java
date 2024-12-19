import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;

public class Vehicle {
    private String licensePlateNumber;
    private String vehicleType;
    private double length;
    private double width;
    private double height;
    private LocalDateTime entryTimestamp;
    private LocalDateTime exitTimestamp;

    public Vehicle(String licensePlateNumber, String vehicleType, double length, double width, double height, LocalDateTime entryTimestamp) {
        this.licensePlateNumber = licensePlateNumber;
        this.vehicleType = vehicleType;
        this.length = length;
        this.width = width;
        this.height = height;
        this.entryTimestamp = entryTimestamp;
        this.exitTimestamp = null;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTimestamp() {
        return entryTimestamp;
    }

    public LocalDateTime getExitTimestamp() {
        return exitTimestamp;
    }

    public LocalTime getExitTimestampDayTime() {
        return exitTimestamp != null ? exitTimestamp.toLocalTime() : null;
    }

    public String getSizeDimensions() {
        return length + "m x " + width + "m x " + height + "m";
    }

    public void setExitTimestamp(LocalDateTime exitTimestamp) {
        this.exitTimestamp = exitTimestamp;
    }

    public Duration calculateParkingDuration() {
        if (entryTimestamp != null && exitTimestamp != null) {
            return Duration.between(entryTimestamp, exitTimestamp);
        }
        return null; // Return null if either timestamp is not set
    }

    @Override
    public String toString() {
        return "License Plate: " + licensePlateNumber + "\n" +
                "Type: " + vehicleType + "\n" +
                "Dimensions: " + length + "m x " + width + "m x " + height + "m\n" +
                "Entry Time: " + entryTimestamp + "\n" +
                "Exit Time: " + (exitTimestamp != null ? exitTimestamp : "N/A");
    }
}
