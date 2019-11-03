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
public class Investment {   //the super class
    
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double Bookvalue;
    private double gains;
    
    public Investment(String s, String n, int q, double p, double bv){  //recieves values for the private variables 
    
    this.symbol = s;
    this.name = n;
    this.quantity = q;
    this.price = p;
    this.gains = q*p;
    this.Bookvalue = bv;
    
    
}
    
    public void setSymbol(String sm){   //setter for the symbol
        this.symbol = sm;
    }
    
    public String getSymbol(){  //getter for the symbol
        return symbol;
    }
    
    public void setPrice(double prc){   //setter for the price
        this.price = prc;
    }
    
    public double getPrice(){   //getter for the price
        return price;
    }
    
    public void setQuantity(int qty){   //setter for the quantity
        this.quantity = qty;
    }
    
    public int getQuantity(){   //getter for the quantity
        return quantity;
    }
    
    public void setName(String name){   //setter for the name
        this.name = name;
    }
    
    public String getName(){    //getter for the name
        return name;
    }
    
    
    public double getBookvalue(){
        return Bookvalue;  
    }
    
    public void setBookvalue(double bv){
        this.Bookvalue = bv;
    }
    
    public double getGains(){
      return (getQuantity()*getPrice() - getBookvalue());  
    }
    
    public double getPayment(double sellprice, int qtysold){
        return sellprice*qtysold;
    }
    
    public String toString(){   //the toString method for the investments
        return (getSymbol()+", "+ getName() +", "+ getQuantity() +", $"+ getPrice());
    }
    
    
    public boolean equals(Investment other){    //the equals method to compare two investments
       if ((getSymbol().equals(other.getSymbol())) && (getName().equals(other.getName())) && (getQuantity() == (other.getQuantity())) && (getPrice() == other.getPrice())){
           return true;
       }
       
       else{
           return false;
       }
   }
    
    
    
}
