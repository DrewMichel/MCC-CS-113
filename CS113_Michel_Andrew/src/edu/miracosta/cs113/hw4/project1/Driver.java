package edu.miracosta.cs113.hw4.project1;

import java.util.Scanner;

/**
 * Created by Andrew Michel on 2/13/2017.
 *
 * Adds students to the start and end of the linked list and removes from the start and by name
 */
public class Driver
{
    public static final String INSERT_START = "1", INSERT_END = "2",
                                REMOVE_START = "3", REMOVE_NAME = "4",
                                DISPLAY = "5", BILLY = "6",OPTIONS = "7", END = "8";


    public static void main(String[] args)
    {
        KWLinkedList<Student> studentList = new KWLinkedList<Student>();

        Scanner keyboard = new Scanner(System.in);

        String userInput = "", inputName = "", inputID = "";

        printOptions();

        while(!userInput.equals(END))
        {
            System.out.print("Enter input: ");
            userInput = keyboard.nextLine();

            if(userInput.equals(INSERT_START))
            {
                System.out.print("Enter name: ");
                inputName = keyboard.nextLine();

                System.out.print("Enter ID: ");
                inputID = keyboard.nextLine();

                studentList.addFirst(new Student(inputName, inputID));
            }
            else if(userInput.equals(INSERT_END))
            {
                System.out.print("Enter name: ");
                inputName = keyboard.nextLine();

                System.out.print("Enter ID: ");
                inputID = keyboard.nextLine();

                studentList.addLast(new Student(inputName, inputID));
            }
            else if(userInput.equals(REMOVE_START))
            {
                studentList.removeFromStart();
            }
            else if(userInput.equals(REMOVE_NAME))
            {
                System.out.print("Enter name: ");
                inputName = keyboard.nextLine();

                studentList.removeByName(new Student(inputName, ""));
            }
            else if(userInput.equals(BILLY))
            {
                studentList.billy();

                studentList.printData();
            }
            else if(userInput.equals(DISPLAY))
            {
                studentList.printData();
            }
            else
            {
                printOptions();
            }
        }
    }

    /**
     * Displays options
     */
    public static void printOptions()
    {
        System.out.println("Enter " + INSERT_START + " to insert a student at the start");
        System.out.println("Enter " + INSERT_END + " to insert a student at the end");
        System.out.println("Enter " + REMOVE_START + " to remove a student at the start");
        System.out.println("Enter " + REMOVE_NAME + " to remove a student by name");
        System.out.println("Enter " + DISPLAY + " to display all students");
        System.out.println("Enter " + BILLY + " to simulate LinkedList");
        System.out.println("Enter " + OPTIONS + " to display options");
        System.out.println("Enter " + END + " to end program");
    }
}
