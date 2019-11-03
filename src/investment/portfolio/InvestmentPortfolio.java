/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investment.portfolio;

import java.util.Scanner;

import java.util.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Zeeshan
 */


public class InvestmentPortfolio {  
    
    //Interface gui = new Interface();
    //BuyInterface buygui = new BuyInterface();
    
    public static void main(String[] args) {    //The main method
        
        String fName = "";
        
        if(!args[0].equals("")){
           fName = args[0];
        }
        Interface gui = new Interface(fName);
        Portfolio obj = new Portfolio();//Constructor for the main class
        
        gui.setVisible(true);
                
        
    }
  
    /**
     * @param args the command line arguments
     */
    
    


}

