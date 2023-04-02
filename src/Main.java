import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @Author Tihomir
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

            try {
                FileHandler fileHandler = new FileHandler("log.txt");
                logger.addHandler(fileHandler);
                SimpleFormatter formatter = new SimpleFormatter();
                fileHandler.setFormatter(formatter);
            } catch (IOException e) {
                logger.warning("Log file could not be created! " + e.getMessage());
            }

        VehicleManagerImpl vehicleManagerImpl = new VehicleManagerImpl();
        Scanner scanner = new Scanner(System.in);

        int option=0;

        do {
            try {
                vehicleManagerImpl.showOptions();
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        try {
                            vehicleManagerImpl.addVehicle();
                        }
                        catch (DuplicateVehicleException e) {
                            System.out.println("Error" + e);
                        }
                        break;
                    case 2:
                        vehicleManagerImpl.searchVehicles();
                        break;
                    case 3:
                        vehicleManagerImpl.showFleet();
                        break;
                    case 4:
                        try {
                            vehicleManagerImpl.deleteVehicle();

                        }catch (NoSuchVehicleException e) {
                            System.out.println("Error: " + e);
                        }
                        break;
                    case 5:
                        System.exit( 1);
                        break;
                    default:
                        System.out.println("Wrong input!!!");
                }
            }
         catch(InputMismatchException e ){
            logger.warning("Wrong input type");
            System.out.println("Wrong input type");
            scanner.nextLine();
        }

    } while (option !=5);
}}