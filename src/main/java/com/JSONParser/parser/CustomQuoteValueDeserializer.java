package com.JSONParser.parser;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import model.QuoteValue;


import java.io.IOException;
import java.math.BigDecimal;

public class CustomQuoteValueDeserializer extends JsonDeserializer {

    private static final String T_LABEL = "tLabel";
    private static final String VALUE = "value";
    private static final String HOUR = "Hour";
    private static final String NET_VOLUME = "Net Volume";
    private static final String PRICE = "Price";


    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ArrayNode array = p.getCodec().readTree(p);

        QuoteValue quoteValue = new QuoteValue();

        for (JsonNode node : array) {
            String type = node.get(T_LABEL).asText();
            String value = node.get(VALUE).asText();

            if (HOUR.equals(type)) {
                quoteValue.setHour(new Integer(value));
            } else if (NET_VOLUME.equals(type)) {
                quoteValue.setNetVolume(new Double(value));
            } else if (PRICE.equals(type))
                quoteValue.setPrice(new BigDecimal(value));
        }

        return quoteValue;
    }
}
