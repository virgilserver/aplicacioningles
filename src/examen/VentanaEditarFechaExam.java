/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import sql.ConexionSQLServer;
import utilerias.mensajesEnPantalla;

/**
 *
 * @author Luis
 */
public class VentanaEditarFechaExam extends javax.swing.JFrame {

    TreeMap<String, Integer> idFechas;
    String entrada;

    /**
     * Creates new form VentanaEditarFechaExam
     */
    public VentanaEditarFechaExam(String entrada) {
        initComponents();
        llenarCombo();
        setVisible(true); 
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.entrada = entrada;
        this.jButton1.setText(entrada);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboFechaExam = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha anterior");

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboFechaExam, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboFechaExam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String fecha = comboFechaExam.getSelectedItem().toString();
        int idFecha = idFechas.get(fecha);
        switch (entrada) {
            case "Editar":
                new VentanaAgregarFechaExam(idFecha, fecha);
                this.dispose();
                break;
            case "Eliminar":
                
                if (ConexionSQLServer.eliminarFechaExamen(idFecha)) {
                    mensajesEnPantalla.mensajeExitoso("La fecha de examen se a eliminado correctamente", "Eliminado");
                    this.dispose();
                }
                break;
            default:
                throw new AssertionError();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFechaExam;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {

        try {
            idFechas = new TreeMap<>();
            ResultSet rs = ConexionSQLServer.vistaFechasExamenes();

            while (rs.next()) {
                String fecha = rs.getDate(2).toString();
                int idfecha = rs.getInt(1);
                idFechas.put(fecha, idfecha);
                this.comboFechaExam.addItem(fecha);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentanaEditarFechaExam.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        comboFechaExam.setRenderer(dlcr);

    }
}
