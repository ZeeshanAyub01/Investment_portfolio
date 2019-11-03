/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investment.portfolio;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

    
/**
 *
 * @author Zeeshan
 */
public class Interface extends JFrame{
    
    JPanel aPanel;
    JPanel welcomePanel = new JPanel();
    Portfolio pf = new Portfolio();
    
        
    
    public Interface(String fName){
    
        super();
        
        
        if (!fName.equals("")){
        pf.loadFromFile(fName);
        }
        setSize(700,700);
        setTitle("Investment Portfolio");
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        //JPanel buyPanel = new JPanel();
        JMenu menu = new JMenu("Commands");     //The menu bar
        JMenuItem buy = new JMenuItem("Buy");   //The buy option in the menu
        menu.add(buy);
        buy.addActionListener(new ActionListener(){     //Sets the interface for the buy option visible
            
            public void actionPerformed(ActionEvent e){
                aPanel.setVisible(false);
            aPanel = buildBuyPanel();
            aPanel.setVisible(true);
            
            //String thesymbol = symbol.getText();
            }
            
        });
        JMenuItem  sell = new JMenuItem("Sell");        //Sell option in the menu
        menu.add(sell);
        sell.addActionListener(new ActionListener(){    //Sets the interface for sell visible
            
            public void actionPerformed(ActionEvent e){ 
                aPanel.setVisible(false);
            aPanel = buildSellPanel();
            aPanel.setVisible(true);
            
            
            }
        });
        JMenuItem  update = new JMenuItem("Update");    //Update option in the menu
        menu.add(update);
        update.addActionListener(new ActionListener(){  //Sets the interface for update visible
            
            public void actionPerformed(ActionEvent e){
            aPanel.setVisible(false);
            aPanel = buildUpdatePanel();
            aPanel.setVisible(true);
            }
        });
        JMenuItem  getgain = new JMenuItem("Get gain");     //Get gains option in the menu
        menu.add(getgain);
        getgain.addActionListener(new ActionListener(){     //Sets the interface to get gains visible
            
            public void actionPerformed(ActionEvent e){
            aPanel.setVisible(false);
            aPanel = buildGainsPanel();
            aPanel.setVisible(true);
            }
        });
        
        JMenuItem  search = new JMenuItem("Search");        //Search option in the menu
        menu.add(search);
        search.addActionListener(new ActionListener(){      //Sets the search interface visible
            
            public void actionPerformed(ActionEvent e){
            aPanel.setVisible(false);
            aPanel = buildSearchPanel();
            aPanel.setVisible(true);
            }
        });
        
        JMenuItem  quit = new JMenuItem("Quit");        //Quit option in the menu
        quit.addActionListener(new ActionListener(){    //exits the program
        
        public void actionPerformed(ActionEvent e){
            pf.saveAndQuit(fName);
            
        }
        });
        menu.add(quit);
        
        JMenuBar bar = new JMenuBar();      ///Adds the menu bar to the GUI
        bar.add(menu);
        setJMenuBar(bar);
        
        //JPanel sellPanel = new JPanel(); 
        //JPanel welcomePanel = new JPanel();
        
      
        
        welcomePanel.setLayout(new BorderLayout());     //The very first panel on the screen
        add(welcomePanel, BorderLayout.CENTER);
        welcomePanel.setBackground(Color.WHITE);
        String welcomemessage = "Welcome! Choose from a list of commands on the top left corner";
        JLabel welcome = new JLabel(welcomemessage);
        welcomePanel.add(welcome, BorderLayout.CENTER);
        
        aPanel = welcomePanel;
        aPanel.setVisible(true);
        
    }
    
    
    /*public void actionPerformed(ActionEvent e){
        
        String command = e.getActionCommand();
        
        if( command.equalsIgnoreCase("Buy")){
            
            aPanel.setVisible(false);
            aPanel = buildBuyPanel();
            aPanel.setVisible(true);
            
            //String thesymbol = symbol.getText();
            
        }
        
        else if( command.equalsIgnoreCase("Sell")){
            
            aPanel.setVisible(false);
            aPanel = buildSellPanel();
            aPanel.setVisible(true);
        
        }
        
        else if( command.equalsIgnoreCase("Update")){
            
            aPanel.setVisible(false);
            aPanel = buildUpdatePanel();
            aPanel.setVisible(true);
            
        }
        
        else if( command.equalsIgnoreCase("Get gain")){
            
            aPanel.setVisible(false);
            aPanel = buildGainsPanel();
            aPanel.setVisible(true);
            
        
        }
        
        else if( command.equalsIgnoreCase("Search")){
            
            aPanel.setVisible(false);
            aPanel = buildSearchPanel();
            aPanel.setVisible(true);
        
        }
        
        
                else if (command.equalsIgnoreCase("Quit")){
        System.exit(0);
        
        } 
        
    }*/
    
   
    
