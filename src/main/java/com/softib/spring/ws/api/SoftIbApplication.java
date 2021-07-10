package com.softib.spring.ws.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.alicebot.ab.Bot;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftIbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftIbApplication.class, args);
	}
}



