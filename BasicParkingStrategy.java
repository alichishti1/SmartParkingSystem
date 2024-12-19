public class BasicParkingStrategy extends ParkingStrategy {
    private ParkingLot parkingLot;

    public BasicParkingStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

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
        System.out.println("Basic optimization completed.");
    }
}
