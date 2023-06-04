package com.mobileproject.news.newsapp.service.impl;

import com.mobileproject.news.newsapp.dto.Article;
import com.mobileproject.news.newsapp.dto.NewsApiResponse;
import com.mobileproject.news.newsapp.dto.NewsDTO;
import com.mobileproject.news.newsapp.entity.News;
import com.mobileproject.news.newsapp.repository.NewsRepository;
import com.mobileproject.news.newsapp.util.ArticleMapper;
import com.mobileproject.news.newsapp.util.NewsApiInterceptor;
import com.mobileproject.news.newsapp.util.NewsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsApiService {

    private final RestTemplate restTemplate;
    private final NewsRepository newsRepository;

    public NewsApiService(RestTemplate restTemplate, NewsRepository newsRepository) {
        this.restTemplate = restTemplate;
        this.newsRepository = newsRepository;
    }

    public List<NewsDTO> fetchNewsFromApi(String categoryName) {

        List<News> newsList = newsRepository.findByCategoryName(categoryName);

        if (!newsList.isEmpty()) {
            return newsList.stream()
                    .map(NewsConverter::toDTO)
                    .collect(Collectors.toList());
        }
        String apiUrl = "https://newsapi.org/v2/everything?q=" + categoryName;

        restTemplate.getInterceptors().add(new NewsApiInterceptor());

        NewsApiResponse response = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
        List<Article> articles = response.getArticles();

        List<NewsDTO> newsDTOList = ArticleMapper.mapToNewsDTOList(articles);

        // Haberleri veritabanına kaydet
        for (NewsDTO newsDTO : newsDTOList) {
            News news = NewsConverter.toEntity(newsDTO);
            news.setCategoryName(categoryName);
            newsRepository.save(news);
        }
        return newsDTOList;
    }

    public List<NewsDTO> getAllNews() {
        // Veritabanından tüm haberleri getir
        List<News> newList = newsRepository.findAll();
        return newList.stream()
                .map(NewsConverter::toDTO)
                .collect(Collectors.toList());
    }

    public String deleteAllNews(){
        newsRepository.deleteAll();
        return "all news deleted";
    }

    public List<NewsDTO> findNewsByCategory(String categoryName){
        List<News> newsList = newsRepository.findByCategoryName(categoryName);
        return newsList.stream()
                .map(NewsConverter::toDTO)
                .collect(Collectors.toList());
    }
}
