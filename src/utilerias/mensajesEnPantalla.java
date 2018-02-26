/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilerias;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public final class mensajesEnPantalla {
     static int dialogResult;
    public final static ImageIcon iconop = new ImageIcon("/Users/Luis/NetBeansProjects/ProyectoIngles/src/imagenes/iconoPalomita.png");
     public final static ImageIcon iconot = new ImageIcon("/Users/Luis/NetBeansProjects/ProyectoIngles/src/imagenes/iconoTachita.png");
   
     public static void mensajeExitoso(String mensaje,String titulo){
        
        
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE, iconop);
    }
    
    public static void mensajeErrorSQL(int codigo){
        JOptionPane.showMessageDialog(null, erroresSQL.returnErrorSQL(codigo), "ERROR", JOptionPane.INFORMATION_MESSAGE, iconot);
    }
    
    
    
    public static  int mensajePregunta(String mensaje,String titulo){
        
        
        dialogResult = JOptionPane.showConfirmDialog(null, mensaje, titulo,JOptionPane.OK_CANCEL_OPTION);
        return dialogResult;
    }
    
    public static void mensajeError(String mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public static void mensajeErrorSQL2(int codigo, String ciclo_Escolar) {
          JOptionPane.showMessageDialog(null, erroresSQL.returnErrorSQL2(codigo,ciclo_Escolar), "ERROR", JOptionPane.INFORMATION_MESSAGE, iconot);
    }
}
