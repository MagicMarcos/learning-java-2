package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem notFound = catalog.findById(19L);

        assertNull(notFound);
    }

    @Test
    public void findById_shouldReturnMusicItem_whenIdFound() {
        MusicItem found = catalog.findById(7L);

        assertEquals(Long.valueOf(7L), found.getId());
    }
}