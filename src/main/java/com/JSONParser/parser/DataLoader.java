package com.JSONParser.parser;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.QuoteResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class DataLoader {


    @Value("${DataLoader.url}")
    String urlStr;

    URL url;

    public void init() throws MalformedURLException {
        if (this.url == null) {
            this.url = new URL(urlStr);
        }
    }

    public QuoteResponse load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(url, QuoteResponse.class);
    }

}
