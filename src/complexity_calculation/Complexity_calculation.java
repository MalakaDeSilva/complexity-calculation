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
        int builtInComp =0;
        int userDefComp=0;
        String currentLine;
        String[] keywords;
        Files.setFilePath(args[0]);
        
        HashMap<String, Integer> builtInClassses = Utilities.getBuiltInClassses();
        HashMap<String, Integer> userDefinedClasses = Utilities.getUserDefClasses();

        buffR = Files.loadFile();
        
        try {
            while((currentLine = buffR.readLine()) != null){
                keywords = currentLine.split("[ <(;]");
                for(String keyword : keywords){
                    builtInComp = Utilities.getComplexity(builtInClassses, keyword);
                    userDefComp = Utilities.getComplexity(userDefinedClasses, keyword);
                    
                    if(builtInComp > 0){
                        System.out.println(currentLine+"\t -> \t"+builtInComp);
                    }

                    if(userDefComp > 0){
                        System.out.println(currentLine+"\t -> \t"+userDefComp);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Complexity_calculation.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Files.unloadFile();
        }
    }
}
