package com.example.education;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FifthTaskTest {
    @Test
    public void testAddNote() {
        Notebook notebook = new Notebook();
        Note note = new Note("Test note");
        notebook.addNote(note);
        assertEquals(1, notebook.getAllNotes().size());
        assertEquals("Test note", notebook.getAllNotes().get(0).getContent());
    }

    @Test
    public void testEditNote() {
        Notebook notebook = new Notebook();
        Note note = new Note("Test note");
        notebook.addNote(note);
        note = new Note("Edited test note");
        notebook.editNote(0, note);
        assertEquals(1, notebook.getAllNotes().size());
        assertEquals("Edited test note", notebook.getAllNotes().get(0).getContent());
    }

    @Test
    public void testGetAllNotes() {
        Notebook notebook = new Notebook();
        Note note1 = new Note("Test note 1");
        Note note2 = new Note("Test note 2");
        notebook.addNote(note1);
        notebook.addNote(note2);
        assertEquals(2, notebook.getAllNotes().size());
        assertEquals("Test note 1", notebook.getAllNotes().get(0).getContent());
        assertEquals("Test note 2", notebook.getAllNotes().get(1).getContent());
    }
}