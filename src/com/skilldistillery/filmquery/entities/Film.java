package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
  private int id;
  private String title;
  private String description;
  private int releaseYear;
  private String language;
  private String rating;
  private int languageId;
  private int length;
  private int rentalDuration;
  private double rentalRate;
  private double replacementCost;
  private String specialFeatures;
  private List<Actor> actors; 

  public Film(int id, String title, String description, int releaseYear, String language, String rating) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.releaseYear = releaseYear;
    this.language = language;
    this.rating = rating;
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

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public int getLanguageId() {
    return languageId;
  }

  public void setLanguageId(int languageId) {
    this.languageId = languageId;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
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

  public double getReplacementCost() {
    return replacementCost;
  }

  public void setReplacementCost(double replacementCost) {
    this.replacementCost = replacementCost;
  }

  public String getSpecialFeatures() {
    return specialFeatures;
  }

  public void setSpecialFeatures(String specialFeatures) {
    this.specialFeatures = specialFeatures;
  }

  public List<Actor> getActors() {
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }

  @Override
  public String toString() {
    return "Film [id=" + id + ", title=" + title + ", description=" + description 
           + ", releaseYear=" + releaseYear + ", language=" + language + ", rating=" + rating 
           + ", languageId=" + languageId + ", length=" + length + ", rentalDuration=" + rentalDuration 
           + ", rentalRate=" + rentalRate + ", replacementCost=" + replacementCost 
           + ", specialFeatures=" + specialFeatures + "]";
  }
}
