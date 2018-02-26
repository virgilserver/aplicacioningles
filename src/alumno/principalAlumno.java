/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import utilerias.JTextFieldFilter;
import utilerias.mensajesEnPantalla;
import ventanas.ventanaPrincipal;

/**
 *
 * @author Luis
 */
public class principalAlumno extends javax.swing.JPanel  {

    TreeMap<String, String> carreras = null;
    listaDeAlumnos LA = new listaDeAlumnos();
    AgregarAlumno AGA ;
    boolean externo =false;
    int indice=0;

    /**
     * Creates new form panelPrincipal
     */
    public principalAlumno() {

        initComponents();   
        principalAlumno.jTabbedPane1.addTab("Lista de Alumno", LA);
        principalAlumno.jTabbedPane1.addTab("Resgitrar Alumno", AGA =new AgregarAlumno(LA));
        LA.setAGA(AGA);
    
        this.setVisible(true);
     
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane(){

            @Override
            public void setSelectedIndex(int newIndex)
            {
                int respuesta=0;
                if(indice==1){
                    if(AGA != null){
                        switch (AGA.entrada){
                            case "Agregar":
                            respuesta= mensajesEnPantalla.mensajePregunta("Si sale de esta ventana se borraran todos los campos ¿Salir sin agregar?", "Advertencia");

                            break;
                            case "Editar":
                            respuesta= mensajesEnPantalla.mensajePregunta("Si sale de esta ventana no se guardaran los cambios  ¿Salir sin editar?", "Advertencia");

                            break;

                            case "Cambiar":
                            break;

                            default:
                            System.out.println("error");
                        }
                        if (respuesta==2){
                            return ;

                        }

                    }
                }
                super.setSelectedIndex(newIndex);
            }

        }
        ;

        setPreferredSize(new java.awt.Dimension(700, 480));

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
    //    ventanaPrincipal.cerrarVentanasHijas();
         
        if (indice == 1) {
          
            AGA.borrarTextFields();
        }
        
        
        indice=jTabbedPane1.getSelectedIndex();
        if (AGA != null) {
            AGA.setEntrada("Agregar");
            AGA.agregarAlumnoBoton.setText("Agregar");
        }

    }//GEN-LAST:event_jTabbedPane1StateChanged

    
    public void llenarCamposParaEdicion(){
         
    }
    
    
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}