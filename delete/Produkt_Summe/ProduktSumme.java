
/**
 * Beschreiben Sie hier die Klasse ProduktSumme.
 * 
 * @author Jonah Sebright    
 * @version Version 26.9.2019
 */

import javax.swing.JOptionPane;
public class ProduktSumme
{
   
    public static void main(int[] nums){
            
        if(nums.length < 2){
            JOptionPane.showMessageDialog (null,//parent window
            "Sie müsen mindstens zwei Zahlen eingeben", //message
            "Error",//Title
             JOptionPane.ERROR_MESSAGE); //typ
           
        }else{
            int i = nums[0];
            int j = nums[1];
             System.out.format("Erste Zahl = %d \t Zweite Zahl = %d \n" 
             + "Die Summe betraegt %d \t Das Produkt betraegt %d ",
             i, j, i+j, i*j); 
            
        }
    
    
    }
}
