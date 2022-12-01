package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2
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

        int topThree = 0;
        int[] topElves = new int[3];

        for(int i = 0; i < 3; i++)
        {
            int max = -1;
            int index = -1;
            int count = 0;
            for(int j : elves)
            {
                if(j > max)
                {
                    max = j;
                    index = count;
                }
                count++;
            }

            elves.remove(index);
            topElves[topThree] = max;
            topThree++;

        }

        int topThreeCal = 0;
        for(int k : topElves)
        {
            topThreeCal += k;
        }
        
        System.out.println("Total Calories for top three:" + topThreeCal);
    }
}