/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

/**
 *
 * @author blitz
 */
public class Complexity_calculation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Files.setFilePath(args[0]);
        Utilities util = new Utilities();
        
        util.identifyParent();
        
        System.out.println(util.getParentClass());
    }
}
