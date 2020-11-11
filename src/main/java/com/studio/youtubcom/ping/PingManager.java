package com.studio.youtubcom.ping;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;


@Service
@Slf4j
@Getter
@Setter
@PropertySource("classpath:application.properties")
public class PingManager {
    @Value("${pingmanager.url}")
    private String url;

    @Scheduled(fixedRateString = "${pingmanager.period}")
    public void pingMe() {
        try {
            int hours = new Date().getHours();

            System.out.println(hours);
            if (hours == 23) {
                URL url = new URL(getUrl());
                url.wait(21600000);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                log.info("Ping {}, OK: response code {}", url.getHost(), connection.getResponseCode());
                connection.disconnect();
            }

        } catch (IOException | InterruptedException e) {
            log.error("Ping FAILED");
            e.printStackTrace();
        }

    }

}
