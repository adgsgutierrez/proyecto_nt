package co.com.konrad.nt.constant;

import java.util.ArrayList;

import co.com.konrad.nt.dto.UsuarioDTO;

public class UsuarioConstant {

	@SuppressWarnings({ "unchecked", "rawtypes"})
	public static ArrayList<UsuarioDTO> list_users(){
		ArrayList usuarios = new ArrayList<UsuarioDTO>();
		// id,  clave,  nombre,  apellido,  ruta_avatar, correo,  telefono,  edad,  tarjetas,  notificaciones
		usuarios.add(new UsuarioDTO(1,"123456","Pedro","Orlando","img/user_1.png","porlando@gmail.com","76543217",23,2,3));
		usuarios.add(new UsuarioDTO(2,"123456","Camilo","Benavides","img/user_2.png","cbenavidez@gmail.com","76543217",30,1,0));
		usuarios.add(new UsuarioDTO(3,"123456","Antonio","Gutíerrez","img/user_3.png","agutierrez@gmail.com","76543217",35,1,0));
		usuarios.add(new UsuarioDTO(4,"123456","Camila","Sanchez","img/user_4.png","csanchez@gmail.com","76543217",28,3,0));
		usuarios.add(new UsuarioDTO(5,"123456","Andrés","Perez","img/user_5.png","aperez@gmail.com","76543217",29,1,0));
		usuarios.add(new UsuarioDTO(6,"123456","Martín","López","img/user_6.png","mlopez@gmail.com","76543217",40,1,0));
		usuarios.add(new UsuarioDTO(7,"123456","Nelson","Salcedo","img/user_7.png","nsalcedo@gmail.com","76543217",33,1,1));
		usuarios.add(new UsuarioDTO(8,"123456","Sneider","Penagos","img/user_8.png","spenagos@gmail.com","76543217",45,1,1));
		return usuarios;
	}
}
