package com.armendtahiraga;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Sorts.ascending;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb+srv://mendi:713_ArmTah@insyaufgabe.z474o3b.mongodb.net/?retryWrites=true&w=majority&appName=INSYAufgabe";

        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("VideoDB");
            MongoCollection<Document> collection = database.getCollection("Videos");
            FindIterable<Document> sortedVideos = collection.find().sort(ascending("title"));

            System.out.println("All videos sorted by title:");
            for (Document video : sortedVideos) {
                System.out.println(video.toJson());
            }
            System.out.println("----------------------------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter search query for video (title or description): ");
            String searchQuery = scanner.nextLine();
            List<Document> results = VideoSearcher.searchVideos(collection, searchQuery);

            if (results.isEmpty()) {
                System.out.println("No videos found matching the search.");
            } else {
                for (Document video : results) {
                    System.out.println(video.toJson());
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}