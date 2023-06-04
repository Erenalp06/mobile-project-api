package com.mobileproject.news.favoritesapp.repository;

import com.mobileproject.news.favoritesapp.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

    List<Favorites> findByEmail(String email);

    Optional<Favorites> findByTitle(String title);
}
