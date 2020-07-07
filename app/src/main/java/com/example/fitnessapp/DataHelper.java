package com.example.fitnessapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataHelper {
    public static  ArrayList<Workout> loadWorkout(Context context){
        ArrayList<Workout> workouts = new ArrayList<>();
        String json = "";

        try {
            InputStream is = context.getAssets().open("girlsBench.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("girlsBenchmark");

            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String t = (jsonObject.getString("title"));
                String w = (jsonObject.getString("wod"));
                workouts.add(new Workout(t, w));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return workouts;
    }

    public static  ArrayList<Workout> loadWorkout1(Context context){
        ArrayList<Workout> workouts = new ArrayList<>();
        String json = "";

        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("girlsBenchmark");

            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String t = (jsonObject.getString("title"));
                String w = (jsonObject.getString("wod"));
                workouts.add(new Workout(t, w));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }    return workouts;
    }
}
