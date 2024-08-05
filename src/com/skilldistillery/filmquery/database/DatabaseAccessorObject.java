package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.InventoryItem;

public class DatabaseAccessorObject implements DatabaseAccessor {

  private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
  private static final String USER = "student";
  private static final String PASS = "student";

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Film findFilmById(int filmId) {
    Film film = null;
    String sql = "SELECT f.id, f.title, f.description, f.release_year, l.name as language, f.rating, "
               + "f.language_id, f.length, f.rental_duration, f.rental_rate, f.replacement_cost, f.special_features "
               + "FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
                        rs.getInt("release_year"), rs.getString("language"), rs.getString("rating"));
        film.setLanguageId(rs.getInt("language_id"));
        film.setLength(rs.getInt("length"));
        film.setRentalDuration(rs.getInt("rental_duration"));
        film.setRentalRate(rs.getDouble("rental_rate"));
        film.setReplacementCost(rs.getDouble("replacement_cost"));
        film.setSpecialFeatures(rs.getString("special_features"));
        
        film.setActors(findActorsByFilmId(filmId)); 
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return film;
  }

  @Override
  public List<Film> findFilmsByTitleKeyword(String keyword) {
    List<Film> films = new ArrayList<>();
    String sql = "SELECT f.id, f.title, f.description, f.release_year, l.name as language, f.rating, "
               + "f.language_id, f.length, f.rental_duration, f.rental_rate, f.replacement_cost, f.special_features "
               + "FROM film f JOIN language l ON f.language_id = l.id "
               + "WHERE f.title LIKE ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      String searchTerm = "%" + keyword + "%";
      stmt.setString(1, searchTerm);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
                             rs.getInt("release_year"), rs.getString("language"), rs.getString("rating"));
        film.setLanguageId(rs.getInt("language_id"));
        film.setLength(rs.getInt("length"));
        film.setRentalDuration(rs.getInt("rental_duration"));
        film.setRentalRate(rs.getDouble("rental_rate"));
        film.setReplacementCost(rs.getDouble("replacement_cost"));
        film.setSpecialFeatures(rs.getString("special_features"));
        
        film.setActors(findActorsByFilmId(film.getId()));
        films.add(film);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return films;
  }

  @Override
  public List<Actor> findActorsByFilmId(int filmId) {
    List<Actor> actors = new ArrayList<>();
    String sql = "SELECT a.id, a.first_name, a.last_name "
               + "FROM actor a JOIN film_actor fa ON a.id = fa.actor_id "
               + "WHERE fa.film_id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Actor actor = new Actor(id, firstName, lastName);
        actors.add(actor);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actors;
  }

  @Override
  public List<Category> findCategoriesByFilmId(int filmId) {
    List<Category> categories = new ArrayList<>();
    String sql = "SELECT c.id, c.name "
               + "FROM category c JOIN film_category fc ON c.id = fc.category_id "
               + "WHERE fc.film_id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        Category category = new Category(id, name);
        categories.add(category);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return categories;
  }

  @Override
  public List<InventoryItem> findInventoryByFilmId(int filmId) {
    List<InventoryItem> inventory = new ArrayList<>();
    String sql = "SELECT id, film_id, media_condition FROM inventory_item WHERE film_id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String condition = rs.getString("media_condition");
        InventoryItem item = new InventoryItem(id, filmId, condition);
        inventory.add(item);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return inventory;
  }
}
