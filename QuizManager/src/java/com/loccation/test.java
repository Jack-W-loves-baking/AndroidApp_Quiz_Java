/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loccation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jack1
 */
public class test {
    
    
    
    public static void main(String[] args) {
        
        int sum =0;
        ArrayList <Integer> arr = new ArrayList <>();
         
        System.out.println("how many numbers you want to input");
        
        Scanner s = new Scanner (System.in);
        
        int num =s.nextInt();
        System.out.println("please input now");
        int tem = 0;
        for (int k =0;k<num;k++){
         tem = s.nextInt();
         arr.add(tem);
        }
        
        System.out.println("what is the total?");
        sum = s.nextInt();
        
       
        
        System.out.println(run (arr,sum));
    }
    
    
    static boolean run(ArrayList<Integer> arr, int k){
        boolean result =false;
        
        for (int ele: arr){
            int res = k-ele;
            if (arr.contains(res)){
                result = true;
            }
    }
        
        return result;
    }
    
}
     