package org.example.controller;

import org.example.model.Url;
import org.example.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping(value = "/url/shorten")
    public Url shortenUrl(@RequestBody Url url) {
        return urlService.shortenUrl(url);
    }

    @GetMapping(value = "/{alias}")
    public String getShortenUrl(@PathVariable String alias) {
        return urlService.getShortenUrl(alias);
    }
}
