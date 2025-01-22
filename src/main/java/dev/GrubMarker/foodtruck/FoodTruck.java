package dev.GrubMarker.foodtruck;
import java.time.LocalTime;
import jakarta.validation.constraints.NotEmpty;

public record FoodTruck(
    @NotEmpty
    String name, 
    @NotEmpty
    FoodType foodType, 
    double latitude, 
    double longitude, 
    @NotEmpty
    LocalTime openTime,
    @NotEmpty
    LocalTime closeTime,
    @NotEmpty 
    Integer id
    ) {}