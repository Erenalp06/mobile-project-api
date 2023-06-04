package com.mobileproject.news.newsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsApiResponse {
    private String status;
    private int totalResults;
    private List<Article> articles;
}
