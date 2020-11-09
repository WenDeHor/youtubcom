package com.studio.youtubcom;

import com.studio.youtubcom.telegram.BotService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@SpringBootApplication
@EnableScheduling
public class YoutubcomApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(YoutubcomApplication.class, args);
    }

}
