package com.mobileproject.news.newsapp.service.impl;

import com.mobileproject.news.newsapp.dto.NewsDTO;
import com.mobileproject.news.newsapp.entity.News;
import com.mobileproject.news.newsapp.exception.custom.NewsNotFoundException;
import com.mobileproject.news.newsapp.repository.NewsRepository;
import com.mobileproject.news.newsapp.service.NewsService;
import com.mobileproject.news.newsapp.util.NewsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository theNewsRepository;

    @Override
    public List<NewsDTO> findAll() {
        List<News> newsList = theNewsRepository.findAll();
        return newsList.stream()
                .map(NewsConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NewsDTO findById(Long id) {
        return theNewsRepository.findById(id)
                .map(NewsConverter::toDTO)
                .orElseThrow(NewsNotFoundException::new);
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        News news = theNewsRepository.save(NewsConverter.toEntity(newsDTO));
        return NewsConverter.toDTO(news);

    }

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        /*News existingNews = theNewsRepository.findById(newsDTO.getId())
                .orElseThrow(NewsNotFoundException::new);
        existingNews.setTitle(newsDTO.getTitle());
        existingNews.setContent(newsDTO.getContent());
        News updateNews = theNewsRepository.save(existingNews);
        return NewsConverter.toDTO(updateNews);*/
        return null;
    }

    @Override
    public void deleteById(Long id) {
        theNewsRepository.findById(id)
                .orElseThrow(NewsNotFoundException::new);
        theNewsRepository.deleteById(id);
    }
}
