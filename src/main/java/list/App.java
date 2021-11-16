/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Berkay Arslan
 */

package list;
import java.io.Serializable;
import java.time.LocalDate;

public class App implements Serializable
{
    private String title;
    private String project;
    private LocalDate due;
    private String use;
    private boolean complete;

    public App()
    {
        this.title = title;
        this.project = project;
        this.due = due;
        this.use = use;
        this.complete = false;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }


    public void setDate(LocalDate date)
    {
        this.due = date;
    }


    public LocalDate getDueDate()
    {
        return due;
    }


    public void setUser(String use)
    {
        this.use = use;
    }


    public String getProject()
    {
        return project;
    }


    public void setProject(String project)
    {
        this.project = project;
    }


    public boolean getComplete()
    {
        return complete;
    }


    public void setComplete(boolean done)
    {
        this.complete = done;
    }


    public String toString()
    {
        return "Assignment{" + "title='" + title + '\'' + ", due=" + due + ", user='" + '\'' + ", project='" + project + '\'' + ", complete=" + (complete ? "Complete" : "Incomplete") + '}';
    }
}