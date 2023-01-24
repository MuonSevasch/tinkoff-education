package com.example.education;

import java.lang.reflect.Array;

/**
 * The Notebook class is used to store and manage notes.
 */
public class Notebook {

    private Note[] notes ;

    private int pointer = 0;

    /**
     * Creates an empty notebook.
     */
    public Notebook() {
        notes = new Note[1];
    }

    /**
     * Adds a new note to the notebook.
     *
     * @param note the note to add
     */
    public void addNote(Note note) {
        if(pointer == notes.length-1)
        resize(notes.length*2);
        notes[pointer++] = note;
    }

    /**
     * Edits an existing note in the notebook.
     *
     * @param index the index of the note to edit
     * @param note the new note content
     */
    public void editNote(int index, Note note) {
        notes[index] = note;
    }

    /**
     * Returns all the notes in the notebook.
     *
     * @return the list of notes
     */
    public Note[] getAllNotes() {
        return notes.clone();
    }

    private void resize(int newLength) {
        Note[] newArray = new Note[newLength];
        System.arraycopy(notes, 0, newArray, 0, pointer);
        notes = newArray;
    }
}