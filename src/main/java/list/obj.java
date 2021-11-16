/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Berkay Arslan
 */

package list;
import java.util.ArrayList;
import java.io.*;

public class obj
{
    public void writeAsObject(ArrayList<App> apps)
    {
        try
        {
            File file = new File("objectFile.txt");
            FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(fileStream);

            writer.writeObject(apps);
            writer.close();
            fileStream.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<App> readAsObject()
    {
        ArrayList<App> list = new ArrayList<>();

        File file1 = new File("objectFile.txt");

        if(!file1.exists())
            return list;

        try
        {
            File file = new File("objectFile.txt");

            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fileStream);

            for(App app : list = (ArrayList<App>) reader.readObject()) {

            }

            reader.close();
            fileStream.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}