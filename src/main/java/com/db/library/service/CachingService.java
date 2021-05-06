package com.db.library.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.db.library.model.Book;
import com.db.library.repository.BookRepository;


@Service
@Component
@Configuration
@EnableCaching

public class CachingService {

	@Autowired
	private BookRepository bookRepository;
	
    @CacheEvict(value = "Books", allEntries = true)
    public void evictAllCacheValues() {}
    
    @CacheEvict(value = "first", key = "#cacheKey")
    public void evictSingleCacheValue(String cacheKey) {}
    
    
    @Cacheable("Books")
	public List<Book> findByDeleted(int deleted)
	{
    	System.out.println("From database");
     return	bookRepository.findByDeleted(0);
	}
}