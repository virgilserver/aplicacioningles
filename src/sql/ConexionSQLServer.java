        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.TreeMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilerias.mensajesEnPantalla;

/**
 *
 * @author Luis
 */
public final class ConexionSQLServer {

    public static Connection con = null;
    public static String query;
    public static Statement stmt;
    public static ResultSet rs;
    public static CallableStatement clst;

    public static boolean modificarAlumno(TreeMap<String, Object> parametros) {

        try {
//              cs=conn.prepareStatement("exec sp_name ?,?,?,?,?,?,?");
            query = "exec modificarAlumno ?,?,?,?,?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, (int) parametros.get("idAlumno"));
            clst.setString(2, (String) parametros.get("NC"));
            clst.setString(3, (String) parametros.get("Nombre"));
            clst.setString(4, (String) parametros.get("Apellidos"));
            clst.setString(5, (String) parametros.get("Sexo"));
            clst.setInt(6, Integer.parseInt((String) (parametros.get("idCarrera"))));
            clst.setInt(7, Integer.parseInt(String.valueOf((parametros.get("idTipoAlumno")))));
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("numerito :)  " + ex.getErrorCode());
            SQLServerErrors.erroresAlumnos(ex.getErrorCode());
            //  mensajesEnPantalla.mensajeErrorSQL(ex.getErrorCode());
        }

        return false;
    }

