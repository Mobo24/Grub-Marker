package dev.GrubMarker.foodtruck.foodtruckExceptions;

public class FoodTruckCouldNotBeUpdated extends RuntimeException {
    public FoodTruckCouldNotBeUpdated(Integer id) {
        super("Could not update Food Truck " + id);
    }
}
