public class NotificationManager {
    public void sendNotification(String message) {
        System.out.println("Notification: " + message);
    }

    public void notifyReservation(String vehiclePlate, String spaceId) {
        sendNotification("Reservation confirmed for vehicle: " + vehiclePlate + " at space: " + spaceId);
    }

    public void notifyParkingFull() {
        sendNotification("Parking is full.");
    }

    public void notifyParkingAvailable() {
        sendNotification("Parking spaces are now available.");
    }
}
