package edu.miracosta.cs113.hw002.project1;

/**
 * Created by Andrew Michel on 2/6/2017.
 */
public class Vegetables extends Food
{
    @Override
    public double percentProtein() {
        return this.getCalories() * 0.30;
    }

    @Override
    public double percentFat() {
        return this.getCalories() * 0.15;
    }

    @Override
    public double percentCarbohydrates() {
        return this.getCalories() * 0.55;
    }
}
