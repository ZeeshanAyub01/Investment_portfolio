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
public class MutualFunds extends Investment{    //the MutualFunds subclass
    
   private String type;     //the variable different from it's super class
    //private double Bookvalue;
    
    public MutualFunds(String type, String symbol, String name, int quantity, double price, double bookvalue){  //Setter for the mutual funds class
    
    super(symbol, name, quantity, price, bookvalue);    //the constructor for the super class
    
    this.type = type;
    
    }
    
    private double calculateBookvalue(double q, double p){
        return q*p;
    }
    
    public void setType(){  //setter for the type
        this.type = type;
    }
    
        public String getType(){//the getter for the type
            return type;
    }
        
        /*public void setBookvalue(double bv){    //setter for the bookvalue
        
        this.Bookvalue = bv;*/
    
    
    public double getBookvalue(){   //getter for the bookvalue
        
        return super.getBookvalue();
    }
    
    /*public double getBookvalue(){
        return (getQuantity()*getPrice());  
    }*/
    
    public double getGains(){
      return (getQuantity()*getPrice() - getBookvalue() - 45.00);  
    }
    
    public double getPayment(double sellprice, int qtysold){
        return (sellprice*qtysold - 45.00);
    }
    
    public String toString(){   //the toString method that returns a mutual fund as a string
        return (getType() +", "+ super.toString()+", $"+getBookvalue());
    }
    
    
    public boolean equals(MutualFunds other){    //the equals method to compare two mutual funds
       if ((getSymbol().equals(other.getSymbol())) && (getName().equals(other.getName())) && (getQuantity() == (other.getQuantity())) && (getPrice() == other.getPrice()) && (getBookvalue() == other.getBookvalue()) && (getType().equalsIgnoreCase(other.getType()))){
           return true;
       }
       
       else{
           return false;
       }
   }
    
    
}
    

