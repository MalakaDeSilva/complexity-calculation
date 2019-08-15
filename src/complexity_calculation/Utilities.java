/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

import constants.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blitz
 */
public class Utilities {
    
    private String parentClass;
    private String childClass;
    
    public String getParentClass() {
        return parentClass;
    }
    
    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }
    
    public String getChildClass() {
        return childClass;
    }
    
    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }
    
    public void identifyParent() {
        BufferedReader buffR = Files.loadFile();
        String currentLine;
        String[] words;
        String parent = null;
        int index;
        
        try {
            while ((currentLine = buffR.readLine()) != null) {
                words = currentLine.split("[ {}]");
                
                if (currentLine.contains(Constants.EXTENDS)) {
                    for (String word : words) {
                        if (word.equals(Constants.EXTENDS)) {
                            index = Arrays.asList(words).indexOf(Constants.EXTENDS);
                            parent = words[index + 1];
                        }
                    }
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        } finally {
            Files.unloadFile();
        }
        
        this.setParentClass(parent);
    }
    
    public void identifyChild() {
        BufferedReader buffR = Files.loadFile();
        String currentLine;
        String[] words;
        String child = null;
        int index;
        
        try {
            while ((currentLine = buffR.readLine()) != null) {
                words = currentLine.split("[ {}]");
                
                if (currentLine.contains(Constants.EXTENDS)) {
                    for (String word : words) {
                        if (word.equals(Constants.CLASS)) {
                            index = Arrays.asList(words).indexOf(word);
                            child = words[index + 1];
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        this.setChildClass(child);
    }
    
    public String setFilePath(String className) {
        String currentPath = Files.getFilePath();
        String words[];
        String newPath = new String();
        
        words = currentPath.split("/");
        
        for (String word : words) {
            if (!word.contains(Constants.JAVA_EXT)) {
                newPath = newPath.concat(word + "/");
            } else {
                identifyParent();
                newPath = newPath.concat(this.getParentClass() + ".java");
            }
        }
        
        return newPath;
    }
    
    public void getComplexity() {
        
    }
    
}
