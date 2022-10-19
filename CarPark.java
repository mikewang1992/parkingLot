
/**
 * Project1: CarPark is responsible for maintaining a list of available parking slots.
 * 
 * @author WANJYUN WANG <103801303>
 * @version JDK 1.8.0_341
 * @date Created on 8 sepetember 2022
 */
import java.util.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

import java.time.LocalDateTime;
import java.time.Duration;

public class CarPark {
    public static void CreateSlot(ArrayList<ParkingSlot> arr, String parkingID, boolean forStaff) {
        System.out.println("Starting CreateSlot");

        System.out.println("Enter parking slot ID to create (an uppercase letter followed by 2 digits)");
        Scanner sl = new Scanner(System.in);
        // String parkingID = sl.next();

        System.out.println("Is the parking slot for staff?(true/false)");
        Scanner sf = new Scanner(System.in);
        // boolean forStaff = sf.nextBoolean();

        if (parkingID.length() == 3) {
            parkingID = parkingID.toUpperCase();
            boolean foundSomething = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getparkingID().equals(parkingID)) {
                    // check if the parkingID exist in the system
                    foundSomething = true;
                    System.out.println("the parking ID already exist in our system");
                    JOptionPane.showMessageDialog(null, "The parking ID already exist in our system", "Fail", 0);
                }
            }
            // if no match handle
            if (foundSomething == false) {
                ParkingSlot PSobj = new ParkingSlot(forStaff, parkingID, new Car("", "", false, LocalDateTime.now()));
                arr.add(PSobj);
                System.out.println("Sucessfully add a new slot");
                JOptionPane.showMessageDialog(null, "Sucessfully add a new slot", "Sucess", 1);
            }
        } else {
            System.out.println("The parking slot ID you entered is invalid.");
            JOptionPane.showMessageDialog(null, "The parking slot ID you entered is invalid", "Fail", 0);
        }
        // for (int i = 0; i < arr.size(); i++) {
        // System.out.println(arr.get(i).toString());
        // }
    }

    public static void ParkACar(ArrayList<ParkingSlot> arr, String parkingSlotID, String registration, String owner,
            boolean staffCar) {
        System.out.println("Starting parkACar");

        System.out.println("Enter parking slot ID (an uppercase letter followed by 2 digits) for this car to park");
        Scanner pid = new Scanner(System.in);
        // String parkingSlotID = pid.next();
        // user input wrong format handle
        if (parkingSlotID.length() == 3) {
            parkingSlotID = parkingSlotID.toUpperCase();
            boolean foundSomething = false;
            for (int i = 0; i < arr.size(); i++) {
                // check if the parkingSlotID is available in arr
                if (arr.get(i).getparkingID().equals(parkingSlotID)) {
                    foundSomething = true;
                    System.out.println("this is a valid parkingSlotID,checking if the slot is occupied...");
                    if (arr.get(i).getSlot().getRegistration().length() == 0) {
                        // slot is not occupied
                        System.out.println("the slot is not occupied,proceed to parking car");

                        System.out.println("Enter car registration (an uppercase letter followed by 4 digits)");
                        Scanner rg = new Scanner(System.in);
                        // String registration = rg.next();
                        // checking if the input registration is valid
                        if (registration.length() == 5) {
                            registration = registration.toUpperCase();
                            // checking if a car registration is exist in system
                            boolean foundCarExist = false;
                            for (int j = 0; j < arr.size(); j++) {
                                if (arr.get(j).getSlot().getRegistration().equals(registration)) {
                                    foundCarExist = true;
                                }
                            }
                            if (!foundCarExist) {
                                System.out.println("Enter owner name");
                                Scanner on = new Scanner(System.in);
                                // String owner = on.next();

                                System.out.println("Is the car a staff Car?(true/false)");
                                Scanner sc = new Scanner(System.in);
                                // boolean staffCar = sc.nextBoolean();
                                // check if the slot and car are match in staff or visitor
                                if (arr.get(i).getforStaff() == staffCar) {
                                    // 1.Advanced features: record the time that car parked
                                    LocalDateTime timeInstant = LocalDateTime.now();
                                    // 2.find the slot object from arrayList by parkingSlotID and add this car
                                    // obj into the slot object
                                    Car carObj = new Car(registration, owner, staffCar, timeInstant);
                                    arr.get(i).setSlot(carObj);
                                    System.out.println("Sucessfully park this car");
                                    JOptionPane.showMessageDialog(null, "Sucessfully park this car", "success", 1);

                                } else {
                                    System.out.println(
                                            "fail to park this car, becasue the staff slot is for staffs/the visitor slot if for visitors");
                                    JOptionPane.showMessageDialog(null,
                                            "fail to park this car, becasue the staff slot is for staffs/the visitor slot if for visitors",
                                            "Fail", 0);
                                }
                            } else {
                                System.out.println("The registration has already exist in our system.");
                                JOptionPane.showMessageDialog(null, "The registration has already exist in our system.",
                                        "Fail", 0);
                            }
                        } else {
                            System.out.println("The registration you entered is invalid.");
                            JOptionPane.showMessageDialog(null, "The registration you entered is invalid.", "Fail", 0);
                        }
                    } else {
                        // slot is occupied
                        System.out.println("the slot is occupied");
                        JOptionPane.showMessageDialog(null, "the slot is occupied", "Fail", 0);
                    }
                }
            }
            // if no matech handle
            if (foundSomething == false) {
                System.out.println("The parking slot ID does not exist in our system.");
                JOptionPane.showMessageDialog(null, "The parking slot ID does not exist in our system.", "Fail", 0);
            }
        } else {
            System.out.println("The parking slot ID you entered is invalid.");
            JOptionPane.showMessageDialog(null, "The parking slot ID you entered is invalid.", "Fail", 0);
        }
    }

    public static Object[] FindACar(ArrayList<ParkingSlot> arr, String registration) {
        // frame.setVisible(false);
        System.out.println("Starting FindACar");
        System.out.println("Enter car registration (an uppercase letter followed by 4 digits)");
        Scanner rg = new Scanner(System.in);
        String theSlot = null;
        String duration_formatted = null;
        // String registration = rg.next();
        if (registration.length() == 5) {
            // user input wrong format handle
            boolean foundSomething = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getSlot().getRegistration().equals(registration)) {
                    LocalDateTime timeParked = arr.get(i).getSlot().getParkTime();
                    Duration duration = Duration.between(timeParked, LocalDateTime.now());
                    duration_formatted = String.format("%d:%02d:%02d",
                            duration.toHours(),
                            duration.toMinutesPart(),
                            duration.toSecondsPart());
                    System.out.println("Found the car " + registration + " ,the car is parking in the slot: "
                            + arr.get(i).getparkingID() + " parking time length: "
                            + duration_formatted);
                    theSlot = arr.get(i).getparkingID();
                    foundSomething = true;
                    JOptionPane.showMessageDialog(null,
                            "Found the car " + registration + " ,the car is parking in the slot: "
                                    + arr.get(i).getparkingID() + " parking time length: "
                                    + duration_formatted,
                            "success", 1);
                }
            }
            // if no matech handle
            if (foundSomething == false) {
                System.out.println("The registration does not exist in our system.");
                JOptionPane.showMessageDialog(null,
                        "The registration does not exist in our system.",
                        "Fail", 0);
            }
        } else {
            // user input wrong format handle
            System.out.println("The car registration you entered is invalid.");
            JOptionPane.showMessageDialog(null,
                    "The car registration you entered is invalid.",
                    "Fail", 0);
        }

        return new Object[] { registration, theSlot, duration_formatted };
    }

    public static void DeleteACar(ArrayList<ParkingSlot> arr, String registration) {
        System.out.println("Starting DeleteACar");
        System.out.println("Enter car registration to remove (an uppercase letter followed by 4 digits)");
        Scanner rg = new Scanner(System.in);
        // String registration = rg.next();
        if (registration.length() == 5) {
            // user input wrong format handle
            boolean foundSomething = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getSlot().getRegistration().equals(registration)) {
                    System.out.println("Found the car " + registration + " the car is deleted.");
                    arr.get(i).setSlot(new Car("", "", false, LocalDateTime.now()));
                    foundSomething = true;
                    JOptionPane.showMessageDialog(null, "Found the car " + registration + " the car is deleted.",
                            "success", 1);
                }
            }
            // if no matech handle
            if (foundSomething == false) {
                System.out.println("The registration does not exist in our system.");
                JOptionPane.showMessageDialog(null, "The registration does not exist in our system.",
                        "Fail", 0);
            }
        } else {
            // user input wrong format handle
            System.out.println("The car registration you entered is invalid.");
            JOptionPane.showMessageDialog(null, "The car registration you entered is invalid.",
                    "Fail", 0);
        }
    }

    public static void DeleteSlot(ArrayList<ParkingSlot> arr, String parkingSlotID) {
        System.out.println("Starting DeleteSlot");
        System.out.println("Enter parking slot ID to delete (an uppercase letter followed by 2 digits)");
        Scanner pid = new Scanner(System.in);
        // String parkingSlotID = pid.next();
        if (parkingSlotID.length() == 3) {
            // user input wrong format handle
            boolean foundSomething = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getparkingID().equals(parkingSlotID)) {
                    foundSomething = true;
                    if (arr.get(i).getSlot().getRegistration().length() == 0) {
                        // delete only if slot if empty of car
                        arr.remove(i);
                        System.out.println("Found the parking slot " + parkingSlotID + " the slot is deleted.");
                        JOptionPane.showMessageDialog(null,
                                "Found the parking slot " + parkingSlotID + " the slot is deleted.",
                                "success", 1);
                    } else {
                        System.out.println(
                                "Delete fail, the parking slot " + parkingSlotID + " has a car currently parking in");
                        JOptionPane.showMessageDialog(null,
                                "Delete fail, the parking slot " + parkingSlotID + " has a car currently parking in",
                                "Fail", 0);
                    }
                }
            }
            // if no matech handle
            if (foundSomething == false) {
                System.out.println("The parking slot ID does not exist in our system.");
                JOptionPane.showMessageDialog(null, "The parking slot ID does not exist in our system.",
                        "Fail", 0);
            }
        } else {
            // user input wrong format handle
            System.out.println("The parking slot ID you entered is invalid.");
            JOptionPane.showMessageDialog(null, "The parking slot ID you entered is invalid.", "Fail", 0);
        }
    }

    public static void GetAllSlots(ArrayList<ParkingSlot> arr) {
        System.out.println("Starting GetAllSlots");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }
}
