package com.example.scaffold;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.okhttp3.OkHttpClient;
import org.testcontainers.shaded.okhttp3.Request;
import org.testcontainers.shaded.okhttp3.Response;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class HttpCall {
    @Autowired
    private Environment env;
    private OkHttpClient httpClient;
    private HttpResponse lastResponse;

    @PostConstruct
    public void init() {
        httpClient = new OkHttpClient.Builder().build();
    }

    public void get(String url) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(getServer() + url)
                .get();
        this.lastResponse = new HttpResponse(callRequest(builder));
    }

    private String getServer() {
        return "http://localhost:" + env.getProperty("local.server.port") + "/";
    }

    private Response callRequest(Request.Builder builder) throws IOException {
        Request request = builder.build();
        Response response = httpClient.newCall(request).execute();
        return response;
    }

    public HttpResponse getLastResponse() {
        return lastResponse;
    }
}
