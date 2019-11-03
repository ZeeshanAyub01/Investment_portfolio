/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investment.portfolio;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

import java.util.Scanner;

/**
 *
 * @author Zeeshan
 */
public class Portfolio {
    
    ArrayList<Investment> investmentList = new ArrayList<Investment>();
    HashMap<Integer, Investment> Investments = new HashMap<Integer, Investment>(10); 
    Investment invmnt = new Investment("","",0,0.0,0.0);   //constructor for a new investment
        MutualFunds mf = new MutualFunds("","","",0,0.0,0.0); //Constructor for Mutual funds class
        Stocks s = new Stocks("","","",0,0.0,0.0);  //Constructor for Stock class
        Investment I1 = (Investment) mf;    //upcasting mutual funds
        Investment I2 = (Investment) s;     //upcasting stocks
    
    void workOnPortfolio(String fName){
        
        Scanner keyboard = new Scanner(System.in);  //Object for keyboard input
        
        String insm = "";
        String invtype = "";
        int qtyta = 0;
        int newqty = 0;
        int qtyts = 0;
        int nqty = 0;
        int im = 0;
        int invf = 0;
        String tp = "";
        String tp1 = "";
        String tp2 = "";
        String tp3 = "";
        String smf = "";
        int ism = 0;
        int qtys = 0;
        int ff = 0;
        int ind = 0;
        
        boolean typeCorrect = false;
     
    }
    
    public boolean isNumericalString(String stc){   //a function used all over the program to check if a string entered contained no non-numeric characters
        
        int check = 0;
        for (int i = 0; i<stc.length(); i++){
            char n = stc.charAt(i);
            if (  (n != '1') && (n != '2') && (n != '3') && (n != '4') && (n != '5') && (n != '6') && (n != '7') && (n != '8') && (n != '9') && (n != '0') && (n != '.') || (stc.isEmpty()) || (stc == " ") || (stc.indexOf("-") > 0)){
            check = 1;
                break;
            }
        }
        
        if (check == 0){
            return true;
        }
        
        else{
            return false;
        }
    }
      
    
    