    public static boolean inserExamenColocacion(java.sql.Date idfecha, int idmaestro, int idsalon, Time time, String clave) {
        try {
//              cs=conn.prepareStatement("exec sp_name ?,?,?,?,?,?,?");
            query = "exec insertarExamenColocacion ?,?,?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setTime(1, time);
            clst.setInt(2, idmaestro);
            clst.setInt(3, idsalon);
            clst.setDate(4, idfecha);
            clst.setString(5, clave);

            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {

            System.out.println("numerito :)  " + ex.getErrorCode());
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }
        return false;

    }

    public static boolean inserExamenLiberacion(Date idfecha, int idmaestro, int idsalon, Time time, String clave, int idMaestroCarrera) {
        try {
//              cs=conn.prepareStatement("exec sp_name ?,?,?,?,?,?,?");
            query = "exec insertarExamenLiberacion ?,?,?,?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setTime(1, time);
            clst.setInt(2, idmaestro);
            clst.setInt(3, idsalon);
            clst.setDate(4, new java.sql.Date(idfecha.getTime()));
            clst.setString(5, clave);
            clst.setInt(6, idMaestroCarrera);

            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("numerito :)  " + ex.getErrorCode());
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }
        return false;

    }

    public ConexionSQLServer() {

    }

    public static boolean conectar(String usuario, String pass) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://192.168.0.10;databaseName=centroDeLenguaExtranjera;user=" + usuario + ";password=" + pass + ";";
            con = DriverManager.getConnection(url);
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con = null;
        } catch (SQLException ex) {
            SQLServerErrors.errorUsuarioContraseña(ex.getErrorCode());
            con = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con = null;
        }
        return false;

    }

    public static ResultSet vistaCarreras() {
        try {
            query = "SELECT * FROM vista_carreras";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet vistaIdiomas() {
        try {
            query = "SELECT * FROM vista_Idiomas";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;
    }

    public static ResultSet informacionAlumno(int id) {

        try {
            query = "SELECT Alumnos.numeroDeControl,Alumnos.nombreAlumno,Alumnos.apellidoAlumno, Alumnos.sexoAlumno, Carreras.nombreCarrera,tipoAlumno.Tipo FROM Alumnos INNER JOIN Carreras ON Alumnos.Carreras_idCarreras = Carreras.idCarreras INNER JOIN tipoAlumno ON Alumnos.tipodAlumno_idtipoAlumno =  tipoAlumno.idtipoAlumno where idAlumno = " + id;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;

    }

    public static boolean insertarAlumno(TreeMap parametros) {

        try {
//              cs=conn.prepareStatement("exec sp_name ?,?,?,?,?,?,?");
            query = "exec insertarAlumno ?,?,?,?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, (String) parametros.get("NC"));
            clst.setString(2, (String) parametros.get("Nombre"));
            clst.setString(3, (String) parametros.get("Apellidos"));
            clst.setString(4, (String) parametros.get("Sexo"));
            clst.setInt(5, Integer.parseInt((String) (parametros.get("idCarrera"))));
            clst.setInt(6, Integer.parseInt(String.valueOf((parametros.get("idTipoAlumno")))));
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.erroresAlumnos(ex.getErrorCode());
        }
        return false;

    }

    public static boolean insertarAlumnoExternos(TreeMap parametros) {

        try {
//              cs=conn.prepareStatement("exec sp_name ?,?,?,?,?,?,?");
            query = "exec insertarAlumnoExternos ?,?,?,?, ? ";
            clst = (CallableStatement) con.prepareCall(query);

            clst.setString(1, (String) parametros.get("Nombre"));
            clst.setString(2, (String) parametros.get("Apellidos"));
            clst.setString(3, (String) parametros.get("Sexo"));
            clst.setInt(4, Integer.parseInt((String) (parametros.get("idCarrera"))));
            clst.setInt(5, Integer.parseInt(String.valueOf((parametros.get("idTipoAlumno")))));
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return false;

    }

    public static boolean modificarAlumnoExterno(TreeMap parametros) {

        try {

            query = "exec modificarAlumnoExterno ?,?,?,?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, (int) parametros.get("idAlumno"));
            clst.setString(2, (String) parametros.get("Nombre"));
            clst.setString(3, (String) parametros.get("Apellidos"));
            clst.setString(4, (String) parametros.get("Sexo"));
            clst.setInt(5, Integer.parseInt((String) (parametros.get("idCarrera"))));
            clst.setInt(6, Integer.parseInt(String.valueOf((parametros.get("idTipoAlumno")))));
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return false;

    }

    public static DefaultTableModel consultaToJtable(String query) {
        DefaultTableModel model = null;

        try {
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
            // Get all rows.
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                    System.out.println("" + rs.getObject(i));
                }
                rows.addElement(newRow);
            }
             model = new DefaultTableModel(rows, columnNames) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return model;
    }

    public static ResultSet vistaIdAlumnos() {
        try {
            query = "SELECT * FROM vista_idalumno";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;

    }

    public static boolean borrarAlumno(int id) {
        try {
            query = "exec  eliminarAlumno ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, id);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.erroresAlumnos(ex.getErrorCode());
        }
        return false;
    }

    public static boolean agregarTipoDeAlumno(String descripcion, String identificador, String autoincremental) {
        try {
            query = "exec  insertarTipoAlumno ?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, descripcion);
            clst.setString(2, identificador);
            clst.setString(3, autoincremental);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorMenuBar(ex.getErrorCode());
        }
        return false;
    }

    public static ResultSet vistaIdTipoAlumno() {
        try {
            query = "SELECT * FROM vista_idTipoAlumno";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;

    }

    public static ResultSet vistaIdMaestrosIdiomas() {
        try {
            query = "SELECT * FROM vista_idmaestroIdioma";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;

    }

    public static ResultSet vistaIdSalon() {
        try {
            query = "SELECT * FROM vista_idSalon";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;

    }

    public static ResultSet vistaIdMaestrosCarrera() {
        try {
            query = "SELECT * FROM vista_idmaestroCarrera";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;

    }

    public static boolean elimnarMaestroIdioma(int id) {
        try {
            query = "exec  eliminarMaestroIdioma ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, id);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return false;

    }

    public static String obtenerAutoIncremental(int idtipo) {
        try {
            query = "SELECT [autoIncremental] FROM tipoAlumno WHERE tipoAlumno.idtipoAlumno =" + idtipo;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;
    }

    public static boolean editarMaestroIdioma(int ididioma, String nombre, String apellido, int idMaestroIdioma, String clave) {
        try {
            query = "exec  modificarMestroIdioma ?,?,?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idMaestroIdioma);
            clst.setString(2, nombre);
            clst.setString(3, apellido);
            clst.setInt(4, ididioma);
            clst.setString(5, clave);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());

            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return false;
    }

    public static boolean agregarMaestroIdioma(int ididioma, String nombre, String apellido, String clave) {
        try {
            query = "exec insertarMestroIdioma ?,?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, nombre);
            clst.setString(2, apellido);
            clst.setInt(3, ididioma);
            clst.setString(4, clave);
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return false;
    }

    public static boolean agregarMaestroCarrera(int idCarrera, String nombre, String apellido, String RFC) {
        try {
            query = "exec insertarMestroCarrera ?,?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(2, nombre);
            clst.setString(3, apellido);
            clst.setInt(4, idCarrera);
            clst.setString(1, RFC);
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return false;
    }

    public static ResultSet obtenerUnMaestro(int idMaestro) {
        try {
            query = "Select  Carreras.nombreCarrera, MaestrosCarreras.RFC, MaestrosCarreras.nombreMaestro, MaestrosCarreras.apellidoMaestro FROM MaestrosCarreras INNER JOIN Carreras ON MaestrosCarreras.Carreras_idCarrerasMc = Carreras.idCarreras WHERE MaestrosCarreras.idMaestros = " + idMaestro;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return null;
    }

    public static boolean modificarMaestroCarrera(String nombre, String apellidos, int idMaestro, String RFC, int idCarrera) {
        try {
            query = "exec modificarMestroCarrera ?,?,?,?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idMaestro);
            clst.setString(2, RFC);
            clst.setString(3, nombre);
            clst.setString(4, apellidos);
            clst.setInt(5, idCarrera);
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {

            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return false;
    }

    public static boolean eliminarMaestroCarrera(int idMaestro) {
        try {
            query = "exec eliminarMaestroCarreras ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idMaestro);
            clst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorMaestro(ex.getErrorCode());
        }
        return false;

    }

    public static boolean insertarFechaExamen(java.util.Date fecha) {
        try {
            query = "exec insertarFecha ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setDate(1, new java.sql.Date(fecha.getTime()));
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }
        return false;

    }

    public static ResultSet vistaFechasExamenes() {
        try {
            query = "Select * from vista_Fechasdeexamen";

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }

        return null;
    }

    public static boolean editarFechaExamen(int idFecha, java.util.Date fecha) {
        try {
            query = "exec modificarFecha ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setDate(1, new java.sql.Date(fecha.getTime()));
            clst.setInt(2, idFecha);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }

        return false;

    }

    public static boolean eliminarFechaExamen(int idFecha) {
        try {
            query = "exec eliminarFecha ? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idFecha);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }

        return false;

    }

    public static boolean asignarAlumnoExamenColocacion(int idAlumno, int idExamenColocacion) {
        try {
            query = "exec asignarAlumnoExamenColocacion ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idAlumno);
            clst.setInt(2, idExamenColocacion);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorExamen(ex.getErrorCode());
        }

        return false;

    }

    public static boolean asignarAlumnoExamenLiberacion(int idAlumno, int idExamenColocacion) {
        try {
            query = "exec asignarAlumnoExamenLiberacion ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idAlumno);
            clst.setInt(2, idExamenColocacion);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());

        }

        return false;

    }

    public static boolean desasignarAlumnoExamenColocacion(int idAlumno, int idExamen) {
        try {
            query = "exec desasignarAlumnoExamenColocacion ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idAlumno);
            clst.setInt(2, idExamen);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return false;

    }

    public static boolean desasignarAlumnoExamenLiberacion(int idAlumno, int idExamen) {
        try {
            query = "exec desasignarAlumnoExamenLiberacion ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idAlumno);
            clst.setInt(2, idExamen);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return false;

    }

    public static boolean asignarNivelExamencolocacion(int idAlumno, String nivel, int idExamen) {
        try {
            query = "exec asignarNivelExamenColocacion ?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idAlumno);
            clst.setString(2, nivel);
            clst.setInt(3, idExamen);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());

        }

        return false;

    }

    public static boolean asignarCalificacionExamenLiberacion(int idAlumno, String calificacion, int idExamen) {
        try {
            query = "exec asignarCalificacionExamenLiberacion ?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idAlumno);
            clst.setString(2, calificacion);
            clst.setInt(3, idExamen);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return false;

    }

    public static ResultSet vistaNombreMaIdioma() {
        try {
            query = "Select * from vista_NombreMaIdioma";

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaIdExamenesColocacion() {
        try {
            query = "Select * from vista_idExamenColocacion";

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaIdExamenesColocacio() {
        try {
            query = "Select * from vista_idExaCol";

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaIdExamenesLiberacio() {
        try {
            query = "Select * from vista_ExaLib";

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaAlumnosAsigandosAExamenColocacion(int idExamen) {
        try {
            query = "Select numeroDeControl AS [No. Control],idAlumno from ExamenColocacion INNER JOIN Alumno_has_ExamenColocacion "
                    + "ON ExamenColocacion.idExamenColocacion = Alumno_has_ExamenColocacion.ExamenColocacion_idExamenColocacion INNER JOIN Alumnos ON Alumno_has_ExamenColocacion.Alumno_idAlumnoEC"
                    + " = Alumnos.idAlumno WHERE ExamenColocacion.idExamenColocacion =" + idExamen;

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaAlumnoAsignadosAGrupo(String idGrupo) {

        try {
            String query = "SELECT     dbo.Alumnos.numeroDeControl AS [N. Control], dbo.Alumnos.idAlumno\n"
                    + "FROM         dbo.Grupos INNER JOIN\n"
                    + "                      dbo.Grupos_has_Alumnos ON dbo.Grupos.idGrupo = dbo.Grupos_has_Alumnos.Grupos_idGrupo INNER JOIN\n"
                    + "                      dbo.Alumnos ON dbo.Grupos_has_Alumnos.Alumno_idAlumnoG = dbo.Alumnos.idAlumno where dbo.Grupos_has_Alumnos.Grupos_idGrupo = '" + idGrupo + "'";

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;

    }

    public static ResultSet vistaAlumnosAsigandosAExamenLiberacion(int idExamen) {
        try {
            query = "SELECT     dbo.Alumnos.numeroDeControl AS [N. Control], Alumnos.idAlumno\n"
                    + "FROM         dbo.Alumnos INNER JOIN\n"
                    + "                      dbo.Alumno_has_ExamenLiberacion ON dbo.Alumnos.idAlumno = dbo.Alumno_has_ExamenLiberacion.Alumno_idAlumnoEL INNER JOIN\n"
                    + "                      dbo.ExamenLiberacion ON dbo.Alumno_has_ExamenLiberacion.ExamenLiberacion_idexamenLiberacion = dbo.ExamenLiberacion.idExamenLiberacion where ExamenLiberacion.idExamenLiberacion=" + idExamen;

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaidAlumnosNoAsigandosExamen() {
        try {
            query = "Select * FROM vista_idAlumnosNoAsignadosExamen";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaMaestroIdiomaEspecifico(int idMaestro) {
        try {
            query = "Select * FROM MaestroIdioma where idMaestroIdioma = " + idMaestro;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaClavesCarreras() {
        try {
            query = "Select * FROM vista_claveCarreras";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaNombreMaestroCarrera() {
        try {
            query = "Select * FROM vista_NombreMaCarrera";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaInfoAlumnoExamenColocacion(int idExamen) {
        try {
            String query = "Select numeroDeControl AS [No. Control],RTRIM(nombreAlumno) +' '+ RTRIM(apellidoAlumno) as Nombre,idAlumno,nivelExamenColocacion  from ExamenColocacion INNER JOIN Alumno_has_ExamenColocacion "
                    + "ON ExamenColocacion.idExamenColocacion = Alumno_has_ExamenColocacion.ExamenColocacion_idExamenColocacion INNER JOIN Alumnos ON Alumno_has_ExamenColocacion.Alumno_idAlumnoEC"
                    + " = Alumnos.idAlumno WHERE ExamenColocacion.idExamenColocacion =" + idExamen;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaInfoAsigandosAExamenLiberacion(int idExamen) {
        try {
            query = "SELECT     Alumnos.idAlumno,dbo.Alumnos.numeroDeControl AS [N. Control], Alumno_has_ExamenLiberacion.calificacionExamenLiberacion,RTRIM(dbo.Alumnos.nombreAlumno) + ' ' + RTRIM(dbo.Alumnos.apellidoAlumno) AS Nombre\n"
                    + "FROM         dbo.Alumnos INNER JOIN\n"
                    + "                      dbo.Alumno_has_ExamenLiberacion ON dbo.Alumnos.idAlumno = dbo.Alumno_has_ExamenLiberacion.Alumno_idAlumnoEL INNER JOIN\n"
                    + "                      dbo.ExamenLiberacion ON dbo.Alumno_has_ExamenLiberacion.ExamenLiberacion_idexamenLiberacion = dbo.ExamenLiberacion.idExamenLiberacion where ExamenLiberacion.idExamenLiberacion=" + idExamen;
            ;

            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaIdExamenLiberacion() {
        try {
            String query = "select * from vista_idExamenLiberacion";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaTipoCurso() {
        try {
            String query = "select * from vista_tipoCurso";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static boolean registrarCicloEscolar(String idciclo, String ciclo) {

        try {
            query = "exec registrarCicloEscolar ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, idciclo);
            clst.setString(2, ciclo);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorCicloEscolar(ex.getErrorCode());
        }

        return false;

    }

    public static boolean registrarIdioma(String idioma, String clave) {

        try {
            query = "exec insertarIdioma ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, idioma);
            clst.setString(2, clave);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {

            SQLServerErrors.errorMenuBar(ex.getErrorCode());
        }

        return false;
    }

    public static boolean registrarSalon(String letraSalon) {

        try {
            query = "exec registrarSalon ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, letraSalon);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {

            SQLServerErrors.errorSalon(ex.getErrorCode());
        }

        return false;
    }

    public static boolean registrarCarrera(String nombreCarrera, String claveCarrera) {

        try {
            query = "exec registrarCarrera ?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, nombreCarrera);
            clst.setString(2, claveCarrera);
            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {

            SQLServerErrors.errorMenuBar(ex.getErrorCode());
        }

        return false;
    }

    public static boolean registroRapidoCicloEscolar(String idciclo, String ciclo) {
        if (con == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://192.168.0.10;databaseName=centroDeLenguaExtranjera;user=sa;password=Equis1;";
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                SQLServerErrors.errorUsuarioContraseña(ex.getErrorCode());
            }
        }

        try {
            query = "exec registrarCicloEscolar ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, idciclo);
            clst.setString(2, ciclo);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorCicloEscolar(ex.getErrorCode());
        }
        return false;

    }

    public static ResultSet vistaCicloEscolar() {

        try {
            query = "Select * FROM vista_CicloEscolar";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaRapidaCicloEscolar() {
        if (con == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://192.168.0.10;databaseName=centroDeLenguaExtranjera;user=sa;password=Equis1;";
                con = DriverManager.getConnection(url);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                SQLServerErrors.errorUsuarioContraseña(ex.getErrorCode());
            }
        }

        try {
            query = "Select * FROM vista_CicloEscolar";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            con = null;
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;

    }

    public static boolean insertarGrupo(TreeMap parametros) {

        try {
            query = "exec insertarGrupo ?,?,?,?,?,?,?,?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, parametros.get("1").toString());
            clst.setInt(2, (int) parametros.get("2"));
            clst.setInt(3, (int) parametros.get("3"));
            clst.setString(4, parametros.get("4").toString());
            clst.setTime(5, (Time) parametros.get("5"));
            clst.setTime(6, (Time) parametros.get("6"));
            clst.setString(7, parametros.get("7").toString());
            clst.setInt(8, (int) parametros.get("8"));
            clst.setInt(9, (int) parametros.get("9"));
            clst.setInt(10, (int) parametros.get("10"));

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {

            SQLServerErrors.errorGrupo(ex.getErrorCode());
        }

        return false;
    }

    public static ResultSet vistaHorarioSalon(int idSalon, String idCicloEscoalr) {
        try {
            String query = "SELECT     dbo.Grupos.horaInicio, dbo.Grupos.horaFinal, dbo.Salon.letraSalon, RTRIM(dbo.MaestroIdioma.nombreMaestroIdioma) \n"
                    + "                      + ' ' + RTRIM(dbo.MaestroIdioma.apellidoMaestroIdioma) AS Maestro, dbo.TipoCurso.tipo, RTRIM(dbo.Idioma.nombreIdioma) + ' ' + RTRIM(dbo.Grupos.nivel) \n"
                    + "                      AS Nivel\n"
                    + "FROM         dbo.Grupos INNER JOIN\n"
                    + "                      dbo.Salon ON dbo.Grupos.idSalon = dbo.Salon.idSalon INNER JOIN\n"
                    + "                      dbo.MaestroIdioma ON dbo.Grupos.idMaestro = dbo.MaestroIdioma.idMaestroIdioma INNER JOIN\n"
                    + "                      dbo.TipoCurso ON dbo.Grupos.TipoCurso_idTipoCurso = dbo.TipoCurso.idTipoCurso INNER JOIN\n"
                    + "                      dbo.Idioma ON dbo.Grupos.Idioma_idIdioma = dbo.Idioma.idIdioma AND dbo.MaestroIdioma.idioma_idIdioma = dbo.Idioma.idIdioma WHERE Grupos.CicloEscolar_idCicloEscolar ='" + idCicloEscoalr + "' AND Grupos.idSalon =" + idSalon;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaHorarioMaestro(int idSalon, String idCicloEscoalr) {
        try {
            String query = "SELECT     dbo.Grupos.horaInicio, dbo.Grupos.horaFinal, dbo.Salon.letraSalon, RTRIM(dbo.MaestroIdioma.nombreMaestroIdioma) \n"
                    + "                      + ' ' + RTRIM(dbo.MaestroIdioma.apellidoMaestroIdioma) AS Maestro, dbo.TipoCurso.tipo, RTRIM(dbo.Idioma.nombreIdioma) + ' ' + RTRIM(dbo.Grupos.nivel) \n"
                    + "                      AS Nivel\n"
                    + "FROM         dbo.Grupos INNER JOIN\n"
                    + "                      dbo.Salon ON dbo.Grupos.idSalon = dbo.Salon.idSalon INNER JOIN\n"
                    + "                      dbo.MaestroIdioma ON dbo.Grupos.idMaestro = dbo.MaestroIdioma.idMaestroIdioma INNER JOIN\n"
                    + "                      dbo.TipoCurso ON dbo.Grupos.TipoCurso_idTipoCurso = dbo.TipoCurso.idTipoCurso INNER JOIN\n"
                    + "                      dbo.Idioma ON dbo.Grupos.Idioma_idIdioma = dbo.Idioma.idIdioma AND dbo.MaestroIdioma.idioma_idIdioma = dbo.Idioma.idIdioma WHERE Grupos.CicloEscolar_idCicloEscolar ='" + idCicloEscoalr + "' AND dbo.Grupos.idMaestro =" + idSalon;
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaAlumnosAsignadosaGrupo(String clave) {
        try {
            String query = "SELECT     dbo.Alumnos.numeroDeControl AS [N. Control], Alumno.idAlumno\n"
                    + "FROM         dbo.Grupos INNER JOIN\n"
                    + "                      dbo.Grupos_has_Alumnos ON dbo.Grupos.idGrupo = dbo.Grupos_has_Alumnos.Grupos_idGrupo INNER JOIN\n"
                    + "                      dbo.Alumnos ON dbo.Grupos_has_Alumnos.Alumno_idAlumnoG = dbo.Alumnos.idAlumno where dbo.Grupos_has_Alumnos.Grupos_idGrupo = '" + clave + "'";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;
    }

    public static ResultSet vistaInfoAlumnosAsignadosaGrupo(String clave) {
        try {
            String query = "SELECT     dbo.Alumnos.numeroDeControl AS [N. Control],Alumnos.idAlumno,RTRIM(dbo.Alumnos.nombreAlumno) + ' ' + RTRIM(dbo.Alumnos.apellidoAlumno) AS Nombre,Grupos_has_Alumnos.calificacionCurso,Grupos_has_Alumnos.Observaciones\n"
                    + "FROM         dbo.Grupos INNER JOIN\n"
                    + "                      dbo.Grupos_has_Alumnos ON dbo.Grupos.idGrupo = dbo.Grupos_has_Alumnos.Grupos_idGrupo INNER JOIN\n"
                    + "                      dbo.Alumnos ON dbo.Grupos_has_Alumnos.Alumno_idAlumnoG = dbo.Alumnos.idAlumno where dbo.Grupos_has_Alumnos.Grupos_idGrupo = '" + clave + "'";
            stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;

    }

    public static boolean asignarAlumnoAgrupo(String claveGrupo, int idAlumno) {

        try {
            query = "exec asignarAlumnoGrupo ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, claveGrupo);
            clst.setInt(2, idAlumno);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return false;
    }

    public static boolean desasignarAlumnoAgrupo(String claveGrupo, int idAlumno) {

        try {
            query = "exec desasignarAlumnoGrupo ?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, claveGrupo);
            clst.setInt(2, idAlumno);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return false;
    }

    public static boolean asignarCalificacionAlumnoAgrupo(String claveGrupo, int idAlumno, int calificacion, String observacion) {

        try {
            query = "exec asignarCalificacionGrupoAlumno ?,?,?,? ";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, claveGrupo);
            clst.setInt(2, idAlumno);
            clst.setInt(3, calificacion);
            clst.setString(4, observacion);

            clst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return false;
    }

    public static ResultSet datoTipoAlumnoById(int id) {
        try {
            query = "exec datoTipoCAlumnoById ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, id);
            return clst.executeQuery();

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;

    }

    public static ResultSet datoIdiomaById(int id) {
        try {
            query = "exec datoIdiomaId ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, id);
            return clst.executeQuery();

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;

    }

    public static ResultSet datoCarreraId(int id) {
        try {
            query = "exec datoCarreraId ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, id);
            return clst.executeQuery();

        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }

        return null;

    }

    public static boolean modificarTipoAlumno(int id, String tipo) {
        try {
            query = "exec modificarTipoAlumno ?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, tipo);
            clst.setInt(2, id);

            clst.executeUpdate();
            return true;
        } catch (SQLException ex) {

            SQLServerErrors.errorMenuBar(ex.getErrorCode());
        }

        return false;

    }

    public static boolean modificarCarrera(int id, String tipo) {
        try {
            query = "exec modificarCarrera ?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, tipo);
            clst.setInt(2, id);

            clst.executeUpdate();
            return true;
        } catch (SQLException ex) {

            SQLServerErrors.errorMenuBar(ex.getErrorCode());
        }

        return false;

    }

    public static boolean modificarIdioma(int id, String nombre) {
        try {
            query = "exec modificarIdioma ?,?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, nombre);
            clst.setInt(2, id);

            clst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorMenuBar(ex.getErrorCode());
        }

        return false;

    }

    public static DefaultTableModel gruposToJtable(String idCiloEscolar) {
        DefaultTableModel model = null;

        try {

            query = "exec datoGruposByCicloEscolar ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, idCiloEscolar);

            ResultSet rs = clst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }
            // Get all rows.
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                    System.out.println("" + rs.getObject(i));
                }
                rows.addElement(newRow);
            }

            model = new DefaultTableModel(rows, columnNames) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());

        }
        return model;
    }

    public static ResultSet gruposToResultSet(String idCiloEscolar) {
        try {
            query = "select idGrupo from Grupos where CicloEscolar_idCicloEscolar = '" + idCiloEscolar + "'";
            stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return null;
    }

    public static int totalAlumnosByGrupo(String idGrupo) {

        try {
            query = "exec totalAlumnosByGrupo ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, idGrupo);

            ResultSet rs = clst.executeQuery();

            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return 0;

    }

    public static int totalAlumnosExamenColocacion(int idExamenCol) {
        try {
            query = "exec totalAlumnosByExamenColocacion ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idExamenCol);

            ResultSet rs = clst.executeQuery();

            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return 0;
    }

    public static int totalAlumnosExamenLiberacion(int idExamenCol) {
        try {
            query = "exec totalAlumnosByExamenLiberacion ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idExamenCol);

            ResultSet rs = clst.executeQuery();

            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return 0;
    }

    public static boolean eliminarGrupo(String idGrupo) {
        try {
            query = "exec eliminarGrupo ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setString(1, idGrupo);
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return false;
    }

    public static boolean eliminarExamenColocacion(int idExamen) {
        try {
            query = "exec eliminarExamenColocacion ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idExamen);
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return false;
    }

    public static boolean eliminarExamenLiberacion(int idExamen) {
        try {
            query = "exec eliminarExamenLiberacion ?";
            clst = (CallableStatement) con.prepareCall(query);
            clst.setInt(1, idExamen);
            clst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            SQLServerErrors.errorSQL(ex.getErrorCode());
        }
        return false;
    }

}
