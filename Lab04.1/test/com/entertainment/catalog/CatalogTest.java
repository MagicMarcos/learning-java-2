/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void findByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");

    assertTrue(tvs.isEmpty());
  }

  @Test
  public void findByBrand_shouldReturnTelevisionCollection_whenBrandFound() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");

    assertEquals(7, tvs.size());

    for (Television tv : tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

  // findByBrands test

  @Test
  public void findByBrands_shouldReturnEmptyMap_whenNoBrandsPassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands();

    assertTrue(tvMap.isEmpty());
  }

  @Test
  public void findByBrands_shouldReturnBrandsMap_whenBrandsPassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands("Sony", "NO-MATCH");

    assertEquals(2, tvMap.size());

    // first check for "Sony"
    Collection<Television> sonyTvs = tvMap.get("Sony");
    assertEquals(7, sonyTvs.size());

    for (Television tv : sonyTvs) {
      assertEquals("Sony", tv.getBrand());
    }

    // then check for "NO-MATCH"
    Collection<Television> noMatchTvs = tvMap.get("NO-MATCH");
    assertTrue(noMatchTvs.isEmpty());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void getInventory_shouldThrowException_whenAddingToList() {
    Collection<Television> unmodifiableCatalog = Catalog.getInventory();
    Television tv = new Television();

    unmodifiableCatalog.add(tv);

    assertEquals(30, unmodifiableCatalog.size());
  }

  @Test
  public void removeDuplicates_shouldReturn23() {
    HashSet<Television> results = new HashSet<>(Catalog.getInventory());

    assertEquals(23, results.size());
  }

  @Test
  public void findLoudestTvSet_shouldReturnSonyVolume94() {
    Collection<Television> catalog = Catalog.getInventory();
    TreeMap<Integer, Television> tvs = new TreeMap<>();
    Television loudTv = new Television("Sony", 94);

    for(Television tv : catalog) {
      tvs.put(tv.getVolume(), tv);
    }

    int maxVol = tvs.lastKey();
    assertEquals(94, maxVol);

    assertEquals(loudTv, tvs.lastEntry().getValue());
  }
}