    public void buyActions(JComboBox type,JTextField symbol, JTextField name, JTextField quantity, JTextField price, JTextArea messages){
        
        
        int infocorrect = 0;
        String thesymbol = "";
             String thename = "";   
             messages.setText("");
             String existstype = "";
             boolean investmentexists = false;
             double initialprice = 0;
             int thequantity = 0;
             double theprice = 0;
                String thetype = type.getSelectedItem().toString();
                if (symbol.getText().isEmpty()){
                    messages.setText("Invalid or incomplete information entered!");
                    infocorrect++;
                resetBuy(type,symbol,name,quantity,price,messages);
                }
                else {
            thesymbol = symbol.getText();
            infocorrect = 0;
            }
                
                if (name.getText().isEmpty()){
                    messages.setText("Invalid or incomplete information entered!");
                    infocorrect++;
                resetBuy(type,symbol,name,quantity,price,messages);
                }
                
            else{
            thename = name.getText();
            infocorrect = 0;
            }
                
            String qnty = quantity.getText();
            if ((!isNumericalString(qnty)) || (qnty.isEmpty())){
                errorMessage(messages);
                resetBuy(type, symbol,name,quantity,price,messages);
            }
            else{
            thequantity = Integer.parseInt(quantity.getText());
            infocorrect = 0;
            }
            
            String prc = price.getText();
            if ((!isNumericalString(prc)) || (prc.isEmpty())){
                errorMessage(messages);
                resetBuy(type, symbol,name,quantity,price,messages);
            }
            else{
            theprice = Double.parseDouble(price.getText());
            infocorrect = 0;
            }
        
        initialprice = theprice;
        double thebookvalue = thequantity*theprice;
         //messages.append("the book value will be: "+thebookvalue);   
        for (Investment invs: investmentList){
            String investmentsymbol = invs.getSymbol();
            
            if (investmentsymbol.equalsIgnoreCase(thesymbol)){
                existstype = thetype;
                investmentexists = true;
                break;
            }
        }
        
        if (!investmentexists){
        if (thetype.equalsIgnoreCase("Mutual Funds")){
            //I1.setBookvalue(thebookvalue);
            I1 = new MutualFunds(thetype, thesymbol, thename, thequantity, theprice, thebookvalue);
            
            investmentList.add(I1);
        }
        
        else if (thetype.equalsIgnoreCase("Stocks")){
            //I2.setBookvalue(thebookvalue);
            I2 = new Stocks(thetype, thesymbol, thename, thequantity, theprice, thebookvalue);
            
            investmentList.add(I2);
        }}
        
        else{
            messages.setText("");
            messages.setText("That symbol already exists so only the quantity you entered got added"+"\n");
            symbol.setText(thesymbol);
            symbol.setEditable(false);
            name.setText("");
            name.setEditable(false);
            price.setText("");
            price.setEditable(false);
            thequantity = Integer.parseInt(quantity.getText());
            
            for(Investment theinvs: investmentList){
                if (thesymbol.equalsIgnoreCase(theinvs.getSymbol())){
                    int newquantity = theinvs.getQuantity() + thequantity;
                    theinvs.setQuantity(newquantity);
                    theinvs.setBookvalue((newquantity)*(theinvs.getPrice()));
                }
            }
        }
        
        messages.append("You currently own the following investments: \n");
        
        for(Investment inve: investmentList){
            if((inve.getSymbol().isEmpty()) || (inve.getName().isEmpty()) || (inve.getQuantity() == 0) || (inve.getQuantity() == 0)){
                investmentList.remove(inve);
                break;
            }
                
        }
        for (Investment i: investmentList){
            String theinvestment = i.toString();
        messages.append(theinvestment+"\n");
        }
        System.out.println(investmentList);
        resetBuy(type, symbol, name, quantity, price, messages);
            
        }
    
    
    public void resetBuy(JComboBox type,JTextField symbol, JTextField name, JTextField quantity, JTextField price, JTextArea messages){
            
            symbol.setText("");
             symbol.setEditable(true);
            name.setText("");
            name.setEditable(true);
            price.setText("");
            price.setEditable(true);
            quantity.setText("");
            
    }
    
    
    public void checkArrayList(JTextField symbol, JTextField name, JTextField quantity, JTextField price, JTextArea messages, int func){
        
        if (investmentList.size() <= 0){
                    symbol.setEditable(false);
                    quantity.setEditable(false);
                    price.setEditable(false);
                    messages.setText("You don't own any investments currently. Come back here when you have bought some investments!");
                    messages.setEditable(false);
                }
        
        if (func == 2){
            if(investmentList.size() > 0){
            symbol.setText(investmentList.get(0).getSymbol());
            name.setText(investmentList.get(0).getName());
            
        }}
        
    }
    
    
    
