package uz.pdp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            String city = "";
            System.out.println("Qaysi shaharni ob-havosini nilmoqchisiz nomini kiriting - ");
            Scanner scanner = new Scanner(System.in);
            city = scanner.nextLine();

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=4fe48ed053b93226297c6e65619b0194");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

            JsonObject jsonElements = jsonObject.getAsJsonObject("main");
            Weather weather = gson.fromJson(jsonElements, Weather.class);
            System.out.println("Hozir " + city + " da " + Math.round(weather.getTemp() - 273.15) + " gradus");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
