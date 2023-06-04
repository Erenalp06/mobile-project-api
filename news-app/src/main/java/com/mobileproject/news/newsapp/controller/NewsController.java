package com.mobileproject.news.newsapp.controller;

import com.mobileproject.news.newsapp.dto.NewsDTO;
import com.mobileproject.news.newsapp.service.NewsService;
import com.mobileproject.news.newsapp.service.impl.NewsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService theNewsService;
    private final NewsApiService theNewsApiService;

    @GetMapping
    public List<NewsDTO> findAll(){
        return theNewsApiService.getAllNews();
    }

    @GetMapping("/fetch/{categoryName}")
    public List<NewsDTO> fetchAll(@PathVariable String categoryName){
        return  theNewsApiService.fetchNewsFromApi(categoryName);
    }

    @GetMapping("/{categoryName}")
    public List<NewsDTO> findNewsByCategoryName(@PathVariable String categoryName){
        return theNewsApiService.findNewsByCategory(categoryName);
    }

    @DeleteMapping("/all")
    public String deleteAll(){
        return theNewsApiService.deleteAllNews();
    }


}
