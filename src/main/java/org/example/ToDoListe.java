package org.example;

import java.util.Scanner;

public class ToDoListe {
    public static String[] aufgabe = new String[10];

    public void main() {
        System.out.println("1: Aufgabe hinzufügen \n2: Alle Aufgaben anzeigen \n3: Aufgabe bearbeiten \n4: Aufgabe löschen \n5: Programm beenden");
        Scanner scan = new Scanner(System.in);
        boolean isrunning = true;
        while (isrunning) {
            switch (scan.nextInt()) {
                case 1:
                    args();
                    break;
                case 2:
                    show(aufgabe);
                    break;
                case 3:
                    umbenennen(aufgabe);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    isrunning = false;
                    break;
            }
        }
    }

    public static void args() {
        System.out.println("Gib deine Aufgabe ein:");
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < aufgabe.length; i++) {
            if (aufgabe[i] == null) {
                aufgabe[i] = scan.nextLine();
                System.out.println("Aufgabe hinzugefügt!");
                return;
            }
        }
    }

    public static void show(String[] aufgabe1) {
        System.out.println("TO Do Liste:");
        for (int i = 0; i < aufgabe1.length; i++) {
            if (aufgabe1[i] != null) {
                System.out.println( "- " + aufgabe1[i]);
            }
        }
    }

    public static void umbenennen(String[] aufgaben) {
        System.out.println("Welche Aufgabe möchtest du bearbeiten?");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        System.out.println("Was soll die neue Aufgabe sein?");
        String neueAufgabe = scan.nextLine();
        aufgaben[i - 1] = neueAufgabe;
    }

    public static void delete() {
        System.out.println("Welche Aufgabe willst du löschen?");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        aufgabe[i - 1] = null;
    }
}