    public void sellActions(JTextField symbol, JTextField quantity, JTextField price, JTextArea messages){
        
        int investmentfound = 1;
            String investmentbeingsold = "";
            int quantityexisting = 0;
        double sellprice = 0;
        
        String thesymbol = symbol.getText();
        if(thesymbol.isEmpty()){
          errorMessage(messages);
                resetSell(symbol,quantity,price,messages);  
        }
        
                int sellqty = Integer.parseInt(quantity.getText());
                String sellingprice = price.getText();
                if ((!isNumericalString(sellingprice)) || (sellingprice.isEmpty())){
                messages.setText("Invalid or incomplete information entered!");
                resetSell(symbol,quantity,price,messages);
            }
            else{
            sellprice = Double.parseDouble(price.getText());
            }
                
                for (Investment invs: investmentList){
            String investmentsymbol = invs.getSymbol();
            
            if (investmentsymbol.equalsIgnoreCase(thesymbol)){
               quantityexisting = invs.getQuantity();
               investmentbeingsold = thesymbol;
                messages.setText("Investment found! Quantity sold successfully!\nAnd the payment recieved from the sale of "+invs.getSymbol()+" was: $"+invs.getPayment(sellprice, sellqty)+"\n");
                investmentfound = 1;
                break;
            }
            else{
                investmentfound = 0;
            }
        }
                
        
              if(investmentfound == 0){
              messages.setText("Investment not found! Reset and enter again!");
              }
              else if(sellqty > quantityexisting){
                messages.setText("You only have "+quantityexisting+" of "+thesymbol+"! Reset and enter again!\n");  
              }
              
              else if(sellqty <= 0){
                messages.setText("Sell quantity cannot be zero or negative! Reset and enter again!");  
              }
              
              else{
                  quantityexisting = quantityexisting - sellqty;
                  
            for (Investment invs: investmentList){
            String investmentsymbol = invs.getSymbol();
            
            if (investmentsymbol.equalsIgnoreCase(thesymbol)){
               invs.setQuantity(quantityexisting);
               invs.setBookvalue(quantityexisting*invs.getPrice());
            }
            
            if(invs.getQuantity() == 0){
                
                messages.append("The investment "+ invs.getSymbol()+" was removed from your list because you sold all of it\n");
                investmentList.remove(invs);
                if (investmentList.size() == 0){
                    messages.append("You don't own any investments now!\n");
                    symbol.setEditable(false);
                    quantity.setEditable(false);
                    price.setEditable(false);
                }
                break;
            }
                              
                  
              }
            
            if(investmentList.size() > 0){
            messages.append("You currently own the following investments: \n");
        for (Investment i: investmentList){
            String theinvestment = i.toString();
        messages.append(theinvestment+"\n");
        }}
              }
    }
    
    public void resetSell(JTextField symbol, JTextField quantity, JTextField price, JTextArea messages){
        
            symbol.setText("");
            symbol.setEditable(true);
            price.setText("");
            price.setEditable(true);
            quantity.setText("");
            messages.setText("");
        
    }
    
    
    
