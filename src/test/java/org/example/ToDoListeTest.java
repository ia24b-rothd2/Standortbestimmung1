package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListeTest {

    @BeforeEach
    void setUp() {
        ToDoListe.aufgabe = new String[10];
    }

    @Test
    void testargs() {
        String simulatedInput = "Test Aufgabe\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ToDoListe.args();
        //Das habe ich teilweise mit Chat GPT erstellt, da ich nicht wusste, wie man eine User Eingabe simuliert
        assertEquals("Test Aufgabe", ToDoListe.aufgabe[0], "Die Aufgabe wurde nicht korrekt hinzugefügt.");
    }


    @Test
    void testshow() {
        ToDoListe.aufgabe[0] = "Test Aufgabe";
        ToDoListe.show(ToDoListe.aufgabe);
        assertEquals("Test Aufgabe", ToDoListe.aufgabe[0], "Die Aufgabe sollte 'Test Aufgabe' sein.");
    }


    @Test
    void testumbenennen() {
        ToDoListe.aufgabe[0] = "Alte Aufgabe";
        String simulatedInput = "1\nNeue Aufgabe\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        //Das habe ich teilweise mit Chat GPT erstellt, da ich nicht wusste, wie man eine User Eingabe simuliert
        ToDoListe.umbenennen(ToDoListe.aufgabe);
        assertEquals("Neue Aufgabe", ToDoListe.aufgabe[0], "Die Aufgabe wurde nicht korrekt umbenannt.");
    }

    @Test
    void testdelete() {
        ToDoListe.aufgabe[0] = "Test Aufgabe";
        String simulatedInput = "1\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        ToDoListe.delete();
        //Das habe ich teilweise mit Chat GPT erstellt, da ich nicht wusste, wie man eine User Eingabe simuliert
        assertNull(ToDoListe.aufgabe[0], "Die Aufgabe sollte gelöscht worden sein.");
    }
}

