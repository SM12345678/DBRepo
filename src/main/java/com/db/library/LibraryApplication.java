package com.db.library;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.db.library.repository.CustomRepositoryImpl;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class LibraryApplication {
	
	
	public static void main(String[] args) {
		
		
		  new SimpleCacheManager().setCaches(Arrays.asList( new
		  ConcurrentMapCache("Books"), new ConcurrentMapCache("authors")));
		 
		SpringApplication.run(LibraryApplication.class, args);
		
	}
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("Books");
    }

}
