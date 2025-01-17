package dev.GrubMarker.foodtruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.GrubMarker.foodtruck.foodtruckExceptions.FoodTruckCouldNotBeUpdated;
import dev.GrubMarker.foodtruck.foodtruckExceptions.FoodTruckNotFoundException;
import jakarta.annotation.PostConstruct;

@Repository
public class FoodTruckRepository {
    private List<FoodTruck> foodTrucks = new ArrayList<>();

    //getFoodTrucks method
    List<FoodTruck> getFoodTrucks() {
        return foodTrucks;
    }
    //getFoodTruckById method
    Optional <FoodTruck> getFoodTruckById(int id) {
        return foodTrucks.stream()
            .filter(foodTruck -> foodTruck.id() == id)
            .findFirst();
    }

    void create(FoodTruck foodTruck) {
        foodTrucks.add(foodTruck);
    }

    void updateFoodTruck(FoodTruck foodTruck, Integer id) {
        Optional <FoodTruck> foodTruckToUpdate = getFoodTruckById(id);
        if (!foodTruckToUpdate.isPresent()){
            throw new FoodTruckCouldNotBeUpdated(id);
        }
        else{
            foodTrucks.set(foodTrucks.indexOf(foodTruckToUpdate.get()), foodTruck);
        }
    }
    void deleteFoodTruck(Integer id) {
        Optional <FoodTruck> foodTruckToDelete = getFoodTruckById(id);
        if (!foodTruckToDelete.isPresent()){
            throw new FoodTruckNotFoundException(id);
        }
        else{
            foodTrucks.remove(foodTruckToDelete.get());
        }
    }

    @PostConstruct
    private void init(){
        foodTrucks.add(new FoodTruck("Taco Truck", FoodType.MEXICAN, 37.7749, -122.4194, null, null,1));
        foodTrucks.add(new FoodTruck("Pizza Truck", FoodType.AMERICAN, 37.7749, -122.4194, null, null,1));
        foodTrucks.add(new FoodTruck("Burger Truck", FoodType.FAST_FOOD, 37.7749, -122.4194, null, null,1));
    }
    
}
