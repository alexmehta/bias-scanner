package com.diversity.checker.server.requests.scraper;

import com.diversity.checker.server.entities.ObjectionableContent;
import com.diversity.checker.server.entities.WebsiteRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class RequestsService {

    private final RecordRepository repository;
    private final ObjectionableContentRepository objectionableContentRepository;

    public RequestsService(RecordRepository repository, ObjectionableContentRepository objectionableContentRepository) {
        this.repository = repository;
        this.objectionableContentRepository = objectionableContentRepository;
    }

    public WebsiteRecord scanWebsite(String url) throws IOException {
        WebsiteRecord websiteRecord = new WebsiteRecord(url);
        Document website = Jsoup.connect(url).get();
        Element element = website.body();
        String objContent = getObjectionable(element);
        String summary = getObjectionableSummary(element);
        String selector = element.cssSelector();
        ObjectionableContent o = new ObjectionableContent(summary, objContent, selector);
        objectionableContentRepository.save(o);
        websiteRecord.getObjectionableContentList().add(o);
        System.out.println(summary);
        repository.save(websiteRecord);
        return websiteRecord;
    }

    private String getObjectionableSummary(Element element) throws IOException {
        File dir = new File("biased-words");
        HashSet<String> detections = new HashSet<>();
        File[] dirlist = dir.listFiles();
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(element.text().split(" ")));
        if (dirlist != null) {
            for (File file : dirlist) {
                if (file.getName().length() <= 3) continue;
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = br.readLine();
                while (line != null) {
                    if (words.contains(line)) {
                        detections.add(file.getName() + ", ");
                    }
                    line = br.readLine();
                }
            }
        }
        String word = "";
        for (String detection : detections) {
            word += detection + ", ";
        }
        return word;
    }

    private String getObjectionable(Element element) throws IOException {
        File dir = new File("biased-words");
        HashSet<String> detections = new HashSet<>();
        File[] dirlist = dir.listFiles();
        ArrayList<String> words = new ArrayList<String>(Arrays.asList(element.text().split(" ")));
        if (dirlist != null) {
            for (File file : dirlist) {
                if (file.getName().length() <= 3) continue;
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = br.readLine();
                while (line != null) {
                    if (words.contains(line)) {
                        detections.add(line);
                    }
                    line = br.readLine();
                }
            }
        }
        String word = "";
        for (String detection : detections) {
            word += detection + ", ";
        }
        return word;

    }


}
