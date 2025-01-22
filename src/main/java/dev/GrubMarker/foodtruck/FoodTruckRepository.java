package dev.GrubMarker.foodtruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class FoodTruckRepository {
    private List<FoodTruck> foodTrucks = new ArrayList<>();

    private final JdbcClient jdbcClient;

    public FoodTruckRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    //getFoodTrucks method
    public List<FoodTruck> getFoodTrucks() {
        foodTrucks = jdbcClient.sql("SELECT * FROM FOODTRUCK")
            .query(FoodTruck.class) // map to class
            .list();
        return foodTrucks;
    }

    //getFoodTruckById method
    Optional <FoodTruck> getFoodTruckById(int id) {
        return jdbcClient.sql("SELECT * FROM FOODTRUCK WHERE ID = :id")
            .param("id", id)
            .query(FoodTruck.class) // map to class
            .optional();
    }

    public void create(FoodTruck foodTruck) {
        var output = jdbcClient.sql("INSERT INTO FOODTRUCK (NAME, FOODTYPE, LATITUDE, LONGITUDE, OPENTIME, CLOSETIME) VALUES (:name, :foodType, :latitude, :longitude, :openTime, :closeTime)")
            .param("name", foodTruck.name())
            .param("foodType", foodTruck.foodType().toString())
            .param("latitude", foodTruck.latitude())
            .param("longitude", foodTruck.longitude())
            .param("openTime", foodTruck.openTime())
            .param("closeTime", foodTruck.closeTime())
            .update();

        Assert.state(output == 1, "could not create the food truck");
    }

    void updateFoodTruck(FoodTruck foodTruck,String field, Object value, int id) {
            jdbcClient.sql("UPDATE FOODTRUCK SET :field = :value WHERE ID = :id")
            .update();
    }
    void deleteFoodTruck(Integer id) {
            jdbcClient.sql("UPDATE FOODTRUCK SET :field = :value WHERE ID = :id")
            .update();
    }

    Integer count() {
        return jdbcClient.sql("SELECT COUNT(*) FROM FOODTRUCK").query().listOfRows().size();  
    }

    public void saveAll(List<FoodTruck> foodtruck) {
        foodtruck.stream().forEach(this::create);
    }

}
