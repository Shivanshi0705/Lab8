package com.example.lab8;

import java.util.List;

public class CustomList {

    private final List<City> cities;

    public CustomList(Object context, List<City> cities) {
        this.cities = cities;
    }

    public int getCount() {
        return cities.size();
    }

    public void addCity(City city) {
        cities.add(city);
    }
}
