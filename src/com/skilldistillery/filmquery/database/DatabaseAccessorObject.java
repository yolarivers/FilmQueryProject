package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
  private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

  @Override
  public Film findFilmById(int filmId) {
    Film film = null;
    try {
      Connection conn = DriverManager.getConnection(url, "student", "student");
      String sql = "SELECT id, title, description, release_year, language_id, rental_duration, "
                 + "rental_rate, length, replacement_cost, rating, special_features "
                 + "FROM film WHERE id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getShort(4), rs.getInt(5), 
                        rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), 
                        rs.getString(10), rs.getString(11));
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
  public Actor findActorById(int actorId) {
    Actor actor = null;
    try {
      Connection conn = DriverManager.getConnection(url, "student", "student");
      String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, actorId);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actor;
  }

  @Override
  public List<Actor> findActorsByFilmId(int filmId) {
    List<Actor> actors = new ArrayList<>();
    try {
      Connection conn = DriverManager.getConnection(url, "student", "student");
      String sql = "SELECT actor.id, actor.first_name, actor.last_name "
                 + "FROM actor JOIN film_actor ON actor.id = film_actor.actor_id "
                 + "WHERE film_actor.film_id = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, filmId);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        int actorId = rs.getInt(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        Actor actor = new Actor(actorId, firstName, lastName);
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
}
