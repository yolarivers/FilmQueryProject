package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Actor;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.launch();
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    startUserInterface(input);
    input.close();
  }

  private void startUserInterface(Scanner input) {
    boolean keepGoing = true;
    
    while (keepGoing) {
      System.out.println("1. Look up a film by its ID");
      System.out.println("2. Look up an actor by their ID");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");
      
      int choice = input.nextInt();
      input.nextLine(); 
      
      switch (choice) {
        case 1:
          lookUpFilmById(input);
          break;
        case 2:
          lookUpActorById(input);
          break;
        case 3:
          keepGoing = false;
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private void lookUpFilmById(Scanner input) {
    System.out.print("Enter the film ID: ");
    int filmId = input.nextInt();
    input.nextLine();  
    
    Film film = db.findFilmById(filmId);
    if (film != null) {
      System.out.println(film);
      List<Actor> actors = film.getActors();
      if (actors != null && !actors.isEmpty()) {
        System.out.println("Actors:");
        for (Actor actor : actors) {
          System.out.println("  - " + actor);
        }
      } else {
        System.out.println("No actors found for this film.");
      }
    } else {
      System.out.println("Film not found.");
    }
  }

  private void lookUpActorById(Scanner input) {
    System.out.print("Enter the actor ID: ");
    int actorId = input.nextInt();
    input.nextLine();  
    
    Actor actor = db.findActorById(actorId);
    if (actor != null) {
      System.out.println(actor);
    } else {
      System.out.println("Actor not found.");
    }
  }
}
