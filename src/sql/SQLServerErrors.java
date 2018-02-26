/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import javax.swing.JOptionPane;

/**
 *
 * @author Xcode
 */
public final class SQLServerErrors {
 
    public static void errorUsuarioContraseña(int code) {
        switch (code) {
            case 18456:
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos", "Error 01", JOptionPane.WARNING_MESSAGE);

                break;
            case 0:
                JOptionPane.showMessageDialog(null, "Error al establecer una conexión con la base de datos", "Error 05", JOptionPane.WARNING_MESSAGE);
                break;
                
            default:
                throw new AssertionError();
        }
    }

    public static void erroresAlumnos(int code) {

        switch (code) {
            case 2601:
                JOptionPane.showMessageDialog(null, "El numero de control ya ha sido registrado anteriormente", "Error 03", JOptionPane.WARNING_MESSAGE);

                break;
            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
            case 547:
                JOptionPane.showMessageDialog(null, "El alumno seleccionado no puede ser eliminado", "Error 10", JOptionPane.WARNING_MESSAGE);
                
            default:
                throw new AssertionError();
        }

    }
  
    public static void errorMenuBar(int code) {
        switch (code) {
            case 2601:
                JOptionPane.showMessageDialog(null, "La clave que intenta registrar ya ha sido usada,intente con otra", "Clave Duplicada", JOptionPane.WARNING_MESSAGE);

                break;
            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }
    public static void errorCicloEscolar (int code){
        switch (code) {
            case 2627:
                JOptionPane.showMessageDialog(null, "El ciclo escolar que intenta registrar ya ha sido registrado anteriormente", "Error 09", JOptionPane.WARNING_MESSAGE);
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }
    public static void errorSalon(int code) {
        switch (code) {
            case 2601:
                JOptionPane.showMessageDialog(null, "El salon ya ha sido registrado con esa letra", "Salon Duplicada", JOptionPane.WARNING_MESSAGE);

                break;
            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void errorMaestro(int code) {
        switch (code) {
            case 2601:
                JOptionPane.showMessageDialog(null, "La clave del maestro ya fue registrada anteriormente,intente con otra", "Salon Duplicada", JOptionPane.WARNING_MESSAGE);

                break;
            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
                
               case 547:
                JOptionPane.showMessageDialog(null, "El maestro seleccionado no puede ser eliminado", "Error 10", JOptionPane.WARNING_MESSAGE);
          
            default:
                throw new AssertionError();
        }
    }

    public static void errorGrupo(int code) {
        switch (code) {

            //para los id´s
            case 2627:
                JOptionPane.showMessageDialog(null, "Ya existe un grupo con esas especificaciones", "Grupo ya registrado", JOptionPane.WARNING_MESSAGE);

                break;
            case 2601:
                JOptionPane.showMessageDialog(null, "El salon ya tiene asignado una clase ala hora indicada", "", JOptionPane.WARNING_MESSAGE);

                break;
            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public static void errorSQL(int code) {
        
          switch (code) {

            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
      public static void errorExamen(int code) {
        
          switch (code) {

            case 0:
                JOptionPane.showMessageDialog(null, "La conexión con la base de datos se ha interrumpido", "Error 04", JOptionPane.WARNING_MESSAGE);
                break;
             case 2601:
                JOptionPane.showMessageDialog(null, "Ya existe un examen con esas especificaciones", "error", JOptionPane.WARNING_MESSAGE);

                break;
            
            default:
                throw new AssertionError();
        }
        
    }
    
    
}
