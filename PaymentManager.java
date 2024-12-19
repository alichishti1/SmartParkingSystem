public class PaymentManager {
    public double calculateParkingFee(int duration, String vehicleType) {
        double rate = vehicleType.equalsIgnoreCase("Car") ? 5.0 : 3.0;
        return duration * rate;
    }
    public String processPayment(int amount, String paymentMethod) {
        return "This is your payment receipt: ";
    }
    public String generateReceipt(int amount, String paymentMethod) {
        return "This is your receipt: ";
    }
}
