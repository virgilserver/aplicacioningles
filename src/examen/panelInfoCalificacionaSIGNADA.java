/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen;

import sql.ConexionSQLServer;
import utilerias.JTextFieldFilter;

/**
 *
 * @author Luis
 */
public class panelInfoCalificacionaSIGNADA extends javax.swing.JPanel {

    int idExamen, idAlumno;

    /**
     * Creates new form panelInfoCalificacionaSIGNADAaci
     */
    public panelInfoCalificacionaSIGNADA(String nombre, String numeroControl, String calificacion, int idExamen, int idAlumno) {
        
        System.out.println("calificion "+calificacion);
               initComponents();
        formatFIeld();
        this.idAlumno = idAlumno;
        this.idExamen = idExamen;
 
        llenarInformacion(nombre, numeroControl, calificacion);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        labelNControl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldCalificacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        comboCalifiacion = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelNombre.setText("jLabel1");

        labelNControl.setText("jLabel2");

        jLabel3.setText("Calificacion");

        fieldCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCalificacionActionPerformed(evt);
            }
        });
        fieldCalificacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fieldCalificacionPropertyChange(evt);
            }
        });
        fieldCalificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCalificacionKeyTyped(evt);
            }
        });

        jButton1.setText("ASIGNAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboCalifiacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin Asignar", "NA" }));
        comboCalifiacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCalifiacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelNControl, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(comboCalifiacion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(labelNControl)
                    .addComponent(jLabel3)
                    .addComponent(fieldCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCalifiacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboCalifiacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCalifiacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCalifiacionActionPerformed

    private void fieldCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCalificacionActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_fieldCalificacionActionPerformed

    private void fieldCalificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCalificacionKeyTyped
        // TODO add your handling code here:
         if (fieldCalificacion.getText().isEmpty()) {
             this.comboCalifiacion.setEnabled(true);
        }
        else{
          
             this.comboCalifiacion.setEnabled(false);
             
        }
    }//GEN-LAST:event_fieldCalificacionKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String calificacion;
        
        
        
        
        if (fieldCalificacion.getText().isEmpty()) {
            calificacion = comboCalifiacion.getSelectedItem().toString();
        }else{
            calificacion = fieldCalificacion.getText();
            
        }
        
        
        
        
        ConexionSQLServer.asignarCalificacionExamenLiberacion(idAlumno, calificacion, idExamen);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldCalificacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fieldCalificacionPropertyChange
        // TODO add your handling code here:
          String calificacion;
      if (fieldCalificacion.getText().isEmpty()) {
            calificacion = comboCalifiacion.getSelectedItem().toString();
        }else{
            calificacion = fieldCalificacion.getText();
            
        }   
        
    }//GEN-LAST:event_fieldCalificacionPropertyChange

    
    public void asignar(){
        String calificacion;
        
        
        
        
        if (fieldCalificacion.getText().isEmpty()) {
            calificacion = comboCalifiacion.getSelectedItem().toString();
        }else{
            calificacion = fieldCalificacion.getText();
            
        }
        
        
        
        
        ConexionSQLServer.asignarCalificacionExamenLiberacion(idAlumno, calificacion, idExamen);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCalifiacion;
    private javax.swing.JTextField fieldCalificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelNControl;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables

    private void llenarInformacion(String nombre, String nContorl, String calificacion) {
        labelNombre.setText(nombre);
        labelNControl.setText(nContorl);
        
        if (calificacion.trim().equals("NA") || calificacion.trim().equals("Sin Asignar")) {
            comboCalifiacion.setSelectedItem(calificacion);
        } else {
           // fieldCalificacion.setText("90");
            fieldCalificacion.setText(calificacion.trim());
            this.comboCalifiacion.setEnabled(false);
        }
        
    }

    private void formatFIeld() {
        JTextFieldFilter tf = new JTextFieldFilter(JTextFieldFilter.NUMERIC,3);
        tf.setNegativeAccepted(true);
        this.fieldCalificacion.setDocument(tf);
    
    
    }
    
}
