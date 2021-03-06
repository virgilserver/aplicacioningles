/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sql.ConexionSQLServer;
import utilerias.mensajesEnPantalla;

/**
 *
 * @author Luis
 */
public class ListaDeProfesoresCarrera extends javax.swing.JPanel {

    public static VentanaEmergenteMaestrosCarrera vemc;
    public TreeMap<String, Integer> idMaestros;
    private TableRowSorter trsfiltro;
    String stringSearch = "";

    public ListaDeProfesoresCarrera() {
        initComponents();
        this.setVisible(true);
        llenartabla();
        aplicarFiltro();
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
        jTableMaestrosCarrera = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        TFBuscar = new javax.swing.JTextField();
        botonLupita1 = new javax.swing.JButton();

        jTableMaestrosCarrera.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMaestrosCarrera);

        jLabel1.setText("Buscar:");

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        TFBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFBuscarActionPerformed(evt);
            }
        });
        TFBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFBuscarKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBuscarKeyReleased(evt);
            }
        });

        botonLupita1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconlupita.png"))); // NOI18N
        botonLupita1.setBorder(null);
        botonLupita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLupita1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAgregar)
                        .addGap(35, 35, 35)
                        .addComponent(botonEditar)
                        .addGap(41, 41, 41)
                        .addComponent(botonEliminar)
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonLupita1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(botonLupita1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonEditar)
                    .addComponent(botonEliminar))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBuscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TFBuscarActionPerformed

    private void botonLupita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLupita1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLupita1ActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        vemc = new VentanaEmergenteMaestrosCarrera(this);

    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        // TODO add your handling code here:
        int fila = jTableMaestrosCarrera.getSelectedRow();
        if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun maestro de la tabla", "Error");
        } else {
            String RFC = (String) jTableMaestrosCarrera.getValueAt(fila, 0);
            int id = idMaestros.get(RFC);

            vemc = new VentanaEmergenteMaestrosCarrera(this, id);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jTableMaestrosCarrera.getSelectedRow();
        if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun maestro de la tabla", "Error");
        } else {
            String RFC = (String) jTableMaestrosCarrera.getValueAt(fila, 0);
            String nombre = (String) jTableMaestrosCarrera.getValueAt(fila, 1);
            int id = idMaestros.get(RFC);
            if (mensajesEnPantalla.mensajePregunta("Esta seguro de elminar al profesor " + nombre.trim() + " con el rfc " + RFC.trim(), "Advertencia") == 0) {

                if (ConexionSQLServer.eliminarMaestroCarrera(id)) {
                    mensajesEnPantalla.mensajeExitoso("El profesor seleccionado a sido eliminado correctamente", "Eliminado");
                    llenartabla();
                }
            }
        }

    }//GEN-LAST:event_botonEliminarActionPerformed

    private void TFBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyTyped
        // TODO add your handling code here:
              String cadena = String.valueOf(evt.getKeyChar());
                 int n = evt.getKeyChar();
                 
                 
                if (n == 8 && stringSearch.length() > 0) {
              stringSearch = stringSearch.substring(0, stringSearch.length() - 1);
                   
        }else{
                    
                    if (n!=8) {
                          stringSearch += cadena;
                    }
      
                
                }
        System.out.println(stringSearch);
    }//GEN-LAST:event_TFBuscarKeyTyped

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        // TODO add your handling code here:
        
          TFBuscar.setText(TFBuscar.getText().toUpperCase());
        
        
        
        if (stringSearch.length() > 1 ) {
                     char caracter =  TFBuscar.getText().charAt(1);
          String letra = "" + caracter;
            if (isNumeric(letra)) {
                System.out.println("es numeor de contorl");
               
            }else{
                System.out.println("nombre");
              
            }
           
        }
        filtro();
    }//GEN-LAST:event_TFBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLupita1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableMaestrosCarrera;
    // End of variables declaration//GEN-END:variables

    public void llenartabla() {

        DefaultTableModel modelo = ConexionSQLServer.consultaToJtable("Select * from vista_ProfesorCarreras");
        jTableMaestrosCarrera.setModel(modelo);
        setVisible(true);
        llenarTreeMap();

    }

    public void llenarTreeMap() {
        try {
            idMaestros = new TreeMap<>();
            ResultSet rs = ConexionSQLServer.vistaIdMaestrosCarrera();

            while (rs.next()) {

                int id = rs.getInt(1);

                String RFC = rs.getString(2);
                idMaestros.put(RFC, id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaDeProfesoresCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      public void filtro(){
           trsfiltro.setRowFilter(RowFilter.regexFilter(TFBuscar.getText(), 1));
    }
     
    public boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public void aplicarFiltro(){
        trsfiltro = new TableRowSorter(jTableMaestrosCarrera.getModel());
        jTableMaestrosCarrera.setRowSorter(trsfiltro);
    }
}
