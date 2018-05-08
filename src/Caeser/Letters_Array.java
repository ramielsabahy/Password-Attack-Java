/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caeser;

import java.util.HashMap;

/**
 *
 * @author RAMI
 */
public class Letters_Array {

        public HashMap<Character, Integer> dicCodeToIndex = new HashMap<Character, Integer>();
        public HashMap<Integer, Character> indexToChar = new HashMap<Integer,Character>();
        
    public void set(char s , int a){
        //dicCodeToIndex.remove(s, a);
        Letters_Array l = new Letters_Array();
        for(int count=0 ; count<53;count++){
            dicCodeToIndex.remove(l.poly(count));
        }
        dicCodeToIndex.put(s, a);
    }
    public void clear(){
        dicCodeToIndex.clear();
    }
    public void clearPoly(){
        indexToChar.clear();
    }
    public int get(char s){
        return dicCodeToIndex.get(s);
    }
    public char getPoly(int s){
        return indexToChar.get(s);
    }
    public void setPoly(char s , int a){
        indexToChar.replace(a, s);
        
    }
    
    public int check(char s) {
// valuating
        dicCodeToIndex.put(' ', 0);
        dicCodeToIndex.put('a', 1);
        dicCodeToIndex.put('b', 2);
        dicCodeToIndex.put('c', 3);
        dicCodeToIndex.put('d', 4);
        dicCodeToIndex.put('e', 5);
        dicCodeToIndex.put('f', 6);
        dicCodeToIndex.put('g', 7);
        dicCodeToIndex.put('h', 8);
        dicCodeToIndex.put('i', 9);
        dicCodeToIndex.put('k', 11);
        dicCodeToIndex.put('l', 12);
        dicCodeToIndex.put('m', 13);
        dicCodeToIndex.put('n', 14);
        dicCodeToIndex.put('o', 15);
        dicCodeToIndex.put('p', 16);
        dicCodeToIndex.put('q', 17);
        dicCodeToIndex.put('r', 18);
        dicCodeToIndex.put('s', 19);
        dicCodeToIndex.put('t', 20);
        dicCodeToIndex.put('u', 21);
        dicCodeToIndex.put('v', 22);
        dicCodeToIndex.put('w', 23);
        dicCodeToIndex.put('x', 24);
        dicCodeToIndex.put('y', 25);
        dicCodeToIndex.put('z', 26);
        dicCodeToIndex.put('A', 27);
        dicCodeToIndex.put('B', 28);
        dicCodeToIndex.put('C', 29);
        dicCodeToIndex.put('D', 30);
        dicCodeToIndex.put('E', 31);
        dicCodeToIndex.put('F', 32);
        dicCodeToIndex.put('G', 33);
        dicCodeToIndex.put('H', 34);
        dicCodeToIndex.put('I', 35);
        dicCodeToIndex.put('J', 36);
        dicCodeToIndex.put('K', 37);
        dicCodeToIndex.put('L', 38);
        dicCodeToIndex.put('M', 39);
        dicCodeToIndex.put('N', 40);
        dicCodeToIndex.put('O', 41);
        dicCodeToIndex.put('P', 42);
        dicCodeToIndex.put('Q', 43);
        dicCodeToIndex.put('R', 44);
        dicCodeToIndex.put('S', 45);
        dicCodeToIndex.put('T', 46);
        dicCodeToIndex.put('U', 47);
        dicCodeToIndex.put('V', 48);
        dicCodeToIndex.put('W', 49);
        dicCodeToIndex.put('X', 50);
        dicCodeToIndex.put('Y', 51);
        dicCodeToIndex.put('Z', 52);
        return dicCodeToIndex.get(s);
    }
    public char poly(int s){
        indexToChar.put(0, ' ');
        indexToChar.put(1, 'a');
        indexToChar.put(2, 'b');
        indexToChar.put(3, 'c');
        indexToChar.put(4, 'd');
        indexToChar.put(5, 'e');
        indexToChar.put(6, 'f');
        indexToChar.put(7, 'g');
        indexToChar.put(8, 'h');
        indexToChar.put(9, 'i');
        indexToChar.put(10, 'j');
        indexToChar.put(11, 'k');
        indexToChar.put(12, 'l');
        indexToChar.put(13, 'm');
        indexToChar.put(14, 'n');
        indexToChar.put(15, 'o');
        indexToChar.put(16, 'p');
        indexToChar.put(17, 'q');
        indexToChar.put(18, 'r');
        indexToChar.put(19, 's');
        indexToChar.put(20, 't');
        indexToChar.put(21, 'u');
        indexToChar.put(22, 'v');
        indexToChar.put(23, 'w');
        indexToChar.put(24, 'x');
        indexToChar.put(25, 'y');
        indexToChar.put(26, 'z');
        indexToChar.put(27, 'A');
        indexToChar.put(28, 'B');
        indexToChar.put(29, 'C');
        indexToChar.put(30, 'D');
        indexToChar.put(31, 'E');
        indexToChar.put(32, 'F');
        indexToChar.put(33, 'G');
        indexToChar.put(34, 'H');
        indexToChar.put(35, 'I');
        indexToChar.put(36, 'J');
        indexToChar.put(37, 'K');
        indexToChar.put(38, 'L');
        indexToChar.put(39, 'M');
        indexToChar.put(40, 'N');
        indexToChar.put(41, 'O');
        indexToChar.put(42, 'P');
        indexToChar.put(43, 'Q');
        indexToChar.put(44, 'R');
        indexToChar.put(45, 'S');
        indexToChar.put(46, 'T');
        indexToChar.put(47, 'U');
        indexToChar.put(48, 'V');
        indexToChar.put(49, 'W');
        indexToChar.put(50, 'X');
        indexToChar.put(51, 'Y');
        indexToChar.put(52, 'Z');
        return indexToChar.get(s);
    }
}
