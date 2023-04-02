public interface VehicleManager {
    void addVehicle() throws DuplicateVehicleException;
    void  searchVehicles();
    void deleteVehicle() throws NoSuchVehicleException;
}
