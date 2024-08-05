package com.skilldistillery.filmquery.entities;

public class InventoryItem {
  private int id;
  private int filmId;
  private String condition;

  public InventoryItem(int id, int filmId, String condition) {
    this.id = id;
    this.filmId = filmId;
    this.condition = condition;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  @Override
  public String toString() {
    return "InventoryItem [id=" + id + ", filmId=" + filmId + ", condition=" + condition + "]";
  }
}
