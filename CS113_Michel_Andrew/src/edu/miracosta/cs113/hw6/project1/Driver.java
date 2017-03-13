package edu.miracosta.cs113.hw6.project1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Andrew Michel on 3/11/2017.
 */
public class Driver
{
    public static void main(String[] args)
    {
        final String PROMPT = "Enter the number of print iterations between pauses: ";
        final int ITERATIONS = 100;
        final long DELAY = 100;
        final int NUMBER_OF_PAGES_PER_MINUTE = 10;

        Calendar startTime = new GregorianCalendar();
        Calendar currentTime = new GregorianCalendar();
        //currentTime.setTime(System.nanoTime());

        Office officeA = new Office(1);
        Office officeB = new Office(2);
        Office officeC = new Office(3);

        // Sync clocks
        officeB.setCurrentTime(officeA.getCurrentTime());
        officeC.setCurrentTime(officeA.getCurrentTime());

        PrintJob incomingJobA, incomingJobB, incomingJobC;

        Scanner keyboard = new Scanner(System.in);

        StringBuilder pause;

        int numberOfPages = 0;

        int counter = 0, spacing = 0, index = 0;

        boolean firstRun = true, finished = false;

        spacing = (int) (Math.log10(ITERATIONS) + 1);

        counter = getInput(PROMPT);

        //System.out.println(spacing);

        // TODO: reduce end times by start time to determine time required to complete printing jobs
        // TODO: change to do-while... use orderoutput to determine if all 3x100 have finished

        do
        {
            if(index % counter == 0 && firstRun == false)
            {
                pause = new StringBuilder(keyboard.nextLine());
                pause.setLength(0);
            }

            officeA.processPrintJob();
            officeB.processPrintJob();
            officeC.processPrintJob();

            officeA.printPages(NUMBER_OF_PAGES_PER_MINUTE);
            officeB.printPages(NUMBER_OF_PAGES_PER_MINUTE);
            officeC.printPages(NUMBER_OF_PAGES_PER_MINUTE);

            if(index < ITERATIONS)
            {
                //numberOfPages = 1;
                numberOfPages = (int) (Math.random() * 50) + 1;


                // USE I * milliseconds to minute to print time added to queue regardless of pausing or speed

                // 60,000 milliseconds = 60 seconds (1 printjob added per 60 seconds)
                // 6,000 milliseconds = 6 seconds (1 page per 6 seconds)
                currentTime.setTimeInMillis(startTime.getTimeInMillis() + ((long) index * 60000 ));

                incomingJobA = new PrintJob(numberOfPages, currentTime, index + 1);
                incomingJobB = new PrintJob(numberOfPages, currentTime, index + 1);
                incomingJobC = new PrintJob(numberOfPages, currentTime, index + 1);

                System.out.printf("ADDING: Job # %" + spacing + "d | CONTAINS:  %" + spacing + "d pages to queue at " + currentTime.getTime() + "\n", (index + 1), numberOfPages);

                officeA.addPrintJobToQueue(incomingJobA);
                officeB.addPrintJobToQueue(incomingJobB);
                officeC.addPrintJobToQueue(incomingJobC);
            }

            firstRun = false;
            index++;
            finished = (officeA.hasFinished(ITERATIONS) && officeB.hasFinished(ITERATIONS) && officeC.hasFinished(ITERATIONS));

        }while(finished == false);

        System.out.println("STARTED AT: " + startTime.getTime() + "\n");

        System.out.println(officeC + " COMPLETED AT: " + officeC.getTimeCompleted().getTime());
        System.out.println("TIME ELAPSED: " + elapsedTime(startTime.getTimeInMillis(), officeC.getTimeCompleted().getTimeInMillis()) + "\n");

        System.out.println(officeB + " COMPLETED AT: " + officeB.getTimeCompleted().getTime());
        System.out.println("TIME ELAPSED: " + elapsedTime(startTime.getTimeInMillis(), officeB.getTimeCompleted().getTimeInMillis()) + "\n");

        System.out.println(officeA + " COMPLETED AT: " + officeA.getTimeCompleted().getTime());
        System.out.println("TIME ELAPSED: " + elapsedTime(startTime.getTimeInMillis(), officeA.getTimeCompleted().getTimeInMillis()) + "\n");
    }

    public static int getInput(String prompt)
    {
        Scanner keyboard = new Scanner(System.in);

        int input = 0;

        boolean badInput = true;

        System.out.print(prompt);

        do {
            try
            {
                input = keyboard.nextInt();

                badInput = false;
            }
            catch(InputMismatchException e)
            {
                keyboard.nextLine();
                //System.out.println(e.getMessage());
                System.out.print(prompt);

                badInput = true;
            }
        }while(badInput == true);

        return input;
    }

    public static String elapsedTime(long startPoint, long endPoint)
    {
        long difference = endPoint - startPoint;

        long days = 0;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;

        try
        {
            seconds = (difference / 1000) % 60;
            minutes = (difference / (1000 * 60)) % 60;
            hours = (difference / (1000 * 60 * 60)) % 24;
            days = (difference / (1000 * 60 * 60 * 24)) % 7;
        }
        catch(ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }

        return "Days: " + days + " | Hours: " + hours + " | Minutes: " + minutes + " | Seconds: " + seconds;
    }
}
