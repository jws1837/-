package com.flab.baseballgame.configuration;

import com.flab.baseballgame.repository.InMemoryRepository;
import com.flab.baseballgame.repository.Repository;
import com.flab.baseballgame.service.BaseballService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class baseballConfiguration {

    @Bean
    public Repository repository() {
        return new InMemoryRepository();
    }

    @Bean
    public BaseballService service(){
        return new BaseballService(repository());
    }

}
