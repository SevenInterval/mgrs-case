package com.migros;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migros.dto.StoreDto;
import com.migros.model.Store;
import com.migros.service.IStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SpringBootMigrosCaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMigrosCaseApplication.class, args);
    }

    Logger logger = LoggerFactory.getLogger( SpringBootMigrosCaseApplication.class );

    @Bean
    CommandLineRunner runner(IStoreService storeService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<StoreDto>> typeReference = new TypeReference<List<StoreDto>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/database/schema/schema.json");
            try {
                List<StoreDto> storeList = mapper.readValue(inputStream,typeReference);
                for (StoreDto store: storeList ) {
                    storeService.saveStore(store);
                }
                logger.info("First store commit succesfully saved!");

            } catch (IOException e){
                logger.error("saveStore error first runner: " + e.getMessage());
            }
        };
    }
}
