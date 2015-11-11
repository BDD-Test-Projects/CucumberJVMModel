package com.newsint.xplore.qa.api;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
* Created with IntelliJ IDEA.
* User: Vinod Kumar M
* Date: 28/06/12
* Time: 14:49
* To change this template use File | Settings | File Templates.
*/
public class JSONParser {

    public static Map<String, Object> actual = new HashMap<String, Object>();

    public static void getJsonValues(String rootName, int index) throws JSONException {

        String jsString = RestClient.getResponseAsString();

        JSONObject obj = new JSONObject(jsString);
        JSONObject startLocation = obj.getJSONArray(rootName).optJSONObject(index);
        System.out.println("The actual value of id is :"+ startLocation.get("id"));
        System.out.println("The actual value of id is :"+ startLocation.get("name"));
        System.out.println("The actual value of id is :"+ startLocation.get("version"));
        actual.put("id", startLocation.get("id"));
        actual.put("name", startLocation.get("name"));
        actual.put("version", startLocation.get("version"));
    }





}
