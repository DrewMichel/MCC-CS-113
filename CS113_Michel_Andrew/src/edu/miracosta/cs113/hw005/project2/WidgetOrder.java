package edu.miracosta.cs113.hw005.project2;

/**
 * Created by Andrew Michel on 3/5/2017.
 *
 * This class uses an ArrayList of Widget to process widgets
 */

import java.util.ArrayList;

public class WidgetOrder
{
    private ArrayList<Widget> orders;

    private int orderSize;

    public WidgetOrder()
    {
        orders = new ArrayList<>();

        orderSize = 5;
    }

    public WidgetOrder(int size, int orderSize)
    {
        orders = new ArrayList<>(size);

        this.orderSize = orderSize;
    }

    public int getOrderSize()
    {
        return orderSize;
    }

    public void setOrderSize(int orderSize)
    {
        this.orderSize = orderSize;
    }

    public ArrayList<Widget> getOrders()
    {
        return orders;
    }

    /**
     *
     * @return sum price of all widgets without billed price
     */
    public double getTotalPrice()
    {
        double sum = 0;

        for (Widget widget: orders)
        {
            sum += widget.getPrice();
        }
        return sum;
    }

    /**
     *
     * @return sum price of all widgets with billed price
     */
    public double getTotalBilledPrice()
    {
        double sum = 0;

        for (Widget widget: orders)
        {
            sum += widget.getBilledPrice();
        }

        return sum;
    }

    /**
     *
     * populates all widgets in this WidgetOrder
     */
    public void populateOrder()
    {
        while(orders.size() < orderSize)
        {
            orders.add(new Widget(Math.random() * 1000));
        }
    }

    /**
     *
     * @param price populates all widgets in this WidgetOrder
     */
    public void populateOrder(double price)
    {
        while(orders.size() < orderSize)
        {
            orders.add(new Widget(price));
        }
    }

    /**
     *
     * @param wo WidgetOrder which has its widgets moved into this WidgetOrder
     */
    public void moveWidgets(WidgetOrder wo)
    {
        while((orders.size() < this.orderSize) && wo.getOrders().size() > 0)
        {
            this.orders.add(wo.getOrders().remove(wo.getOrders().size() - 1));
        }
    }

    /**
     *
     * @return true if the widget order is full, else false
     */
    public boolean isFull()
    {
        return (this.orderSize <= orders.size());
    }

    /**
     *
     * @return String containing instance variables, should only be called upon being shipped
     */
    public String toString()
    {
        return "Number of Widgets Shipped: " + orderSize + " | Total Price: " + getTotalPrice() + " | Total Billed Price: " + getTotalBilledPrice();
    }
}
