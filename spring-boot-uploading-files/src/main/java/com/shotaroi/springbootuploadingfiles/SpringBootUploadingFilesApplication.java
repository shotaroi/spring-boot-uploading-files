package com.shotaroi.springbootuploadingfiles;

import com.shotaroi.springbootuploadingfiles.storage.StorageProperties;
import com.shotaroi.springbootuploadingfiles.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringBootUploadingFilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUploadingFilesApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
