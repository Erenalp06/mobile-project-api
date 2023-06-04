package com.mobileproject.news.favoritesapp.service;


import com.mobileproject.news.favoritesapp.dto.FavoritesDTO;
import com.mobileproject.news.favoritesapp.dto.NewsDTO;
import com.mobileproject.news.favoritesapp.entity.Favorites;

import java.util.List;

public interface FavoritesService {

    List<FavoritesDTO> findAll();

    List<NewsDTO> findFavoritesByEmail(String email);

    FavoritesDTO createAddNewsToFavorites(FavoritesDTO favoritesDTO);

    boolean findByTitle(String title);


}
