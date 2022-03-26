package com.diversity.checker.server.websitehistory;

import com.diversity.checker.server.entities.WebsiteLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LedgerRepository extends JpaRepository<WebsiteLedger, String> {

}
