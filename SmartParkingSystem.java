import java.time.LocalDateTime;
import java.util.Scanner;

public class SmartParkingSystem {
    public static void main(String[] args) {
        // the total spaces should be more than 81
        ParkingLot parkingLot = new ParkingLot(100, "9 AM - 9 PM", "Entrance Coordinates", "Exit Coordinates");
        ReservationManager reservationManager = new ReservationManager(parkingLot);
        PaymentManager paymentManager = new PaymentManager();
        NotificationManager notificationManager = new NotificationManager();
        BasicParkingStrategy basicStrategy = new BasicParkingStrategy(parkingLot);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Smart Parking System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Parking Spaces");
            System.out.println("2. Reserve a Parking Space");
            System.out.println("3. Manage Reservations");
            System.out.println("4. Make a Payment");
            System.out.println("5. Park Vehicle");
            System.out.println("6. Exit Parking");
            System.out.println("7. Settings");
            System.out.println("8. Exit System");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // View Available Parking Spaces
                    System.out.print("Enter space type to filter (standard/compact/disabled-accessible) or 'all': ");
                    String filter = scanner.next().toLowerCase();
                    for (ParkingSpace space : parkingLot.getSpaces()) {
                        if ((filter.equals("all") || space.getSize().equalsIgnoreCase(filter)) &&
                                !space.isOccupied() && !space.isReserved()) {
                            System.out.println(space);
                        }
                    }
                    break;

                case 2: // Reserve a Parking Space
                    System.out.print("Enter Vehicle License Plate: ");
                    String licensePlate = scanner.next();
                    System.out.print("Enter Vehicle Type (Car/Motorcycle): ");
                    String vehicleType = scanner.next();
                    System.out.print("Enter Space Type (standard/compact/disabled-accessible): ");
                    String spaceType = scanner.next();
                    System.out.print("Enter Reservation Duration (hours): ");
                    int duration = scanner.nextInt();
                    Vehicle vehicle = new Vehicle(licensePlate, vehicleType, 4.5, 2.0, 1.8, LocalDateTime.now());
                    reservationManager.makeReservation(vehicle, spaceType, duration);
                    break;

                case 3: // Manage Reservations
                    System.out.println("1. View Reservations");
                    System.out.println("2. Cancel Reservation");
                    System.out.print("Enter your choice: ");
                    int manageChoice = scanner.nextInt();
                    if (manageChoice == 1) {
                        reservationManager.displayReservations();
                    } else if (manageChoice == 2) {
                        System.out.print("Enter License Plate of Vehicle to Cancel Reservation: ");
                        licensePlate = scanner.next();
                        boolean found = false;
                        for (ParkingSpace space : parkingLot.getSpaces()) {
                            if (space.isReserved() && licensePlate.equals(space.getResLicense())) {
                                space.setReserved(false);
                                space.setResLicense(null);
                                System.out.println("Reservation for " + licensePlate + " has been canceled.");
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("No reservation found for this vehicle.");
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 4: // Make a Payment
                    System.out.print("Enter Parking Duration (hours): ");
                    int hours = scanner.nextInt();
                    System.out.print("Enter Vehicle Type (Car/Motorcycle): ");
                    vehicleType = scanner.next();
                    double fee = paymentManager.calculateParkingFee(hours, vehicleType);
                    System.out.println("Total Fee: $" + fee);
                    System.out.println("Payment Methods: 1. Credit Card 2. Debit Card 3. Cashless Payment");
                    System.out.print("Choose Payment Method: ");
                    int paymentMethod = scanner.nextInt();
                    if (paymentMethod >= 1 && paymentMethod <= 3) {
                        System.out.println("Payment Successful!");
                    } else {
                        System.out.println("Invalid Payment Method.");
                    }
                    break;

                case 5: // Park Vehicle
                    System.out.print("Enter Vehicle License Plate: ");
                    licensePlate = scanner.next();
                    System.out.println("Assigning a parking space...");
                    ParkingSpace assignedSpace = basicStrategy.findAvailableParking();
                    if (assignedSpace != null) {
                        assignedSpace.setOccupied(true);
                        assignedSpace.setOccLicense(licensePlate);
                        System.out.println("Assigned Space: " + assignedSpace.getId() + " to vehicle " + licensePlate);
                    } else {
                        System.out.println("No available spaces.");
                    }
                    break;

                case 6: // Exit Parking
                    System.out.print("Enter Vehicle License Plate: ");
                    licensePlate = scanner.next();
                    for (ParkingSpace space : parkingLot.getSpaces()) {
                        if (space.isOccupied() && licensePlate.equals(space.getOccLicense())) {
                            space.setOccupied(false);
                            space.setOccLicense(null);
                            System.out.print("Enter Parking Duration (hours): ");
                            hours = scanner.nextInt();
                            fee = paymentManager.calculateParkingFee(hours, "Car"); // Assume "Car" for simplicity
                            System.out.println("Exit Fee: $" + fee);
                            System.out.println("Vehicle has exited.");
                            break;
                        }
                    }
                    break;

                case 7: // Settings
                    System.out.println("1. Adjust Notifications");
                    System.out.println("2. Update Contact Information");
                    System.out.print("Enter your choice: ");
                    int settingsChoice = scanner.nextInt();
                    if (settingsChoice == 1) {
                        System.out.println("Notifications settings updated.");
                    } else if (settingsChoice == 2) {
                        System.out.print("Enter New Contact Info: ");
                        String contactInfo = scanner.next();
                        System.out.println("Contact info updated to: " + contactInfo);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 8: // Exit System
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
