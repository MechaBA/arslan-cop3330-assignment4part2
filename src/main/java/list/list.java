/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Berkay Arslan
 */

package list;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;
import java.util.*;

public class list
{
    public static final String s1 = "\u001B[30m";
    public static final String s2 = "\u001B[31m";
    public static final String s3 = "\u001B[32m";
    public static final String s4 = "\u001B[0m";
    private final Scanner scanner = new Scanner(System.in);
    DateTimeFormatter SimpleDateFormat = DateTimeFormatter.ofPattern("YYYY-MM-DD");
    private ArrayList<App> apps;
    private obj writerAndReader;

    public list()
    {
        writerAndReader = new obj();
        apps = writerAndReader.readAsObject();
    }


    public list(ArrayList<App> apps)
    {
        this.apps = apps;
    }


    public void showApps()
    {
        System.out.println(s2 + "To-do list App" + s4);
        System.out.println(s2 + "----------" + s4);
        int number = 0;
        for(App app : apps)
        {
            System.out.println(++number + " " + app);
        }
        System.out.println(s2 + "----------" + s4);
    }


    public void markComplete(App app)
    {
        if(app.getComplete())
        {
            System.out.println("None.");
        }
        else
        {
            app.setComplete(true);
            System.out.println("Marked." + app + " as complete.");
        }
    }


    public void removeApps(App app)
    {
        System.out.println("Remove.");
        apps.remove(app);
        System.out.println("Operation deleted.");
    }


    public void showAppsByProject()
    {
        List<App> list = this.apps.stream()
                .sorted(Comparator.comparing(app -> app.getProject()))
                .collect(Collectors.toList());
        this.apps = new ArrayList<>(list);
    }


    public void showAppsByDate()
    {
        Collections.sort(this.apps, new assign());
    }


    public void editApp()
    {
        showApps();
        System.out.println(s1 + "What task do you want to edit?" + s4);
        String indexString = scanner.nextLine();

        int index = Integer.parseInt(indexString);

        if((index - 1) < 0 || index > apps.size())
        {
            System.out.println(s1 + "Wrong input. Enter in range of 1 to " + apps.size() + s4);
        }
        else
        {
            App app = apps.get(index - 1);
            editAppOptions(app);
            System.out.println("Current: " + app.toString() + " successfully edited");
            showApps();
        }
    }


    public void editAppOptions(App app)
    {
        System.out.println(s1 + "What do you want to edit with the task?" + s4);
        System.out.println("Pick an option:");
        System.out.println("(1)" + s3 + "Change title: " + s4);
        System.out.println("(2)" + s3 + "Change due date: " + s4);
        System.out.println("(3)" + s3 + "Change assignment: " + s4);
        System.out.println("(4)" + s3 + "Finished? " + s4);
        System.out.println("(5)" + s3 + "Delete? " + s4);
        System.out.println("(6)" + s2 + "Main Menu? " + s4);
        System.out.print(s1 + "Choice: " + s4);
        String input = scanner.nextLine();

        int editChoices = Integer.parseInt(input);

        switch (editChoices)
        {
            case 1 -> {
                System.out.println("Input new title: ");
                String title = scanner.nextLine();
                app.setTitle(title);
                System.out.println("Title changed.");
            }

            case 2 -> {
                System.out.print("Input new due date (YYYY-MM-DD): ");
                LocalDate date = validateDate();
                app.setDate(date);
                System.out.println("Due date changed.");
            }

            case 3 -> {
                System.out.println("Input an assignment name: ");
                String project = scanner.nextLine();
                app.setProject(project);
                System.out.println("Assignment name changed.");
            }

            case 4 -> {
                markComplete(app);
                System.out.println("Finished.");
                break;
            }

            case 5 -> {
                System.out.println("Delete? ");
                removeApps(app);
                System.out.println("Deleted.");
            }

            case 6 -> {
                System.out.println("Go to main menu? ");
                break;
            }

            default -> throw new IllegalStateException("Value: " + editChoices);
        }
        save();
        showApps();
    }


    public int completedAppsCounter()
    {
        int counter = 0;
        for(App app : apps)
        {
            if(app.getComplete())
            {
                counter++;
            }
        }
        return counter;
    }


    public int incompleteAppsCounter()
    {
        int counter = 0;
        for(App app : apps)
        {
            if(!app.getComplete())
            {
                counter++;
            }
        }
        return counter;
    }


    public void addApp()
    {
        App app;
        app = new App();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter assignment to add app: ");
        String project = scanner.nextLine();
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter assignment due date (YYYY-MM-DD): ");
        LocalDate date = validateDate();

        app.setUser(name);
        app.setTitle(title);
        app.setProject(project);
        app.setDate(date);
        apps.add(app);
        save();
        showApps();
    }


    public void save()
    {
        writerAndReader.writeAsObject(apps);
    }


    public LocalDate validateDate()
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            LocalDate date = convertToDate(scanner.nextLine());
            if(date != null)
            {
                return date;
            }
            else
            {
                System.out.println("Enter date: ");
            }
        }
    }


    public LocalDate convertToDate(String dateString)
    {
        try
        {
            return LocalDate.parse(dateString, SimpleDateFormat);
        }
        catch(DateTimeParseException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}