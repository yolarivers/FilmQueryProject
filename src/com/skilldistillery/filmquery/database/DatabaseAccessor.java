package com.skilldistillery.filmquery.database;

import java.util.List;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.InventoryItem;

public interface DatabaseAccessor {
  Film findFilmById(int filmId);
  List<Film> findFilmsByTitleKeyword(String keyword);
  List<Actor> findActorsByFilmId(int filmId);
  List<Category> findCategoriesByFilmId(int filmId);
  List<InventoryItem> findInventoryByFilmId(int filmId);
}


