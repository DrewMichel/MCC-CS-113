package edu.miracosta.cs113.hw2.project1;

/**
 * From textbook Data Structures: Abstraction and Design Using Java 3rd edition
 * by Elliot B. Koffman and Paul A.T. Wolfgang
 */
/** Abstract class that models a kind of food. */
public abstract class Food
{
    // Data Field

    private double calories;

    // Abstract Methods

    /** Calculates the percent of protein in a Food object. */
    public abstract double percentProtein();

    /** Calculates the percent of fat in a Food object. */
    public abstract double percentFat();

    /** Calculates the percent of carbohydrates in a Food object. */
    public abstract double percentCarbohydrates();

    // Actual Methods
    public double getCalories() { return calories; }

    public void setCalories(double cal) {
        calories = cal;
    }
}
