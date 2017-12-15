/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        //ArrayList Al = new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/emendez/Desktop/Orders.txt")))
        {
            try(PrintWriter input = new PrintWriter(new BufferedWriter(new FileWriter("/Users/emendez/Desktop/OrdersProcessed.txt")))){
            System.out.println("Processing has started...");
           br.readLine();
            String Line = br.readLine();
            
            while(Line != null)
            {
               
               //variables that make up all the objects and splits the bars
              String[] items = Line.split("\\|");
               String OrderID = items[0];
               String partNum = items[1];
               double Price = Double.parseDouble(items[2]);
              double Quantity = Double.parseDouble(items[3]) ;
               double subtotal = Price*Quantity;
               double t = Tax_Rate()*subtotal;
               double s = Shipping()*subtotal;
                double total = subtotal + s + t;
               //Prints all the values 
               System.out.println("Order ID: "+ OrderID);
               System.out.println("Part Num: "+partNum);
               System.out.println("Price: "+ Price);
               System.out.println("Quantity: "+ Quantity);
               System.out.println("Shipping: "+s);
                System.out.println("Tax " + t);
               System.out.println("Total: "+total);
                System.out.println("-------------------------------");
                
               
               
               input.println("Order ID: "+OrderID);
               input.println("Part Num: "+partNum);
               input.println("Price: "+Price);
               input.println("Quantity: "+Quantity);
               input.println("Shipping: "+s);
               input.println("Tax: "+t);
               input.println("Total: "+total);
               input.println("----------------------------");
               Line = br.readLine();
            }
           input.close();
           
            }
            catch(IOException ioe){
                
            }
            br.close();
        }
        //catches any exception
        catch(IOException ioe)
        {
            System.out.println("ERROR");
        }
          catch(NullPointerException npe){
              System.out.println("ERROR");
          }  
        catch(ArrayIndexOutOfBoundsException obe){
            
        }
        
        //gives the tax rate
    }
    private static double Tax_Rate(){
        final double TAX_RATE = .02;
        return TAX_RATE;
   }
    //gives the shipping
    private static double Shipping(){
        final double SHIPPING = .05;
        return SHIPPING;
    }
}
