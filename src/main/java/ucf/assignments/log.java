/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Berkay Arslan
 */

package ucf.assignments;
import list.list;
import java.util.*;

public class log
{
    public static final String s1 = "\u001B[30m";
    public static final String s2 = "\u001B[33m";
    public static final String s3 = "\u001B[35m";
    public static final String s4 = "\u001B[0m";
    public static final String s5 = "\u001B[1m";
    private static final list todo = new list();
    private final Scanner scanner = new Scanner(System.in);


    public static void seeMenu()
    {
        System.out.println(s3 + "----------" + s4);
        System.out.println(s1 + "There is: " + todo.incompleteAppsCounter() + ' ' + "tasks completed with" + ' ' + todo.completedAppsCounter() + ' ' + "done" + s4);
        System.out.println(s3 + "----------" + s4);
        System.out.println(s3 + "Pick option:" + s4);
        System.out.println(s2 + "1." + s4 + " Show list by date/project ");
        System.out.println(s2 + "2." + s4 + " Add new task ");
        System.out.println(s2 + "3." + s4 + " Edit task ");
        System.out.println(s2 + "4." + s4 + " Save and quit ");
        System.out.println(s2 + "Help for using application:" + s4 + " readme.md file ");
        System.out.println(s5 + "Make a selection (1-4) " + s4);
        System.out.print(s3 + "Selection: " + s4);
    }


    public void showAppsMenu()
    {
        System.out.println("Pick option to show:");
        System.out.println("----------");
        System.out.println("(1) 1. Task List");
        System.out.println("(2) 2. Task by date");
        System.out.println("(3) 3. Task by project");
        System.out.println("(4) Main menu");
        System.out.print("Selection: ");
        String input = scanner.nextLine();
        int editChoices = Integer.parseInt(input);

        switch (editChoices)
        {
            case 1 -> {
                todo.showApps();
            }

            case 2 -> {
                System.out.println("Task by due date: ");
                todo.showAppsByDate();
            }

            case 3 -> {
                System.out.println("Task by project: ");
                todo.showAppsByProject();
            }

            case 4 -> {
                break;
            }
            default -> throw new IllegalStateException("Number: " + editChoices);
        }
        todo.save();
        todo.showApps();
    }


    public void run()
    {
        int choice = 0;
        {
            while(choice != 4)
            {
                seeMenu();
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
                System.out.println("Task (edit/remove): ");

                switch(choice)
                {
                    case 1 -> {
                        System.out.println("List of tasks: ");
                        showAppsMenu();
                    }

                    case 2 -> {
                        System.out.println("Add new task (edit/remove): ");
                        todo.addApp();
                    }

                    case 3 -> todo.editApp();

                    case 4 -> {
                        System.out.println("Terminate system. ");
                        todo.save();
                        System.exit(0);
                    }
                    default -> System.out.println("Choose a number (1-4): ");
                }
            }
        }
    }
}