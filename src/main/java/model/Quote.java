package model;

import com.JSONParser.parser.CustomDateDeserializer;
import com.JSONParser.parser.CustomQuoteValueDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



public class Quote {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty(value = "date_applied")
    private String date_applied;

    @JsonDeserialize(using = CustomQuoteValueDeserializer.class)
    @JsonProperty("values")
    private QuoteValue quoteValue;


    public Quote() {
    }

    public String getDate_applied() {
        return date_applied;
    }

    public void setDate_applied(String date_applied) {
        this.date_applied = date_applied;
    }

    public QuoteValue getQuoteValue() {
        return quoteValue;
    }

    public void setQuoteValue(QuoteValue quoteValue) {
        this.quoteValue = quoteValue;
    }

    @Override
    public String toString() {
        return "Quote{" +
                " date_applied='" + date_applied + '\'' +
                ", quoteValue=" + quoteValue +
                '}';
    }

}
