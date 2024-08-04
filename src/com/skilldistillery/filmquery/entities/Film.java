package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
  private int id;
  private String title;
  private String description;
  private short releaseYear;
  private int languageId;
  private int rentalDuration;
  private double rentalRate;
  private int length;
  private double replacementCost;
  private String rating;
  private String specialFeatures;
  private List<Actor> actors;

  // Constructors, getters, setters, toString, equals, and hashCode

  public Film(int id, String title, String description, short releaseYear, int languageId, 
              int rentalDuration, double rentalRate, int length, double replacementCost, 
              String rating, String specialFeatures) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.releaseYear = releaseYear;
    this.languageId = languageId;
    this.rentalDuration = rentalDuration;
    this.rentalRate = rentalRate;
    this.length = length;
    this.replacementCost = replacementCost;
    this.rating = rating;
    this.specialFeatures = specialFeatures;
  }

  // Getters and setters for all fields, including actors

  public List<Actor> getActors() {
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }

  @Override
  public String toString() {
    return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
        + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
        + ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
        + ", specialFeatures=" + specialFeatures + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, actors);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Film other = (Film) obj;
    return id == other.id && title.equals(other.title) && description.equals(other.description) 
        && releaseYear == other.releaseYear && languageId == other.languageId 
        && rentalDuration == other.rentalDuration && Double.compare(other.rentalRate, rentalRate) == 0 
        && length == other.length && Double.compare(other.replacementCost, replacementCost) == 0 
        && rating.equals(other.rating) && specialFeatures.equals(other.specialFeatures)
        && Objects.equals(actors, other.actors);
  }
}
