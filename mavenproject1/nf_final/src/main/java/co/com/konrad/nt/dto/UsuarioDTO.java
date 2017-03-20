package co.com.konrad.nt.dto;

public class UsuarioDTO {
	
	private Integer id;
	private String clave;
	private String nombre;
	private String apellido;
	private String ruta_avatar;
	private String correo;
	private String telefono;
	private Integer edad;
	private Integer tarjetas;
	private Integer notificaciones;
		
	public UsuarioDTO() {
		super();
	}
	public UsuarioDTO(Integer id, String clave, String nombre, String apellido, String ruta_avatar,
			String correo, String telefono, Integer edad, Integer tarjetas, Integer notificaciones) {
		super();
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ruta_avatar = ruta_avatar;
		this.correo = correo;
		this.telefono = telefono;
		this.edad = edad;
		this.tarjetas = tarjetas;
		this.notificaciones = notificaciones;
	}
	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", ruta_avatar=" + ruta_avatar + ", correo=" + correo + ", telefono="
				+ telefono + ", edad=" + edad + ", tarjetas=" + tarjetas + ", notificaciones=" + notificaciones + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRuta_avatar() {
		return ruta_avatar;
	}
	public void setRuta_avatar(String ruta_avatar) {
		this.ruta_avatar = ruta_avatar;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(Integer tarjetas) {
		this.tarjetas = tarjetas;
	}
	public Integer getNotificaciones() {
		return notificaciones;
	}
	public void setNotificaciones(Integer notificaciones) {
		this.notificaciones = notificaciones;
	}
}
