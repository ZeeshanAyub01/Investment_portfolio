CIS*2430 Assignment 3
Author: Muhammad Zeeshan Ayub,
Student Id: 0994442,
Instructor: Fei Song.


What the program does:
The program maintains the investment portfolio of a user. It accepts input from the user regarding Investments (Mutual funds or stocks bought or sold) from a text file or directly. The program keeps the information about the existing investments and the gains, and can provide the user with the required information when the user requests it. 


Operation of the program (User Guide):
the program starts off by accepting a single word as a file name, as a command line argument, and uploads all the information contained in the file onto the ArrayList in the program, it the specified file exists. Otherwise the user can continue working on other functions of the program and can later create the file with the name specified earlier. The user must ensure that the INFORMATION CONTAINED IS IN THE FORMAT DESCIRBED IN THE NEXT HEADING! Otherwise the program can result in erroneous output or it could even crash (even though the autor has tried to test it and prevent it from crashing with all possible inputs). 

***************************************************************************************************************
To run it in Netbeans click the 'Run' button; but to run it on the terminal, follow the instructions below

To compile the program:
Inside the folder the folder with .java files (Investment_portfolio/src/investment/portfolio):
Type: javac *.java

To run the program:
Inside the directory: Investment_portfolio/src/
Type: java investment.portfolio.InvestmentPortfolio <Name of text file>
***************************************************************************************************************


FILE INPUT FORMAT:
The name of the file must be a single word. The information for each investment must be contained in a single line,with each part of the information seperated by a comma and at maximum one blank space. The format and a sample input that would work for the file is shown below:

Type(case insensitive), st(a STRING seperated by anything but a comma, it's case-insensitive), Name of the stock(a STRING seperated by anything but a comma), quantity(an INTEGER), $price(the price a Double, the Dollar sign may or may not be added).


The following input will work perfectly:

Mutualfund, mf 01, some Mutual Fund, 500, $99.99

All input must follow this format. Any other format will result in erroneous output.


The Main menu:
This is the fist prompt the user recieves. The user may type any of the listed options or could enter the corresponding number.


1.Buy:
When chosen, this option asks the user to specify the type of investment being bought by entering the corresponding number (1. Mututal funds, or 2. Stocks)
After that the program gets all the other information fom the user about the investment, except for the bookvalue. The bookValue is calculated by the program based on the quantity and the price entered for the investment. The information once taken is stored in an arraylist of type "Investment".


2.Sell:
The user will only be able to use this option if the user owns any investments. This option asks the user for the quantity they wish to sell for the investment and deducts the quantity sold from the existing quantity. The BookValue is also updated.


3.Update:
This option asks the user to enter a new price for each of the investments contained in the list of investments, but does not change the bookvalue.


4.Getgains:
This option calculates the total gains from all the investments and displays them to the user. The formula used to calculate the gains is the same as that used for assignment 1.


5.Search:
This option performs a search based on keywords or price range. For keywords, the user may enter as many keywords as they like. The program will display the index in the map and the corresponding investment found one by one for each keyword entered.


6.Display:
This option, although, not required for the assignment, the author included to aid himself and anyone testinf the program, to display everything contained in the list of investments.


7.Quit:
This option asks the user if they wish to save any changes they made to their portfolio to the file specified earlier. If the file does not exist, it will be created.



TEST PLAN:

Cases tested against:

Non-numerical strings: All fields that require numbers were tested with non-numerical strings; methods that prevented the program from crashing were added. In most cases the user will be prompted to re-enter the value if this happens.

Negative numbers: This program does not accept negative numbers for any field. In most cases the user will prompted to re-enter the number.

String Emptiness: All fields requiring a string were tested to see if they were empty. In most cases the user is prompted to re-enter the string if it is empty. 

Matching symbols: If the user tries to add an investment with a symbol that already exists, the program will refuse to add the investment and instead will only add the quantity.

Selling a non-existing investment: If the user enters a symbol to sell that doesn't exist, the program will tell the user that it doesn't exist and then return to the main menu.

Not reading when file is not found: The program checks to see if the speicified file exists. If it doesn't, the user can still add information though the program and choose to later save it in a new file with the name speicified earlier.

Invalid information contained in the file: If any of the fields in the file contain information in the wrong format or the wrong type, the program generates an error message and refuses to add the investment to the list



LIMITATIONS OF THE PROGRAM AND POSSIBLE FUTURE IMPROVEMENTS:

This program still can maintain the portfolio of a single user and the for two types of investments: stocks and mutual funds. In future this program can be modified to include further types of investments and to perform further operations on the data contained in the arraylist.




