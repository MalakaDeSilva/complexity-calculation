/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexity_calculation;

import java.util.ArrayList;

/**
 *
 * @author blitz
 */
public class Super {

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
            System.out.println("Class " +cls.getName());
        });

        clss = iClass.getInterfaces();
        System.out.println("\n\nInherited Interfaces : \n");
        
        for (int i = 0; clss.length > i; i++) {
            count++;
            System.out.println(clss[i]);
        }

        return count;
    }
}
