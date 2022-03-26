package com.diversity.checker.server.requests.scraper;

import com.diversity.checker.server.entities.ObjectionableContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectionableContentRepository extends JpaRepository<ObjectionableContent, Long> {
}
