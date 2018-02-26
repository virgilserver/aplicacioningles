/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grupos;

import java.sql.Time;

/**
 *
 * @author Luis
 */
public class hora {
    public Time horaI,horaf;
    public hora(Time horaI,Time horaf){
      this.horaI = horaI;
      this.horaf = horaf;
    }
    
   
    @Override
   public String toString(){
       String hora= horaI.toString().substring(0,5) + "-"+horaf.toString().substring(0,5);
       
        return hora;

}
}
