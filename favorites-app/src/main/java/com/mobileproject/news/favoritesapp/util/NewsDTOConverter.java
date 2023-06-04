package com.mobileproject.news.favoritesapp.util;

import com.mobileproject.news.favoritesapp.dto.FavoritesDTO;
import com.mobileproject.news.favoritesapp.dto.NewsDTO;

public class NewsDTOConverter {

    public static FavoritesDTO toFavoritesDTO(NewsDTO newsDTO) {
        return FavoritesDTO.builder()
                .id(newsDTO.getId())
                .email(null) // E-posta alanı boş kalacak, çünkü NewsDTO'da e-posta bilgisi yok.
                .title(newsDTO.getTitle())
                .content(newsDTO.getContent())
                .sourceId(newsDTO.getSourceId())
                .sourceName(newsDTO.getSourceName())
                .author(newsDTO.getAuthor())
                .description(newsDTO.getDescription())
                .url(newsDTO.getUrl())
                .imageUrl(newsDTO.getImageUrl())
                .publishedAt(newsDTO.getPublishedAt())
                .build();
    }

    public static NewsDTO toNewsDTO(FavoritesDTO favoritesDTO) {
        return NewsDTO.builder()
                .id(favoritesDTO.getId())
                .sourceId(favoritesDTO.getSourceId())
                .sourceName(favoritesDTO.getSourceName())
                .author(favoritesDTO.getAuthor())
                .title(favoritesDTO.getTitle())
                .description(favoritesDTO.getDescription())
                .url(favoritesDTO.getUrl())
                .imageUrl(favoritesDTO.getImageUrl())
                .publishedAt(favoritesDTO.getPublishedAt())
                .content(favoritesDTO.getContent())
                .build();
    }
}
