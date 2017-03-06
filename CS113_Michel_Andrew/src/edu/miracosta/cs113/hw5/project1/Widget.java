package edu.miracosta.cs113.hw5.project1;

/**
 * Created by Andrew Michel on 3/5/2017.
 *
 * This class records the individual price of a widget and can also return the billed price of the widget
 */

public class Widget
{

    private double price;

    public Widget()
    {
        price = 0;
    }

    public Widget(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getBilledPrice()
    {
        return price * 1.5;
    }

    /**
     *
     * @return String containing price and billed price of this widget
     */
    public String toString()
    {
        return "Price: " + price + " | Billed Price: " + (price * 1.5);
    }
}
