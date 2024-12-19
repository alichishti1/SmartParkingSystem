public class UltrasonicSensor implements ParkingSensor
{
    private double distanceThreshold;
    private boolean isOccupied;

    public UltrasonicSensor(double threshold)
    {
        this.distanceThreshold = threshold;
    }

    public void setup()
    {
        System.out.println("Ultrasonic Sensor setup complete.");
    }

    public double measureDistance()
    {
        return Math.random() * 10;
    }

    public double getDistanceThreshold() {
        return distanceThreshold;
    }

    public void setDistanceThreshold(double threshold)
    {
        this.distanceThreshold = threshold;
    }

    public boolean isOccupied()
    {
        return measureDistance() < distanceThreshold;
    }

    public boolean isVacant()
    {
        return !isOccupied;
    }

    public void detectVehicle()
    {
        isOccupied = isOccupied();
    }

    public boolean getParkingStatus()
    {
        return isOccupied;
    }

    public void powerOn()
    {
        System.out.println("Ultrasonic Sensor powered on.");
    }

    public void powerOff()
    {
        System.out.println("Ultrasonic Sensor powered off.");
    }

    public void reset()
    {
        System.out.println("Ultrasonic Sensor reset.");
    }
}