     public JPanel buildBuyPanel(){     //Constructs the buy panel
        
        String types[] = {"Stocks", "Mutual Funds"};
        JPanel buyPanel = new JPanel();
        buyPanel.setLayout(new GridLayout(2,1));
        add(buyPanel, BorderLayout.CENTER);
        buyPanel.setBackground(Color.BLUE);
        
        JPanel buying = new JPanel();
        buying.setLayout(new GridLayout(1,2));
        buyPanel.add(buying);
        buying.setBackground(Color.WHITE);
        
        JPanel invinfo = new JPanel();
        invinfo.setLayout(new BorderLayout());
        buying.add(invinfo);
        invinfo.setBackground(Color.ORANGE);
        JLabel buylabel = new JLabel("Buying an investment");
        invinfo.add(buylabel, BorderLayout.NORTH);
        
        
        JPanel theinfo = new JPanel();
        invinfo.add(theinfo, BorderLayout.CENTER);
        JLabel typelabel = new JLabel("Type: ");
        theinfo.add(typelabel);
        JComboBox type = new JComboBox(types);      //The combo box for the buy interface
        theinfo.add(type, BorderLayout.NORTH);
        theinfo.setLayout(new GridLayout(5,2));
        
        
        theinfo.setBackground(Color.ORANGE);
        
        JLabel symbollabel = new JLabel("Symbol: ");
        theinfo.add(symbollabel);
        JTextField symbol = new JTextField(20);
        theinfo.add(symbol);                            //Text field for the symbol
        JLabel namelabel = new JLabel("Name: ");
        theinfo.add(namelabel);
        JTextField name = new JTextField(20);
        theinfo.add(name);                              //Text field for the name
        JLabel qtylabel = new JLabel("Quantity: ");
        theinfo.add(qtylabel);
        JTextField quantity = new JTextField(20);
        theinfo.add(quantity);                          //Text field for the quantity
        JLabel pricelabel = new JLabel("Price: ");
        theinfo.add(pricelabel);                        
        JTextField price = new JTextField(20);
        theinfo.add(price);                             //Text field for the price
        
        JPanel buyreset = new JPanel();
        //buyreset.setLayout(new GridLayout(2,1));
        buying.add(buyreset);
        buyreset.setBackground(Color.BLUE);
        JButton reset = new JButton("Reset");           //The reset button
        JButton buybutton = new JButton("Purchase");    //The button to buy an investment
        
        buyreset.add(reset);
        buyreset.add(buybutton);
        
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        buyPanel.add(messagePanel);
        messagePanel.setBackground(Color.RED);
        JLabel messagelabel = new JLabel("Messages: ");
        messagePanel.add(messagelabel, BorderLayout.NORTH);
        JTextArea messages = new JTextArea();                   //The JText area at the booton of the panel
        //messagePanel.add(messages);
        messages.setLineWrap(true);
        messages.setEditable(false);
        JScrollPane messagebox = new JScrollPane(messages);
        messagebox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        messagebox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(messagebox);
        
        buybutton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                
                pf.buyActions(type,symbol, name, quantity, price, messages);
             /*String thesymbol = "";
             String thename = "";   
             messages.setText("");
             String existstype = "";
             boolean investmentexists = false;
             double initialprice = 0;
             
                String thetype = type.getSelectedItem().toString();
                if (!symbol.getText().isEmpty()){
            thesymbol = symbol.getText();
            }
            if (!name.getText().isEmpty()){
            thename = name.getText();
            }
            int thequantity = Integer.parseInt(quantity.getText());
        double theprice = Double.parseDouble(price.getText());
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
                    theinvs.setBookvalue((newquantity)*(initialprice));
                }
            }
        }
        
        messages.append("You currently own the following investments: \n");
        for (Investment i: investmentList){
            String theinvestment = i.toString();
        messages.append(theinvestment+"\n");
        }*/
                //messages.setText("You entered: "+thetype+ thesymbol+ thename+ thequantity+ theprice+ thebookvalue);
                
            }
        });
        
        reset.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e){
             
             pf.resetBuy(type, symbol, name, quantity, price, messages);
             /*symbol.setText("");
             symbol.setEditable(true);
            name.setText("");
            name.setEditable(true);
            price.setText("");
            price.setEditable(true);
            quantity.setText("");
            messages.setText("");*/
         }
         });
        
        
        //JLabel buyinterface = new JLabel("This is the buy Interface!");
        //invinfo.add(buyinterface, BorderLayout.CENTER);
        
       /*public class BuyClass implements ActionListener{ 
           
           public void ActionPerformed(ActionEvent e ){
               
           }
       }*/
        /*String thetype = type.getSelectedItem().toString();
        
        String thesymbol = "";
        String thename = "";
        
        if (!symbol.getText().isEmpty()){
        thesymbol = symbol.getText();
        }
        if (!name.getText().isEmpty()){
        thename = name.getText();
        }
        int thequantity = Integer.parseInt(quantity.getText());
        double theprice = Double.parseDouble(price.getText());
        double thebookvalue = 0.0;
        
        if (thetype.equalsIgnoreCase("Mutual Funds")){
            I1 = new MutualFunds(thetype, thesymbol, thename, thequantity, theprice, thebookvalue);
            investmentList.add(I1);
        }
        for (Investment i: investmentList){
            String theinvestment = i.toString();
        messages.setText(theinvestment);
        }*/
        

        return buyPanel;
        
    }
    
    JPanel buildSellPanel(){
        
        JPanel sellPanel = new JPanel();
        
        sellPanel.setLayout(new GridLayout(2,1));
        add(sellPanel, BorderLayout.CENTER);
        sellPanel.setBackground(Color.YELLOW);
        
        JPanel selling = new JPanel();
        selling.setLayout(new GridLayout(1,2));
        //JLabel sellinterface = new JLabel("Selling an investment");
        //selling.add(sellinterface, BorderLayout.NORTH);
        sellPanel.add(selling);
        selling.setBackground(Color.CYAN);
        
        
        JPanel sinvinfo = new JPanel();
        selling.add(sinvinfo);
        sinvinfo.setLayout(new BorderLayout());
        sinvinfo.setBackground(Color.MAGENTA);
        JLabel sellinterface = new JLabel("Selling an investment");
        sinvinfo.add(sellinterface, BorderLayout.NORTH);
        JPanel theinfo = new JPanel();
        theinfo.setLayout(new GridLayout(3,2));
        sinvinfo.add(theinfo, BorderLayout.CENTER);
        JLabel symbollabel = new JLabel("Symbol: ");
        theinfo.add(symbollabel);
        JTextField symbol = new JTextField();
        theinfo.add(symbol);
        JLabel qtylabel = new JLabel("Quantity: ");
        theinfo.add(qtylabel);
        JTextField quantity = new JTextField();
        theinfo.add(quantity);
        JLabel pricelabel = new JLabel("Price: ");
        theinfo.add(pricelabel);
        JTextField price = new JTextField();
        theinfo.add(price);
        
        JPanel sellreset = new JPanel();
        //sellreset.setLayout(new GridLayout(2,1));
        selling.add(sellreset);
        sellreset.setBackground(Color.BLUE);
        JButton reset = new JButton("Reset");
        JButton sellbutton = new JButton("Sell");
        sellreset.add(reset);
        sellreset.add(sellbutton);
        
        
        JPanel messagePanel = new JPanel();
        sellPanel.add(messagePanel);
        messagePanel.setBackground(Color.RED);
        messagePanel.setLayout(new BorderLayout());
        JLabel messagelabel = new JLabel("Messages: ");
        messagePanel.add(messagelabel, BorderLayout.NORTH);
        JTextArea messages = new JTextArea();
        messages.setEditable(false);
        JScrollPane messagebox = new JScrollPane(messages);
        messagebox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        messagebox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(messagebox);
        //messagePanel.add(messages, BorderLayout.CENTER);
        JTextField name = new JTextField();
        /*if (investmentList.size() <= 0){
                    symbol.setEditable(false);
                    quantity.setEditable(false);
                    price.setEditable(false);
                    messages.setText("You don't own any investments currently. Come back here when you have bought some investments!");
                    messages.setEditable(false);
                }*/
        
        pf.checkArrayList(symbol, name, quantity, price, messages,1);
        
        //else{
        sellbutton.addActionListener(new ActionListener(){
           
            int investmentfound = 1;
            String investmentbeingsold = "";
            int quantityexisting = 0;
            
            public void actionPerformed(ActionEvent e){
                
                
                pf.sellActions(symbol, quantity, price, messages);
                /*if (investmentList.size() <= 0){
                    symbol.setEditable(false);
                    quantity.setEditable(false);
                    price.setEditable(false);
                    messages.setText("You don't own any investments currently. Come back here when you hve bought some investments!");
                    messages.setEditable(false);
                }*/
                
                
                /*String thesymbol = symbol.getText();
                int sellqty = Integer.parseInt(quantity.getText());
                double sellprice = Double.parseDouble(price.getText());
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
                
                messages.setText("The investment "+ invs.getSymbol()+" was removed from your list because you sold all of it\n");
                investmentList.remove(invs);
                break;
            }
                              
                  
              }
            
            if(investmentList.size() > 0){
            messages.append("You currently own the following investments: \n");
        for (Investment i: investmentList){
            String theinvestment = i.toString();
        messages.append(theinvestment+"\n");
        }}
              }*/
                
            }});
        
        reset.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e){
            /*symbol.setText("");
            symbol.setEditable(true);
            price.setText("");
            price.setEditable(true);
            quantity.setText("");
            messages.setText("");*/
            pf.resetSell(symbol, quantity, price, messages);
         }
         });
        
    
        //JLabel sellint = new JLabel("This is the sell Interface!");
        //messagePanel.add(sellint, BorderLayout.CENTER);
        
        return sellPanel;
        
    }
    
    JPanel buildUpdatePanel(){
       
        int index = 0;
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(2,1));
        add(updatePanel, BorderLayout.CENTER);
        updatePanel.setBackground(Color.CYAN);
        
        
        JPanel updating = new JPanel();
        updating.setLayout(new GridLayout(1,2));
        //JLabel sellinterface = new JLabel("Selling an investment");
        //selling.add(sellinterface, BorderLayout.NORTH);
        updatePanel.add(updating);
        updating.setBackground(Color.CYAN);
        
        
        JPanel uinvinfo = new JPanel();
        updating.add(uinvinfo);
        uinvinfo.setLayout(new BorderLayout());
        uinvinfo.setBackground(Color.MAGENTA);
        JLabel updateinterface = new JLabel("Updating investments");
        uinvinfo.add(updateinterface, BorderLayout.NORTH);
        JPanel theinfo = new JPanel();
        theinfo.setLayout(new GridLayout(3,2));
        uinvinfo.add(theinfo, BorderLayout.CENTER);
        JLabel symbollabel = new JLabel("Symbol: ");
        theinfo.add(symbollabel);
        JTextField symbol = new JTextField();
        theinfo.add(symbol);
        JLabel namelabel = new JLabel("Name: ");
        theinfo.add(namelabel);
        JTextField name = new JTextField();
        theinfo.add(name);
        JLabel pricelabel = new JLabel("Price: ");
        theinfo.add(pricelabel);
        JTextField price = new JTextField();
        theinfo.add(price);
        
        JPanel updatereset = new JPanel();
        //sellreset.setLayout(new GridLayout(2,1));
        updating.add(updatereset);
        updatereset.setBackground(Color.CYAN);
        JButton savebutton = new JButton("Save");
        JButton prevbutton = new JButton("Previous");
        updatereset.add(savebutton);
        updatereset.add(prevbutton);
        JButton nextbutton = new JButton("Next");
        updatereset.add(nextbutton);
        JButton updatebutton = new JButton();
        
        JPanel messagePanel = new JPanel();
        updatePanel.add(messagePanel);
        messagePanel.setBackground(Color.ORANGE);
        messagePanel.setLayout(new BorderLayout());
        JLabel messagelabel = new JLabel("Messages: ");
        messagePanel.add(messagelabel, BorderLayout.NORTH);
        JTextArea messages = new JTextArea();
        messages.setEditable(false);
        //messagePanel.add(messages, BorderLayout.CENTER);
        JScrollPane messagebox = new JScrollPane(messages);
        messagebox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        messagebox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(messagebox);
        symbol.setEditable(false);
        name.setEditable(false);
        prevbutton.setEnabled(false);
        JTextField quantity = new JTextField();
        pf.checkArrayList(symbol, name, quantity, price, messages, 2);
        
        
        
        
        updatebutton.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
            
            
        }
        });
        
        nextbutton.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
                
                int indexer = 0;
                int i = 0;
           pf.updateActions(symbol, name, price, messages, nextbutton, prevbutton, indexer);     
                
           
        }
        });
        
        prevbutton.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
                
                int indexer = 1;
            pf.updateActions(symbol, name, price, messages, nextbutton, prevbutton, indexer);
            
            
            
        }
        });
       
        
        savebutton.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
                
                pf.updatePrice(symbol, name, price, messages, nextbutton, prevbutton);
        
        }
        });
        
        
        return updatePanel;
    }
    
    JPanel buildGainsPanel(){
        
        double totalgains = 0;
        JPanel gainsPanel = new JPanel();
        
        gainsPanel.setLayout(new GridLayout(3,1));
        add(gainsPanel, BorderLayout.CENTER);
        gainsPanel.setBackground(Color.GREEN);
        
        JPanel gains = new JPanel();
        gains.setLayout(new BorderLayout());
        gainsPanel.add(gains);
        JLabel gainslabel = new JLabel("Total gains: ");
        JPanel gainsfield = new JPanel();
        gainsfield.setLayout(new BorderLayout());
        gainsPanel.add(gainsfield);
        gains.add(gainslabel, BorderLayout.SOUTH);
        JTextField gainsvalue = new JTextField();
        gainsfield.add(gainsvalue, BorderLayout.NORTH);
        
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        gainsPanel.add(messagePanel);
        messagePanel.setBackground(Color.ORANGE);
        JLabel messagelabel = new JLabel("Individual gains: ");
        messagePanel.add(messagelabel, BorderLayout.NORTH);
        JTextArea messages = new JTextArea();
        JScrollPane messagebox = new JScrollPane(messages);
        messagebox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        messagebox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(messagebox);
        //messagePanel.setLineWrap(true);
        
        pf.computeGains(gainsvalue, messages);
        /*for (Investment ginvs: investmentList){
            
            totalgains = totalgains + ginvs.getGains();
            messages.append(""+ginvs.getSymbol()+": $"+ginvs.getGains()+"\n");
        }
        
        gainsvalue.setText("$"+totalgains);*/
        
        JLabel gainsinterface = new JLabel("This is the gains Interface!");
        //gainsPanel.add(gainsinterface, BorderLayout.CENTER);
        
        
        return gainsPanel;
        
    }
    
    JPanel buildSearchPanel(){
        
        JPanel searchPanel = new JPanel();
        
        searchPanel.setLayout(new GridLayout(2,1));
        add(searchPanel, BorderLayout.CENTER);
        searchPanel.setBackground(Color.RED);
        
        JPanel searching = new JPanel();
        searching.setLayout(new GridLayout(1,2));
        searchPanel.add(searching);
        searching.setBackground(Color.WHITE);
        
        JPanel invinfo = new JPanel();
        invinfo.setLayout(new BorderLayout());
        searching.add(invinfo);
        invinfo.setBackground(Color.ORANGE);
        JLabel buylabel = new JLabel("Searching for an investment");
        invinfo.add(buylabel, BorderLayout.NORTH);
        
        
        JPanel theinfo = new JPanel();
        invinfo.add(theinfo, BorderLayout.CENTER);
        theinfo.setLayout(new GridLayout(5,2));
        theinfo.setBackground(Color.ORANGE);
        
        JLabel symbollabel = new JLabel("Symbol: ");
        theinfo.add(symbollabel);
        JTextField symbol = new JTextField();
        theinfo.add(symbol);
        JLabel namekwlabel = new JLabel("Name keywords: ");
        theinfo.add(namekwlabel);
        JTextField namekw = new JTextField();
        theinfo.add(namekw);
        JLabel lowprclabel = new JLabel("Low Price: ");
        theinfo.add(lowprclabel);
        JTextField lowprc = new JTextField();
        theinfo.add(lowprc);
        JLabel highpricelabel = new JLabel("Highest Price: ");
        theinfo.add(highpricelabel);
        JTextField highprice = new JTextField();
        theinfo.add(highprice);
        
        JPanel buyreset = new JPanel();
        //buyreset.setLayout(new GridLayout(2,1));
        searching.add(buyreset);
        buyreset.setBackground(Color.BLUE);
        JButton reset = new JButton("Reset");
        JButton searchbutton = new JButton("Search");
        buyreset.add(reset);
        buyreset.add(searchbutton);
        
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        searchPanel.add(messagePanel);
        messagePanel.setBackground(Color.RED);
        JLabel messagelabel = new JLabel("Messages: ");
        messagePanel.add(messagelabel, BorderLayout.NORTH);
        JTextArea messages = new JTextArea();
        //messagePanel.add(messages);
        messages.setEditable(false);
        
        JScrollPane messagebox = new JScrollPane(messages);
        messagebox.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        messagebox.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(messagebox);
        
        searchbutton.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                pf.searchInvestment(symbol, namekw, lowprc, highprice, messages);
            }
            
        });
        
        JLabel searchinterface = new JLabel("This is the search Interface!");
        //searchPanel.add(searchinterface, BorderLayout.CENTER);
        
        return searchPanel;
    }
    
    
    public void getBuyInfo(){
        
        
    }






}
    
    
    
    
    
    
    
    
    