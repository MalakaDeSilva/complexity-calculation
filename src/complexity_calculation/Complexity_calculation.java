/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author blitz
 */
public class Complexity_calculation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader buffR;
        String currentLine;
        String[] words;
        HashMap<Integer, String> map = new HashMap<>();
        int iter;
        
        Files.setFilePath(args[0]);
        buffR = Files.loadFile();

        try {
            while ((currentLine = buffR.readLine()) != null) {
                //System.out.println(currentLine);
                iter = 0;
                
                words = currentLine.split(" ");
                
                for(String currentWord : words){
                    //System.out.println(words[0]);
                    if(currentWord.equalsIgnoreCase("new")){
                        System.out.println("new "+iter);
                    }
                    iter++;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Complexity_calculation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
