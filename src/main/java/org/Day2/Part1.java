package org.Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    //12 red cubes, 13 green cubes, and 14 blue cubes

    int redMax = 12;
    int greenMax = 13;
    int blueMax = 14;

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
            System.out.println(sum);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int getGameID(String input) {
        int gameID;

        //process input to get the gameID

        char[] lineChars = input.toCharArray();
        gameID = Character.getNumericValue(lineChars[5]);
        System.out.println(gameID);

        return gameID;

    }

    public static boolean validityCheck(String input) {

        boolean valid = true;


        //regex blue

        //regex green

        //regex red

        //get max number from each regex

        //check if each number is less than the max cubes

        //regex experiement
        Pattern pattern = Pattern.compile("(\\d blue)", Pattern.CASE_INSENSITIVE); //TODO check if the regex to be valid
        Matcher matcher = pattern.matcher(input);
        boolean matchFound = matcher.find();
        if (matchFound){
            System.out.println("Match found");
            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println(input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
        }
        while (matcher.find()) {

            System.out.println("Match found");
            int start = matcher.start(0);
            int end = matcher.end(0);
            System.out.println(input.substring(start, end));
            //get first item (index 0)
            int numberStr = getNumber(input.substring(start,start+1));
        }


            return valid;
    }

    public static int getNumber(String input) {
        int number = Integer.parseInt(input);

        System.out.println(number);
        return number;
    }
}


