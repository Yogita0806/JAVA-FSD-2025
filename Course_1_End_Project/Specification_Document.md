# LockedMe.com Specification Document

## Project Details
- **Application:** LockedMe.com File Manager Prototype
- **Developer:** Student

## Sprint Plan
| Sprint | Duration | Tasks |
|-------|---------|------|
| Sprint 1 | Week 1 | Setup project structure, create welcome screen, implement menu navigation and list files option |
| Sprint 2 | Week 2 | Implement add, delete and search file features with exception handling |
| Sprint 3 | Week 3 | Final testing, create documentation and push source code to GitHub |

## Core Concepts Used
- Java Collections and Arrays for handling file lists
- File class for file operations
- Exception handling for robust CLI
- Sorting using `Arrays.sort` to display file names in ascending order

## Algorithm Overview
1. Display a welcome screen with app and developer details.
2. Present the main menu with options to list files, operate on files or exit.
3. On listing, retrieve filenames from the root directory and sort them using case-insensitive order.
4. The file operations submenu allows the user to:
   - Add a new file (create if not present).
   - Delete an existing file (case-sensitive match).
   - Search for a file and display if found.
   - Return to the main menu.
5. User inputs are validated and invalid options do not crash the application.
6. The application loops until the user chooses to exit.

## Flow Chart
```
+------------------+
|  Welcome Screen  |
+---------+--------+
          |
          v
   +------+------+
   | Main Menu   |
   +-------------+
    | 1 List     |
    | 2 Operate  |
    | 3 Exit     |
          |
          v
   +-------------+
   | Sub Menu    |
   +-------------+
    |1 Add       |
    |2 Delete    |
    |3 Search    |
    |4 Back      |
```

## GitHub Repository
Source code is version controlled using Git. The repository link can be updated here when published.

## Conclusion / USP
This prototype demonstrates a simple command line file manager using core Java concepts. The modular code and sprint based approach make it easy to enhance with additional features like logging or a graphical UI in future iterations.
