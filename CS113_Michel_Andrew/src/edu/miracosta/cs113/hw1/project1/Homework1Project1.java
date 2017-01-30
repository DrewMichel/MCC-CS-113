package edu.miracosta.cs113.hw1.project1;

import edu.miracosta.cs113.hw1.assistant.AssistantJack;
import edu.miracosta.cs113.hw1.assistant.Theory;
import edu.miracosta.cs113.hw1.assistant.TheoryItem;

/**
 * Created by Andrew Michel on 1/28/2017.
 */

public class Homework1Project1
{

    // main method
    public static void main(String[] args)
    {
        // Answer set 1 with weapon, location, and person set to 1
        System.out.println("Starting jack1: answer set 1");
        AssistantJack jack1 = new AssistantJack(1);
        Theory theory1 = iterateThroughChecks(jack1);

        System.out.println("jack1 found the answer!");
        System.out.println("It was " + TheoryItem.getPersonName(theory1.getPerson()) + " with the " + TheoryItem.getWeaponName(theory1.getWeapon()) + " in the " + TheoryItem.getLocationName(theory1.getLocation())+ "\n");

        // Answer set 2 with weapon and person set to 6 and location set to 10
        System.out.println("Starting jack2: answer set 2");
        AssistantJack jack2 = new AssistantJack(2);
        Theory theory2 = iterateThroughChecks(jack2);

        System.out.println("jack2 found the answer!");
        System.out.println("It was " + TheoryItem.getPersonName(theory2.getPerson()) + " with the " + TheoryItem.getWeaponName(theory2.getWeapon()) + " in the " + TheoryItem.getLocationName(theory2.getLocation())+ "\n");

        // Answer set random with weapon, location, and person set randomly
        System.out.println("Starting jack3: answer set random");
        AssistantJack jack3 = new AssistantJack(3);
        Theory theory3 = iterateThroughChecks(jack3);

        System.out.println("jack3 found the answer!");
        System.out.println("It was " + TheoryItem.getPersonName(theory3.getPerson()) + " with the " + TheoryItem.getWeaponName(theory3.getWeapon()) + " in the " + TheoryItem.getLocationName(theory3.getLocation()) + "\n");

    }

    /**
     *
     * @param jackieChan accepts an object of AssistantJack
     * @return theory a Theory object with the correct solutions after
     *          finding the person, weapon, and location
     */
    public static Theory iterateThroughChecks(AssistantJack jackieChan)
    {
        Theory theory = null;

        int numberOfChecks = 0;

        int currentWeapon = 1;
        int currentPerson = 1;
        int currentLocation = 1;

        int numberOfIncorrect = -1;

        do
        {
            theory = new Theory(currentWeapon,currentLocation,currentPerson);

            numberOfIncorrect = jackieChan.checkAnswer(theory);
            numberOfChecks++;

            // 1 means the incorrect weapon was found,
            // 2 means the incorrect location was found,
            // 3 means the incorrect person was found
            if(numberOfIncorrect == 1)
            {
                currentWeapon++;
            }
            if(numberOfIncorrect == 2)
            {
                currentLocation++;
            }
            if(numberOfIncorrect == 3)
            {
                currentPerson++;
            }

            System.out.println("Answer #" + numberOfChecks +  " returned a " + numberOfIncorrect);
        } while(numberOfIncorrect != 0);

        return theory;
    }
}
