package com.armendtahiraga;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
        String uri = "mongodb+srv://mendi:713_ArmTah@insyaufgabe.z474o3b.mongodb.net/?retryWrites=true&w=majority&appName=INSYAufgabe";

        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("VideoDB");
            System.out.println("Verbindung erfolgreich zu: " + database.getName());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}