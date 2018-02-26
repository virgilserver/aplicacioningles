/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grupos;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * 7
 * @author Luis
 */
public class horaSalon {

   
    Time horainicio,horafinal;
    String maestro,idiomaNivel,tipoCurso;
    public horaSalon(Time horainicio,Time horafinal,String maestro,String  idiomaNivel,String tipoCurso){
        this.horafinal = horafinal;
        this.horainicio = horainicio;
        this.maestro = maestro;
        this.idiomaNivel = idiomaNivel;
        this.tipoCurso = tipoCurso;
    }  
    
    
    @Override
    public String toString(){
       
         
       
        return "Maestro : "+maestro + "idiomanivel : "+ idiomaNivel + "hora inicio : " + horainicio + "hora final : "+horafinal;
        
        
    }

    public Time getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Time horainicio) {
        this.horainicio = horainicio;
    }

    public Time getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Time horafinal) {
        this.horafinal = horafinal;
    }

    public String getMaestro() {
        return maestro;
    }

    public void setMaestro(String maestro) {
        this.maestro = maestro;
    }

    public String getIdiomaNivel() {
        return idiomaNivel;
    }

    public void setIdiomaNivel(String idiomaNivel) {
        this.idiomaNivel = idiomaNivel;
    }

    public String getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(String tipoCurso) {
        this.tipoCurso = tipoCurso;
    }
    
    
    
    
    
    
    
    
    
    
    
}
