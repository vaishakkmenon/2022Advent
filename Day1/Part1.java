package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1
{
    public static void main(String[] args)
    {
        File f = new File("Part1Data.txt");
        int total = 0;
        ArrayList<Integer> elves = new ArrayList<Integer>();
        try 
        {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                if(line != "")
                {
                    int num = Integer.parseInt(line);
                    total += num;
                }
                else
                {
                    elves.add(total);
                    total = 0;
                }
            }

            sc.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        int max = -1;
        int index = -1;
        int count = 0;
        for(int i : elves)
        {
            if(i > max)
            {
                max = i;
                index = count;
            }
            count++;
        }
        
        System.out.println("Elf with the most amount of calories: " + index);
        System.out.println("Number of calories elf " + index + " carries:" + max);
    }
}