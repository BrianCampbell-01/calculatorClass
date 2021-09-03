/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m_three.calculator;

import java.util.Vector;

/**
 *
 * @author Brian
 */
public class Calculator {
    
    private Vector<Integer> integerValues = new Vector(); 
    private Vector<String> opperands = new Vector();
    int sum = 0;
    
    public void readInput(String userEquation)
    {
        String oppDelims = "[ + = * / - ]+";
        String intDelims= "[0-9]+";
        String[] tokens = userEquation.split(oppDelims);
        String[] opps = userEquation.split(intDelims);
        for(int i =0; i <tokens.length; i++)
        {
            System.out.println(tokens[i]);
            
            integerValues.add(Integer.parseInt(tokens[i]));
        }
         for(int i =0; i <opps.length; i++)
        {
           // System.out.println(i);
            System.out.println(opps[i]);
            opperands.add(opps[i]);
        }
         determineValue();
    }
     
    private void determineValue()
    {    
        int opp = 1;
   
        for(int i =0; i < integerValues.size(); i++)
        {
            //System.out.println(integerValues.get(i));
            if (i == 0)
            {
                sum =integerValues.get(i);
            }
            
            else
            {       
                computeOpperation(opperands.get(opp), integerValues.get(i));
                opp++;
            }
            
            
        }
                     
    }
    
    
    private void computeOpperation(String str, int a )
    {
        System.out.println(str);
        
        if(str.equals("+"))
        {
            sum+=a;
        } 
        else if (str.equals("-"))
        {
            sum-=a;
        }
        else if (str.equals("/"))
        {
            sum/=a;
        }
        else if (str.equals("*"))
        {
            sum*=a;
        }
        else 
            System.out.println("function not supported");
    }
    public void displayValue()
    {

        System.out.println("sum: "+ sum);
    }
    
}
