package dev.GrubMarker.user;

public record User (
    Integer id,
    String name,
    String username, 
    String email,
    Address Address,
    String Phone,
    String website,
    Company Company ) {}
