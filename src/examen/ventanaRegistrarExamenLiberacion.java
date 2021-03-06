/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import sql.ConexionSQLServer;
import utilerias.mensajesEnPantalla;

/**
 *
 * @author Luis
 */
public class ventanaRegistrarExamenLiberacion extends javax.swing.JFrame {
  panelExamenLiberacion p ;
    TreeMap<String, Integer> idMaestros, idSalones, idFechas, idMaestrosCarreras;
    TreeMap<String, String> carrerasMaestrosCarreras,clavesCarreras;

    /**
     * Creates new form ventanaRegistrarExamenLiberacion
     */
    public ventanaRegistrarExamenLiberacion(panelExamenLiberacion aThis) {
        p = aThis;
        initComponents();
        llenarComboBox();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
       this.setResizable(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinnerHora = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        spinnerMinutos = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboSalones = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboMaestros = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboMaestrosCarreras = new javax.swing.JComboBox();
        labelCarreraMaestroCarrera = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha de Examen:");

        jLabel2.setText("Hora de Examen");

        spinnerHora.setModel(new javax.swing.SpinnerNumberModel(12, 7, 20, 1));

        jLabel3.setText("Hora");

        spinnerMinutos.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "30"}));

        jLabel4.setText("Minutos");

        jLabel5.setText("Salon de Examen:");

        jLabel6.setText("Maestro de Idioma:");

        comboMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMaestrosActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Maestro de Carrera:");

        comboMaestrosCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMaestrosCarrerasActionPerformed(evt);
            }
        });

        labelCarreraMaestroCarrera.setText("Carrera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1))
                    .addComponent(comboMaestros, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(11, 11, 11)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelCarreraMaestroCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMaestrosCarreras, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboSalones, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(comboSalones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboMaestrosCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCarreraMaestroCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String hora = spinnerHora.getModel().getValue().toString() + ":" + spinnerMinutos.getModel().getValue().toString() + ":00";
        System.out.println("hora: " + hora);
        Time time = java.sql.Time.valueOf(hora);
        System.out.println(time.getTime());
        String hr = spinnerHora.getModel().getValue().toString();
        Date fecha = jDateChooser1.getDate();
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        String maestro = comboMaestros.getSelectedItem().toString();
        int idmaestro = idMaestros.get(maestro);
        String maestrocarrera = comboMaestrosCarreras.getSelectedItem().toString();
        int idMaestroCarrera = idMaestrosCarreras.get(maestrocarrera);
        System.out.println("id maestro = " + idmaestro);
        String clavecarrera = clavesCarreras.get(labelCarreraMaestroCarrera.getText());

        String salon = comboSalones.getSelectedItem().toString();
        int idsalon = idSalones.get(salon);
        if (hr.length() == 1) {
            hr = 0 + hr;
        }

        String clave = salon.trim() + fecha2.toString().trim().replaceAll("-", "") + hr + spinnerMinutos.getModel().getValue().toString().charAt(0) + clavecarrera;

        System.out.println("claVE IMPRIMIDA"+ clave);
        
        if (  ConexionSQLServer.inserExamenLiberacion( fecha2, idmaestro, idsalon, time, clave, idMaestroCarrera)) {
            mensajesEnPantalla.mensajeExitoso("Examen de liberacion registrado correctmente", "Registro");
            p.llenarTabla();
        this.dispose();
        }
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void comboMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMaestrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMaestrosActionPerformed

    private void comboMaestrosCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMaestrosCarrerasActionPerformed
        // TODO add your handling code here:
        labelCarreraMaestroCarrera.setText(carrerasMaestrosCarreras.get(comboMaestrosCarreras.getSelectedItem().toString()));
        
    }//GEN-LAST:event_comboMaestrosCarrerasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboMaestros;
    private javax.swing.JComboBox comboMaestrosCarreras;
    private javax.swing.JComboBox comboSalones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelCarreraMaestroCarrera;
    private javax.swing.JSpinner spinnerHora;
    private javax.swing.JSpinner spinnerMinutos;
    // End of variables declaration//GEN-END:variables

    private void llenarComboBox() {
        idSalones = new TreeMap<>();
        idMaestros =  new TreeMap<>();
        idFechas = new TreeMap<>();
        idMaestrosCarreras = new TreeMap<>();
        carrerasMaestrosCarreras = new TreeMap<>();
        clavesCarreras = new TreeMap<>();
        ResultSet rs;
        try {
        rs   = ConexionSQLServer.vistaIdSalon();
            
            
            while (rs.next()) {
                String nombreSalon = rs.getString(1);
                int idSalon = rs.getInt(2);
                idSalones.put(nombreSalon, idSalon);
                comboSalones.addItem(nombreSalon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventanaRegistrarExamenLiberacion.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
    
   
        try {
        rs   = ConexionSQLServer.vistaNombreMaIdioma();
            
            
            while (rs.next()) {
                String nombreMaestro = rs.getString(2);
                int idMaestro = rs.getInt(1);
                idMaestros.put(nombreMaestro,idMaestro );
                comboMaestros.addItem(nombreMaestro.trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventanaRegistrarExamenLiberacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        try {
        rs   = ConexionSQLServer.vistaNombreMaestroCarrera();
            
            
            while (rs.next()) {
                String nombreMaestro = rs.getString(2);
                int idMaestro = rs.getInt(1);
                String carrera = rs.getString(3);
                idMaestrosCarreras.put(nombreMaestro,idMaestro );
                carrerasMaestrosCarreras.put(nombreMaestro, carrera);
                comboMaestrosCarreras.addItem(nombreMaestro.trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventanaRegistrarExamenLiberacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {
        rs   = ConexionSQLServer.vistaClavesCarreras();
            
            
            while (rs.next()) {
                String nombreCarrrera = rs.getString(1);
                
                String claveCarrera = rs.getString(2);
                clavesCarreras.put(nombreCarrrera, claveCarrera);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ventanaRegistrarExamenLiberacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
}
