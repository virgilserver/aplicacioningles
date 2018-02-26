/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sql.ConexionSQLServer;
import utilerias.mensajesEnPantalla;

/**
 *
 * @author Luis
 */
public class panelExamenColocacion extends javax.swing.JPanel {
    ArrayList<Integer> idExamenesColocacion;
    TreeMap<String, Integer >idExamenCol; 
    /**
     * Creates new form panelExamenColocacion
     */
    public panelExamenColocacion() {
        initComponents();
        llenarTabla();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaExamenesColocacion = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LabelCantidad = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        tablaExamenesColocacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaExamenesColocacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaExamenesColocacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaExamenesColocacionMouseClicked(evt);
            }
        });
        tablaExamenesColocacion.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tablaExamenesColocacionComponentMoved(evt);
            }
        });
        tablaExamenesColocacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaExamenesColocacionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaExamenesColocacion);

        jButton1.setText("Registrar Examen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Administrar Examen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Asignar Niveles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total de alumnos:");

        LabelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCantidad.setText("0");

        jButton4.setText("Eliminar Examen");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LabelCantidad))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ventanaRegistrarExamenColocacion(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int fila = tablaExamenesColocacion.getSelectedRow();
       if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun examen", "Error");
        } else {
      
        int id = idExamenesColocacion.get(fila);
        String nomMaestro = (String) tablaExamenesColocacion.getValueAt(fila, 0);
        String salon = (String) tablaExamenesColocacion.getValueAt(fila, 1);
        String fecha = tablaExamenesColocacion.getValueAt(fila, 2).toString();
        String hora = tablaExamenesColocacion.getValueAt(fila, 3).toString();
        new VentanaAdmnExamenColocacion(id, nomMaestro, fecha, hora, salon);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       int fila = tablaExamenesColocacion.getSelectedRow();
       if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun examen", "Error");
        } else {
        //String clave =  (String) tablaExamenesColocacion.getValueAt(fila, 0);
        int id = idExamenesColocacion.get(fila);
        String nomMaestro = (String) tablaExamenesColocacion.getValueAt(fila, 0);
        String salon = (String) tablaExamenesColocacion.getValueAt(fila, 1);
        String fecha = tablaExamenesColocacion.getValueAt(fila, 2).toString();
        String hora = tablaExamenesColocacion.getValueAt(fila, 3).toString();
        new VentanaAsignarNivelExamenColocacion(id, nomMaestro, fecha, hora, salon);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaExamenesColocacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaExamenesColocacionMouseClicked
        // TODO add your handling code here:
        
        
          int pos = tablaExamenesColocacion.getSelectedRow();
          System.out.println("");
        int clave = idExamenesColocacion.get(pos);
        System.out.println("clave" +clave);
        LabelCantidad.setText(String.valueOf(ConexionSQLServer.totalAlumnosExamenColocacion(clave)));
    }//GEN-LAST:event_tablaExamenesColocacionMouseClicked

    private void tablaExamenesColocacionComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaExamenesColocacionComponentMoved
      
    }//GEN-LAST:event_tablaExamenesColocacionComponentMoved

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          int fila = tablaExamenesColocacion.getSelectedRow();
       if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun examen", "Error");
        } else {
        int i = mensajesEnPantalla.mensajePregunta("Esta seguro que desea eliminar el examen seleccionado,esto conlleva a la eliminacion de los alumnos asignados a este examen al igual que sus calificaciones", "Eliminar");

            
          
       int clave = idExamenesColocacion.get(fila);
       
       
           if (i == 0) {
                if (ConexionSQLServer.eliminarExamenColocacion(clave)) {
                  mensajesEnPantalla.mensajeExitoso("Examen de Colocacion Eliminado Correctamente", "Eliminado");
                    llenarTabla();
           }
           }
          
       
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaExamenesColocacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaExamenesColocacionKeyReleased
        // TODO add your handling code here:
          int pos = tablaExamenesColocacion.getSelectedRow();
          System.out.println("");
        int clave = idExamenesColocacion.get(pos);
        System.out.println("clave" +clave);
        LabelCantidad.setText(String.valueOf(ConexionSQLServer.totalAlumnosExamenColocacion(clave)));
    }//GEN-LAST:event_tablaExamenesColocacionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCantidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaExamenesColocacion;
    // End of variables declaration//GEN-END:variables

    public void llenarTabla() {
        DefaultTableModel modelo = ConexionSQLServer.consultaToJtable("select * from vista_ExamenesColocacion");
        
        tablaExamenesColocacion.setModel(modelo);


        tablaExamenesColocacion.getColumnModel().getColumn(0).setPreferredWidth(400);
                tablaExamenesColocacion.getColumnModel().getColumn(0).setResizable(false);
    
                
        tablaExamenesColocacion.getColumnModel().getColumn(1).setPreferredWidth(100);
                tablaExamenesColocacion.getColumnModel().getColumn(1).setResizable(false);
     
                
                
        tablaExamenesColocacion.getColumnModel().getColumn(2).setPreferredWidth(174);
                tablaExamenesColocacion.getColumnModel().getColumn(2).setResizable(false);
     
                
        tablaExamenesColocacion.getColumnModel().getColumn(3).setPreferredWidth(180);
                tablaExamenesColocacion.getColumnModel().getColumn(3).setResizable(false);
     
                
       // tablaExamenesColocacion.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tablaExamenesColocacion.getTableHeader().setReorderingAllowed(false);
     
        //llenarTreeMap();
        llenarArraylist();
        this.setVisible(true);
    }

//    private void llenarTreeMap() {
//        try {
//            idExamenCol = new TreeMap<>();
//            ResultSet rs = ConexionSQLServer.vistaIdExamenesColocacion();
//            
//            while (rs.next()) {
//               
//             int id = rs.getInt(1);
//             String clave = rs.getString(2);
//                     System.out.println("clave piano " + clave + " id pls " + id);
//             idExamenCol.put(clave.trim(), id);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(panelExamenColocacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }

 public void llenarArraylist() {
        
        try {
            idExamenesColocacion = new ArrayList<>();
            
            ResultSet rs = ConexionSQLServer.vistaIdExamenesColocacio();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("id ++++"+id);
                idExamenesColocacion.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelExamenColocacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
}