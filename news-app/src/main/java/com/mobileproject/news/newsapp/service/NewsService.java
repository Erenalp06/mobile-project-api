package com.mobileproject.news.newsapp.service;


import com.mobileproject.news.newsapp.dto.NewsDTO;

import java.util.List;

public interface NewsService {

    List<NewsDTO> findAll();

    NewsDTO findById(Long id);

    NewsDTO save(NewsDTO newsDTO);

    NewsDTO update(NewsDTO newsDTO);

    void deleteById(Long id);
}
