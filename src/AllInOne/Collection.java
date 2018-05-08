package AllInOne;

import Caeser.Letters_Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author RAMI
 */
public class Collection {
    
    static Letters_Array l = new Letters_Array();
    static String plain,cipher,customAlpha;
    static HashMap<Character , Integer> convertCharToInteger = new HashMap<>();
    static HashMap<Integer , Character> convertIntegerToChar = new HashMap<>();
    
    public static void insertCustomAlpha(char mychar , int i){
        convertCharToInteger.put(mychar, i);
        convertIntegerToChar.put(i, mychar);
    }
    
    
    public static void main(String[] args) {
        ArrayList<Integer> poly = new ArrayList<>();
        
        customAlpha = JOptionPane.showInputDialog("Enter your Alpha : ");
        for(int counter = 0 ; counter<customAlpha.length();counter++){
            insertCustomAlpha(customAlpha.charAt(counter), counter);
            
        }
        plain = JOptionPane.showInputDialog("Enter the Plain : ");
        cipher = JOptionPane.showInputDialog("Enter the Cipher :");
        int pl1 = l.check(plain.charAt(0));
        int pl2 = l.check(plain.charAt(1));
        int ci1 = l.check(cipher.charAt(0));
        int ci2 = l.check(cipher.charAt(1));
        int res1IfCaeser = ci1-pl1;
        int res2IfCaeser = ci2-pl2;
        
        int res1IfPoly = ci1-pl1;
        int res2IfPoly = ci2-pl2;
        
        if(res1IfCaeser <0){
            res1IfCaeser = res1IfCaeser+customAlpha.length();
        }
        if(res2IfCaeser <0){
            res2IfCaeser = res2IfCaeser+customAlpha.length();
        }
        if(res1IfCaeser == res2IfCaeser){
            System.out.println("Key used in Encryption is : "+res1IfCaeser);
        }
        else if(res1IfCaeser != res2IfCaeser){
            for(int counter = 0 ; counter < plain.length() ; counter++){
                int pl = convertCharToInteger.get(plain.charAt(counter));
                int ci = convertCharToInteger.get(cipher.charAt(counter));
                int diff = ci-pl;
                if(diff < 0){
                    diff = diff+customAlpha.length();
                }
                poly.add(diff);
            }
            for(int counter = 0 ; counter < plain.length() ; counter++){
                System.out.print(convertIntegerToChar.get(poly.get(counter)));
            }
        }
        else if(res1IfCaeser != res2IfCaeser){
            FullVigenere.vigenere.main(args);
        }
    }
    
}
