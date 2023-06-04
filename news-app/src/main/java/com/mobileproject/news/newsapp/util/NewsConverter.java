package com.mobileproject.news.newsapp.util;

import com.mobileproject.news.newsapp.dto.NewsDTO;
import com.mobileproject.news.newsapp.entity.News;
import org.modelmapper.ModelMapper;

public class NewsConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static NewsDTO toDTO(News news){
        return modelMapper.map(news, NewsDTO.class);
    }

    public static News toEntity(NewsDTO newsDTO){
        return modelMapper.map(newsDTO, News.class);
    }
}
