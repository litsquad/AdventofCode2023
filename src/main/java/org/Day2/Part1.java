package org.Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    static int redMax = 12;
    static int greenMax = 13;
    static int blueMax = 14;

    public static void main(String[] args) {
        int sum = 0;
        int currentID;

        try {
            String filePath = new File("").getAbsolutePath();
            System.out.println(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath + "\\src\\main\\java\\org\\Day2\\GameText"));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                currentID = getGameID(line);

                if (validityCheck(line)) {
                    sum = sum + currentID;
                }

                line = reader.readLine();
            }

            System.out.println("sum is " + sum);
            reader.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }
        //TODO================================================DOESNT DETECT DOUBLE DIGITS:(((((
    public static int getGameID(String input) { //process input to get the gameID
        int gameID;
        char[] lineChars = input.toCharArray();
        gameID = Character.getNumericValue(lineChars[5]);
        System.out.println("Game ID " + gameID);

        return gameID;
    }

    public static boolean validityCheck(String input) {
        boolean valid = false;

        //regex blue
        int blue = getMaxBlue(input);

        //regex green
        int green = getMaxGreen(input);

        //regex red
        int red = getMaxRed(input);

        if (blue <= blueMax && red <= redMax && green <= greenMax) {
            valid = true;
        }
            System.out.println("validity check: " + valid);
            return valid;
    }

    public static int getMaxBlue(String input){
        int max = 0;

        Pattern pattern = Pattern.compile("(\\d blue)", Pattern.CASE_INSENSITIVE); //TODO check if the regex to be valid
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if (matchFound){

            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println("Match is " + input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
            max = numberStr;
        }

        while (matcher.find()) {


            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println("Match is " + input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
            if (max < numberStr){
                max = numberStr;
            }
        }
        System.out.println("Blue max " + max);
        return max;
    }

    public static int getMaxRed(String input){
        int max = 0;

        Pattern pattern = Pattern.compile("(\\d red)", Pattern.CASE_INSENSITIVE); //TODO check if the regex to be valid
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if (matchFound){

            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println("Match is " + input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
            max = numberStr;
        }

        while (matcher.find()) {


            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println("Match is " + input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
            if (max < numberStr){
                max = numberStr;
            }
        }
        System.out.println("Red max " + max);

        return max;
    }

    public static int getMaxGreen(String input){
        int max = 0;

        Pattern pattern = Pattern.compile("(\\d green)", Pattern.CASE_INSENSITIVE); //TODO check if the regex to be valid
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();

        if (matchFound){

            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println("Match is " + input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
            max = numberStr;
        }

        while (matcher.find()) {


            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println("Match is " + input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
            if (max < numberStr){
                max = numberStr;
            }
        }
        System.out.println("Green max " + max);


        return max;
    }

    public static int getNumber(String input) {
        int number = Integer.parseInt(input);

        System.out.println(number);
        return number;
    }
}


