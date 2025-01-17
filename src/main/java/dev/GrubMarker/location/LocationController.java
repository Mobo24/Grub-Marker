package dev.GrubMarker.location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @GetMapping("/location")
    String getLocation() {
        return "Welcome to GrubMarker!";
    }
    
}
