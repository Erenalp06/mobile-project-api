package com.mobileproject.news.favoritesapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(length = 1000)
    private String title;

    @Column(length = 1000)
    private String content;

    private String sourceId;

    private String sourceName;

    private String author;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String url;

    @Column(length = 1000)
    private String imageUrl;

    private String publishedAt;
}
