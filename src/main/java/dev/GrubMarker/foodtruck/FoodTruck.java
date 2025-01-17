package dev.GrubMarker.foodtruck;
import java.time.LocalTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;

public record FoodTruck(
    @NotEmpty
    String name, 
    @NotEmpty
    FoodType foodType, 
    double latitude, 
    double longitude, 
    LocalTime openTime,
    LocalTime closeTime,
    @NotEmpty 
    Integer id
    ) {}