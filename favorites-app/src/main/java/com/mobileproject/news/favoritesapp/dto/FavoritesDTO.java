package com.mobileproject.news.favoritesapp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoritesDTO {

    private Long id;
    private String email;
    private String title;
    private String content;
    private String sourceId;
    private String sourceName;
    private String author;
    private String description;
    private String url;
    private String imageUrl;
    private String publishedAt;
}
