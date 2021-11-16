/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Berkay Arslan
 */

package list;
import java.util.Comparator;

public class assign implements Comparator<App>
{
    public int compare(App app1, App app2)
    {
        return app1.getDueDate().compareTo(app2.getDueDate());
    }
}