package com.JSONParser.parser;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomDateDeserializer extends JsonDeserializer {

    private static final String TIME_ZONE = "GMT+1";
    private static final String DATE_FORMAT = "dd MMM yyyy HH:mm:ss z";


    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        Long toParse = p.getLongValue();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        format.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));

        String formattedActualDate = format.format(new Date(toParse));

        return formattedActualDate;
    }
}
