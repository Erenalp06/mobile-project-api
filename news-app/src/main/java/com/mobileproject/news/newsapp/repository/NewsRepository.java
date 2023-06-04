package com.mobileproject.news.newsapp.repository;

import com.mobileproject.news.newsapp.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByCategoryName(String categoryName);
}