    public void updateActions(JTextField symbol, JTextField name, JTextField price, JTextArea messages, JButton nextbutton, JButton prevbutton, int indexer){
        
        
        
        int index = 0;
        int i = 0;
        String thecurrent = symbol.getText();
        //symbol.setText(investmentList.get(index).getSymbol());
            //name.setText(investmentList.get(index).getName());
            /*if(investmentList.size() == 1){
                nextbutton.setEnabled(false);
            prevbutton.setEnabled(false);
            price.setEditable(true);
            }*/
    
    for(i = 0; i< investmentList.size(); i++){
                    if(thecurrent.equalsIgnoreCase(investmentList.get(i).getSymbol())){
                        
                        index = i;
                        break;
                    }
                }
    
               if(indexer == 0){ 
            index++;
               }
               else
               {
                   index--;
               }
               
               if(index == (investmentList.size() - 1)){
                nextbutton.setEnabled(false);
                prevbutton.setEnabled(true);
            }
            
            else if(index == 0){
                nextbutton.setEnabled(true);
                prevbutton.setEnabled(false);
            }
            else {
                nextbutton.setEnabled(true);
                prevbutton.setEnabled(true);
            }
               
               
            symbol.setText(investmentList.get(index).getSymbol());
            name.setText(""+investmentList.get(index).getQuantity());
            
            
            
    }
    
    
    public void updatePrice(JTextField symbol, JTextField name, JTextField price, JTextArea messages, JButton nextbutton, JButton prevbutton){
        int index = 0;
                double newprice = 0;
                int i = 0;
                
                for(i = 0; i< investmentList.size(); i++){
                    if(symbol.getText().equalsIgnoreCase(investmentList.get(i).getSymbol())){
                        index = i;
                    }
                }
                
                if(price.getText().isEmpty()){
                    newprice = 0;
                }
                
                else{
                    newprice = Double.parseDouble(price.getText());
                    Investment oldinv = investmentList.get(index);
                    oldinv.setPrice(newprice);
                }
                
                messages.append("You currently own the following investments: \n");
            for (Investment alltheinvs: investmentList){
            String theinvestment = alltheinvs.toString();
            messages.append(theinvestment+"\n");
        }
                
    }
    
    
    public void computeGains(JTextField gainsvalue, JTextArea messages){
        
        double totalgains = 0;
        
        gainsvalue.setEditable(false);
        messages.setEditable(false);
        
        for (Investment ginvs: investmentList){
            
            totalgains = totalgains + ginvs.getGains();
            messages.append(""+ginvs.getSymbol()+": $"+ginvs.getGains()+"\n");
        }
        
        String formatstring = String.format("%.02f",totalgains);
        gainsvalue.setText("$"+formatstring);
    }
    
    
    public void searchInvestment(JTextField symbol, JTextField namekw, JTextField lowprc,JTextField highprice, JTextArea messages){
        
                    int invfound = 0;
                       
                       for (int ind1 = 0; ind1<investmentList.size(); ind1++){
                       Investments.put(ind1, investmentList.get(ind1));
                       }
                       
                       Set<Integer> keys = Investments.keySet();
                       
                        
                        
                        
                        String keywords = namekw.getText();
                        StringTokenizer searchwords = new StringTokenizer(keywords);
                                messages.append("You entered the following search words: \n");
                                
                                while (searchwords.hasMoreTokens()){    
                                    String swt = searchwords.nextToken();
                                    messages.append(""+swt+"\n");
                                    Iterator<Integer> iter = keys.iterator();
                                    while (iter.hasNext()) {
                                    Integer key = iter.next();
                                    Investment content = Investments.get(key);
                                    String nameAtKey = content.getName();
                                    StringTokenizer searchnames = new StringTokenizer(nameAtKey);
                                    
                                    while (searchnames.hasMoreTokens()){
                                    String sn = searchnames.nextToken();
                                    if (swt.equalsIgnoreCase(sn)){
                                        messages.append(swt+" exists at: "+key+" in: "+Investments.get(key).toString()+"\n");
                                    }
                                    }
                                    
                                    }
                                }
                       
                           
                           if((!isNumericalString(lowprc.getText())) || (lowprc.getText().isEmpty())){
                               messages.append("Invalid Entry! Enter the minimum price again");
                               symbol.setText("");
                               namekw.setText("");
                               lowprc.setText("");
                               highprice.setText("");
                               //minprice = keyboard.nextLine();
                           }
                           
                           
                           Double minp = Double.parseDouble(lowprc.getText());
                           
                           if((!isNumericalString(highprice.getText())) || (highprice.getText().isEmpty())){
                               System.out.println("Invalid Entry! Enter the maximum price again");
                               symbol.setText("");
                               namekw.setText("");
                               lowprc.setText("");
                               highprice.setText("");
                           
                       }
                           
                           
                           Double maxp = Double.parseDouble(highprice.getText());
                           
                            for (Investment ins: investmentList){
                                if ((ins.getPrice() >= minp) && (ins.getPrice() <= maxp)){
                                    messages.append(ins.toString()+"\n");
                                    invfound++;
                                }
                            }
                            
                            if(invfound == 0){
                               messages.append("No investments were found in that price range!");
                            }
                            
                            for(Investment all: investmentList){
                                if(symbol.getText().equalsIgnoreCase(all.getSymbol())){
                                    messages.append("The symbol entered "+symbol.getText()+" exists in: "+all.toString()+"\n");
                                }
                                else{
                                invfound++;
                                }
                            }
                       
                       if(invfound == 0){
                           
                                    messages.append("The symbol entered was not found!\n");
                               
                       }
                        
    }
    
