package edu.miracosta.cs113.lecture006.group3;

/**
 * David N. Cole, Zach Pownell, Ross McGuyer, Andrew Michel, Mark Blinder
 */
public class Group3
{
    public static void main(String[] args)
    {
        System.out.println(powah(5 ,3));
        System.out.println(powah(5,0));
        System.out.println(powah(5,-2));

    }

    public static double powah(double x, double pow)
    {
        // if positive
        // else negative
        if(pow == 0)
        {
            return 1;
        }
        if(Math.abs(pow) > 1 )
        {
            x *= powah(x, Math.abs(pow) - 1);
        }

        if(pow < 0)
        {
            return 1/x;
        }
        else
        {
            return x;
        }

    }
}
