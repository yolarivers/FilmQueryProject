package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import com.skilldistillery.filmquery.entities.Category;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.InventoryItem;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }

  @Test
  void test_getFilmById_returns_film_with_id() {
    Film f = db.findFilmById(1);
    assertNotNull(f);
    assertEquals("ACADEMY DINOSAUR", f.getTitle());
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }

  @Test
  void test_findCategoriesByFilmId_returns_categories_for_film() {
    List<Category> categories = db.findCategoriesByFilmId(1);
    assertNotNull(categories);
    assertTrue(categories.size() > 0); 
  }

  @Test
  void test_findCategoriesByFilmId_with_invalid_id_returns_empty_list() {
    List<Category> categories = db.findCategoriesByFilmId(-42);
    assertNotNull(categories);
    assertEquals(0, categories.size());
  }

  @Test
  void test_findInventoryByFilmId_returns_inventory_items_for_film() {
    List<InventoryItem> inventory = db.findInventoryByFilmId(1);
    assertNotNull(inventory);
    assertTrue(inventory.size() > 0); 
  }

  @Test
  void test_findInventoryByFilmId_with_invalid_id_returns_empty_list() {
    List<InventoryItem> inventory = db.findInventoryByFilmId(-42);
    assertNotNull(inventory);
    assertEquals(0, inventory.size());
  }
}
