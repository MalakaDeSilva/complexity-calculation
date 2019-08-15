/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blitz
 */
public class Utilities {

    public static int hierarchy(Class<?> c) {
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

        clss = iClass.getInterfaces();
        for (int i = 0; clss.length > i; i++) {
            count++;
        }
        return count;
    }

    public static HashMap<String, Integer> getUserDefClasses() {
        String currentLine, className;
        String packageName = null;
        BufferedReader buffR;
        String[] words, tempWords;
        HashMap<String, Integer> map = new HashMap<>();
        int iter;

        buffR = Files.loadFile();

        try {
            while ((currentLine = buffR.readLine()) != null) {
                iter = 0;
                words = currentLine.split(" ");

                for (String currentWord : words) {
                    if (currentWord.equals("package")) {
                        tempWords = words[1].split(";");
                        packageName = tempWords[0];
                    } else if (currentWord.equalsIgnoreCase("new")) {
                        tempWords = words[iter + 1].split("[(<]");
                        if (!keywordExist(getBuiltInClassses(), tempWords[0])) {
                            System.out.println(packageName + "." + tempWords[0]);
                            className = packageName + "." + tempWords[0];

                            map.put(className, hierarchy(Class.forName(className)));
                        }
                    }

                    iter++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Complexity_calculation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Files.unloadFile();
        }

        return map;
    }

    public static HashMap<String, Integer> getBuiltInClassses() {
        BufferedReader buffR;
        String currentLine;
        String[] words;
        HashMap<String, Integer> map = new HashMap<>();
        buffR = Files.loadFile();

        try {
            while ((currentLine = buffR.readLine()) != null) {

                words = currentLine.split("[ ;]");

                for (String word : words) {
                    if (words[0].equals("import") && !word.equals("import")) {
                        map.put(word, hierarchy(Class.forName(word)));
                    }
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Files.unloadFile();
        }
        //return
        return map;
    }

    public static int getComplexity(HashMap<String, Integer> map, String word) {
        Set<String> set = map.keySet();
        String[] keywords = set.toArray(new String[set.size()]);
        String[] classPath;

        for (String str : keywords) {
            classPath = str.split("\\.");
            if (word.equals(classPath[classPath.length - 1])) {
                return map.get(str);
            }
        }
        return 0;
    }

    private static boolean keywordExist(HashMap<String, Integer> map, String word) {
        Set<String> set = map.keySet();
        String[] keywords = set.toArray(new String[set.size()]);
        String[] classPath;

        for (String str : keywords) {
            classPath = str.split("\\.");

            if(word.equals(classPath[classPath.length-1])){
                return true;
            }
        }
        
        return false;
    }
}
