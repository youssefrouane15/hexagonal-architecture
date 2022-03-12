package com.luv2kode.config;

import com.luv2kode.adapters.BookJpaAdapter;
import com.luv2kode.ports.api.BookServicePort;
import com.luv2kode.ports.spi.BookPersistencePort;
import com.luv2kode.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistence(){
        return new BookJpaAdapter();
    }

    @Bean
    public BookServicePort bookService(){
        return new BookServiceImpl(bookPersistence());
    }
}
