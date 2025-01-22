package dev.GrubMarker.foodtruck;

import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FoodTruckDataJsonLoader implements CommandLineRunner {

    private final static Logger log = LoggerFactory.getLogger(FoodTruckDataJsonLoader.class);
    private final FoodTruckRepository foodTruckRepository;
    private final ObjectMapper objectMapper;

    public FoodTruckDataJsonLoader(FoodTruckRepository foodTruckRepository, ObjectMapper objectMapper) {
        this.foodTruckRepository = foodTruckRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if(foodTruckRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("src/main/resources/data/foodtrucks.json")) {
                System.out.println("inputStream: " + inputStream);
                FoodTrucks allFoodTrucks = objectMapper.readValue(inputStream, FoodTrucks.class);
                log.info("Reading food truck data from file ",  allFoodTrucks.foodtrucks().size());
                foodTruckRepository.saveAll(allFoodTrucks.foodtrucks());
            } catch (IOException e) {
               throw new RuntimeException("Could not load food truck data", e);
            }
            
        }
        else{
            log.info("Food truck data already loaded");

        }
       
       
    }
    
}

