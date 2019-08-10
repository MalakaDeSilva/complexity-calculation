/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blitz
 */
public class Utilities {

    public static int showHierarchy(Class<?> c) {
        Class[] clss;
        Class iClass;
        int count = 0; //No of times inherited
        ArrayList<Class<?>> list = new ArrayList<>();

        iClass = c; //Preserve to get the Interfaces count

        while (c != null) {
            count++;
            list.add(0, c); // add to front
            c = c.getSuperclass();
        }

        System.out.println("Inherited Classes : \n");
        list.forEach((cls) -> {
            System.out.println("Class " + cls.getName());
        });

        clss = iClass.getInterfaces();
        System.out.println("\n\nInherited Interfaces : \n");

        for (int i = 0; clss.length > i; i++) {
            count++;
            System.out.println(clss[i]);
        }

        return count;
    }

    public static ArrayList<String> getClassNames(BufferedReader buffR) {
        String currentLine;
        String[] words, tempWords;
        ArrayList<String> tempClassList = new ArrayList<>();
        int iter;
        
        try {
            while ((currentLine = buffR.readLine()) != null) {
                iter = 0;
                words = currentLine.split(" ");

                for (String currentWord : words) {
                    if (currentWord.equalsIgnoreCase("new")) {
                        tempWords = words[iter + 1].split("[(<]");

                        tempClassList.add(tempWords[0]);
                    }

                    iter++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Complexity_calculation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tempClassList;
    }
}
