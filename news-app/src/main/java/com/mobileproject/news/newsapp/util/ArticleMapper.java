package com.mobileproject.news.newsapp.util;

import com.mobileproject.news.newsapp.dto.Article;
import com.mobileproject.news.newsapp.dto.NewsDTO;
import com.mobileproject.news.newsapp.entity.News;

import java.util.ArrayList;
import java.util.List;

public class ArticleMapper {
    public static NewsDTO mapToDto(Article article) {
        return NewsDTO.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .sourceId(article.getSource().getId())
                .sourceName(article.getSource().getName())
                .author(article.getAuthor())
                .description(article.getDescription())
                .url(article.getUrl())
                .imageUrl(article.getUrlToImage())
                .publishedAt(article.getPublishedAt())
                .build();
    }

    public static News mapToEntity(NewsDTO newsDTO) {
        return News.builder()
                .title(newsDTO.getTitle())
                .content(newsDTO.getContent())
                .build();
    }

    public static List<NewsDTO> mapToNewsDTOList(List<Article> articles) {
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (Article article : articles) {
            NewsDTO newsDTO = mapToDto(article);
            newsDTO.setId(null); // id alanını null olarak ayarlayın
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }
}
