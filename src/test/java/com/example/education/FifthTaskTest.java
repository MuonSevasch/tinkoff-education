package com.example.education;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FifthTaskTest {
    @Test
    public void testAddNote() {
        Notebook notebook = new Notebook();
        Note note = new Note("Test note");
        notebook.addNote(note);
        assertEquals("Test note", notebook.getAllNotes()[0].getContent());
    }

    @Test
    public void testEditNote() {
        Notebook notebook = new Notebook();
        Note note = new Note("Test note");
        notebook.addNote(note);
        note = new Note("Edited test note");
        notebook.editNote(0, note);
        assertEquals("Edited test note", notebook.getAllNotes()[0].getContent());
    }

    @Test
    public void testGetAllNotes() {
        Notebook notebook = new Notebook();
        Note note1 = new Note("Test note 1");
        Note note2 = new Note("Test note 2");
        notebook.addNote(note1);
        notebook.addNote(note2);
        assertEquals("Test note 1", notebook.getAllNotes()[0].getContent());
        assertEquals("Test note 2", notebook.getAllNotes()[1].getContent());
    }
}