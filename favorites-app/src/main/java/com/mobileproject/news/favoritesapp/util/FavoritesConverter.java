package com.mobileproject.news.favoritesapp.util;

import com.mobileproject.news.favoritesapp.dto.FavoritesDTO;
import com.mobileproject.news.favoritesapp.entity.Favorites;
import org.modelmapper.ModelMapper;

public class FavoritesConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static FavoritesDTO toDTO(Favorites favorites){
        return modelMapper.map(favorites, FavoritesDTO.class);
    }

    public static Favorites toEntity(FavoritesDTO favoritesDTO){
        return modelMapper.map(favoritesDTO, Favorites.class);
    }
}
