package co.com.konrad.nt.constant;

public class Constant {

	public static final String CODE_SUCCESS = "00";
	public static final String SMS_SUCCESS = "Consulta Exitosa";
	
	public static final String CODE_ERROR_GENERAL = "01";
	public static final String SMS_ERROR_GENERAL = "Se presentó un error no controlado en la aplicación, por favor reintente la operación";
	public static final String CODE_ERROR_PWD_USER = "02";
	public static final String SMS_ERROR_PWD_USER = "El usuario y/o clave son incorrectos";
	public static final String CODE_ERROR_USER_NOT_EXIST = "03";
	public static final String SMS_ERROR_USER_NOT_EXIST = "El usuario no existe, para poder ingresar debe crear uno.";
        
        public static final String CODE_HISTORY_NO_FOUND = "04";
        public static final String SMS_HISTORY_NO_FOUND = "No se encontró historial de actividad.";
        
        public static final String CODE_NOT_CONTACT_ADD = "05";
        public static final String SMS_NOT_CONTACT_ADD = "No se logró adicionar a tu lista de contactos.";
        
        public static final String CODE_NOT_CREDIT_ADD = "06";
        public static final String SMS_NOT_CREDIT_ADD = "No se logró adicionar esta tarjeta.";
        
        public static final String CODE_NOT_ADD_USER = "07";
        public static final String SMS_NOT_ADD_USER = "No se pudo crear el usuario, se presentó un error.";
	
}
