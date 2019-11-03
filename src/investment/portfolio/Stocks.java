/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investment.portfolio;

/**
 *
 * @author Zeeshan
 */
public class Stocks extends Investment{ //the Stocks subclass
    
    private String type;    //the variable different from it's super class
    //private double Bookvalue;
    
    public Stocks(String type, String symbol, String name, int quantity, double price, double bookvalue){    //Setter for the Stock class
    
    super(symbol, name, quantity, price, bookvalue);    //constructor for the superclass
    
    
    this.type = type;
    
}
    
    private double calculateBookvalue(double q, double p){
        return q*p+9.99;
    }

    public void setType(){      //setter for the type
        this.type = type;
    }
    
    public String getType(){    //getter for the type
        return type;
    }
    
    /*public void setBookvalue(double bv){    //setter for the bookvalue
        
        this.Bookvalue = bv + 9.99;
    }*/
    
    /*public double getBookvalue(){   //getter for the bookvalue
        
        return Bookvalue;
    }*/
    
    public double getBookvalue(){
        return super.getBookvalue()+9.99;  
    }
    
    public double getGains(){
      return (getQuantity()*getPrice() - getBookvalue());  
    }
    
    public double getPayment(double sellprice, int qtysold){
        return (sellprice*qtysold - 9.99);
    }
    
    public String toString(){   //to string method that returns the stock as a string
        return (getType() +", "+ super.toString()+", $"+getBookvalue());
    }
    
    
    public boolean equals(Stocks other){    //the equals method to compare two mutual funds
       if ((getSymbol().equals(other.getSymbol())) && (getName().equals(other.getName())) && (getQuantity() == (other.getQuantity())) && (getPrice() == other.getPrice()) && (getBookvalue() == other.getBookvalue()) && (getType().equalsIgnoreCase(other.getType()))){
           return true;
       }
       
       else{
           return false;
       }
   }
    

    
}
