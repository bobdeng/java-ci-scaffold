package com.example.scaffold;

import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;

public class HttpCallSteps {
    @Autowired
    HttpCall httpCall;

    @Then("网络请求返回 {int}")
    public void 网络请求返回(int code) {
        httpCall.getLastResponse().assertCode(code);
    }
}
