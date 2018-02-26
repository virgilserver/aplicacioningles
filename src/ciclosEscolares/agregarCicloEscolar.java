/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ciclosEscolares;

import java.awt.Dimension;
import java.awt.Toolkit;
import sql.ConexionSQLServer;
import utilerias.WindowHandler;
import utilerias.mensajesEnPantalla;
import ventanas.Login;
import ventanas.ventanaPrincipal;

/**
 *
 * @author Luis
 */
public class agregarCicloEscolar extends javax.swing.JFrame {
    Login l = null;

    /**
     * Creates new form agregarCicloEscolar
     */
    public agregarCicloEscolar() {
        initComponents();
        addYearsToCombobox();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
    }

    public agregarCicloEscolar(Login l) {

        initComponents();
        addYearsToCombobox();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        this.l = l;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboMeses = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        comboAno = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonCan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboMeses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENERO-MARZO", "ENERO-JUNIO", "ABRIL-JUNIO", "AGOSTO-SEPTIEMBRE", "AGOSTO-DICIEMBRE", "OCTUBRE-DICIEMBRE", "VERANO", " " }));

        jLabel1.setText("Periodo");

        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Año");

        jButton1.setText("Resgistrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("/");

        botonCan.setText("Cancelar");
        botonCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1))
                            .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonCan)
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jLabel2)
                            .addGap(67, 67, 67))
                        .addComponent(comboAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(botonCan))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ciclo = (String) comboMeses.getSelectedItem();
        String ano = String.valueOf(comboAno.getSelectedItem());
        String ano2, idCicloEscolar;
        if (ciclo.equals("VERANO")) {
            String ciclo2 = ciclo.substring(0, 2);

            ano2 = ano.substring(2);
            idCicloEscolar = ciclo2 + ano2;
            System.out.println(idCicloEscolar);
        } else {
            ano2 = ano.substring(2);
            String[] meses = ciclo.split("-");
            String mes1 = meses[0].substring(0, 1);
            String mes2 = meses[1].substring(0, 1);
            idCicloEscolar = mes1 + mes2 + ano2;
            System.out.println(idCicloEscolar);

        }

        String periodo = ciclo + "/" + ano;
        System.out.println("Ciclo: " + periodo);

        if (this.l != null) {
            if (ConexionSQLServer.registroRapidoCicloEscolar(idCicloEscolar, periodo)) {
                mensajesEnPantalla.mensajeExitoso("El Ciclo Escolar se ha registrado correctamente", "Registro");
                dispose();
                l.comboCiclos();
                l.setVisible(true);

            }

        } else {
            if (ConexionSQLServer.registrarCicloEscolar(idCicloEscolar, periodo)) {
                mensajesEnPantalla.mensajeExitoso("El Ciclo Escolar se ha registrado correctamente", "Registro");
                dispose();

                ventanaPrincipal.ace = null;
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCanActionPerformed
        // TODO add your handling code here:
        dispose();
        ventanaPrincipal.ace = null;
    }//GEN-LAST:event_botonCanActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(agregarCicloEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(agregarCicloEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(agregarCicloEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(agregarCicloEscolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new agregarCicloEscolar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCan;
    private javax.swing.JComboBox comboAno;
    private javax.swing.JComboBox comboMeses;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void addYearsToCombobox() {
        for (int i = 2013; i <= 2099; i++) {
            this.comboAno.addItem(i);
        }
    }
}
