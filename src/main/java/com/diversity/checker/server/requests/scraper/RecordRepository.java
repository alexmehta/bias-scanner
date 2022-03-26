package com.diversity.checker.server.requests.scraper;

import com.diversity.checker.server.entities.WebsiteRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<WebsiteRecord, String> {
}
