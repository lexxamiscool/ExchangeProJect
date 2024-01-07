package exchange.main;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class ExchangeMain {
    /*
     * Create a currency converter between CLP, ARS, USD, EUR, TRY, GBP with the following features:
*       The user must choose their initial currency and the currency they want to exchange to. DONE
*       The user can choose whether or not to withdraw their funds. If they choose not to withdraw,
*       it should return to the main menu.DONE
*       If the user decides to withdraw the funds, the system will charge a 1% commission.
*       Set a minimum and maximum amount for each currency, it can be of your choice.DONE
*       The system should ask the user if they want to perform another operation. If they choose to do so,
*       it should restart the process; otherwise, the system should close.DONE

     * */
    public static void main(String[] args) {
        
        String initialCurrency;
        String currencyToExchange;
        boolean decition = true;
        String decition2;
        HashMap<String, Double> fromCurrencyTo = new HashMap<String, Double>(); 
        fromCurrencyTo.put("CLP", 0.0011);
        fromCurrencyTo.put("ARS", 0.0012);
        fromCurrencyTo.put("EUR", 1.10);
        fromCurrencyTo.put("TRY", 0.034);
        fromCurrencyTo.put("GBP", 1.27);
        fromCurrencyTo.put("USD", 1.00);
         do{
             
             JOptionPane.showMessageDialog(null, "Welcome to the exchange \n You have the following currencies to exchange \n 1.)CLP \n 2.)ARS \n 3.)USD \n 4.) EUR \n6.)GBP");
             initialCurrency = JOptionPane.showInputDialog("Please write your initial currency");
             if(fromCurrencyTo.containsKey(initialCurrency)) {
                 currencyToExchange = JOptionPane.showInputDialog("Please write you currency to exchange");
                 if(fromCurrencyTo.containsKey(currencyToExchange)) {
                     withdraw(initialCurrency,currencyToExchange); 
                 }
             }
             
                 
                        
            decition2=JOptionPane.showInputDialog("Would you like to do another operation? write yes or no");
            if(!decition2.equalsIgnoreCase("yes")) {
                 decition=false;
            }
        }while(decition);
    }
    
    public static boolean withdraw(String initialCurrency, String currencyToExchange) {
        double minimunCLP = 1000;
        double maximumCLP = 5000;
        double minimumARS = 500;
        double maximumARS = 6000;
        double minimumUSD = 100;
        double maximumUSD = 7000;
        double minimumEUR = 400;
        double maximumEUR = 8000;
        double minimumTRY = 500;
        double maximumTRY = 3000;
        double minimumGBP = 100;
        double maximumGBP = 7000;
        double totalamount;
        String choose = JOptionPane.showInputDialog("Would you like to withdraw your funds?\n Remember this transaction will cost you 1%\n Write Yes or No ");
        if(choose.equalsIgnoreCase("yes")) {
          double amountToWithdraw = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you would like to withdraw"));
          switch(initialCurrency) {
              case "USD":
                  if(amountToWithdraw >=minimumUSD && amountToWithdraw<=maximumUSD) {
                       totalamount =dollarToOther(amountToWithdraw, currencyToExchange)+ (dollarToOther(amountToWithdraw, currencyToExchange)*0.01);
                       JOptionPane.showMessageDialog(null, "The total amount you withdraw was: " + totalamount);
                  }else {
                      JOptionPane.showMessageDialog(null, "The operation can't be done due it overpass the amount minimum of" + minimumUSD +"  or maximun"+ maximumUSD + " to convert");
                  }
                  
                  break;
              case "CLP":
                  if(amountToWithdraw >=minimunCLP && amountToWithdraw<=maximumCLP) {
                      totalamount = clpToOther(amountToWithdraw, currencyToExchange) + (clpToOther(amountToWithdraw, currencyToExchange)*0.01);
                      JOptionPane.showMessageDialog(null, "The total amount you withdraw was: " + totalamount);
                  }else {
                      JOptionPane.showMessageDialog(null, "The operation can't be done due it overpass the amount minimum of" + minimunCLP +"  or maximun"+ maximumCLP + " to convert");
                  }
                  
                  break;
              case "ARS":
                  if(amountToWithdraw >=minimumARS && amountToWithdraw<=maximumARS) {
                      totalamount =arsToOther(amountToWithdraw, currencyToExchange) + (arsToOther(amountToWithdraw, currencyToExchange)* 0.01);
                      JOptionPane.showMessageDialog(null, "The total amount you withdraw was: " + totalamount);
                  }else {
                      JOptionPane.showMessageDialog(null, "The operation can't be done due it overpass the amount minimum of" + minimumARS +"  or maximun"+ maximumARS + " to convert");
                  }
                  
                  break;
              case "EUR":
                  if(amountToWithdraw >=minimumEUR && amountToWithdraw<=maximumEUR) {
                      totalamount =eurToOther(amountToWithdraw, currencyToExchange) +(eurToOther(amountToWithdraw, currencyToExchange)*0.01);
                      JOptionPane.showMessageDialog(null, "The total amount you withdraw was: " + totalamount);
                  }else {
                      JOptionPane.showMessageDialog(null, "The operation can't be done due it overpass the amount minimum of" + minimumEUR +"  or maximun"+ maximumEUR + " to convert");
                  }
                  
                  break;
              case "GBP":
                  if(amountToWithdraw >=minimumGBP && amountToWithdraw<=maximumGBP) {
                      totalamount =gbpToOther(amountToWithdraw, currencyToExchange);
                  }else {
                      JOptionPane.showMessageDialog(null, "The operation can't be done due it overpass the amount minimum of" + minimumGBP +"  or maximun"+ maximumGBP + " to convert");
                  }
                  
                  break;
              case "TRY":
                  if(amountToWithdraw >=minimumTRY && amountToWithdraw<=maximumTRY) {
                      totalamount =tryToOther(amountToWithdraw, currencyToExchange) + (tryToOther(amountToWithdraw, currencyToExchange)*0.01);
                      JOptionPane.showMessageDialog(null, "The total amount you withdraw was: " + totalamount);
                  }else {
                      JOptionPane.showMessageDialog(null, "The operation can't be done due it overpass the amount minimum of" + minimumTRY +"  or maximun"+ maximumTRY + " to convert");
                  }
                  
                  break;
                  
          }
        }
        return false;
    }

    public static double dollarToOther(double amount, String exchangeCurrency) {
        double amountToReturn;
        switch(exchangeCurrency) {
        case "ARS":
             amountToReturn = amount * 808.47;
            return amountToReturn;
            
        case "CLP":
             amountToReturn = amount *888.94;
            return amountToReturn;
            
        case "EUR":
            amountToReturn = amount * 0.91;
            return amountToReturn;
        case "TRY":
            amountToReturn = amount * 29.81;
            return amountToReturn;
        case "GBP":
            amountToReturn= amount * 0.79;
            return amountToReturn;
            
        default:
            return 0.0;
        }
    }
    
    public static double clpToOther(double amount, String exchangeCurrency) {
        double amountToReturn;
        switch(exchangeCurrency) {
        case "ARS":
             amountToReturn = amount * 0.91;
            return amountToReturn;
            
        case "USD":
             amountToReturn = amount *0.0011;
            return amountToReturn;
            
        case "EUR":
            amountToReturn = amount * 0.0010;
            return amountToReturn;
        case "TRY":
            amountToReturn = amount * 0.033;
            return amountToReturn;
        case "GBP":
            amountToReturn= amount * 0.00088;
            return amountToReturn;
            
        default:
            return 0.0;
        }
    }
    
    public static double arsToOther(double amount, String exchangeCurrency) {
        double amountToReturn;
        switch(exchangeCurrency) {
        case "CLP":
             amountToReturn = amount * 1.10;
            return amountToReturn;
            
        case "USD":
             amountToReturn = amount * 0.0012;
            return amountToReturn;
            
        case "EUR":
            amountToReturn = amount * 0.0011;
            return amountToReturn;
        case "TRY":
            amountToReturn = amount * 0.037;
            return amountToReturn;
        case "GBP":
            amountToReturn= amount * 0.00097;
            return amountToReturn;
            
        default:
            return 0.0;
        }
    }
    
    public static double eurToOther(double amount, String exchangeCurrency) {
        double amountToReturn;
        switch(exchangeCurrency) {
        case "CLP":
             amountToReturn = amount * 973.04;
            return amountToReturn;
            
        case "USD":
             amountToReturn = amount * 1.09;
            return amountToReturn;
            
        case "ARS":
            amountToReturn = amount * 884.95;
            return amountToReturn;
        case "TRY":
            amountToReturn = amount * 32.70;
            return amountToReturn;
        case "GBP":
            amountToReturn= amount * 0.86;
            return amountToReturn;
            
        default:
            return 0.0;
        }
    }
    
    public static double gbpToOther(double amount, String exchangeCurrency) {
        double amountToReturn;
        switch(exchangeCurrency) {
        case "CLP":
             amountToReturn = amount * 1131.18;
            return amountToReturn;
            
        case "USD":
             amountToReturn = amount * 1.27;
            return amountToReturn;
            
        case "ARS":
            amountToReturn = amount * 1028.78;
            return amountToReturn;
        case "TRY":
            amountToReturn = amount * 37.98;
            return amountToReturn;
        case "EUR":
            amountToReturn= amount * 1.16;
            return amountToReturn;
            
        default:
            return 0.0;
        }
    }
    public static double tryToOther(double amount, String exchangeCurrency) {
        double amountToReturn;
        switch(exchangeCurrency) {
        case "CLP":
             amountToReturn = amount * 29.78;
            return amountToReturn;
            
        case "USD":
             amountToReturn = amount * 0.034;
            return amountToReturn;
            
        case "ARS":
            amountToReturn = amount * 27.09;
            return amountToReturn;
        case "GBP":
            amountToReturn = amount * 0.026;
            return amountToReturn;
        case "EUR":
            amountToReturn= amount * 0.031;
            return amountToReturn;
            
        default:
            return 0.0;
        }
    }
    
    
}
