package edu.miracosta.cs113.hw005.project1;

/**
 * Created by Andrew Michel on 3/5/2017.
 * This class simulates a warehouse which
 * 1. Accepts orders and attempts to fill them with widgets within the warehouse
 * 2. Accepts deliveries of widgets and attempts to fill any remaining orders then place remaining widgets into inventory
 * Inventory and Orders operate on a most recent basis
 * The textbook instructions are garbage to be honest
 */

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Scanner;

public class StackWidget
{
    public static final String ADD_ORDER = "1", ADD_WIDGETS = "2", OPTIONS = "3", EXTERMINATE = "4";

    public static void main(String[] args)
    {
        Stack<WidgetOrder> orderStack = new Stack<WidgetOrder>();

        Stack<WidgetOrder> inventoryStack = new Stack<WidgetOrder>();

        WidgetOrder delivery = new WidgetOrder();

        WidgetOrder order = new WidgetOrder();

        WidgetOrder bud = new WidgetOrder();

        Scanner keyboard = new Scanner(System.in);

        int number = 0;

        double price = 0;

        String input = "";

        printOptions();

        do {

            System.out.print("Enter choice: ");
            input = keyboard.nextLine();

            if(input.equals(ADD_ORDER))
            {
                System.out.print("Enter number of widgets in order: ");
                number = (int) getInput();

                order = new WidgetOrder(10, number);

                while(inventoryStack.empty() == false && order.isFull() == false)
                {
                    bud = inventoryStack.pop();

                    order.moveWidgets(bud);
                }

                if(order.isFull() == false)
                {
                    orderStack.push(order);
                    System.out.println(orderStack.peek().getOrders().size() + " widgets moved to order.  Awaiting " + (orderStack.peek().getOrderSize() - orderStack.peek().getOrders().size()) + " more widgets.");
                }
                else
                {
                    System.out.println(order.toString());
                }

                if(bud.getOrders().size() > 0)
                {
                    System.out.println("Returning " + bud.getOrders().size() + " widgets to inventory");

                    inventoryStack.push(bud);
                }
                else if(inventoryStack.empty() == false)
                {
                    System.out.println("Number of widgets on next stack: "+ inventoryStack.peek().getOrders().size());
                }
                else
                {
                    System.out.println("No remaining widgets");
                }
            }
            else if(input.equals(ADD_WIDGETS))
            {
                System.out.print("Enter number of widgets: ");
                number = (int) getInput();

                System.out.print("Enter price per widget: ");
                price = getInput();

                delivery = new WidgetOrder(10, number);
                delivery.populateOrder(price);

                while(orderStack.empty() == false && delivery.getOrders().size() > 0)
                {
                    orderStack.peek().moveWidgets(delivery);

                    if(orderStack.peek().isFull() == true)
                    {
                        try
                        {
                            WidgetOrder temp = orderStack.pop();
                            System.out.println(temp.toString());
                        }
                        catch(NoSuchElementException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                if(delivery.getOrders().size() > 0)
                {
                    System.out.println("Moving " + delivery.getOrders().size() + " widgets to inventory");

                    inventoryStack.push(delivery);
                }

            }
            else if(input.equals(OPTIONS))
            {
                printOptions();
            }

        }while(!input.equals(EXTERMINATE));
    }

    /**
     * Displays menu options
     */
    public static void printOptions()
    {
        System.out.println("Enter " + ADD_ORDER + " to place an order of widgets");
        System.out.println("Enter " + ADD_WIDGETS + " to deliver widgets");
        System.out.println("Enter " + OPTIONS + " to display options");
        System.out.println("Enter " + EXTERMINATE + " to end program");
    }

    /**
     *
     * @return input double which is entered via keyboard
     */
    public static double getInput()
    {
        Scanner keyboard = new Scanner(System.in);

        boolean bad = true;

        double input = 0;

        do {

            try
            {
                input = keyboard.nextDouble();
                bad = false;
            }
            catch(InputMismatchException e)
            {
                bad = true;
                System.out.println(e.getMessage());
            }


        }while(bad);

        return input;
    }

    /**
     *
     * @param wos the Stack to be popped and have its elements displayed
     */
    public static void popStack(Stack<WidgetOrder> wos)
    {
        while(wos.empty() == false)
        {
            for (Widget widget: wos.peek().getOrders())
            {
                System.out.println(widget);
            }

            try
            {
                wos.pop();
            }
            catch(NoSuchElementException e)
            {
                System.out.println(e.getMessage());
            }
        }


    }
}
