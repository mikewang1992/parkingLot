
/**
 * Project1: ParkingSlot object constructor/getter/setter
 * 
 * @author WANJYUN WANG <103801303>
 * @version JDK 1.8.0_341
 * @date Created on 20 October 2022
 */

public class ParkingSlot {

    private boolean forStaff;
    private String parkingID;
    private Car slot;

    public ParkingSlot(boolean forStaff, String parkingID, Car slot) {
        this.forStaff = forStaff;
        this.parkingID = parkingID;
        this.slot = slot;
    }

    public boolean getforStaff() {
        return forStaff;
    }

    public void setforStaff(boolean forStaff) {
        this.forStaff = forStaff;
    }

    public String getparkingID() {
        return parkingID;
    }

    public void setparkingID(String parkingID) {
        this.parkingID = parkingID;
    }

    public Car getSlot() {
        return slot;
    }

    public void setSlot(Car slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return ("forStaff: " + this.getforStaff() + " parkingID: " + this.getparkingID() + " slot info: "
                + this.getSlot());
    }
}
