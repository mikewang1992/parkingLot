
/**
 * Project1: Application is the Console (Text Based) Interface class including the main() method and handling all inputs and outputs
 * 
 * @author WANJYUN WANG <103801303>
 * @version JDK 1.8.0_341
 * @date Created on 8 sepetember 2022
 */
import java.util.*;

public class Application {

    public static void main(String[] args) {
        ArrayList<ParkingSlot> arr = new ArrayList<ParkingSlot>();
        boolean stop = false;
        while (!stop) {
            System.out
                    .println(
                            "What would you like to do today? 1=CreateSlot, 2=ParkACar, 3=FindACar, 4=DeleteAcar, 5=DeleteSlot, 6=GetAllSlots");
            Scanner dowhat = new Scanner(System.in);
            String option = "0";
            option = dowhat.next();
            try {
                int x = Integer.parseInt(option);
                switch (x) {
                    case 1:
                        CarPark.CreateSlot(arr);
                        break;
                    case 2:
                        CarPark.ParkACar(arr);
                        break;
                    case 3:
                        CarPark.FindACar(arr);
                        break;
                    case 4:
                        CarPark.DeleteACar(arr);
                        break;
                    case 5:
                        CarPark.DeleteSlot(arr);
                        break;
                    case 6:
                        CarPark.GetAllSlots(arr);
                        break;
                    default:
                        System.out.println("input is not an valid value");
                }
            } catch (NumberFormatException e) {
                System.out.println("input is not an valid value");
            }

            // Asking to do again or not
            System.out.println("Enter 'Y' to run the program again, anything else to exit.");
            Scanner doAgain = new Scanner(System.in);
            String d = doAgain.nextLine();
            if (!d.equals("Y")) {
                stop = true;
            }
        }
    }
}