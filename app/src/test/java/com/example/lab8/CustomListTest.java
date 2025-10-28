package com.example.lab8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<City>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }
    @org.junit.Test

    public void hasCityTest() {
        list = MockCityList();
        City estevan = new City("Estevan", "SK");
        City redDeer = new City("Red Deer", "AB");

        list.addCity(estevan);

        org.junit.Assert.assertTrue(list.hasCity(new City("Estevan", "SK")));

        org.junit.Assert.assertFalse(list.hasCity(redDeer));
    }
    @org.junit.Test
    public void deleteCityTest() {
        list = MockCityList();
        City estevan = new City("Estevan", "SK");
        City toronto = new City("Toronto", "ON");
        list.addCity(estevan);
        list.addCity(toronto);

        int before = list.getCount();
        list.deleteCity(new City("Estevan", "SK"));
        org.junit.Assert.assertFalse(list.hasCity(estevan));
        org.junit.Assert.assertEquals(before - 1, list.getCount());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void deleteCityThrowsWhenMissing() {
        list = MockCityList();
        // never added "Red Deer"
        list.deleteCity(new City("Red Deer", "AB"));
    }
    @org.junit.Test

    public void countCitiesTest() {
        list = MockCityList();
        org.junit.Assert.assertEquals(0, list.countCities());

        list.addCity(new City("Estevan", "SK"));
        org.junit.Assert.assertEquals(1, list.countCities());

        list.addCity(new City("Toronto", "ON"));
        org.junit.Assert.assertEquals(2, list.countCities());
    }

}
