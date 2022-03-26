package com.diversity.checker.server.websitehistory;

import com.diversity.checker.server.entities.WebsiteLedger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SaveWebsiteHistoryController {
    private final LedgerService ledgerService;

    public SaveWebsiteHistoryController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @GetMapping("/get/url/")
    public WebsiteLedger websiteLedger( String url) throws IOException {
       return ledgerService.getWebsite(url);
    }
}
