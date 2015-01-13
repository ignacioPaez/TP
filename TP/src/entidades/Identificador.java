package entidades;

import mySqlData.IdentificadorDao;

public class Identificador {
	
	static int id;

	static public int getId() {
		return id;
	}

	public static void setId() {
		Identificador.id=0;
		Identificador.id = sumarId();
	}
	
	static int sumarId(){
		
		id++;
		return id;
	}
	
	public static void setId(int id) {
		
		Identificador.id=sumarId();
	}
	
	
	
	

}
