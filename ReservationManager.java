import java.util.ArrayList;

public class ReservationManager {
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ParkingLot parkingLot;

    public ReservationManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void makeReservation(Vehicle vehicle, String spaceType, int duration) {
        for (ParkingSpace space : parkingLot.getSpaces()) {
            if (!space.isOccupied() && !space.isReserved() && space.getSize().equalsIgnoreCase(spaceType)) {
                Reservation reservation = new Reservation(vehicle, space, duration);
                reservations.add(reservation);
                space.setReserved(true);
                space.setResLicense(vehicle.getLicensePlateNumber());
                System.out.println("Reservation confirmed for vehicle " + vehicle.getLicensePlateNumber() +
                        " at space " + space.getId() + " for " + duration + " hours.");
                return;
            }
        }
        System.out.println("No available spaces of the requested type.");
    }

    public void displayReservations() {
        boolean anyRes = false;
        for (ParkingSpace space : parkingLot.getSpaces()) {
            if (space.isReserved()) {
                anyRes = true;
                System.out.println("Vehicle: " + space.getResLicense() +
                        " Space: " + space.getId());
            }
        }
        if (!anyRes) {
            System.out.println("No available spaces of the requested type.");
        }
    }

    public void cancelReservation(String licensePlateNumber) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            if (reservation.getVehicle().getLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)) {
                ParkingSpace reservedSpace = reservation.getSpace();
                reservedSpace.setReserved(false); // Mark the parking space as not reserved
                reservations.remove(i); // Remove the reservation from the list
                System.out.println("Reservation for vehicle " + licensePlateNumber +
                        " at space " + reservedSpace.getId() + " has been canceled.");
                return;
            }
        }
        System.out.println("No reservation found for vehicle with license plate: " + licensePlateNumber);
    }
}
