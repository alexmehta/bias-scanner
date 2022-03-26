package com.diversity.checker.server.websitehistory;

import com.diversity.checker.server.entities.WebsiteLedger;
import com.diversity.checker.server.entities.WebsiteRecord;
import com.diversity.checker.server.requests.scraper.RequestsService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LedgerService {
    private final LedgerRepository ledgerRepository;
    private final RequestsService requestsService;

    public LedgerService(LedgerRepository ledgerRepository, RequestsService requestsService) {
        this.ledgerRepository = ledgerRepository;
        this.requestsService = requestsService;
    }

    public WebsiteLedger getWebsite(String url) throws IOException {
    WebsiteRecord website = requestsService.scanWebsite(url);
        if (ledgerRepository.findById(url).isPresent()) {
            WebsiteLedger w = ledgerRepository.findById(url).get();
            w.getRecordList().add(website);
            ledgerRepository.save(w);
            return w;
        } else {
            WebsiteLedger w = new WebsiteLedger(url);
            w.getRecordList().add(website);
            return w;
        }
    }
}
