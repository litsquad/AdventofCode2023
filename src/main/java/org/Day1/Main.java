package org.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader;
        int sum = 0;

        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\FramedWurk\\IdeaProjects\\AdventofCode2023\\src\\main\\java\\org\\Day1\\InputText"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);

                sum = sum + processString(line);
                line = reader.readLine();
            }
            System.out.println(sum);

            reader.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int processString(String line){

        char[] lineChars = line.toCharArray();

        String backwardsStr = reverseStr(line);
        char[] backwardsChar = backwardsStr.toCharArray();

        //iterate forwards until int
        int i = 0;
        while (!Character.isDigit(lineChars[i])){
            System.out.println(lineChars[i]);
            i++;
        }
        int firstDigit = Character.getNumericValue(lineChars[i]);
        System.out.println("first digit " + firstDigit);


        //iterate backwards until int
        int j = 0;
        while (!Character.isDigit(backwardsChar[j])){

            j++;
        }
        int lastDigit = Character.getNumericValue(backwardsChar[j]);
        System.out.println("last digit " + lastDigit);

        //concatenate
        int number = Integer.valueOf(String.valueOf(firstDigit) + String.valueOf(lastDigit));
        System.out.println(number);
        return number;
    }

    public static String reverseStr(String input){
        StringBuilder stringBuilder = new StringBuilder(input);

        String reversedString = stringBuilder.reverse().toString();


        return reversedString;
    }



}