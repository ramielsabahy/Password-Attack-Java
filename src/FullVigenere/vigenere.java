/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FullVigenere;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author RAMI
 */
public class vigenere {

    public static void main(String[] args) {
        String cipher;
        HashMap<Character , HashMap<Character , Character>> keys = new HashMap<>();
        HashMap<Character , Character> inner = new HashMap<>();
        HashMap<Character , Integer> plainIndex = new HashMap<>();
        HashMap<Character , Integer> cipherIndex= new HashMap<>();
        ArrayList<Integer> unifiedPlainIndex = new ArrayList<>();
        ArrayList<Integer> unifiedCipherIndex = new ArrayList<>();
        char finalResult ;
        String plain;
        char key [] = new char [10];
        String customAlpha;
        char[][] alphaMatrix;
        int valueToAddToMakeArray = 0;
        customAlpha = JOptionPane.showInputDialog("Enter Your Custom Alpha : ");
        plain = JOptionPane.showInputDialog("Enter the Plain Text : ");
        cipher = JOptionPane.showInputDialog("Enter the Cipher : ");
        alphaMatrix = new char[customAlpha.length()][customAlpha.length()];
        for(int count = 0 ; count <customAlpha.length() ; count++){
            key[count] = customAlpha.charAt(count);
            valueToAddToMakeArray=0;
            for(int innerCount = 0 ; innerCount<customAlpha.length() ; innerCount++){
                int sum = innerCount+count;
                if(sum >alphaMatrix.length-1){
                    sum = 0+valueToAddToMakeArray;
                    alphaMatrix[count][innerCount]=customAlpha.charAt(sum);
                    valueToAddToMakeArray++;
                }else{
                alphaMatrix[count][innerCount]=customAlpha.charAt(sum);
                }
                
            }
           
            
        }
        for(int count =0 ; count<customAlpha.length();count++){
            for(int innerC = 0 ; innerC<plain.length();innerC++){
                if(key[count]==plain.charAt(innerC)){
                unifiedPlainIndex.add(count);
                
                
                //System.out.println(count);
            }
             Collections.sort(unifiedPlainIndex);
            }
        }
        //finalResult +=
        for (char[] alphaMatrix1 : alphaMatrix) {
            for (int a = 0; a<alphaMatrix.length; a++) {
                System.out.print(alphaMatrix1[a]);
            }
            System.out.println("");
        }
        for(int count =0 ; count<plain.length();count++){
            
            int start = 0;
            if(start > plain.length()){
                break;
            }
            for(int a = 0 ; a<plain.length();a++){
                
            if(plain.charAt(start)==alphaMatrix[count][a]){
                    plainIndex.put(alphaMatrix[count][a], count);
                }
            start++;
            }
        }
        for(int count = 0 ; count < key.length ; count++){
            
                plainIndex.put(key[count],count);
            }
        // دلوقتى انا عايز الف على السايفر حرف حرف و اشوفه
        
        for(int count = 0 ; count < customAlpha.length() ; count++){
            for(int in = 0 ; in<customAlpha.length() ; in++){
            if(count<plain.length()&&in<plain.length()){
            if(cipher.charAt(in)==alphaMatrix[in][unifiedPlainIndex.get(count)]){
                System.out.println(alphaMatrix[in][count]);
            }
            }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        System.out.println(plainIndex+" "+unifiedPlainIndex);
    }

}
