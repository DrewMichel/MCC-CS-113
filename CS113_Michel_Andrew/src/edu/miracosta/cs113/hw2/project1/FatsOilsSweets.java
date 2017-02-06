package edu.miracosta.cs113.hw2.project1;

/**
 * Created by Andrew Michel on 2/6/2017.
 */
public class FatsOilsSweets extends Food
{
    @Override
    public double percentProtein() {
        return this.getCalories() * 0.05;
    }

    @Override
    public double percentFat() {
        return this.getCalories() * 0.80;
    }

    @Override
    public double percentCarbohydrates() {
        return this.getCalories() * 0.15;
    }
}
