package data;

import java.util.ArrayList;

import entidades.Lavarropa;
import entidades.Televisor;

public class DbtTelevisor {
	ArrayList<Televisor> televisores = new ArrayList<>();

	public void RegistrarTelevisor(Televisor televisor) {

		televisores.add(televisor);
	}

	public ArrayList<Televisor> getTelevisores() {

		return televisores;

	}

	public void modificarTelevisor(Televisor televisor) {

		for (int i = 0; i < televisores.size(); i++) {

			if (televisor.getIdElectrodomestico() == televisores.get(i)
					.getIdElectrodomestico()) {
				televisores.set(i, televisor);
			}
		}

	}
	
	public void ActualizarTelevisor(ArrayList<Televisor> televisores) {
		this.televisores.clear();
		this.televisores.addAll(televisores);

	}

}
