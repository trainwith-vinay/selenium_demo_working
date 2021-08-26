package com.example.demo;


import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RestController
@RequestMapping(path = "/")
public class RestApiController {

    @GetMapping(path = "/displaytime")
    public String getTime() {

        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        return "Current time in local is :"+myObj;
    }

    @GetMapping(path = "/runTest")
    public String runTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.close();
        driver.quit();
        return "Test Completed";
    }
    
}
