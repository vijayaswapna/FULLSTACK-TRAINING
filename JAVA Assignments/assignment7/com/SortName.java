package com;

import java.util.*;

public class DemoTest {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter number of names");
      int n=sc.nextInt();
      String[] s=new String[n];
      System.out.println("Enter the Names");
      for(int i=0;i<n;i++) {
         s[i]=sc.next();
      }
      Arrays.sort(s);
      Arrays.sort(s, String.CASE_INSENSITIVE_ORDER);
      System.out.println("CASE INSENSITIVE ASC ORDER : ");
      System.out.println(Arrays.toString(s));

      for(int i = 0; i<s.length-1; i++){  
         for (int j = i+1; j<s.length; j++){   
            if(s[j].compareTo(s[i])>0){   
               String temp = s[i];  
               s[i] = s[j];  
               s[j] = temp;  
            }  
         }  
      }
      System.out.println("CASE INSENSITIVE DESC ORDER : ");
      for(String a:s){
         System.out.println(a);
      }
   }
} 