/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilerias;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class filtroNumeroDeControl extends PlainDocument {

  public int limit;  
 
  public static final String  ncontrol = "EDMedm0123456789";
  


  protected String acceptedChars = null;
  

  protected boolean negativeAccepted = false;


  public filtroNumeroDeControl(String acceptedchars,int limite) {
    acceptedChars = acceptedchars;
    limit = limite;
   
  }

  public void setNegativeAccepted(boolean negativeaccepted) {
    if (acceptedChars.equals(ncontrol)) {
      negativeAccepted = negativeaccepted;
      acceptedChars += "-";
    }
  }

  @Override
  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;
    
  
       
       
    for (int i = 0; i < str.length(); i++) {
      if (acceptedChars.indexOf(str.valueOf(str.charAt(i))) == -1)
        return;
    }

    if (negativeAccepted) {
      if (str.indexOf(".") != -1) {
        if (getText(0, getLength()).indexOf(".") != -1) {
          return;
        }
      }
    }

       if (negativeAccepted) {
      if ((str.indexOf("E") != -1) || (str.indexOf("M" ) != -1) || (str.indexOf("D") != -1) || (str.indexOf("m" ) != -1)  || (str.indexOf("d" ) != -1) || (str.indexOf("e" ) != -1)  ) {
        if ((getText(0, getLength()).indexOf("E") != -1) || (getText(0, getLength()).indexOf("M") != -1) || (getText(0, getLength()).indexOf("D") != -1) || (getText(0, getLength()).indexOf("e") != -1 || (getText(0, getLength()).indexOf("d") != -1) || (getText(0, getLength()).indexOf("m") != -1))    ) {
          return;
        }
      }
    }

    if (negativeAccepted && str.indexOf("-") != -1) {
      if (str.indexOf("-") != 0 || offset != 0) {
        return;
      }
    }
    
    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
    
 

  //  super.insertString(offset, str, attr);
  }
}