    public void loadFromFile(String fName){
        
        String tp1 = "1";
        boolean typeCorrect = false;
        
        try{
            
                    double initialprice = 0;
                    BufferedReader inputStream = new BufferedReader(new FileReader(fName));//Constructor for the object to read input from file
                    
                    String invInfo = inputStream.readLine();
                    do{
                    
                    StringTokenizer data = new StringTokenizer(invInfo, ",");
                    String invType = data.nextToken();

                    /*if ((!invType.equalsIgnoreCase("mutual fund")) && (!invType.equalsIgnoreCase("mutualfund")) && (!invType.equalsIgnoreCase("mutual funds")) && (!invType.equalsIgnoreCase("mutualfunds")) && (!invType.equalsIgnoreCase("stock")) && (!invType.equalsIgnoreCase("stocks"))){
                        //("Some invalid information was detected for the symbol, make sure the information in the file is in the format specified in the readMe!");
                                               
                    }*/   //this if tatement ensures that the type of investment entered is correct
                    
                     if ((invType.equalsIgnoreCase("mutual fund")) || (invType.equalsIgnoreCase("mutualfund")) || (invType.equalsIgnoreCase("mutual funds")) || (invType.equalsIgnoreCase("mutualfunds"))){
                        invType = "Mutual Funds";
                        tp1 = "1";
                        typeCorrect = true;
                    }
                    
                    else if ((invType.equalsIgnoreCase("stock")) || (invType.equalsIgnoreCase("stocks"))){
                        invType = "Stocks";
                        tp1 = "2";
                        typeCorrect = true;
                    }
                    
                    if (typeCorrect == true){
                        
                        String invSymbol = data.nextToken();    //The token after the type is the symbol according to the format
                        
                        int si = 0;
                        if (invSymbol.charAt(si) == ' '){
                            invSymbol = invSymbol.substring(si+1);  //removes the space at the beginning
                        }
                        
                        
                        
                        String invName = data.nextToken();  //the name of the investment
                        int ni = 0;
                        if (invName.charAt(ni) == ' '){
                            invName = invName.substring(ni+1);
                        }
                        
                        String iQty = data.nextToken(); //the quantity
                        int qi = 0;
                        if (iQty.charAt(qi) == ' '){
                            iQty = iQty.substring(qi+1);
                        }
                    
                        int iqty = Integer.parseInt(iQty);
                        
                        String iPrice = data.nextToken();   //the price
                        int pi = 0;
                        if (iPrice.charAt(pi) == ' '){
                            iPrice = iPrice.substring(pi+1);
                        }
                        for (int anindex = 0; anindex < iPrice.length(); anindex++){
                            if (iPrice.charAt(anindex) == '$'){
                                iPrice = iPrice.substring(anindex+1);
                            }
                        }
                        
                
                      
                        Double iprice = Double.parseDouble(iPrice);
                        Double iBookvalue = iprice*iqty;
                    
                        if (tp1.equals("1")){
                        I1 = new MutualFunds(invType, invSymbol, invName, iqty, iprice, iBookvalue);
                        
                        investmentList.add(I1);
                        //System.out.println(I1.toString());
                        }
                        else if (tp1.equals("2")){
                        I2 = new Stocks(invType, invSymbol, invName, iqty, iprice, iBookvalue);
                        investmentList.add(I2);
                        //System.out.println(I2.toString());
                        }}
                        
                    invInfo = inputStream.readLine();
                        
                    }while (invInfo != null);
                    
                    
                    
        }
        catch(FileNotFoundException fnf){
                    System.out.println("File not found!");
                }
                catch(IOException ioe){
                    System.out.println("Error reading from file!");
                }
        
    }
    
    public void errorMessage(JTextArea messages){
        messages.setText("Invalid or incomplete information was entered! Try again!\n");
    }
    
    
    public void saveAndQuit(String fName){
       
                        
                   PrintWriter outputStream = null;
                     
                        
                    try
                    {
                    outputStream = new PrintWriter(new FileOutputStream(fName));
                    for (Investment allInvestments: investmentList){
                    outputStream.println(allInvestments.toString());
                }
                    }
                    catch(FileNotFoundException error){
                    System.out.println("There was an error opening the file!");
                    
               
                    }
                       outputStream.close(); 
                       System.exit(0);
                        
                        
                       
                        
                        
            }
            
        
    }
    
    
    
    

    

