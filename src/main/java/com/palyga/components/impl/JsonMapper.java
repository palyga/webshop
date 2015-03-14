package com.palyga.components.impl;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Admin on 12.03.2015.
 */

@Component
public class JsonMapper {

    @Autowired
    ObjectMapper objectMapper;

    public String getJson(Map<String,Integer> map){
        String json=null;
        try {
            json=objectMapper.writeValueAsString(map);
            return json;
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
