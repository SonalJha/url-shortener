package com.sonaljha.urlshortener.controller;

import com.sonaljha.urlshortener.model.ShortUrl;
import com.sonaljha.urlshortener.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortUrl> shorten(@RequestParam String url) {
        ShortUrl shortUrl = service.createShortUrl(url);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        String originalUrl = service.getOriginalUrl(id);

        if (originalUrl == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(302)
                .header("Location", originalUrl)
                .build();
    }
}
