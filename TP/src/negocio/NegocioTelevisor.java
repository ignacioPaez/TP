package negocio;

import java.util.ArrayList;

import mySqlData.TelevisorDao;
import entidades.InterfaceDbt;
import entidades.Lavarropa;
import entidades.Televisor;

public class NegocioTelevisor implements InterfaceDbt {
	
	private TelevisorDao dataTelevisor;

	public TelevisorDao getDataTelevisor() {
		return dataTelevisor;
	}

	public void setDataTelevisor(TelevisorDao dataTelevisor) {
		this.dataTelevisor = dataTelevisor;
	}
	
	/*public ArrayList<entidades.Televisor> getAllTelevisores() throws Exception{
		return getDataTelevisor().getAll();
	}*/

	public void Registrar(Televisor televisor){
		dbtTelevisor.RegistrarTelevisor(televisor);
	}
	
	public void modificarTelevisor(Televisor televisor) {
		// TODO Auto-generated method stub
		dbtTelevisor.modificarTelevisor(televisor);
	}
}