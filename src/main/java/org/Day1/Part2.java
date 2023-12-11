package org.Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {

    public static void main(String[] args){
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
        int j = 0;
        int firstDigit=Character.getNumericValue(lineChars[i]);
        int lastDigit=Character.getNumericValue(backwardsChar[j]);

        while (!Character.isDigit(lineChars[i])){
            System.out.println(lineChars[i]);
            if (((lineChars[i]) == 'o') && ((lineChars[i+1]) == 'n') && ((lineChars[i+2]) == 'e')){
               firstDigit = 1;
               break;
            }
            else if (((lineChars[i]) == 't') && ((lineChars[i+1]) == 'w') && ((lineChars[i+2]) == 'o')){
                firstDigit = 2;
                break;
            }
            else if (((lineChars[i]) == 't') && ((lineChars[i+1]) == 'h') && ((lineChars[i+2]) == 'r') && ((lineChars[i+3]) == 'e') && ((lineChars[i+4]) == 'e')){
                firstDigit = 3;
                break;
            }
            else if (((lineChars[i]) == 'f') && ((lineChars[i+1]) == 'o') && ((lineChars[i+2]) == 'u') && ((lineChars[i+3]) == 'r')){
                firstDigit = 4;
                break;
            }
            else if (((lineChars[i]) == 'f') && ((lineChars[i+1]) == 'i') && ((lineChars[i+2]) == 'v') && ((lineChars[i+3]) == 'e')){
                firstDigit = 5;
                break;
            }
            else if (((lineChars[i]) == 's') && ((lineChars[i+1]) == 'i') && ((lineChars[i+2]) == 'x')){
                firstDigit = 6;
                break;
            }
            else if (((lineChars[i]) == 's') && ((lineChars[i+1]) == 'e') && ((lineChars[i+2]) == 'v') && ((lineChars[i+3]) == 'e') && ((lineChars[i+4]) == 'n')){
                firstDigit = 7;
                break;
            }
            else if (((lineChars[i]) == 'e') && ((lineChars[i+1]) == 'i') && ((lineChars[i+2]) == 'g') && ((lineChars[i+3]) == 'h') && ((lineChars[i+4]) == 't')){
                firstDigit = 8;
                break;
            }
            else if (((lineChars[i]) == 'n') && ((lineChars[i+1]) == 'i') && ((lineChars[i+2]) == 'n') && ((lineChars[i+3]) == 'e')){
                firstDigit = 9;
                break;
            }
            else {
                firstDigit = Character.getNumericValue(lineChars[i+1]);

            }

            i++;
        }

        System.out.println("first digit " + firstDigit);


        //iterate over backwards string

        while (!Character.isDigit(backwardsChar[j])){
            System.out.println(backwardsChar[j]);
            if (((backwardsChar[j]) == 'e') && ((backwardsChar[j+1]) == 'n') && ((backwardsChar[j+2]) == 'o')){
                lastDigit = 1;
                break;
            }
            else if (((backwardsChar[j]) == 'o') && ((backwardsChar[j+1]) == 'w') && ((backwardsChar[j+2]) == 't')){
                lastDigit = 2;
                break;
            }
            else if (((backwardsChar[j]) == 'e') && ((backwardsChar[j+1]) == 'e') && ((backwardsChar[j+2]) == 'r') && ((backwardsChar[j+3]) == 'h') && ((backwardsChar[j+4]) == 't')){
                lastDigit = 3;
                break;
            }
            else if (((backwardsChar[j]) == 'r') && ((backwardsChar[j+1]) == 'u') && ((backwardsChar[j+2]) == 'o') && ((backwardsChar[j+3]) == 'f')){
                lastDigit = 4;
                break;
            }
            else if (((backwardsChar[j]) == 'e') && ((backwardsChar[j+1]) == 'v') && ((backwardsChar[j+2]) == 'i') && ((backwardsChar[j+3]) == 'f')){
                lastDigit = 5;
                break;
            }
            else if (((backwardsChar[j]) == 'x') && ((backwardsChar[j+1]) == 'i') && ((backwardsChar[j+2]) == 's')){
                lastDigit = 6;
                break;
            }
            else if (((backwardsChar[j]) == 'n') && ((backwardsChar[j+1]) == 'e') && ((backwardsChar[j+2]) == 'v') && ((backwardsChar[j+3]) == 'e') && ((backwardsChar[j+4]) == 's')){
                lastDigit = 7;
                break;
            }
            else if (((backwardsChar[j]) == 't') && ((backwardsChar[j+1]) == 'h') && ((backwardsChar[j+2]) == 'g') && ((backwardsChar[j+3]) == 'i') && ((backwardsChar[j+4]) == 'e')){
                lastDigit = 8;
                break;
            }
            else if (((backwardsChar[j]) == 'e') && ((backwardsChar[j+1]) == 'n') && ((backwardsChar[j+2]) == 'i') && ((backwardsChar[j+3]) == 'n')){
                lastDigit = 9;
                break;
            }
            else {

                lastDigit = Character.getNumericValue(backwardsChar[j+1]);
            }
            j++;
        }



        System.out.println("last digit " + lastDigit);

        //concatenate
        int number = Integer.valueOf(String.valueOf(firstDigit) + String.valueOf(lastDigit));
        System.out.println("number is " + number);
        return number;
    }

    public static String reverseStr(String input){
        StringBuilder stringBuilder = new StringBuilder(input);

        String reversedString = stringBuilder.reverse().toString();


        return reversedString;
    }


}
