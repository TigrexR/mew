package com.tigrex.core.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author linus
 */
public class JacksonUtils {

    static ObjectMapper objectMapper;
    static XmlMapper xmlMapper;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper = new XmlMapper();
    }

    private JacksonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static ObjectMapper getJackson() {
        return objectMapper;
    }

    public static XmlMapper getXml() {
        return xmlMapper;
    }
}
