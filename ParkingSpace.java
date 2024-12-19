import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingSpace {
    private String id;
    private String size;
    private String location;
    private boolean isOccupied;
    private boolean isReserved;
    private LocalDateTime reservationEndTime;
    private String resLicense;
    private String occLicense;

    public ParkingSpace(String id, String size, String location) {
        this.id = id;
        this.size = size;
        this.location = location;
        this.isOccupied = false;
        this.isReserved = false;
        this.reservationEndTime = null;
        this.resLicense = null;
        this.occLicense = null;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getLocation() {
        return location;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public String getResLicense() {
        return resLicense;
    }

    public void setResLicense(String lic) {
        resLicense = lic;
    }

    public String getOccLicense() {
        return occLicense;
    }

    public void setOccLicense(String lic) {
        occLicense = lic;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public LocalDateTime getReservationEndTime() {
        return reservationEndTime;
    }

    public void reserveSpace(Duration duration) {
        if (!isReserved && !isOccupied) {
            this.isReserved = true;
            this.reservationEndTime = LocalDateTime.now().plus(duration);
            System.out.println("Space reserved for " + duration.toHours() + " hours.");
        } else {
            System.out.println("Space cannot be reserved as it is either occupied or already reserved.");
        }
    }

    public void cancelReservation() {
        if (isReserved) {
            this.isReserved = false;
            this.reservationEndTime = null;
            System.out.println("Reservation has been canceled.");
        } else {
            System.out.println("No reservation exists to cancel.");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Size: " + size + ", Location: " + location +
                ", Status: " + (isOccupied ? "Occupied" : "Vacant") +
                ", Reserved: " + isReserved +
                (reservationEndTime != null ? ", Reservation Ends At: " + reservationEndTime : "");
    }
}
