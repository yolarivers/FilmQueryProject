package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.InventoryItem;

public class FilmQueryApp {

  DatabaseAccessor db = new DatabaseAccessorObject();
  Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.launch();
  }

  private void launch() {
    startUserInterface();
  }

  private void startUserInterface() {
    boolean keepGoing = true;
    while (keepGoing) {
      System.out.println("1. Look up a film by its ID");
      System.out.println("2. Look up a film by a search keyword");
      System.out.println("3. Exit");
      int choice = getIntInput();
      input.nextLine();  
      switch (choice) {
        case 1:
          lookUpFilmById();
          break;
        case 2:
          lookUpFilmByKeyword();
          break;
        case 3:
          System.out.println("Goodbye!");
          keepGoing = false;
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void lookUpFilmById() {
    System.out.print("Enter film ID: ");
    int filmId = getIntInput();
    input.nextLine();  
    Film film = db.findFilmById(filmId);
    if (film != null) {
      displayFilmDetails(film);
    } else {
      System.out.println("Film not found.");
    }
  }

  private void lookUpFilmByKeyword() {
    System.out.print("Enter search keyword: ");
    String keyword = input.nextLine();
    List<Film> films = db.findFilmsByTitleKeyword(keyword);
    if (films.isEmpty()) {
      System.out.println("No matching films found.");
    } else {
      for (Film film : films) {
        displayFilmDetails(film);
      }
    }
  }

  private void displayFilmDetails(Film film) {
    if (film == null) {
      System.out.println("Film not found.");
      return;
    }

    System.out.println("\nTitle: " + film.getTitle());
    System.out.println("Year: " + film.getReleaseYear());
    System.out.println("Rating: " + film.getRating());
    System.out.println("Description: " + film.getDescription());
    System.out.println("Language: " + film.getLanguage());
    System.out.println("Cast: ");
    if (film.getActors() != null) {
      film.getActors().forEach(actor -> System.out.println(" - " + actor.getFirstName() + " " + actor.getLastName()));
    } else {
      System.out.println(" No cast information available.");
    }

    handleSubmenu(film);
  }

  private void handleSubmenu(Film film) {
    boolean inSubmenu = true;
    while (inSubmenu) {
      System.out.println("\nWhat would you like to do next?");
      System.out.println("1. Return to main menu");
      System.out.println("2. View all film details");

      int choice = getIntInput();
      input.nextLine(); 

      switch (choice) {
        case 1:
          return;
        case 2:
          displayAllFilmDetails(film);
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void displayAllFilmDetails(Film film) {
    System.out.println("\nID: " + film.getId());
    System.out.println("Title: " + film.getTitle());
    System.out.println("Description: " + film.getDescription());
    System.out.println("Release Year: " + film.getReleaseYear());
    System.out.println("Language ID: " + film.getLanguageId());
    System.out.println("Rental Duration: " + film.getRentalDuration());
    System.out.println("Rental Rate: " + film.getRentalRate());
    System.out.println("Length: " + film.getLength());
    System.out.println("Replacement Cost: " + film.getReplacementCost());
    System.out.println("Rating: " + film.getRating());
    System.out.println("Special Features: " + film.getSpecialFeatures());
    System.out.println("Language: " + film.getLanguage());
    System.out.println("Cast: ");
    film.getActors().forEach(actor -> System.out.println(" - " + actor.getFirstName() + " " + actor.getLastName()));

    
    System.out.println("Categories: ");
    List<Category> categories = db.findCategoriesByFilmId(film.getId());
    categories.forEach(category -> System.out.println(" - " + category.getName()));

  
    System.out.println("Inventory: ");
    List<InventoryItem> inventory = db.findInventoryByFilmId(film.getId());
    inventory.forEach(item -> System.out.println(" - ID: " + item.getId() + ", Condition: " + item.getCondition()));
  }

  private int getIntInput() {
    while (true) {
      try {
        return input.nextInt();
      } catch (InputMismatchException e) {
        input.next();
        System.out.println("Invalid input. Please enter a number.");
      }
    }
  }
}
