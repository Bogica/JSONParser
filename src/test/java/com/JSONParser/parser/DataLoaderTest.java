package com.JSONParser.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Quote;
import model.QuoteResponse;
import model.QuoteValue;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @Test
    public void load() throws Exception {

        DataLoader sut = new DataLoader();
        sut.url = getClass().getResource("data.json");
        QuoteResponse response = sut.load();
        assertNotNull(response);

        assertNotNull(response.getQuote());
        assertFalse(ObjectUtils.isEmpty(response.getQuote()));

        Quote quote = response.getQuote().get(0);

        QuoteValue quoteValue = quote.getQuoteValue();
        assertNotNull(quoteValue);
        assertEquals(4514.2, quoteValue.getNetVolume(), 0.0);
        assertEquals(1, quoteValue.getHour().intValue());
        assertEquals(34, quoteValue.getPrice().doubleValue(), 0.0);

        for(Quote quotes : response.getQuote()) {
            System.out.println(quotes.toString());
        }

    }

    @Test
    public void deserializeQuoteValue() throws IOException {

        String json = "{\"hour\":23,\"netVolume\":4746.6,\"price\":40.14}";
        QuoteValue response = new ObjectMapper().readValue(json, QuoteValue.class);
        assertEquals(4746.6, response.getNetVolume(), 0.0);

    }

}