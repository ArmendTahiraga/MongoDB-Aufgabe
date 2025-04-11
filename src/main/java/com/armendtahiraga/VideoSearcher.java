package com.armendtahiraga;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class VideoSearcher {
    public static List<Document> searchVideos(MongoCollection<Document> collection, String searchQuery) {
        return collection.find(
                Filters.or(
                        Filters.regex("title", searchQuery, "i"),
                        Filters.regex("description", searchQuery, "i")
                )
        ).into(new ArrayList<>());
    }
}
