package utils;

import java.util.List;
import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    private String artist; // Artist of the songs in the list

    private class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.artist = null; // Initially, no artist is set
    }

        public int size() {
            return this.size;
        }


    /**
     * Retrieves a song at a specified position in the list.
     *
     * @param position the position of the song to retrieve.
     * @return the song at the specified position.
     * @throws IndexOutOfBoundsException If the position is out of range (position < 0 || position >= size()).
     */
    public Song get(int position) {
            if (position < 0 || position >= this.size) {
                throw new IndexOutOfBoundsException("Invalid position: " + position);
            }
            Node current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            return current.song;
        }
    /**
     * finds the index of a given song in the list
     *
     * @param song the song to find.
     * @return the index of the song, or -1 if not found.
     */
        public int indexOf(Song song) {
            Node current = head;
            for (int i = 0; i < this.size; i++) {
                if (current.song.equals(song)) {
                    return i;
                }
                current = current.next;
            }
            return -1; // Song not found
        }

    /**
     * checks if the list is empty
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds a song to the end of the list ,if the list is empty, the artist of this song
     * sets the artist for the list. If the list already has songs, the artist of the new song
     * must match the list's artist
     *
     * @param song the song to add
     */
    public void add(Song song) {
        if (isEmpty()) {
            artist = song.getArtist().toLowerCase(); // Initialize artist on first add
        } else if (!song.getArtist().equalsIgnoreCase(artist)) {
            System.out.println("All songs must be by the artist: " + artist);
            return; // Don't add the song if the artist doesn't match
        }
        Node newNode = new Node(song);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        this.size++;
    }

    /**
     * Removes the first occurrence of a specified song from the list
     *
     * @param song The song to remove
     * @return true if the song was successfully removed, false otherwise.
     */
    public boolean remove(Song song) {
        if (isEmpty()) return false;

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.song.equals(song)) {
                if (prev == null) { // Song is at head
                    head = current.next;
                    if (head == null) { // List is now empty
                        tail = null;
                    }
                } else {
                    prev.next = current.next;
                    if (prev.next == null) { // Removed tail
                        tail = prev;
                    }
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false; // Song not found
    }


    /**
     * Returns the last song in the list.
     *
     * @return The last song, or null if the list is empty.
     */
         public Song tail() {
            if (isEmpty()) {
                return null;
            }
            return tail.song;
        }
    }