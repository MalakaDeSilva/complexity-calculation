/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

import java.io.BufferedReader;
import java.util.ArrayList;

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
        ArrayList<String> tempClassList;
        ArrayList<String> classList;

        Files.setFilePath(args[0]);
        buffR = Files.loadFile();

        tempClassList = Utilities.getClassNames(buffR);
        
        Files.unloadFile();
        
        classList = Files.removeDuplVals(tempClassList);
        
        classList.forEach((name) -> {
            System.out.println(name);
        });
    }
}
