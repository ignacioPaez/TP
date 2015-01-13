package data;

import java.util.ArrayList;
import java.util.Collection;

import entidades.Lavarropa;

public class DbtLavarropa {

	ArrayList<Lavarropa> lavarropas = new ArrayList<>();

	public void RegistrarLavarropa(Lavarropa lavarropa) {
		lavarropas.add(lavarropa);

	}

	public ArrayList<Lavarropa> getLavarropas() {
		return lavarropas;
	}

	public void ActualizarLavarropas(ArrayList<Lavarropa> lavarropas) {
		this.lavarropas.clear();
		this.lavarropas.addAll(lavarropas);

	}
	
	public void modificarLavarropa(Lavarropa lavarropa){
		
		for(int i = 0 ; i < lavarropas.size(); i++){
			
			if(lavarropa.getIdElectrodomestico() == lavarropas.get(i).getIdElectrodomestico()){
				lavarropas.set(i, lavarropa);
			}
		}

	}

}