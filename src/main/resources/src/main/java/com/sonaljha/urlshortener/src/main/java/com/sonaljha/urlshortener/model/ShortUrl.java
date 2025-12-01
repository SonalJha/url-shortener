package com.sonaljha.urlshortener.model;

public class ShortUrl {
    private String id;
    private String originalUrl;

    public ShortUrl(String id, String originalUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
    }

    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
