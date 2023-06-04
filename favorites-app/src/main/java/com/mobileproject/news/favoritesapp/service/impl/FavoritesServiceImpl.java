package com.mobileproject.news.favoritesapp.service.impl;

import com.mobileproject.news.favoritesapp.dto.FavoritesDTO;
import com.mobileproject.news.favoritesapp.dto.NewsDTO;
import com.mobileproject.news.favoritesapp.entity.Favorites;
import com.mobileproject.news.favoritesapp.repository.FavoritesRepository;
import com.mobileproject.news.favoritesapp.service.FavoritesService;
import com.mobileproject.news.favoritesapp.util.FavoritesConverter;
import com.mobileproject.news.favoritesapp.util.NewsDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;


    @Override
    public List<FavoritesDTO> findAll() {
        return favoritesRepository.findAll()
                .stream()
                .map(FavoritesConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findFavoritesByEmail(String email) {
        List<Favorites> favoritesList = favoritesRepository.findByEmail(email);
        List<NewsDTO> newsDTOList = new ArrayList<>();

        for (Favorites favorites : favoritesList) {
            FavoritesDTO favoritesDTO = FavoritesConverter.toDTO(favorites);
            NewsDTO newsDTO = NewsDTOConverter.toNewsDTO(favoritesDTO);
            newsDTOList.add(newsDTO);
        }

        return newsDTOList;
    }


    @Override
    public FavoritesDTO createAddNewsToFavorites(FavoritesDTO favoritesDTO) {
        Favorites favorites = FavoritesConverter.toEntity(favoritesDTO);
        Favorites createdFavorites = favoritesRepository.save(favorites);
        return FavoritesConverter.toDTO(createdFavorites);
    }

    @Override
    public boolean findByTitle(String title) {
        Optional<Favorites> favoritesOptional = favoritesRepository.findByTitle(title);
        if(favoritesOptional.isPresent()){
            return true;
        }
        return false;
    }
}
