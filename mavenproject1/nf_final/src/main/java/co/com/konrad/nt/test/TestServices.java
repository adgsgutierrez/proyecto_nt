package co.com.konrad.nt.test;

import com.google.gson.Gson;

import co.com.konrad.nt.dto.ResponseNT;
import co.com.konrad.nt.logic.Usuario;

public class TestServices {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario;
		Gson gson = new Gson();
		usuario = new Usuario();
		ResponseNT respuesta = usuario.iniciar_sesion("porlando@gmail.com","123456");
		System.out.println(gson.toJson(respuesta)); 
	}

}
