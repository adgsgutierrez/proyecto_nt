/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.constant;

import co.com.konrad.nt.dto.HistoricoDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADGS
 */
public class HistoricoConstant {
    
    public static ArrayList<HistoricoDTO> getHistorial(Integer id_usuario){
        ArrayList historial = new ArrayList<HistoricoDTO>();
        //fecha,nombre_imagen,ruta_imagen,nombre_usuario,tipo,estado,valor
        if(id_usuario % 2 == 0){
          historial.add(new HistoricoDTO("12-02-2017", "Los Caballos Locos", "img/obj/123.png", "porlando@gmail.com", "V", "T", "$ 45.000"));
          historial.add(new HistoricoDTO("06-01-2017", "La Gran familia", "img/obj/124.png", "cbenavidez@gmail.com", "C", "A", "$ 16.000"));
          historial.add(new HistoricoDTO("08-12-2016", "EL PASTAL", "img/obj/125.png", "porlando@gmail.com", "C", "P", "$ 23.000"));
          historial.add(new HistoricoDTO("15-11-2016", "Camila y su duda", "img/obj/126.png", "cbenavidez@gmail.com", "C", "P", "$ 56.000"));
          historial.add(new HistoricoDTO("18-10-2016", "Abstract", "img/obj/127.png", "aperez@gmail.com", "C", "T", "$ 66.000"));
          historial.add(new HistoricoDTO("23-09-2016", "El aprendiz", "img/obj/128.png", "aperez@gmail.com", "C", "T", "$ 150.000"));
          historial.add(new HistoricoDTO("01-08-2016", "La venganza", "img/obj/129.png", "cbenavidez@gmail.com", "C", "T", "$ 5.000"));
        }else{
          historial.add(new HistoricoDTO("12-02-2017", "Los Caballos Locos", "img/obj/123.png", "mlopez@gmail.com", "V", "T", "$ 45.000"));
          historial.add(new HistoricoDTO("06-01-2017", "La Gran familia", "img/obj/124.png", "cbenavidez@gmail.com", "C", "A", "$ 16.000"));
          historial.add(new HistoricoDTO("08-12-2016", "EL PASTAL", "img/obj/125.png", "porlando@gmail.com", "C", "P", "$ 23.000"));
          historial.add(new HistoricoDTO("15-11-2016", "Camila y su duda", "img/obj/126.png", "spenagos@gmail.com", "C", "P", "$ 56.000"));
          historial.add(new HistoricoDTO("18-10-2016", "Abstract", "img/obj/127.png", "spenagos@gmail.com", "C", "T", "$ 66.000"));
          historial.add(new HistoricoDTO("23-09-2016", "El aprendiz", "img/obj/128.png", "mlopez@gmail.com", "C", "T", "$ 150.000"));
          historial.add(new HistoricoDTO("01-08-2016", "La venganza", "img/obj/129.png", "spenagos@gmail.com", "C", "T", "$ 5.000"));
        }
        return historial;
    }
}
