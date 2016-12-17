package com.AlejandroSeaah;

import com.AlejandroSeaah.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alejandroseaah on 16/12/17.
 */
public class PluginsTest {
    @Test
    public void ProfileTest() throws DataProcessException {
        Nationality nat = new Nationality();
        String value = "{\n" +
                "    \"topic\": \"profile\",\n" +
                "    \"username\": \"alejandro\",\n" +
                "    \"gender\": 0,\n" +
                "    \"nationality\": 2,\n" +
                "    \"address\": {\n" +
                "        \"street\": \"颐和园5号.\",\n" +
                "        \"city\": \"北京\",\n" +
                "        \"country\": \"中国\"\n" +
                "    }\n" +
                "}";
        String topic = "profile";
        Input input = new Input(topic, value);

        Output output =  nat.Process(input);
        String json = output.getValue();
        JSONObject obj = JSON.parseObject(json);
        assertEquals("中国",obj.getString("nationality"));
    }

    @Test
    public void OrderTest() throws DataProcessException {
        Order order = new Order();

        String value = "{\n" +
                "    \"topic\": \"order\",\n" +
                "    \"product\": \"Iphone\",\n" +
                "    \"price\": 100,\n" +
                "    \"discount\": 97,\n" +
                "    \"address\": {\n" +
                "        \"street\": \"颐和园5号.\",\n" +
                "        \"city\": \"北京\",\n" +
                "        \"country\": \"中国\"\n" +
                "    }\n" +
                "}";
        String topic = "order";
        Input input = new Input(topic, value);


        Output output =  order.Process(input);
        String json = output.getValue();
        JSONObject obj = JSON.parseObject(json);
        assertEquals("97",obj.getString("real_price"));
    }
}
