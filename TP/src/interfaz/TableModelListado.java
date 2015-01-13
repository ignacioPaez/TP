package interfaz;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entidades.Electrodomestico;
import entidades.Lavarropa;
import entidades.Televisor;

public class TableModelListado extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Televisor> televisores;
	private ArrayList<Lavarropa> lavarropas;
	public ArrayList<Electrodomestico> electrodomesticos;

	public ArrayList<Electrodomestico> getElectrodomesticos() {
		return electrodomesticos;
	}

	public void setElectrodomesticos(ArrayList<Electrodomestico> electrodomesticoss){
		this.electrodomesticos=electrodomesticoss;
		
		
	}

	

	public ArrayList<Televisor> getTelevisores() {
		return televisores;
	}

	public void setTelevisores(ArrayList<Televisor> televisores) {
		this.televisores = televisores;
	}

	public ArrayList<Lavarropa> getLavarropas() {
		return lavarropas;
	}

	public void setLavarropas(ArrayList<Lavarropa> lavarropas) {
		this.lavarropas = lavarropas;
	}

	public int getColumnCount() {

		return 7;
	}

	public int getRowCount() {

		return (electrodomesticos.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Electrodomestico ele = electrodomesticos.get(rowIndex);

		Object o = null;

		switch (columnIndex) {
		case 0:
			o = ele.getPeso();

			break;
		case 1:
			o = ele.getPrecioBase();

			break;
		case 2:
			o = ele.getColor().getColor();

			break;
		case 3:
			o = ele.getConsumoEnergetico().getConsumoEner();

			break;
		case 4:
			if(ele instanceof Televisor){
				o=((Televisor)ele).getResolucion();
			}
			else{
				o = null;
			}
			break;
		case 5:
			if(ele instanceof Televisor){
				o=((Televisor)ele).isSintonizador();
			}
			else{
				o=null;
			}

			break;
		case 6:
			if(ele instanceof Lavarropa){
						
			o = ((Lavarropa)ele).getCarga();}
			else{
				o=null;
			}

			break;

		default:
			o = null;
			break;
		}

		return o;
	}

	public String getColumnName(int columna) {
		String nombre = "";
		switch (columna) {
		case 0:
			nombre = "Peso";
			break;
		case 1:
			nombre = "Precio";
			break;
		case 2:
			nombre = "Color";
			break;
		case 3:
			nombre = "Consumo";
			break;
		case 4:
			nombre = "Resolucion";
			break;
		case 5:
			nombre = "Sintonizador";
			break;
		case 6:
			nombre = "Carga";
			break;
		default:
			nombre = "";
			break;
		}
		return nombre;

	}
}
