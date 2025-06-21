package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LockedMe {
    private static final String ROOT_DIR = "Course_1_End_Project/root_directory";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        ensureRootDir();
        showWelcomeScreen();
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    listFiles();
                    break;
                case 2:
                    showSubMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using LockedMe.com! Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        SCANNER.close();
    }

    private static void ensureRootDir() {
        File dir = new File(ROOT_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    private static void showWelcomeScreen() {
        System.out.println("*********************************");
        System.out.println("Welcome to LockedMe.com");
        System.out.println("Developer: Student");
        System.out.println("*********************************");
    }

    private static void showMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Show files in ascending order");
        System.out.println("2. File operations");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void showSubMenu() {
        boolean inSubMenu = true;
        while (inSubMenu) {
            System.out.println("\nFile Operations:");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search a file");
            System.out.println("4. Back to main menu");
            System.out.print("Enter your choice: ");
            int subChoice = getUserChoice();
            switch (subChoice) {
                case 1:
                    addFile();
                    break;
                case 2:
                    deleteFile();
                    break;
                case 3:
                    searchFile();
                    break;
                case 4:
                    inSubMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            // return -1
        }
        return choice;
    }

    private static void listFiles() {
        File dir = new File(ROOT_DIR);
        String[] files = dir.list();
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Files:");
        for (String file : files) {
            System.out.println(file);
        }
    }

    private static void addFile() {
        System.out.print("Enter file name to add: ");
        String fileName = SCANNER.nextLine();
        File file = new File(ROOT_DIR, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    private static void deleteFile() {
        System.out.print("Enter file name to delete: ");
        String fileName = SCANNER.nextLine();
        File file = new File(ROOT_DIR, fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    private static void searchFile() {
        System.out.print("Enter file name to search: ");
        String fileName = SCANNER.nextLine();
        File file = new File(ROOT_DIR, fileName);
        if (file.exists()) {
            System.out.println("File found in directory.");
        } else {
            System.out.println("File not found.");
        }
    }
}
