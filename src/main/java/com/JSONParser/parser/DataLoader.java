package com.JSONParser.parser;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.QuoteResponse;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class DataLoader {

    private static final String url = "src/test/resources/data/data.json";

    @PostConstruct
    public void init() {
        QuoteResponse response = null;
        try {
            response = parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public QuoteResponse parse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(Files.readAllBytes(Paths.get(url)), QuoteResponse.class);
    }
}

