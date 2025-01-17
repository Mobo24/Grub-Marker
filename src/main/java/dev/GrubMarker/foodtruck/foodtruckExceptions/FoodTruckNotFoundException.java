package dev.GrubMarker.foodtruck.foodtruckExceptions;

public class FoodTruckNotFoundException extends RuntimeException {
    public FoodTruckNotFoundException(Integer id) {
        super("Could not find Food Truck " + id);
    }
    
}
