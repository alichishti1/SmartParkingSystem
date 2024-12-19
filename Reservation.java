public class Reservation {
    private Vehicle vehicle;
    private ParkingSpace space;
    private int duration;

    public Reservation(Vehicle vehicle, ParkingSpace space, int duration) {
        this.vehicle = vehicle;
        this.space = space;
        this.duration = duration;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpace getSpace() {
        return space;
    }

    public int getDuration() {
        return duration;
    }
}
