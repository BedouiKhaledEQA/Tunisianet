package com.Tunisianet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties props=new Properties();

    public Base(){
        File file;
        String envirement =System.getProperty("env","local");
        if("local".equalsIgnoreCase(envirement)){
            file=new File("src/main/java/com/Tunisianet/Propeties/local_config.Properties");
        } else if ("prod".equalsIgnoreCase(envirement)) {
            file=new File("src/main/java/com/Tunisianet/Propeties/Prod_config.Properties");

        }else throw new RuntimeException("envirement n'est pas pris en charge !");

        try
            (FileInputStream fis =new FileInputStream(file)){
            props.load(fis);}
        catch (IOException e){
            throw  new RuntimeException("failed to load file ",e);
        }
    }

    public static WebDriver luncher(){
        String browser =System.getProperty("browser","chrome");
        switch (browser){

            case "chrome"->{
                driver=new ChromeDriver();
            }
            case "firefox"->{
                driver=new FirefoxDriver();
            }
            case "Edge"->{
                driver=new EdgeDriver();
            }
            default -> throw new RuntimeException("navigateur n'est pas pris en charge !"+browser);

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(props.getProperty("url"));
        return driver;



    }


}
