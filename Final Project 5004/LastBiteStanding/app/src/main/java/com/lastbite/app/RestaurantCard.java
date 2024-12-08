package com.lastbite.app;

public class RestaurantCard {
    private String name;
    private String cuisine;
    private String rating;
    private String address;
    private String suggestedFor;

    public RestaurantCard(String name, String cuisine, String rating, String address, String suggestedFor) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
        this.address = address;
        this.suggestedFor = suggestedFor;
    }

    public String getName() { return name; }
    public String getCuisine() { return cuisine; }
    public String getRating() { return rating; }
    public String getAddress() { return address; }
    public String getSuggestedFor() { return suggestedFor; }
}