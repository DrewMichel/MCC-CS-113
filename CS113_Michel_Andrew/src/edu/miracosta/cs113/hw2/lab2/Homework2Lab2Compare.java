package edu.miracosta.cs113.hw2.lab2;

/**
 * Created by Andrew Michel on 2/6/2017.
 */
public class Homework2Lab2Compare
{
    public static void main(String[] args)
    {
        for(int n = 0; n < 100; n+= 10)
        {
            int y1 = 100 * n + 10;

            int y2 = 5 * n * n + 2;

            System.out.printf("Comparing at #" + n + " y1: " + y1 + " y2: " + y2  + " ");
        }
    }
}
