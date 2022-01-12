package com.example.scaffold;

import org.testcontainers.shaded.okhttp3.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class HttpResponse {
    private int code;
    private String content;

    public HttpResponse(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public HttpResponse(Response response) throws IOException {
        this.code = response.code();
        this.content = response.body().string();
    }

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    public void assertCode(int code) {
        assertThat(this.code, is(code));
    }
}