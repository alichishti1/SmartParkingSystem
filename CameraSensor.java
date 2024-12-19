public class CameraSensor implements ParkingSensor
{
    private String resolution;
    private boolean isOccupied;

    public CameraSensor(String resolution)
    {
        this.resolution = resolution;
    }

    public void setup()
    {
        System.out.println("Camera Sensor setup with resolution: " + resolution);
    }

    public void captureImage()
    {
        System.out.println("Image captured.");
    }

    public void processImage()
    {
        System.out.println("Processing image for license plates...");
    }

    public void detectVehicle()
    {
        isOccupied = Math.random() > 0.5;
    }

    public boolean getParkingStatus()
    {
        return isOccupied;
    }

    public void powerOn()
    {
        System.out.println("Camera Sensor powered on.");
    }

    public void powerOff()
    {
        System.out.println("Camera Sensor powered off.");
    }

    public void reset()
    {
        System.out.println("Camera Sensor reset.");
    }
}