import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Andrew Michel on 2/13/2017.
 */
public class Driver
{
    public static final String ADD = "1", REMOVE = "2", DISPLAY = "3", UPCOMING = "4", OPTIONS = "5", END = "6";

    public static void main(String[] args)
    {
        Chapter2_Project1<Assignment> linked = new Chapter2_Project1<Assignment>();

        ArrayList<Assignment> returnedList = null;

        Scanner keyboard = new Scanner(System.in);

        String userInput = "", inputClass = "", inputAssignment = "";

        int inputYear = 0, inputMonth = 0, inputDay = 0;

        printOptions();

        while(!userInput.equals(END))
        {
            try
            {
                System.out.print("Enter input: ");
                userInput = keyboard.nextLine();

                if(userInput.equals(ADD))
                {
                    System.out.print("Enter class name: ");
                    inputClass = keyboard.nextLine();

                    System.out.print("Enter assignment name: ");
                    inputAssignment = keyboard.nextLine();

                    System.out.print("Enter due year month and day ");
                    inputYear = keyboard.nextInt();
                    inputMonth = keyboard.nextInt();
                    inputDay = keyboard.nextInt();

                    linked.add(new Assignment(inputClass, inputAssignment, inputYear, inputMonth, inputDay));
                }
                else if(userInput.equals(REMOVE))
                {
                    System.out.print("Enter class name: ");
                    inputClass = keyboard.nextLine();

                    System.out.print("Enter assignment name: ");
                    inputAssignment = keyboard.nextLine();

                    System.out.print("Enter due year month and day ");
                    inputYear = keyboard.nextInt();
                    inputMonth = keyboard.nextInt();
                    inputDay = keyboard.nextInt();

                    linked.remove(new Assignment(inputClass, inputAssignment, inputYear, inputMonth, inputDay));

                }
                else if(userInput.equals(DISPLAY))
                {
                    returnedList = linked.getArrayList();

                    for(int i = 0; i < returnedList.size(); i++)
                    {
                        System.out.println(returnedList.get(i));
                    }
                }
                else if(userInput.equals(UPCOMING))
                {
                    linked.printUpcoming();
                }
                else
                {
                    printOptions();
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * Displays options
     */
    public static void printOptions()
    {
        System.out.println("Enter " + ADD + " to add an assignment");
        System.out.println("Enter " + REMOVE + " to remove an assignment");
        System.out.println("Enter " + DISPLAY + " view all assignments");
        System.out.println("Enter " + UPCOMING + " view nearest due assignments");
        System.out.println("Enter " + OPTIONS + " view options");
        System.out.println("Enter " + END + " to end program");
    }
}
