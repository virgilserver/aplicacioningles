/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupos;

import profesores.*;
import alumno.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sql.ConexionSQLServer;
import utilerias.JTextFieldFilter;
import utilerias.mensajesEnPantalla;
import ventanas.ventanaPrincipal;

/**
 *
 * @author Luis
 */
public class ListaDeGrupos extends javax.swing.JPanel {

 
    public static ArrayList<String> clavesGrupos = null;
    private TableRowSorter trsfiltro;
    /**
     * Creates new form panelPrincipal
     */
    public ListaDeGrupos() {
        System.out.println("me creo");
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
        tablaGrupos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        TFBuscar = new javax.swing.JTextField();
        botonLupita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelTotalAlumnos = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(850, 600));

        tablaGrupos.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        tablaGrupos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaGrupos.setToolTipText("");
        tablaGrupos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablaGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGruposMouseClicked(evt);
            }
        });
        tablaGrupos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaGruposPropertyChange(evt);
            }
        });
        tablaGrupos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaGruposKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaGruposKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGrupos);

        jButton1.setText("Administrar grupo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        botonLupita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconlupita.png"))); // NOI18N
        botonLupita.setBorder(null);
        botonLupita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLupitaActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        jButton2.setText("Calificaciones grupo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Total de Alumnos:");

        labelTotalAlumnos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotalAlumnos.setText("0");

        jButton3.setText("Eliminar grupo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar grupo");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(labelTotalAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonLupita, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(labelTotalAlumnos))
                    .addComponent(botonLupita, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila = tablaGrupos.getSelectedRow();
        if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun grupo de la tabla", "Error");
        } else {

            int indices = tablaGrupos.getSelectedRow();
            String clave = clavesGrupos.get(indices).trim();
            String horai = tablaGrupos.getValueAt(indices, 3).toString();
            String horaf = tablaGrupos.getValueAt(indices, 4).toString();
            String salon = tablaGrupos.getValueAt(indices, 1).toString();
            String maestro = tablaGrupos.getValueAt(indices, 0).toString();
            String idioma = tablaGrupos.getValueAt(indices, 5).toString();

            new VentanaAdmnGRUPO(clave, horai, horaf, salon, maestro, idioma);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBuscarActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_TFBuscarActionPerformed

    private void botonLupitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLupitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLupitaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila = tablaGrupos.getSelectedRow();
        if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun grupo de la tabla", "Error");
        } else {
            int indices = tablaGrupos.getSelectedRow();
            String clave = clavesGrupos.get(indices).trim();
            String horai = tablaGrupos.getValueAt(indices, 3).toString();
            String horaf = tablaGrupos.getValueAt(indices, 4).toString();
            String salon = tablaGrupos.getValueAt(indices, 1).toString();
            String maestro = tablaGrupos.getValueAt(indices, 0).toString();
            String idioma = tablaGrupos.getValueAt(indices, 5).toString();

            new ventanaAsignarCalificacionGrupo(clave, salon, horai, horaf, maestro);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGruposMouseClicked
        // TODO add your handling code here:
        String clave = clavesGrupos.get(tablaGrupos.getSelectedRow());
        int total = ConexionSQLServer.totalAlumnosByGrupo(clave.trim());
        System.out.println("total " + total);
        labelTotalAlumnos.setText(String.valueOf(total));

    }//GEN-LAST:event_tablaGruposMouseClicked

    private void tablaGruposPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaGruposPropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_tablaGruposPropertyChange

    private void tablaGruposKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaGruposKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tablaGruposKeyPressed

    private void tablaGruposKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaGruposKeyReleased
        // TODO add your handling code here:
        int i = tablaGrupos.getSelectedRow();
        String clave = clavesGrupos.get(i);
        int total = ConexionSQLServer.totalAlumnosByGrupo(clave.trim());
        System.out.println("total " + total);
        labelTotalAlumnos.setText(String.valueOf(total));
    }//GEN-LAST:event_tablaGruposKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int fila = tablaGrupos.getSelectedRow();
        if (fila == -1) {
            mensajesEnPantalla.mensajeError("No se ha seleccionado algun grupo de la tabla", "Error");
        } else {
            int i = mensajesEnPantalla.mensajePregunta("Esta seguro que desea eliminar el grupo,esto conlleva a la eliminacion de los alumnos asignados a este grupo al igual que sus calificaciones", "Eliminar");

            System.out.println(i);
            String clave = clavesGrupos.get(tablaGrupos.getSelectedRow());
            if (i == 0) {
                if (ConexionSQLServer.eliminarGrupo(clave.trim())) {
                    mensajesEnPantalla.mensajeExitoso("Grupo Eliminado Correctamente", "Eliminado");
                    llenarTabla();
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       new ventanaCrearGrupo(this);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TFBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyTyped
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_TFBuscarKeyTyped

    private void TFBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBuscarKeyReleased
        // TODO add your handling code here:
          this.TFBuscar.setText(this.TFBuscar.getText().toUpperCase());
           trsfiltro.setRowFilter(RowFilter.regexFilter(TFBuscar.getText(), 0));
    }//GEN-LAST:event_TFBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFBuscar;
    private javax.swing.JButton botonLupita;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotalAlumnos;
    javax.swing.JTable tablaGrupos;
    // End of variables declaration//GEN-END:variables

    public void llenarTabla() {
        try {
            //     DefaultTableModel tm = ConexionSQLServer.consultaToJtable("SELECT dbo.Grupos.idGrupo AS Clave,Grupos.CicloEscolar_idCicloEscolar,dbo.Idioma.nombreIdioma AS Idioma, RTRIM(dbo.MaestroIdioma.nombreMaestroIdioma) \n" +
//"                      + ' ' + RTRIM(dbo.MaestroIdioma.apellidoMaestroIdioma) AS Profesor, dbo.Salon.letraSalon, dbo.TipoCurso.tipo, dbo.Grupos.horaInicio, dbo.Grupos.horaFinal, \n" +
//"                      dbo.Grupos.nivel\n" +
//"FROM         dbo.Grupos INNER JOIN\n" +
//"                      dbo.Idioma ON dbo.Grupos.Idioma_idIdioma = dbo.Idioma.idIdioma INNER JOIN\n" +
//"                      dbo.MaestroIdioma ON dbo.Grupos.idMaestro = dbo.MaestroIdioma.idMaestroIdioma AND dbo.Idioma.idIdioma = dbo.MaestroIdioma.idioma_idIdioma INNER JOIN\n" +
//"                      dbo.Salon ON dbo.Grupos.idSalon = dbo.Salon.idSalon INNER JOIN\n" +
//"                      dbo.TipoCurso ON dbo.Grupos.TipoCurso_idTipoCurso = dbo.TipoCurso.idTipoCurso where Grupos.CicloEscolar_idCicloEscolar = '"+ventanaPrincipal.idCicloEscolar+"'");
//
            DefaultTableModel tm = ConexionSQLServer.gruposToJtable(ventanaPrincipal.idCicloEscolar);

            this.tablaGrupos.setModel(tm);
            trsfiltro =  new TableRowSorter(tablaGrupos.getModel());
             tablaGrupos.setRowSorter(trsfiltro);
            clavesGrupos = new ArrayList<>();

            ResultSet rs = ConexionSQLServer.gruposToResultSet(ventanaPrincipal.idCicloEscolar);

            while (rs.next()) {
                clavesGrupos.add(rs.getString(1));

            }

            this.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ListaDeGrupos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
