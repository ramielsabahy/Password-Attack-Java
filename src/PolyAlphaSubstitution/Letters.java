/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolyAlphaSubstitution;

import java.util.HashMap;

/**
 *
 * @author RAMI
 */
public class Letters {
    
    public HashMap<Character, Integer> poly = new HashMap<>();
    public HashMap<Integer, Character> intAsKeyForChar = new HashMap<>();
    public void setCharAsKey(char s , int a){
        poly.put(s, a);
    }
    public int getCharAsKey(char s){
        
        return poly.get(s);
    }
    public void setIntAsKeyForChar(char s , int a){
        intAsKeyForChar.put(a, s);
    }
    public char getIntAsKeyForChar(int a){
        return intAsKeyForChar.get(a);
    }
    
}
