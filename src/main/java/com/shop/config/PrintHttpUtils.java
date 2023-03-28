package com.shop.config;


import com.alibaba.fastjson.JSONObject;
import com.shop.entity.Result;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class PrintHttpUtils {

    public void print(HttpServletResponse response, Result result) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSONObject.toJSONString(result));

        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
