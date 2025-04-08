package com.armendtahiraga;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Sorts.ascending;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb+srv://mendi:713_ArmTah@insyaufgabe.z474o3b.mongodb.net/?retryWrites=true&w=majority&appName=INSYAufgabe";

        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("VideoDB");
            MongoCollection<Document> collection = database.getCollection("Videos");
            FindIterable<Document> sortedVideos = collection.find().sort(ascending("title"));

            for (Document video : sortedVideos) {
                System.out.println(video.toJson());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}