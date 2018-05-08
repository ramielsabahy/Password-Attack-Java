/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolyAlphaSubstitution;

import Caeser.Letters_Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author RAMI
 *
 * كدا ناقص انى اعمل لو الكلمه اللى عايز اشفرها اكبر من الشفره اخليه يزود حروف
 * الشفره تانى
 *
 */
public class PolyalphaSub {
    

    public static void main(String[] args) {
        Letters_Array letters = new Letters_Array();
        Letters polyLetters = new Letters();
        
        HashMap<Character, Integer> poly = new HashMap<>();
        HashMap<Integer, Character> intAsKeyForChar = new HashMap<>();
        
        
        String finalResult = "";
        int diffInLengthBetweenPlAndCi = 0;

        int [] su = new int [4];
        
        HashMap<Integer, String> plainIndex;
        ArrayList<Character> inputCahrs = new ArrayList<>();
        ArrayList<Integer> inputCharIndexes = new ArrayList<>();
        ArrayList<Integer> sumOfCipherAndPlain = new ArrayList();
        ArrayList<Character> charOfCipherAndPlain = new ArrayList<>();
        plainIndex = new HashMap<>();
        int flag = 0;
        int lastFlag = 0;
        int customAlphaLength = 0;
        String customAlpha = null;
        HashMap<Integer, String> cipherIndex;
        cipherIndex = new HashMap<>();
        int sub = 0;
        String choice = JOptionPane.showInputDialog("Enter 1 to Use normal Alphapet or any key to Enter Custom Alphapet ");
        String plain;
        String Cipher;
        // To Store each single Char in an index so that i can compare it with cipher
        ArrayList indexpl = new ArrayList();
        ArrayList indexci = new ArrayList();

        ArrayList plainToGet = new ArrayList();
        ArrayList cipherToGet = new ArrayList();

        ArrayList plainSample = new ArrayList();
        ArrayList cipherSample = new ArrayList();

        ArrayList<Integer> plainInt = new ArrayList();
        ArrayList<Integer> cipherInt = new ArrayList();
        if (choice.equals("1")) {
            plain = JOptionPane.showInputDialog("Enter The Plain Text : ");
            Cipher = JOptionPane.showInputDialog("Enter The Cipher : ");
            for (int count = 0; count < plain.length(); count++) {
                indexci.add(count, ' ');
                indexpl.add(count, ' ');
                sumOfCipherAndPlain.add(count, count);
            }
            for (int count = 0; count < plain.length(); count++) {
                indexpl.set(count, plain.charAt(count));
                indexci.set(count, Cipher.charAt(count));

                try {
                    sumOfCipherAndPlain.set(count, (letters.check((char) indexci.get(count)) - letters.check((char) indexpl.get(count))));

                    if (sumOfCipherAndPlain.get(count) < 0) {
                        sumOfCipherAndPlain.set(count, (sumOfCipherAndPlain.get(count) + 27));
                    }
                } catch (Exception e) {
                    System.out.println(sumOfCipherAndPlain.get(3) + " " + indexpl.get(3) + " " + indexci.get(3));
                }
            }
            /*diffInLengthBetweenPlAndCi = plain.length()-Cipher.length();
                if(diffInLengthBetweenPlAndCi>0){
                     indexci.add(Cipher.length(), Cipher.charAt(0));
                }*/
            try {
                for (int count = 0; count < sumOfCipherAndPlain.size(); count++) {
                    finalResult += letters.poly(sumOfCipherAndPlain.get(count));
                }
                //System.out.println(letters.check((char) indexci.get(3)) - letters.check((char) indexpl.get(3)));
                JOptionPane.showMessageDialog(null, "The key used in encryption is : " + finalResult);
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
            /*finally{
                System.out.println(sumOfCipherAndPlain);
            }*/
        } else {
            customAlphaLength = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of Chars in your Alpha "));
            customAlpha = JOptionPane.showInputDialog("Enter the chars in your Alpha Seperated by  ");
            plain = JOptionPane.showInputDialog("Enter The Plain Text : ");
            Cipher = JOptionPane.showInputDialog("Enter The Cipher : ");
            letters.clear();
            for(int count = 0 ; count <customAlphaLength ; count++){
                inputCahrs.add(' ');
            }
            for (int count = 0; count < plain.length(); count++) {
                indexpl.add(count, ' ');
                sumOfCipherAndPlain.add(count, count);
            }
            for(int count = 0 ; count<Cipher.length() ; count++){
                indexci.add(count, ' ');
                
            }
            for (int count = 0; count < plain.length(); count++) {
                indexpl.add(count, plain.charAt(count));
            }
            for (int count = 0; count < Cipher.length(); count++) {
                indexci.add(count, Cipher.charAt(count));
            }
            
            for (int count = 0; count < customAlphaLength; count++) {
                
                poly.put(customAlpha.charAt(count), count);
                intAsKeyForChar.put(count , customAlpha.charAt(count));
                inputCahrs.add(count,customAlpha.charAt(count));
                charOfCipherAndPlain.add(count, ' ');
            }
                /*letters.dicCodeToIndex.replace(customAlpha.charAt(count), count);
                letters.indexToChar.replace(count , customAlpha.charAt(count));
                
                *///System.out.println(letters.check(0));
                //System.out.println(inputCahrs);
                //inputCharIndexes.add(letters.getPoly(inputCahrs.get(count)));
                for(int count = 0 ; count < customAlphaLength ; count++){    
                if(count<plain.length()){
                    //sumOfCipherAndPlain.set(count , (poly.get(Cipher.charAt(count)) - poly.get(plain.charAt(count))));
                    sumOfCipherAndPlain.set(count,poly.get(Cipher.charAt(count)) - poly.get(plain.charAt(count)));
                    }else{
                        continue;
                    }
                    if (sumOfCipherAndPlain.get(count) < 0) {
                        sumOfCipherAndPlain.set(count,sumOfCipherAndPlain.get(count) + customAlpha.length());
                    }
                    charOfCipherAndPlain.set(count,intAsKeyForChar.get(sumOfCipherAndPlain.get(count)));
            }
            
            /*diffInLengthBetweenPlAndCi = plain.length()-Cipher.length();
                if(diffInLengthBetweenPlAndCi>0){
                     indexci.add(Cipher.length(), Cipher.charAt(0));
                }*/
            try {
                for (int count = 0; count < plain.length(); count++) {
                    finalResult += intAsKeyForChar.get(sumOfCipherAndPlain.get(count));
                    System.out.println(finalResult);
                    
                }
                //System.out.println(letters.check((char) indexci.get(3)) - letters.check((char) indexpl.get(3)));
                JOptionPane.showMessageDialog(null, "The key used in encryption is : " + finalResult);
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
           // letters.setPoly('#', 1);
//            System.out.println(customAlpha.charAt(0)+" "+customAlpha.charAt(1));
            //letters.clear();
            
           // letters.set('#', 1);
            System.out.println(intAsKeyForChar);
        }
    }
}
