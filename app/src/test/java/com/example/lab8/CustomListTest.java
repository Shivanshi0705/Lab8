package com.example.lab8;

import java.util.List;

public class CustomList {

    private final List<City> cities;

    public CustomList(Object context, List<City> cities) {
        this.cities = cities;
    }

    /** this gets size of the list */
    public int getCount() {
        return cities.size();
    }

    /** this adds a city object to the list */
    public void addCity(City city) {
        cities.add(city);
    }
}
