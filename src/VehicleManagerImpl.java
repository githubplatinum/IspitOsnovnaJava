import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class VehicleManagerImpl implements VehicleManager{
    /**
     * This class provide a management feet system for vehicle
     * implements the VehicleManager interface, which defines methods for
     * adding, searching deleting and print all vehicle in the fleet
     *
     */
       ArrayList<Vehicle> vehicleList = new ArrayList<>();
    Logger logger = Logger.getLogger(VehicleManagerImpl.class.getName());
    public VehicleManagerImpl() {
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            logger.warning("Log file could not be created! " + e.getMessage());
        }
    }

    /**
     * If user enter VIN who exist in list method will throw exception
     * @throws DuplicateVehicleException
     */
    @Override
    public void addVehicle() throws DuplicateVehicleException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("What type of vehicle would you like to add:");
        System.out.println("Enter 'car' or 'truck': ");
        try {


        String type = scanner.nextLine();
           if (!type.equals("car") && !type.equals("truck") ) {
               System.out.println("Invalid vehicle type");
               return;
           } else {

               System.out.println("Enter make: ");
               String make = scanner.nextLine();

               System.out.println("Enter model: ");
               String model = scanner.nextLine();

               System.out.println("Enter VIN ");
               String vin = scanner.nextLine();
               for (Vehicle vehicle: vehicleList){
                   if(vehicle.getVin().equals(vin)){
                       throw new  DuplicateVehicleException("Vehicle with VIN " + vin +" already exists!");
                   }
               }

               System.out.println("Enter year: ");
               int year = scanner.nextInt();
               scanner.nextLine();

               System.out.println("Enter color: ");
               String color = scanner.nextLine();

               System.out.println("Enter fuel type: ");
               String fuelType = scanner.nextLine();

               if (type.equals("car")) {
                   System.out.println("Enter number of door: ");
                   int doorNumber = scanner.nextInt();
                   scanner.nextLine();

                   System.out.println("Enter body style: ");
                   String bodyStyle = scanner.nextLine();

                   Car car = new Car(make, model, vin, year,
                           color, fuelType, doorNumber, bodyStyle);
                   vehicleList.add(car);
               } else if (type.equals("truck")) {
                   System.out.println("Enter towing capacity");
                   double maxPayload = scanner.nextInt();
                   scanner.nextLine();

                   Truck truck = new Truck(make, model, vin, year, color, fuelType,
                           maxPayload);
                   vehicleList.add(truck);
               }
               System.out.println("Vehicle added successfully.");

           }
        } catch (InputMismatchException e){
            logger.warning("Wrong input type!!");
            System.out.println("Wrong input type!!");
            }
        catch (DuplicateVehicleException e){
            logger.info("Error: " + e);
            System.out.println("Error: " + e);
        }

    }
    @Override
    public void searchVehicles(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How would you like search for vehicles?");
        System.out.println("1. Search by make");
        System.out.println("2. Search by model");
        System.out.println("3. Search by VIN");
        System.out.println("Enter command:");

        try {
            int searchOption = scanner.nextInt();
            String searchTerm = scanner.nextLine();


            switch (searchOption){
                case  1:
                    System.out.println("Enter make:");
                    String searchByMake = scanner.nextLine();
                    System.out.println("Search result: ");
                    boolean foundByMake = false;
                    for (Vehicle vehicle: vehicleList) {
                        if (vehicle.getMake().equals(searchByMake)){
                            System.out.println(vehicle.toString());
                            foundByMake = true;
                        }
                    }
                    if(!foundByMake){
                        System.out.println("Vehicle not found! ");
                    }
                    break;

                case 2 :
                    System.out.println("Enter model:");
                    String searchByModel = scanner.nextLine();
                    System.out.println("Search result: ");
                    boolean foundByModel = false;
                    for (Vehicle vehicle: vehicleList) {
                        if (vehicle.getModel().equals(searchByModel)){
                            System.out.println(vehicle.toString());
                            foundByModel = true;
                        }
                    }
                    if(!foundByModel) {
                        System.out.println("Vehicle not found! ");
                    }
                    break;

                case 3:
                    System.out.println("Enter VIN:");
                    String searchByVin = scanner.nextLine();
                    System.out.println("Search result: ");
                    boolean foundByVin = false;
                    for (Vehicle vehicle: vehicleList) {
                        if (vehicle.getVin().equals(searchByVin)){
                            System.out.println(vehicle.toString());
                            foundByVin = true;
                        }
                    }
                    if(!foundByVin) {
                        System.out.println("Vehicle not found! ");
                    }
                    break;

            }

        } catch (InputMismatchException e){
            System.out.println("Invalid command! Enter a number between 1 and 3");
        }
    }

    /**
     *  If user enters a VIN that not exist in list, method will throw a
     *  NoSuchVehicleException
     * @throws NoSuchVehicleException
     */
    @Override
    public void deleteVehicle() throws NoSuchVehicleException {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter VIN vehicle to delete");
            String vinToDelete = scanner.nextLine();
            boolean foundByVin = false;

            for (int i = 0; i < vehicleList.size(); i++) {
                if (vehicleList.get(i).getVin().equals(vinToDelete)) {
                    foundByVin = true;
                    System.out.println("Vehicle with VIN " + vinToDelete + " deleted successfully!");
                    vehicleList.remove(i);
                    break;
                }
            }
                    if(!foundByVin){
                        throw new NoSuchVehicleException("Vehicle with VIN "+ vinToDelete +" not found!");
                    }

        }
        catch (NoSuchVehicleException e){

            System.out.println("Error: " + e);
        }
    }

    public void showOptions(){
        System.out.println("");
        System.out.println("Vehicle Fleet Management System");
        System.out.println("--------------------------------------");
        System.out.println("1. Add a vehicle to the fleet");
        System.out.println("2. Search for vehicle by make or model");
        System.out.println("3. Print all vehicle in the fleet");
        System.out.println("4. Delete a vehicle from the fleet");
        System.out.println("5. Quit");
    }

    public void showFleet(){
        System.out.println("----------------------------");
        System.out.println("All vehicle in the fleet");

        for(Vehicle vehicle: vehicleList) {
            System.out.println(vehicle.toString());
        }
    }




}