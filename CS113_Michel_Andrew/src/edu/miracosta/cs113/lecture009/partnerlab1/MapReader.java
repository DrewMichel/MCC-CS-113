package edu.miracosta.cs113.lecture009.partnerlab1;

/**
 * Created by w7237616 on 4/3/2017.
 *
 * Zach Pownell
 * Andrew Michel
 *
 * page 372, project 1
 *
 * Write statements to create a Map object
 * that will store each word occurring in a term paper along
 * with the number of times the word occurs
 *
 * page 372, project 2
 *
 * Write a method buildWordCounts (based on buildIndex)
 * that builds the Map object described in Programming Exercise 1.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

public class MapReader
{
    public static void main(String[] args)
    {
        // Key String - word in file
        // Value Integer - number of occurrences in file
        Map<String, Integer> map = new HashMap<>();

        Scanner fileInput = null;

        Scanner keyboard = new Scanner(System.in);

        PrintWriter pw;

        String fileName = "";

        String input = "";

        System.out.print("Enter file name: ");

        fileName = keyboard.nextLine();

        try
        {
            pw = new PrintWriter(fileName);

            do
            {
                System.out.print("Enter line: ");

                input = keyboard.nextLine();

                if(!input.equals(""))
                {
                    pw.println(input);
                }

            }while(!input.equals(""));

            pw.close();

            fileInput = new Scanner(new FileInputStream(fileName));

            buildWordCounts(map, fileInput);

            fileInput.close();

            displayMap(map);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(0);
        }


    }

    /**
     * Populates a Map<String, Integer> with words in a file, if a word already exists as a key,
     * Integer value associated with that word is incremented by one.
     * @param map Map<String, Integer> which stores words as keys and
     *            the number of occurrences as values
     * @param fileInput the stream which words are read in from and added as keys to the map param
     */
    public static void buildWordCounts(Map<String, Integer> map, Scanner fileInput)
    {
        Scanner lineReader = null;

        String currentLine = "";
        String currentWord = "";

        while(fileInput.hasNextLine())
        {
            currentLine = fileInput.nextLine();

            lineReader = new Scanner(currentLine);

            while(lineReader.hasNext())
            {
                currentWord = lineReader.next();


                if(map.containsKey(currentWord))
                {
                    //map.replace(currentWord, map.get(currentWord) + 1);
                    map.put(currentWord, map.get(currentWord) + 1);
                }
                else
                {
                    map.put(currentWord, 1);
                }
            }
        }
    }

    /**
     *
     * @param map Map<String, Integer> that is iterated over and has its String
     *            keys displayed with its associated Integer value
     */
    public static void displayMap(Map<String, Integer> map)
    {
        int counter = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.print(entry.getKey() + ": " + entry.getValue() + " ");

            counter++;

            if(counter % 5 == 0 && counter != 0)
            {
                System.out.println();
            }
        }
    }
}
