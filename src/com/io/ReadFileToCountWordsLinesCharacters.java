package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileToCountWordsLinesCharacters {
    public static void main(String[] args) {
        int charsCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String currentline = br.readLine();
            while(currentline != null){
                lineCount++;
                String arr[] = currentline.split(" ");
                wordCount = wordCount + arr.length;
                for(String str :arr){
                    charsCount= charsCount+str.length();
                }

                currentline = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("ExceptionOccurred" + ex.getStackTrace());

        }

        System.out.println("charsCount:"+charsCount);
        System.out.println("wordsCount:"+wordCount);
        System.out.println("lineCount:"+lineCount);


    }
}
