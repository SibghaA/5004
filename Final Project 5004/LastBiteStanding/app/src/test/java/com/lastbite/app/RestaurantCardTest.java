package com.lastbite.app;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class RestaurantCardTest {
    private RestaurantCard restaurantCard;
    private final String VALID_NAME = "Joe's Diner";
    private final String VALID_CUISINE = "American";
    private final String VALID_RATING = "4.5";
    private final String VALID_ADDRESS = "123 Main St";
    private final String VALID_SUGGESTED_FOR = "Breakfast";

    @Before
    public void setUp() {
        restaurantCard = new RestaurantCard(
                VALID_NAME,
                VALID_CUISINE,
                VALID_RATING,
                VALID_ADDRESS,
                VALID_SUGGESTED_FOR
        );
    }

    @Test
    public void testConstructorWithValidParameters() {
        assertNotNull(restaurantCard);
        assertEquals(VALID_NAME, restaurantCard.getName());
        assertEquals(VALID_CUISINE, restaurantCard.getCuisine());
        assertEquals(VALID_RATING, restaurantCard.getRating());
        assertEquals(VALID_ADDRESS, restaurantCard.getAddress());
        assertEquals(VALID_SUGGESTED_FOR, restaurantCard.getSuggestedFor());
    }

    @Test
    public void testConstructorWithEmptyStrings() {
        RestaurantCard emptyCard = new RestaurantCard("", "", "", "", "");

        assertEquals("", emptyCard.getName());
        assertEquals("", emptyCard.getCuisine());
        assertEquals("", emptyCard.getRating());
        assertEquals("", emptyCard.getAddress());
        assertEquals("", emptyCard.getSuggestedFor());
    }

    @Test
    public void testConstructorWithNullValues() {
        RestaurantCard nullCard = new RestaurantCard(null, null, null, null, null);

        assertNull(nullCard.getName());
        assertNull(nullCard.getCuisine());
        assertNull(nullCard.getRating());
        assertNull(nullCard.getAddress());
        assertNull(nullCard.getSuggestedFor());
    }

    @Test
    public void testGetName() {
        assertEquals(VALID_NAME, restaurantCard.getName());
    }

    @Test
    public void testGetCuisine() {
        assertEquals(VALID_CUISINE, restaurantCard.getCuisine());
    }

    @Test
    public void testGetRating() {
        assertEquals(VALID_RATING, restaurantCard.getRating());
    }

    @Test
    public void testGetAddress() {
        assertEquals(VALID_ADDRESS, restaurantCard.getAddress());
    }

    @Test
    public void testGetSuggestedFor() {
        assertEquals(VALID_SUGGESTED_FOR, restaurantCard.getSuggestedFor());
    }

    @Test
    public void testConstructorWithSpecialCharacters() {
        String specialChars = "!@#$%^&*()_+-=[]{}|;:'\",.<>?/\\";
        RestaurantCard specialCard = new RestaurantCard(
                specialChars,
                specialChars,
                specialChars,
                specialChars,
                specialChars
        );

        assertEquals(specialChars, specialCard.getName());
        assertEquals(specialChars, specialCard.getCuisine());
        assertEquals(specialChars, specialCard.getRating());
        assertEquals(specialChars, specialCard.getAddress());
        assertEquals(specialChars, specialCard.getSuggestedFor());
    }

    @Test
    public void testConstructorWithLongStrings() {
        String longString = "a".repeat(1000);
        RestaurantCard longCard = new RestaurantCard(
                longString,
                longString,
                longString,
                longString,
                longString
        );

        assertEquals(longString, longCard.getName());
        assertEquals(longString, longCard.getCuisine());
        assertEquals(longString, longCard.getRating());
        assertEquals(longString, longCard.getAddress());
        assertEquals(longString, longCard.getSuggestedFor());
    }

    @Test
    public void testConstructorWithWhitespaceStrings() {
        String whitespace = "   ";
        RestaurantCard whitespaceCard = new RestaurantCard(
                whitespace,
                whitespace,
                whitespace,
                whitespace,
                whitespace
        );

        assertEquals(whitespace, whitespaceCard.getName());
        assertEquals(whitespace, whitespaceCard.getCuisine());
        assertEquals(whitespace, whitespaceCard.getRating());
        assertEquals(whitespace, whitespaceCard.getAddress());
        assertEquals(whitespace, whitespaceCard.getSuggestedFor());
    }
}