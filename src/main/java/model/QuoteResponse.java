package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuoteResponse {

    @JsonProperty(value = "quote")
    List<Quote> quotes;

    public List<Quote> getQuote() {
        return quotes;
    }

    public void setQuote(List<Quote> quote) {
        this.quotes = quote;
    }

    @Override
    public String toString() {
        return "QuoteResponse{" +
                "quotes=" + quotes +
                '}';
    }
}