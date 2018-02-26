/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilerias;

/**
 *
 * @author Luis
 */
public  final class erroresSQL {
    
    
    
    public static String returnErrorSQL(int codigoDeError){
        switch (codigoDeError) {
            case 1045:
                return "Contraseña y nombre incorrectos";
                case 0: 
                return  "La Base de Datos esta Detenida";
                case 1451:
                 return "No puede eliminar un alumno que ya ha sido registrado en un examen o grupo";
                case 1062:
                   return  "El ID ya ha sido registrado";
                default:
                throw new AssertionError();
        }
        
    }
            
       
    public static String returnErrorSQL2(int codigoDeError,String cadena){
        switch (codigoDeError) {
            case 1045:
                return "Contraseña y nombre incorrectos";
                case 0: 
                return  "La Base de Datos esta Detenida";
                case 1451:
                 return "No puede eliminar un alumno que ya ha sido registrado en un examen o grupo";
                case 1062:
                   return  "El "+ cadena+ " ya ha sido registrado";
                default:
                throw new AssertionError();
        }
        
    }
        
            
            
            
}
