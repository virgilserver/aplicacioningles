/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilerias;

import alumno.listaDeAlumnos;
import ciclosEscolares.agregarCicloEscolar;

import examen.VentanaAgregarFechaExam;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import ventanas.ventanaPrincipal;

/**
 *
 * @author Luis
 */
public class WindowHandler extends WindowAdapter{
   
    
    String nombreVentana= null;

    public WindowHandler(VentanaAgregarFechaExam aThis) {
        System.out.println("la ventana es VentanaAgregarFechaExamLi "); 
        nombreVentana = "vafel";
    }


    
 
   
    public WindowHandler (agregarCicloEscolar aThis){
        nombreVentana="ace";
    }
    
    public void windowClosing(WindowEvent e) {
      System.out.println("closing");
      
        switch (nombreVentana ) {
        
               
           case "eal": 
               
               break; 
               
     
           case "ace":
               ventanaPrincipal.ace=null;
               break;
            default:
                throw new AssertionError();
        }
       
      
    }
}
