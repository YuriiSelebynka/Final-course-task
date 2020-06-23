/*
*
* Classname : Java Development (K)
*
*  23 June 2020
*
* Created by Selebynka Yurii (UzhNU)
*
*   Final course task.
*   1. GLOSSARY
*
* 1.1. Download a text about Harry Potter.
* 1.2. For each distinct word in the text calculate the number of occurrence.
* 1.3. Use RegEx.
* 1.4. Sort in the DESC mode by the number of occurrence.
* 1.5. Find  the first 20 pairs.
* 1.6  Find all the proper names.
* 1.7. Count them and arrange in alphabetic order.
* 1.8. First 20 pairs and names write into to a file test.txt.
* 1.9. Create a fine header for the file.
* 1.10 Use Java  Collections to demonstrate your experience (Map, List).
*
* */

package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.nio.file.Path;

import static jdk.nashorn.internal.objects.NativeString.substring;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class Main {

    private static Object FileNotFoundException;

    public static void main(String[] args) throws IOException {

        //------------ 1.1. Download a text about Harry Potter. -------------\\

        /*
         * @param text - reads a txt-format file from computer.
         *
         * @return - usable text for program.
         */

        String text = new String(Files.readAllBytes(Paths
                .get("C:/Users/Home/Desktop/harry.txt")));

        //------------ 1.3. Use RegEx. --------------------------------------\\

        /*
         * @param cleanedText - cleans text from all useless symbols.
         *
         * @return - cleaned text, suitable to sorting.
         */

        String cleanedText = text.replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("\"", "")
                .replaceAll("�", "")
                .replaceAll("\\?", "")
                .replaceAll("\\!", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\.", "")
                .replaceAll("\\;", "")
                .replaceAll("\\:", "")
                .replaceAll("--", "")
                .replaceAll("\\'", "");
                //.replaceAll("\\-", "");

        String[] words = cleanedText.split(" ");

        //------------1.7. Count them and arrange in alphabetic order. ------\\

        /*
         * @param distinctArray - array of separate words.
         *
         * @return - list of words from text in alphabetic order.
         */

        String distinctString = "";

        for (int i = 0; i < words.length; i++) {
            if (!distinctString.contains(words[i])){
                distinctString += words[i] + " ";
            }
        }

        String [] distinctArray = distinctString.split(" ");

        Arrays.sort(distinctArray);

        for (int i = 0; i < distinctArray.length; i++) {
            System.out.println(distinctArray[i]);
        }

           //--------- 1.2. For each distinct word in the text calculate -\\
          //---------- the number of occurrence. --------------------------\\
         //----------- 1.4. Sort in the DESC mode by -----------------------\\
        //------------ the number of occurrence. ----------------------------\\

        /*
         * @param Map<String, Long> result - map, what used for sorting words
         *                                from text by the number of occurrence.
         *
         * @return - map of words and number of occurrence, sorted from most
         *           frequent to less frequent.
         */

        Map<String, Long> result = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.<String>identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                //.limit(20)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l,r) -> l,
                        LinkedHashMap::new));

        System.out.println(result);

        //------------ 1.5. Find the first 20 pairs. ------------------------\\

        /*
         * @param Map<String, Long> result1 - sorting first 20 words from text
         *                                   by the number of occurrence.
         *
         * @return - map of first 20 words and number of occurrence, sorted
         *           from most frequent to less frequent.
         */

        Map<String, Long> result1 = Arrays.stream(words)
                //.map((key) -> key + toUpperCase(0) + result.get(key))
                .collect(Collectors.groupingBy(Function.<String>identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                .limit(20)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l,r) -> l,
                        LinkedHashMap::new));

        System.out.println(result1);

         //----------- 1.8. First 20 pairs and names write -----------------\\
        //------------ into to a file test.txt. -----------------------------\\

        /*
         * @param firstTwenty - summary first most frequent 20 words
         *                      with number of occurrence.
         *
         * @return - separate txt-format file, which includes first most
         *           frequent 20 words with number of occurrence.
         */

        String firstTwenty = result1.toString();

        Path path = Paths.get("C:/Users/Home/Desktop/subHarry1.txt");
        Files.write(path, Collections.singleton(firstTwenty));

        /*
         * @param content - header for this program.
         *
         * @return - separate txt-format header file.
         */

        //------------ 1.9. Create a fine header for the file. --------------\\

        try {

            String content = "This is the HEADER of the file\n"
                    + result1.toString();

            File f = new File("C:/Users/Home/Desktop/header.txt");

            FileWriter fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
