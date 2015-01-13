package negocio;

import java.util.ArrayList;

import mySqlData.LavarropaDao;
import entidades.InterfaceDbt;
import entidades.Lavarropa;

public class NegocioLavarropa implements InterfaceDbt {
	
	private LavarropaDao dataLavarropa;
	
	
	 public LavarropaDao getDataLavarropa() {
		return dataLavarropa;
	}


	public void setDataLavarropa(LavarropaDao lavarropa) {
		dataLavarropa = lavarropa;
	}

	/*public ArrayList<entidades.Lavarropa> getAllLavarropas() throws Exception
	{
		return getDataLavarropa().getAll();
	}*/

	public void Registrar(Lavarropa lavarropa)
	    {
		 dbtLavarropa.RegistrarLavarropa(lavarropa);
	       
	    }

	public void modificarLavarropa(Lavarropa lava) {
		// TODO Auto-generated method stub
		dbtLavarropa.modificarLavarropa(lava);
	}
		
}
