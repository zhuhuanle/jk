package com.zhu.two.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author : zhu_huan
 * @createTime : 2021/3/23
 **/
@Slf4j
public class TestHttpClient {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("http://localhost:8150/test");

        CloseableHttpResponse response= null;

        try {
            response = httpClient.execute(httpGet);
            if (response == null) {
                throw new RuntimeException("返回值为空");
            }
            StatusLine statusLine = response.getStatusLine();
            log.info("statusLine{}",statusLine);
            HttpEntity entity = response.getEntity();
            log.info("返回值{}", EntityUtils.toString(entity));
        }catch (Exception e){
            log.error("请求异常{}", e.getMessage());
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
