package hillCipher;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author RAMI
 */
public class Hill {

    static String alpha , plain , cipher ;
    static HashMap<Character, Integer> lettersArray = new HashMap<>();
    static HashMap<Integer , Character> giveIntTakeChar = new HashMap<>();
    static int cipherIntegers [],cipherIntegers1[],cipherIntegers2[];
    static int plainIntegers [],plainIntegers1[],plainIntegers2[];
    public static void main(String[] args) {
        alpha = JOptionPane.showInputDialog("Enter your Alpha : ");
        plain = JOptionPane.showInputDialog("Enter your Plain Text : ");
        cipher = JOptionPane.showInputDialog("Enter your Cipher : ");
        //Decide which Matrix to use ! 2x2 or 3x3 depending on the length of the cipher
        if(cipher.length()%4==0){
            System.out.println("=========================== 2x2 Mtrix will be used =============================");
            cipherIntegers = new int [4];
            plainIntegers = new int [4];
        }else if(cipher.length()%6==0){
            System.out.println("=========================== 3x3 Mtrix will be used =============================");
            cipherIntegers = new int [6];
            plainIntegers = new int [6];
        }
        for(int counter = 0 ; counter < alpha.length();counter++){
            lettersArray.put(alpha.charAt(counter), counter);
            giveIntTakeChar.put(counter, alpha.charAt(counter));
        }
        //loop to put the values for the cipher characters in the array
        int inr = 0;
        for(int counter = 0 ; counter < cipher.length() ; counter++){
            cipherIntegers[counter]=lettersArray.get(cipher.charAt(counter));
            
            if(counter<plain.length()){
                plainIntegers[counter]=lettersArray.get(plain.charAt(counter));
                
            }else{
                plainIntegers[counter]=lettersArray.get(giveIntTakeChar.get(inr));
                inr++;
            }
        }
        // loop just to test check the cipherIntegers Array anf whether the indexes were well assigned or not
        /*for(int counter = 0 ; counter<cipherIntegers.length ; counter++){
            System.out.println(cipherIntegers[counter]);
        }*/
        
        int [][]key = new int [3][3];
        for (int[] x1 : key) {
            for (int inner = 0; inner <key.length; inner++) {
                x1[inner] = 1;
            }
        }
        /*for (int[] x1 : x) {
            for (int inner = 0; inner < x.length; inner++) {
                System.out.print(x1[inner]);
            }
            System.out.println("");
        }*/
        
        // لحد هنا كل حاجه شغاله تمام عشان لو حصل اى غلط :)
        plainIntegers1 = new int [3];
        plainIntegers2 = new int [3];
        cipherIntegers1 = new int [3];
        cipherIntegers2 = new int [3];
        plainIntegers1[0]=plainIntegers[0];
        plainIntegers1[1]=plainIntegers[1];
        plainIntegers1[2]=plainIntegers[2];
        plainIntegers2[0]=plainIntegers[3];
        plainIntegers2[1]=plainIntegers[4];
        plainIntegers2[2]=plainIntegers[5];
        
        cipherIntegers1[0]=cipherIntegers[0];
        cipherIntegers1[1]=cipherIntegers[1];
        cipherIntegers1[2]=cipherIntegers[2];
        cipherIntegers2[0]=cipherIntegers[3];
        cipherIntegers2[1]=cipherIntegers[4];
        cipherIntegers2[2]=cipherIntegers[5];
        int sum []= {0,0,0};
        for (int counter = 0 ; counter <key.length;counter++){
            for(int inner = key.length-1 ; inner >-1 ; inner--){
                sum[counter] = sum[counter] + key[counter][inner]*plainIntegers1[inner];
                
            }
            
            for(int in = key.length-1 ; in >-1 ; in--){
                if(sum[counter]%26==cipherIntegers1[counter]){
                    System.out.println("done !!");
                }else{
                    //System.out.println("===1>"+key[counter][in]);
                    key[counter][in]=key[counter][in]+1;
                    //System.out.println("===2>"+key[counter][in]);
                }
            }
        }
        for(int i = 0 ; i <key.length ; i++){
            System.out.println(sum[i]);
        }
        
    }
    
}
