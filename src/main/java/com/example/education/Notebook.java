package com.example.education;

import java.util.ArrayList;

/**
 * The Notebook class is used to store and manage notes.
 */
public class Notebook {
    private ArrayList<Note> notes;

    /**
     * Creates an empty notebook.
     */
    public Notebook() {
        notes = new ArrayList<>();
    }

    /**
     * Adds a new note to the notebook.
     * @param note the note to add
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Edits an existing note in the notebook.
     * @param index the index of the note to edit
     * @param note the new note content
     */
    public void editNote(int index, Note note) {
        notes.set(index, note);
    }

    /**
     * Returns all the notes in the notebook.
     * @return the list of notes
     */
    public ArrayList<Note> getAllNotes() {
        return notes;
    }
}