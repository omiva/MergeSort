package com.company;

import java.util.Random;  //to take in random input values

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        int[] a = new int[100000];

        Scanner in = new Scanner(System.in);

        long start, end;

        System.out.print("ENTER THE NUMBER OF ELEMENTS TO BE SORTED: ");

        int n = in.nextInt();

        Random rand = new Random();

        for (int i = 0; i < n; i++)

            a[i] = rand.nextInt(2000);

        System.out.println("\nARRAY ELEMENTS TO BE SORTED ARE: ");

        for (int i = 0; i < n; i++)

            System.out.println(a[i]);

        start = System.nanoTime();

        mergesort(a, 0, n - 1);

        end = System.nanoTime();

        System.out.println("\nTHE SORTED ELEMENTS ARE: ");

        for (int i = 0; i < n; i++)

            System.out.println(a[i]);

        System.out.println("\nTHE TIME TAKEN TO SORT IS " + (end - start) + "ns");
    }
    static void mergesort (int[] a, int low, int high)
    {
        int mid;
        if (low < high)
        {
            mid = (low + high) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    static void merge(int[] a, int low, int mid, int high)
    {

        int i, j, h, k;
        int []  b= new int[100000];
        h=low; i=low; j=mid+1;

        while((h<=mid) && (j<=high))
        {
            if(a[h] < a[j])
            {
                b[i]=a[h];
                h=h+1;
            }
            else
            {
                b[i] = a[j];
                j=j+1;
            }
            i = i+1;
        }
        if(h > mid)
        {
            for(k=j; k<=high; k++)
            {
                b[i]=a[k];
                i= i+1;
            }
        }
        else
        {
            for(k=h;k<=mid;k++)
            {
                b[i]=a[k];
                i= i+1;
            }
        }
        for(k=low; k<= high; k++)
            a[k] = b[k];
    }
}
