package com.sonaljha.urlshortener.service;

import com.sonaljha.urlshortener.model.ShortUrl;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

@Service
public class UrlService {

    private final Map<String, ShortUrl> storage = new ConcurrentHashMap<>();

    public ShortUrl createShortUrl(String originalUrl) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        ShortUrl url = new ShortUrl(id, originalUrl);
        storage.put(id, url);
        return url;
    }

    public String getOriginalUrl(String id) {
        ShortUrl url = storage.get(id);
        return url != null ? url.getOriginalUrl() : null;
    }
}
