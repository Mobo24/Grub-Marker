package dev.GrubMarker.location;
import java.time.LocalTime;


public record Location(double latitude, double longitude, LocalTime LocationTime, LocationType Type) {

}