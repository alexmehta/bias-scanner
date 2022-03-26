package com.diversity.checker.server.requests.scraper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RequestsEndpoint {

    private final RequestsService requestsService;

    public RequestsEndpoint(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @PostMapping("/api/v1/website")
    public void scanWebsite(String url) throws IOException {
        requestsService.scanWebsite(url);
    }
}
