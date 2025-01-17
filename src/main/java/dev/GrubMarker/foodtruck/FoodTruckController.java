package dev.GrubMarker.foodtruck;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.GrubMarker.foodtruck.foodtruckExceptions.FoodTruckNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/foodtruck")
public class FoodTruckController {
    private final FoodTruckRepository foodTruckStorage;
    public FoodTruckController(FoodTruckRepository foodTruckStorage) {
        this.foodTruckStorage = foodTruckStorage;
    }
    @GetMapping("")
    List<FoodTruck> FoodTrucksList() {
        return foodTruckStorage.getFoodTrucks();
    }
    @GetMapping("/{id}")
    FoodTruck getFoodTruckById(@PathVariable Integer id) {
        Optional <FoodTruck> foodTruck = foodTruckStorage.getFoodTruckById(id);
        if (!foodTruck.isPresent()){
            throw new FoodTruckNotFoundException(id);
        }

        return foodTruck.get();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addFoodtruck")
    void addFoodTruck(@Valid @RequestBody FoodTruck foodTruck) {
        foodTruckStorage.create(foodTruck);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("updateFoodtruck")
    void updateFoodTruck(@Valid @RequestBody Integer id, @PathVariable FoodTruck foodTruck) {
        foodTruckStorage.updateFoodTruck(foodTruck, id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("deleteFoodtruck")
    void deleteFoodTruck(@RequestBody Integer id) {
        foodTruckStorage.deleteFoodTruck(id);
    }
    
} 

