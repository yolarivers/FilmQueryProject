package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

  @Override
  public Film findFilmById(int filmId) {
    Film film = null;
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdvid", "student", "student");
      String sql = "SELECT film.*, language.name AS language FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        film = new Film();
        film.setId(rs.getInt("id"));
        film.setTitle(rs.getString("title"));
        film.setDescription(rs.getString("description"));
        film.setReleaseYear(rs.getShort("release_year"));
        film.setLanguage(rs.getString("language"));
        film.setRentalDuration(rs.getInt("rental_duration"));
        film.setRentalRate(rs.getDouble("rental_rate"));
        film.setLength(rs.getInt("length"));
        film.setReplacementCost(rs.getDouble("replacement_cost"));
        film.setRating(rs.getString("rating"));
        film.setSpecialFeatures(rs.getString("special_features"));
        film.setActors(findActorsByFilmId(filmId));
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return film;
  }

  @Override
  public List<Actor> findActorsByFilmId(int filmId) {
    List<Actor> actors = new ArrayList<>();
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdvid", "student", "student");
      String sql = "SELECT actor.* FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_actor.film_id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Actor actor = new Actor(id, firstName, lastName);
        actors.add(actor);
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actors;
  }

  @Override
  public List<Film> findFilmsByKeyword(String keyword) {
    List<Film> films = new ArrayList<>();
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdvid", "student", "student");
      String sql = "SELECT film.*, language.name AS language FROM film JOIN language ON film.language_id = language.id "
                 + "WHERE film.title LIKE ? OR film.description LIKE ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, "%" + keyword + "%");
      stmt.setString(2, "%" + keyword + "%");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Film film = new Film();
        film.setId(rs.getInt("id"));
        film.setTitle(rs.getString("title"));
        film.setDescription(rs.getString("description"));
        film.setReleaseYear(rs.getShort("release_year"));
        film.setLanguage(rs.getString("language"));
        film.setRentalDuration(rs.getInt("rental_duration"));
        film.setRentalRate(rs.getDouble("rental_rate"));
        film.setLength(rs.getInt("length"));
        film.setReplacementCost(rs.getDouble("replacement_cost"));
        film.setRating(rs.getString("rating"));
        film.setSpecialFeatures(rs.getString("special_features"));
        film.setActors(findActorsByFilmId(rs.getInt("id")));
        films.add(film);
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return films;
  }
}
