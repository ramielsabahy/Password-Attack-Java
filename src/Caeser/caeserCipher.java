/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caeser;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.HashMap;

/**
 *
 * @author RAMI
 *
 * 12/10/2016
 *
 * المشكله دلوقتى انه بيبص على اول حرف و آخر حرف بس واللى فى النص حتى لو غلط
 * طالما الاول و الاخير صح مش هيقول انهم غلط المشكله ممكن تتحل بس انا مش فاضى
 *
 */
public class caeserCipher {

    public static void main(String[] args) {
        HashMap<Integer, String> plainIndex;
        ArrayList<Character> inputCahrs = new ArrayList<>();
        ArrayList<Integer> inputCharIndexes = new ArrayList<>();
        plainIndex = new HashMap<>();
        int flag = 0;
        int lastFlag = 0;
        int customAlphaLength = 0;
        String customAlpha = null;
        HashMap<Integer, String> cipherIndex;
        cipherIndex = new HashMap<>();
        int sub = 0;
        Letters_Array letters = new Letters_Array();

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
        int[] a = new int[100];
        ArrayList<Integer> plainInt = new ArrayList();
        ArrayList<Integer> cipherInt = new ArrayList();
        if (choice.equals("1")) {
            try {
                plain = JOptionPane.showInputDialog("Enter The Plain Text : ");
                Cipher = JOptionPane.showInputDialog("Enter The Cipher : ");
                for (int count = 0; count < plain.length(); count++) {
                    plainIndex.put(count, plain.substring(count, count + 1));
                    cipherIndex.put(count, Cipher.substring(count, count + 1));
                }
                /*for (int count = 0; count < Cipher.length(); count++) {
                    cipherIndex.put(count, Cipher.substring(count, count + 1));
                }*/
                for (int count = 0; count < plain.length(); count++) {
                    indexpl.add(count, plain.charAt(count));
                    indexci.add(count, Cipher.charAt(count));
                }
                for (int count = 0; count < plain.length(); count++) {
                    plainToGet.add(indexpl.get(count));
                    cipherToGet.add(indexci.get(count));

                    plainSample.add(indexpl.get(count));
                    cipherSample.add(indexci.get(count));
                }
                for(int count = 0 ; count < plain.length() ; count++){
                    plainInt.add(letters.check((char) plainSample.get(count)));
                    cipherInt.add(letters.check((char) cipherSample.get(count)));
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Try and catch must be placed here
            try {
                customAlphaLength = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of Chars in your Alpha "));
                customAlpha = JOptionPane.showInputDialog("Enter the chars in your Alpha ");
                plain = JOptionPane.showInputDialog("Enter The Plain Text : ");
                Cipher = JOptionPane.showInputDialog("Enter The Cipher : ");
                //letters.clear();
                for (int count = 0; count < customAlphaLength; count++) {

                    letters.set(customAlpha.charAt(count), count);
                }

                for (int count = 0; count < customAlphaLength; count++) {

                    inputCahrs.add(customAlpha.charAt(count));
                }

                for (int count = 0; count < customAlpha.length(); count++) {
                    inputCharIndexes.add(letters.get(inputCahrs.get(count)));
                }
                for (int count = 0; count < plain.length(); count++) {
                    plainIndex.put(count, plain.substring(count, count + 1));
                    cipherIndex.put(count, Cipher.substring(count, count + 1));
                }
                /*for (int count = 0; count < Cipher.length(); count++) {
                    cipherIndex.put(count, Cipher.substring(count, count + 1));
                }*/
                for (int count = 0; count < plain.length(); count++) {
                    indexpl.add(count, plain.charAt(count));
                    indexci.add(count, Cipher.charAt(count));
                }
                for (int count = 0; count < plain.length(); count++) {
                    plainToGet.add(indexpl.get(count));
                    cipherToGet.add(indexci.get(count));

                    plainSample.add(indexpl.get(count));
                    cipherSample.add(indexci.get(count));

                    plainInt.add(letters.get((char) plainSample.get(count)));
                    cipherInt.add(letters.get((char) cipherSample.get(count)));
                }
                System.out.println(inputCharIndexes);
            } catch (NullPointerException e) {
                //System.out.println(e.getMessage());
            }
        }

        //Array Lists To read The Encrypted and Plain Texts after being numbers
        ArrayList<Integer> readPlain = new ArrayList();
        ArrayList<Integer> readCipher = new ArrayList();
        for (int count = 0; count < indexpl.size(); count++) {
            readPlain.add(plainInt.get(count));
            readCipher.add(cipherInt.get(count));

            if (readPlain.get(count) < 0 || readCipher.get(count) < 0) {
                readCipher.set(count, readCipher.get(count) + 27);
                readPlain.set(count, readPlain.get(count) + 27);
                System.out.println("less than zero");
            }

        }
        for (int count = 0; count < indexpl.size(); count++) {
            sub = readCipher.get(0) - readPlain.get(0);
            if (readCipher.get(count) - readPlain.get(count) == sub) {
                //System.out.println(readPlain.get(count)-readCipher.get(count));
                flag = 1;
            } else {
                flag = 0;
            }
            lastFlag = flag;
        }

            if (sub < 0) {
                sub = sub + 27;
            }
            System.out.println(plainInt.get(0));
            JOptionPane.showMessageDialog(null, "The Key used to Encrypt is : " + sub);
         

    }
    /*
        String indexPlain = plainIndex.get(0);
        int plainSample1 = letters.check(indexPlain);
        
        String indexPlain2 = plainIndex.get(1);
        int plainSample2 = letters.check(indexPlain2);
        
        String cipherPlain = cipherIndex.get(0);
        int cipherSample1 = letters.check(cipherPlain);
        
        String cipherPlain2 = cipherIndex.get(1);
        int cipherSample2 = letters.check(cipherPlain2);
        
        int diff = cipherSample1 - plainSample1;
        int diff2 = cipherSample2 - plainSample2;
        if(diff<0||diff2<0){
            diff+=27;
            diff2+=27;
        }
        if(diff==diff2){
            JOptionPane.showMessageDialog(null, "The Key used to Encrypt is : "+diff);
        }else{
            JOptionPane.showMessageDialog(null, "Cipher and Plain didn't match,Please check them");
        }
     */

}
