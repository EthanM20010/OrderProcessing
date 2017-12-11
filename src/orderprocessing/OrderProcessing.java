/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author emendez
 */
public class OrderProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList Al = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/emendez/Desktop/Orders.txt")))
        {
            StringBuilder fileContents = new StringBuilder();
            String Line = br.readLine();
            
            while(Line != null)
            {
               fileContents.append(Line);
               fileContents.append(System.lineSeparator());
               Line = br.readLine();
               Al.add(Line);
            }
            String fileComplete = fileContents.toString();
            System.out.println(fileComplete);
        }
        
        catch(IOException ioe)
        {
            System.out.println("ERROR");
        }
               
    }
    
}
