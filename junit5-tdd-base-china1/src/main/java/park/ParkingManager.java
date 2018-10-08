package park;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager extends ParkingBoy{
    private final List<ParkingBoy> parkingBoys;
    public ParkingManager(List<ParkingBoy> parkingBoys, ParkLot...parkLots){
        super(parkLots);
        this.parkingBoys = parkingBoys;
    }
    @Override
    public ParkTicket park(Car car) {
        for (ParkLot parkLot : parkLots) {
            if (!parkLot.isFull()) {
                return parkLot.park(car);
            }
        }
        throw new IndexOutOfBoundsException("ParkingManager的停车场满了！");
    }

    public void addBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public ParkTicket orderBoyToPark(ParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }
}
