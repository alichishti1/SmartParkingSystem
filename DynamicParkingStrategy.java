public class DynamicParkingStrategy extends ParkingStrategy {
    private ParkingLot parkingLot;

    public DynamicParkingStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    //DynamicParkingStrategy not being used-adjusting
    //based on real-time occupancy and user demand

    @Override
    public ParkingSpace findAvailableParking() {
        for (ParkingSpace space : parkingLot.getSpaces()) {
            if (!space.isOccupied() && !space.isReserved()) {
                return space;
            }
        }
        return null;
    }

    @Override
    public void optimizeParking() {
        System.out.println("Dynamic optimization completed.");
    }
}
