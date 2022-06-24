package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final RecordService service;

    public DemoApplication(RecordService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        System.out.println("STARTING THE APPLICATION");
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            service.makeTransaction();
        } catch (Exception e) {
            System.out.println("an exception occurred");
        }

        System.out.println(service.count());
    }
}
