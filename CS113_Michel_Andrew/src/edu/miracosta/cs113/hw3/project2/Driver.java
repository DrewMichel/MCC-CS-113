package edu.miracosta.cs113.hw3.project2;

/**
 * Created by Andrew Michel on 2/13/2017.
 *
 * Adds students to the start and end of the linked list and removes from the start and by name
 */
public class Driver
{
    public static void main(String[] args)
    {
        Chapter2_Project2<Student> studentList = new Chapter2_Project2<Student>();

        studentList.insertAtStart(new Student("Bob", "55"));
        studentList.insertAtStart(new Student("Jeff", "11"));
        studentList.insertAtStart(new Student("Billy", "33"));
        studentList.insertAtEnd(new Student("Shepard", "44"));
        studentList.insertAtEnd(new Student("Wrex", "70"));

        System.out.println("BEFORE CHANGES: ");

        studentList.printData();

        System.out.println("AFTER CHANGES: ");

        studentList.removeFromStart();

        studentList.removeByName(new Student("Bob", "5"));

        studentList.printData();
    }
}
