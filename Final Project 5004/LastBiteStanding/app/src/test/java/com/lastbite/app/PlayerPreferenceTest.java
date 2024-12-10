package com.lastbite.app;

import android.os.Parcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class PlayerPreferenceTest {

    @Test
    public void testConstructorWithValidInput() {
        String name = "John";
        String cuisine = "Italian";
        PlayerPreference preference = new PlayerPreference(name, cuisine);

        assertEquals("Name should match constructor input", name, preference.name);
        assertEquals("Cuisine should match constructor input", cuisine, preference.cuisine);
    }

    @Test
    public void testConstructorWithEmptyStrings() {
        PlayerPreference preference = new PlayerPreference("", "");

        assertEquals("Name should be empty string", "", preference.name);
        assertEquals("Cuisine should be empty string", "", preference.cuisine);
    }

    @Test
    public void testConstructorWithNullValues() {
        PlayerPreference preference = new PlayerPreference(null, null);

        assertNull("Name should be null", preference.name);
        assertNull("Cuisine should be null", preference.cuisine);
    }

    @Test
    public void testConstructorWithSpecialCharacters() {
        String specialName = "John!@#$%^&*()";
        String specialCuisine = "Italian~`{}[]|\\";
        PlayerPreference preference = new PlayerPreference(specialName, specialCuisine);

        assertEquals("Name should handle special characters", specialName, preference.name);
        assertEquals("Cuisine should handle special characters", specialCuisine, preference.cuisine);
    }

    @Test
    public void testParcelableWriteAndRead() {
        String name = "John";
        String cuisine = "Italian";
        PlayerPreference originalPreference = new PlayerPreference(name, cuisine);

        // Write to parcel
        Parcel parcel = Parcel.obtain();
        originalPreference.writeToParcel(parcel, 0);

        // Reset parcel for reading
        parcel.setDataPosition(0);

        // Read from parcel
        PlayerPreference createdFromParcel = PlayerPreference.CREATOR.createFromParcel(parcel);

        assertEquals("Name should survive parceling", name, createdFromParcel.name);
        assertEquals("Cuisine should survive parceling", cuisine, createdFromParcel.cuisine);

        parcel.recycle();
    }

    @Test
    public void testParcelableWithEmptyStrings() {
        PlayerPreference originalPreference = new PlayerPreference("", "");

        Parcel parcel = Parcel.obtain();
        originalPreference.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        PlayerPreference createdFromParcel = PlayerPreference.CREATOR.createFromParcel(parcel);

        assertEquals("Empty name should survive parceling", "", createdFromParcel.name);
        assertEquals("Empty cuisine should survive parceling", "", createdFromParcel.cuisine);

        parcel.recycle();
    }

    @Test
    public void testParcelableWithNullValues() {
        PlayerPreference originalPreference = new PlayerPreference(null, null);

        Parcel parcel = Parcel.obtain();
        originalPreference.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        PlayerPreference createdFromParcel = PlayerPreference.CREATOR.createFromParcel(parcel);

        assertNull("Null name should survive parceling", createdFromParcel.name);
        assertNull("Null cuisine should survive parceling", createdFromParcel.cuisine);

        parcel.recycle();
    }

    @Test
    public void testParcelableWithSpecialCharacters() {
        String specialName = "John!@#$%^&*()";
        String specialCuisine = "Italian~`{}[]|\\";
        PlayerPreference originalPreference = new PlayerPreference(specialName, specialCuisine);

        Parcel parcel = Parcel.obtain();
        originalPreference.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        PlayerPreference createdFromParcel = PlayerPreference.CREATOR.createFromParcel(parcel);

        assertEquals("Special characters in name should survive parceling",
                specialName, createdFromParcel.name);
        assertEquals("Special characters in cuisine should survive parceling",
                specialCuisine, createdFromParcel.cuisine);

        parcel.recycle();
    }

    @Test
    public void testParcelableWithLongStrings() {
        String longName = "a".repeat(1000);
        String longCuisine = "b".repeat(1000);
        PlayerPreference originalPreference = new PlayerPreference(longName, longCuisine);

        Parcel parcel = Parcel.obtain();
        originalPreference.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);

        PlayerPreference createdFromParcel = PlayerPreference.CREATOR.createFromParcel(parcel);

        assertEquals("Long name should survive parceling", longName, createdFromParcel.name);
        assertEquals("Long cuisine should survive parceling", longCuisine, createdFromParcel.cuisine);

        parcel.recycle();
    }

    @Test
    public void testDescribeContents() {
        PlayerPreference preference = new PlayerPreference("John", "Italian");
        assertEquals("describeContents should return 0", 0, preference.describeContents());
    }

    @Test
    public void testCreatorNewArray() {
        PlayerPreference[] array = PlayerPreference.CREATOR.newArray(5);

        assertNotNull("Created array should not be null", array);
        assertEquals("Created array should have correct length", 5, array.length);
        assertNull("Array elements should be null initially", array[0]);
    }

    @Test
    public void testCreatorNewArrayWithZeroSize() {
        PlayerPreference[] array = PlayerPreference.CREATOR.newArray(0);

        assertNotNull("Created array should not be null", array);
        assertEquals("Created array should have zero length", 0, array.length);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testCreatorNewArrayWithNegativeSize() {
        PlayerPreference.CREATOR.newArray(-1);
    }
}