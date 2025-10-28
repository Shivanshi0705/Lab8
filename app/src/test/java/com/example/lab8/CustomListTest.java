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

        // should find an existing city
        org.junit.Assert.assertTrue(list.hasCity(new City("Estevan", "SK")));

        // should not find a city we never added
        org.junit.Assert.assertFalse(list.hasCity(redDeer));
    }
}
