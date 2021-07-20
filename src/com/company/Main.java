package com.company;

import com.HighLow.HighLow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Cup myCup = new Cup();
        Scanner scanner = new Scanner(System.in);
        String input;

        myCup.roll();
        System.out.println(myCup.displayCup());
        System.out.println("select dice you want to re-roll (1-5)");
        input = scanner.nextLine(); // "1 2 5"
        myCup.roll(myCup.parseSelections(input));
        System.out.println(myCup.displayCup());
        System.out.println("select dice you want to re-roll (1-5)");
        input = scanner.nextLine(); // "1 2 5"
        myCup.roll(myCup.parseSelections(input));
        System.out.println(myCup.displayCup());
    }
}
