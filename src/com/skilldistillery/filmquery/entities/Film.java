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
  private String language; 
  private List<Actor> actors; 

  public Film() {}

  public Film(int id, String title, String description, short releaseYear, int languageId, 
              int rentalDuration, double rentalRate, int length, double replacementCost, 
              String rating, String specialFeatures, String language, List<Actor> actors) { 
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
    this.language = language; 
    this.actors = actors; 
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public short getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(short releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getLanguageId() {
    return languageId;
  }

  public void setLanguageId(int languageId) {
    this.languageId = languageId;
  }

  public int getRentalDuration() {
    return rentalDuration;
  }

  public void setRentalDuration(int rentalDuration) {
    this.rentalDuration = rentalDuration;
  }

  public double getRentalRate() {
    return rentalRate;
  }

  public void setRentalRate(double rentalRate) {
    this.rentalRate = rentalRate;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public double getReplacementCost() {
    return replacementCost;
  }

  public void setReplacementCost(double replacementCost) {
    this.replacementCost = replacementCost;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getSpecialFeatures() {
    return specialFeatures;
  }

  public void setSpecialFeatures(String specialFeatures) {
    this.specialFeatures = specialFeatures;
  }

  public String getLanguage() { 
    return language;
  }

  public void setLanguage(String language) { 
    this.language = language;
  }

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
        + ", specialFeatures=" + specialFeatures + ", language=" + language + ", actors=" + actors + "]"; 
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Film other = (Film) obj;
    return id == other.id;
  }
}
