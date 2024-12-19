public class MaintenanceManager
{
    public void scheduleMaintenance(String task)
    {
        System.out.println("Scheduled maintenance: " + task);
    }

    public void performInspection()
    {
        System.out.println("Performing inspection...");
    }

    public void handleRepairRequest(String issue)
    {
        System.out.println("Handling repair request: " + issue);
    }
}