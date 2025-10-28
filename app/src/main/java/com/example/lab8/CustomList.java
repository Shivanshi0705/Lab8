package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);

    }
    public boolean hasCity(City city) {
        if (city == null) return false;
        for (City c : cities) {
            if (c.getCityName().equals(city.getCityName())
                    && c.getProvinceName().equals(city.getProvinceName())) {
                return true;
            }
        }
        return false;
    }
    public void deleteCity(City city) {
        if (city == null) throw new IllegalArgumentException("city is null");
        for (int i = 0; i < cities.size(); i++) {
            City c = cities.get(i);
            if (c.getCityName().equals(city.getCityName())
                    && c.getProvinceName().equals(city.getProvinceName())) {
                cities.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("city not found");
    }

}
