package negocio;

import mySqlData.LavarropaDao;
import mySqlData.TelevisorDao;
import interfaz.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		LavarropaDao lavaDao = new LavarropaDao();
		TelevisorDao teleDao = new TelevisorDao();
		
		lavaDao.buscarLavarropa();
		teleDao.buscarTelevisor();
		
		
		VentanaPrincipal ventanaPpal= new VentanaPrincipal();
		ventanaPpal.setVisible(true);

	}

}

