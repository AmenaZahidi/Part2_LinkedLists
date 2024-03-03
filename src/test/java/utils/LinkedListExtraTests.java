package utils;

import business.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {



    @Test
    public void testRemove_OnlySongInList() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 1", "Artist A");
        instance.add(s1);

        boolean removed = instance.remove(s1);
        assertTrue(removed);
        assertTrue(instance.isEmpty());
    }


    @Test
    public void testAdd_SongsBySameArtist() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 1", "Artist A");
        Song s2 = new Song("Title 2", "Artist A");

        instance.add(s1);
        instance.add(s2);
        assertEquals(2, instance.size());
        assertFalse(instance.isEmpty());
    }

    @Test
    public void testRemove_MiddleSong() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 1", "Artist A");
        Song s2 = new Song("Title 2", "Artist A");
        Song s3 = new Song("Title 3", "Artist A");
        instance.add(s1);
        instance.add(s2);
        instance.add(s3);

        boolean removed = instance.remove(s2);
        assertTrue(removed);
        assertEquals(2, instance.size());
        assertEquals(s1, instance.get(0));
        assertEquals(s3, instance.get(1));
    }























    }

