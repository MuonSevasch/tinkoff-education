package com.example.education;


/**
 * The Note class represents a single note in the notebook.
 */
public class Note {
    private String content;

    /**
     * Creates a new note with the given content.
     * @param content the content of the note
     */
    public Note(String content) {
        this.content = content;
    }

    /**
     * Returns the content of the note.
     * @return the content of the note
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the note.
     * @param content the new content of the note
     */
    public void setContent(String content) {
        this.content = content;
    }
}
