package com.mobileproject.news.favoritesapp.controller;

import com.mobileproject.news.favoritesapp.dto.FavoritesDTO;
import com.mobileproject.news.favoritesapp.dto.NewsDTO;
import com.mobileproject.news.favoritesapp.service.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    private final FavoritesService favoritesService;

    @GetMapping
    public List<FavoritesDTO> findAll(){
        return favoritesService.findAll();
    }

    @GetMapping("/{email}")
    public List<NewsDTO> findFavoritesByEmail(@PathVariable String email){
        return favoritesService.findFavoritesByEmail(email);
    }

    @PostMapping
    public FavoritesDTO createFavoritesForUser(@RequestBody FavoritesDTO favoritesDTO){
        return favoritesService.createAddNewsToFavorites(favoritesDTO);
    }

    @PostMapping("/check")
    public boolean findFavoritesByEmail(@RequestBody FavoritesDTO favoritesDTO){
        return favoritesService.findByTitle(favoritesDTO.getTitle());
    }
}
