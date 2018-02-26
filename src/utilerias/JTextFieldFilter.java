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
/**
 *
 * @author Luis
 */
public class  JTextFieldFilter extends PlainDocument {

  public int limit;  
  public static final String ALPHA = "abcdefghijklmnopqrstuñvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
  public static final String ALPHANS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String ALPHAD = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/.-# ";
  public static final String ALPHADOT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ. ";
  public static final String NUMERIC = "0123456789";
  public static final String ncontrol = "EDMAXedmxa0123456789";
  public static final String NUMERICFLOAT = "0123456789.";
  public static final String ALPHA_NUMERIC = ALPHAD + NUMERIC;
  public static final String ALPHA_NUMERICONLY = ALPHA+NUMERIC;
  public static final String ALPHA_NUMERICNS = ALPHANS+NUMERIC;
  public static final String afiliacionimms = NUMERIC + "-";
  public static final String direccinoestado = ALPHA + NUMERICFLOAT+",-";
  public static final String rfc = ALPHANS + NUMERIC + "-";
  protected String acceptedChars = null;
  

  protected boolean negativeAccepted = false;

  public JTextFieldFilter() {
    this(ALPHA_NUMERIC,99);
  }

  public JTextFieldFilter(String acceptedchars,int limite) {
    acceptedChars = acceptedchars;
    limit = limite;
   
  }

  public void setNegativeAccepted(boolean negativeaccepted) {
    if (acceptedChars.equals(ALPHA_NUMERIC)) {
      negativeAccepted = negativeaccepted;
      acceptedChars += "-";
    }
  }

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