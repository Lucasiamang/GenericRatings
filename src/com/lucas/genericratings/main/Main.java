package com.lucas.genericratings.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lucas.genericratings.details.Title;
import com.lucas.genericratings.details.TitleOMDB;
import com.lucas.genericratings.profile.AverageRating;
import com.lucas.genericratings.profile.TimeWatched;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //so that the program can easily get the information within TitleOMDB without needing @SerializedName
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        String read = "";

        List<Title> arrayTitle= new ArrayList<>();
        TimeWatched calc = new TimeWatched();
        AverageRating avr = new AverageRating();

        while (!read.equals("9")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Write the name of the movie or series: \n press 9 to leave ");
            read = input.nextLine();
            read = read.replaceAll(" ", "+").toLowerCase();


            if (read.equals("9")){
                System.out.println("total watch time: " + calc.getSumTime());
                System.out.println("average of ratings: " + avr.getSumRatings()/avr.getAverage());
                break;
            }
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://www.omdbapi.com/?t=" + read + "&apikey=ff73bd4c")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //for now catching exceptions since the API has missing info on some movies. ex: into the spiderverse length
            try {
                System.out.println(response.body());
                TitleOMDB temp = gson.fromJson(response.body(), TitleOMDB.class);
                Title realTitle = new Title(temp);
                arrayTitle.add(realTitle);
                System.out.println(realTitle);
                calc.calcTime(realTitle);
                avr.calcRat(realTitle);
            } catch (NumberFormatException error) {
                System.out.println("found an error withing the OMDB database: " + error.getMessage());

            }

        }
        FileWriter jsonList = new FileWriter("titles.json");
        jsonList.write(gson.toJson(arrayTitle));
        jsonList.close();




    }

}
