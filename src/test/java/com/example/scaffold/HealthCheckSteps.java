package com.example.scaffold;

import com.example.scaffold.Application;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

@ActiveProfiles(profiles = "ac")
@ContextConfiguration(classes = {Application.class}, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class HealthCheckSteps {
    @Autowired
    HttpCall httpCall;

    @When("访问健康检查接口")
    public void 访问健康检查接口() throws IOException {
        httpCall.get("/health");
    }
}
