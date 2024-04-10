package com.mycompany.labexer6a;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class LabExer6A {

    Scanner type = new Scanner(System.in);

    public LabExer6A() {
        
        String filename = "d:\\word.txt";
        Path path = Paths.get(filename.toString());
        String temparr[] = new String[100];
        String newarr[];
        Random rand = new Random();

        String hideword, displayword;
        int counter = 0;

        try {
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String word = null;

            while ((word = reader.readLine()) != null) {
                temparr[counter] = word;
                ++counter;
            }
            newarr = new String[counter];
            newarr = Arrays.copyOf(temparr, counter);

            hideword = newarr[rand.nextInt(counter)];
            displayword = hideword.replaceAll("[a-zA-Z]", "?");

           
            if (displayword.length() < 3) {
                displayword = hideword.substring(0, 2) + displayword.substring(2);
            }

            boolean isTrue = true;
            boolean found = false;

            do {
                System.out.println(displayword);

                System.out.print("Enter word or letter: ");
                String guess = type.nextLine();

                if (guess.length() > 1) {
                    if (guess.equalsIgnoreCase(hideword)) {
                        System.out.println("Congrats you are correct!");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Nice try!");
                    
                    //wag gagalawin teka
                    for (int x = 0; x < hideword.length(); x++) {
                        if (guess.equalsIgnoreCase(String.valueOf(hideword.charAt(x)))) {
                            displayword = displayword.substring(0, x) + guess + displayword.substring(x + 1);
                            found = true;
                        }
                    }
                }

                if (found == true) {
                    System.out.println(guess.toUpperCase() + " letter is found!");
                } else {
                    System.out.println(guess.toUpperCase() + " letter is unknown!");
                }

            } while (isTrue);

        } catch (IOException ex) {
            
        }
    }

    public static void main(String[] args) {
        new LabExer6A();
    }
}


