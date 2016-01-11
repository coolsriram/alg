package com.alg.sedgewick.sample;

import com.alg.sedgewick.utils.fromsite.StdDraw;
import com.alg.sedgewick.utils.fromsite.StdRandom;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by selvarajs on 2/17/15.
 */
public class SampleMain {
    public static void main(String[] args){
        System.out.println("Main program comes here..");

        String a = "abc";

        System.out.println(a.substring(3));

        for (int i = 0; i <= a.length(); i++){
        //    System.out.println(a.substring(0,i) + "d" + a.substring(i));
        }


        if (true) return;

        visualAccumulator(1000);
        

    }

    public static void visualAccumulator(int noOfTrials){
        VisualAccumulator accumulator = new VisualAccumulator(noOfTrials, 1.0);

        for (int i = 0; i < noOfTrials; i++){
            double rand = StdRandom.uniform();
            accumulator.addDataValue(rand);
            System.out.println(rand);
        }

        System.out.println("\n\n\n\n" + accumulator);

    }

    public static void drawSquare(){
//        StdDraw.line(0,0.5, 0,.5);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(0.1, 0.1, 0.1, 0.5);
        StdDraw.show(500);
        StdDraw.line(0.1, 0.5, 0.5, 0.5);
        StdDraw.show(500);
        StdDraw.line(0.5, 0.5, 0.5, 0.1);
        StdDraw.show(500);
        StdDraw.line(0.5, 0.1, 0.1, 0.1);
        StdDraw.show(500);
    }

    public static void drawBarGraph(boolean isSort){
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();

        if (isSort)
            Arrays.sort(a);

        for (int i = 0; i < N; i++)
        {
            double x = 1.0*i/N;
            double y = a[i]/2.0;
            double rw = 0.5/N;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }

    }

    public static void plotPoints(){

        int n = 100;
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n*n);
        StdDraw.setPenRadius(0.01);

        for (int i = 1; i < n; i++){
            StdDraw.point(i, i);
            StdDraw.point(i, i*i);
            StdDraw.point(i, Math.log(i));
        }
    }
}
