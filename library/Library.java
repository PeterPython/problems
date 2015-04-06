// Author: Jesus Cheng
// This is a program (written in Java) to manage a personal library that stores titles and authors.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Library {
    private HashMap<String, String> library;  // Library to store Title as Key, and Author as Value
    private HashSet<String> read;   // A set/list of read books

    // Library constructor
    private Library() {
        library = new HashMap<String, String>();
        read = new HashSet<String>();
        run();  // Run the program when object is created
    }

    // 'show all by' command
    private void showAllBy(String author) {
        if(library.size() > 0) {
            for(String title : library.keySet()) {
                if(library.get(title).equals(author)) {
                    if(!read.contains(title)) {
                        System.out.println(title + " by " + library.get(title) + " (unread)");
                    }
                    else {
                        System.out.println(title + " by " + library.get(title) + " (read)");
                    }
                }
            }            
        }
        else {
            System.out.println("(No records found)");
        }
    }

    // 'show all' command
    private void showAll() {
        if(library.size() > 0) {
            for(String title : library.keySet()) {
                if(!read.contains(title)) {
                    System.out.println(title + " by " + library.get(title) + " (unread)");
                }
                else {
                    System.out.println(title + " by " + library.get(title) + " (read)");
                }
            }
        }
        else {
            System.out.println("(No records found)");
        }    
    }

    // 'show unread by' command
    private void showUnreadBy(String author) {
        if(library.size() > 0) {
            for(String title : library.keySet()) {
                if(!read.contains(title) && library.get(title).equals(author)) {
                    System.out.println(title + " by " + library.get(title) + " (unread)");
                }
            }    
        }
        else {
            System.out.println("(No records found)");
        }
    }

    // 'show unread' command
    private void showUnread() {
        if(library.size() > 0) {
            for(String title : library.keySet()) {
                if(!read.contains(title)) {
                    System.out.println(title + " by " + library.get(title) + " (unread)");
                }
            }
            if(read.size() == library.size()) {
                System.out.println("You've read all the books!");
            }
        }
        else {
            System.out.println("(No records found)");
        }
    }

    // 'add' command
    private void add(String title, String author) {
        if(!library.containsKey(title)) {
            library.put(title, author);
            System.out.println("Added " + title + " by " + author);
        }
        else {
            System.out.println("This title already exists in your library.");
        }
    }

    // 'read' command
    private void read(String title) {
        if(library.containsKey(title)) {
            if(!read.contains(title)) {
                read.add(title);
                System.out.println("You've read " + title + "!");            
            }
            else {
                System.out.println("You've read " + title + " again!");
            }
        }
        else {
            System.out.println("(No records found)");
        }
    }

    // 'help' command
    private void help() {
        System.out.println("List of commands and formats:");
        System.out.println("add \"$title\" \"$author\": adds a book to the " + 
            "library with the given title and author. All books are unread by default.");
        System.out.println("read \"$title\": marks a given book as read.");
        System.out.println("show all: displays all of the books in the library.");
        System.out.println("show unread: display all of the books that are unread");
        System.out.println("show all by \"$author\": shows all of the books in the " +
            "library by the given author.");
        System.out.println("show unread by \"$author\": shows the unread books in " +
            "the library by the given author");
        System.out.println("quit: quits the program.");
    }

    // Excecute the program
    private void run() {
        Scanner in = new Scanner(System.in);

        String oneParameterRegEx = "\"[^\"]+\"$";  // RegEx to match one parameter format in command
        String twoParametersRegEx = "\"[^\"]+\"\\s+\"[^\"]+\"$";  // RegEx to match two parameters format in command

        System.out.println("Welcome to your library!");

        System.out.print("> ");
        // Read from the command line and remove extra white spaces
        String command = in.nextLine().replaceAll("\\s+", " ").trim();

        // Run until 'quit' command is executed
        while(!command.matches("^quit$")) {
            // 'show all by' command
            if(command.matches("^show all by " + oneParameterRegEx)) {
                String author = command.replaceAll("^show all by ", "").replaceAll("\"", "");
                showAllBy(author);
            }
            // 'show all' command
            else if(command.matches("^show all$")) {
                showAll();
            }
            // 'show unread by' command
            else if(command.matches("^show unread by " + oneParameterRegEx)) {
                String author = command.replaceAll("^show unread by ", "").replaceAll("\"", "");
                showUnreadBy(author);
            }
            // 'show unread' command
            else if(command.matches("^show unread$")) {
                showUnread();
            }
            // 'add' command
            else if(command.matches("^add " + twoParametersRegEx)) {
                String tittleAuthor[] = command.replaceAll("^add ", "").split("\"");  // Split string into array by "
                String title = "\"" + tittleAuthor[1] + "\"";
                String author = tittleAuthor[3];
                add(title, author);
            }
            // 'read' command
            else if(command.matches("^read " + oneParameterRegEx)) {
                String title = command.replaceAll("^read ", "");
                read(title);    
            }
            // 'help' command
            else if(command.matches("^help$")) {
                help();
            }
            else {
                System.out.println("Command not found or wrong format. If you need help type 'help'");
            }
            System.out.println();
            System.out.print("> ");
            command = in.nextLine().replaceAll("\\s+", " ").trim();
        }
        System.out.println("Bye!");
    }


    // Main method
    public static void main(String args[]) {
        Library lib = new Library();
    }
}