
/**
 * Project1: Car object constructor/getter/setter
 * 
 * @author WANJYUN WANG <103801303>
 * @version JDK 1.8.0_341
 * @date Created on 8 sepetember 2022
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Car {

    private String registration;
    private String owner;
    private boolean staffCar;
    // Advanced features
    private LocalDateTime parkTime;

    public Car(String registration, String owner, boolean staffCar, LocalDateTime parkTime) {
        this.registration = registration;
        this.owner = owner;
        this.staffCar = staffCar;
        this.parkTime = parkTime;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean getStaffCar() {
        return staffCar;
    }

    public void setStaffCar(boolean staffCar) {
        this.staffCar = staffCar;
    }

    public LocalDateTime getParkTime() {
        return parkTime;
    }

    public String getFormatted_ParkTime() {
        DateTimeFormatter formating = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted_parkTime = this.getParkTime().format(formating);
        return formatted_parkTime;
    }

    public String Duration_Formatted() {
        Duration duration = Duration.between(parkTime, LocalDateTime.now());
        String duration_formatted = String.format("%d:%02d:%02d",
                duration.toHours(),
                duration.toMinutesPart(),
                duration.toSecondsPart());
        return duration_formatted;
    }

    public void setParkTime(LocalDateTime parkTime) {
        this.parkTime = parkTime;
    }

    public String toString() {
        String occupied = "false";
        if (registration.length() > 0) {
            occupied = "true";
            DateTimeFormatter formating = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatted_parkTime = this.getParkTime().format(formating);

            Duration duration = Duration.between(parkTime, LocalDateTime.now());
            String duration_formatted = String.format("%d:%02d:%02d",
                    duration.toHours(),
                    duration.toMinutesPart(),
                    duration.toSecondsPart());

            return ("occupied:" + occupied + " registration: " + this.getRegistration() + " owner: " + this.getOwner()
                    + " staffCar: "
                    + this.getStaffCar() + " ParkTime: "
                    + formatted_parkTime + " parking time length: " + duration_formatted);
        } else {
            occupied = "false";
            return occupied;
        }

    }
}
