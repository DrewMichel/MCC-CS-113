package edu.miracosta.cs113.hw9.project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Andrew Michel on 4/16/2017.
 *
 *     Programming Project 2, pg 416.
 *      Use a HashMap to store the frequency counts for all the words
 *      in a large text document.  When you are done, display the
 *      contents of this HashMap.  Next, create a set view of the Map
 *      and store its contents in an array.  Then sort the array based
 *      on the key value and display it.  Finally, sort the array in
 *      decreasing order by frequency and display it.
 */
public class Driver
{
    public static final String PERIOD = "\\.";
    public static final String COMMA = ",";
    public static final String EXCLAMATION = "!";
    public static final String QUESTION_MARK = "\\?";

    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<>();

        Scanner keyboard = new Scanner(System.in);

        String inputFile = "cupcakeipsum.txt";

        boolean failed = false;

        try
        {
            populateMap(map, inputFile);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Failed to open file: " + inputFile);
            failed = true;
        }

        if(failed == true)
        {
            System.out.print("Enter file name: ");
            inputFile = keyboard.nextLine();

            try
            {
                populateMap(map, inputFile);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }

        System.out.println("PRESORT HASHMAP:\n");
        displayMap(map);

        Occurrence[] occurences = convertMapToArray(map);

        // sort array by key values
        keyBubbleSort(occurences);

        System.out.println("ARRAY SORTED BY KEYS:\n");
        // display array
        displayArray(occurences);

        // sort by frequency
        valueBubbleSort(occurences);
        System.out.println("ARRAY SORTED BY FREQUENCY:\n");

        // display array
        displayArray(occurences);

        System.out.println("Text provided by http://www.cupcakeipsum.com/");
        System.out.println("SUGAR-COATED LOREM IPSUM GENERATOR");
    }

    /**
     *
     * @param hash Map which is populated with words within a file and the number
     *             of times they occur
     * @param path String file path that is used to open inputStream
     * @throws FileNotFoundException if inputStream failed to open stream
     */
    public static void populateMap(Map<String, Integer> hash, String path) throws FileNotFoundException
    {
        Scanner inputStream;

        Scanner lineReader;

        String currentLine;

        String currentWord;

        inputStream = new Scanner(new FileInputStream(path));

        while(inputStream.hasNextLine())
        {
           currentLine = inputStream.nextLine();

           lineReader = new Scanner(currentLine);

           while(lineReader.hasNext())
           {
               currentWord = removePunctuation(lineReader.next().toUpperCase());

               if(hash.containsKey(currentWord))
               {
                   hash.put(currentWord, hash.get(currentWord) + 1);
               }
               else if(currentWord.equals("") == false)
               {
                   hash.put(currentWord, 1);
               }
           }
        }
    }

    /**
     *
     * @param word String original word that may contain punctuation
     * @return removed String with punctuation removed
     */
    public static String removePunctuation(String word)
    {
        String removed = word.replaceAll(PERIOD, "").replaceAll(COMMA, "")
                .replaceAll(EXCLAMATION, "").replaceAll(QUESTION_MARK, "").trim();

        return removed;
    }

    /**
     *
     * @param hash Map that is iterated over and display
     */
    public static void displayMap(Map<String,Integer> hash)
    {
        int counter = 1;

        for (Map.Entry<String, Integer> entry: hash.entrySet())
        {
            System.out.print(entry.getKey() + " " + entry.getValue() + " ");

            if(counter % 5 == 0)
            {
                System.out.println();
            }
            counter++;
        }

        System.out.println("\n");
    }

    /**
     *
     * @param hash Map that is iterated over and copied to an array
     * @return occur Occurrence array that has hash's elements copied over
     */
    public static Occurrence[] convertMapToArray(Map<String, Integer> hash)
    {
        Occurrence[] occur = new Occurrence[10];

        int position = 0;

        for (Map.Entry<String, Integer> entry: hash.entrySet())
        {
            if(entry != null)
            {
                if(entry.getKey() != null)
                {
                    if(position >= occur.length - 1)
                    {
                        occur = reallocateArray(occur);
                    }

                    occur[position] = new Occurrence(entry.getKey(), entry.getValue());
                }
            }

            position++;
        }

        return occur;
    }

    /**
     *
     * @param oldArray Occurrence array that is iterated over and has
     *                 its elements copied into a new array
     * @return newArray Occurrence array that has elements copied into it
     */
    public static Occurrence[] reallocateArray(Occurrence[] oldArray)
    {
        Occurrence[] newArray = new Occurrence[oldArray.length * 2 + 1];

        for(int i = 0; i < oldArray.length; i++)
        {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    /**
     *
     * @param array Occurrence array that is sorted in an ascending
     *              lexicographic order
     */
    public static void keyBubbleSort(Occurrence[] array)
    {
        Occurrence temp;

        boolean sorted = false;

        for(int i = 0; i < array.length && sorted == false; i++)
        {
            if(array[i] == null)
            {
                continue;
            }

            sorted = true;

            for(int k = i + 1; k < array.length; k++)
            {
                if(array[k] == null)
                {
                    continue;
                }
                else if(array[i].getPhrase().compareTo(array[k].getPhrase()) > 0)
                {
                    temp = array[k];
                    array[k] = array[i];
                    array[i] = temp;
                    sorted = false;
                }
            }
        }
    }

    /**
     *
     * @param array Occurrence array that is sorted in a descending
     *              frequency order
     */
    public static void valueBubbleSort(Occurrence[] array)
    {
        Occurrence temp;

        boolean sorted = false;

        for(int i = 0; i < array.length && sorted == false; i++)
        {
            if(array[i] == null)
            {
                continue;
            }

            sorted = true;

            for(int k = i + 1; k < array.length; k++)
            {
                if(array[k] == null)
                {
                    continue;
                }
                else if(array[i].getTimes().compareTo(array[k].getTimes()) < 0)
                {
                    temp = array[k];
                    array[k] = array[i];
                    array[i] = temp;
                    sorted = false;
                }
            }
        }
    }

    /**
     *
     * @param array Occurrence array that is iterated over and has
     *              its elements displayed
     */
    public static void displayArray(Occurrence[] array)
    {
        int numberOfPrints = 0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] != null)
            {
                System.out.print(array[i] + " ");
                numberOfPrints++;
            }

            if(numberOfPrints % 5 == 0)
            {
                System.out.println();
                numberOfPrints = 0;
            }
        }

        System.out.println("\n");
    }

    // Inner class start
    private static class Occurrence
    {
        private String phrase;
        private Integer times;

        public Occurrence(String phrase, Integer times)
        {
            this.phrase = phrase;
            this.times = times;
        }

        public String getPhrase() {
            return phrase;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
        }

        public Integer getTimes() {
            return times;
        }

        public void setTimes(Integer times) {
            this.times = times;
        }

        /**
         *
         * @return a String containing instance variables
         */
        @Override
        public String toString()
        {
            return phrase + " " + times;
        }

        /**
         *
         * @param other Object parameter compared against this object
         * @return true if this and parameter object share similar
         *          instance variables, else false
         */
        @Override
        public boolean equals(Object other)
        {
            if(other == null)
            {
                return false;
            }
            if(this.getClass() != other.getClass())
            {
                return false;
            }

            Occurrence temp = (Occurrence) other;

            if(this.phrase.equals(temp.phrase) && this.times.equals(temp.times))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    } // Inner class end
}
