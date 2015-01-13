package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import entidades.Electrodomestico;
import entidades.InterfaceDbt;
import entidades.Lavarropa;

public class ListadoModificar extends JFrame implements ActionListener, InterfaceDbt{

	private JPanel contentPane;
	private JTable table;
	private JButton btnSalir;
	private JButton btnModificarSeleccionado;
	Electrodomestico ele;
	public ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();


	public ListadoModificar() {
		setResizable(false);
		setTitle("Modificar Electrodomestico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 11, 535, 263);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(454, 285, 91, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
		
		btnModificarSeleccionado = new JButton("Modificar Seleccionado");
		btnModificarSeleccionado.setBounds(255, 285, 189, 23);
		contentPane.add(btnModificarSeleccionado);
		btnModificarSeleccionado.addActionListener(this);
		
		LoadTable();
	}
	private void LoadTable(){
		TableModelListado modelo = new TableModelListado();
		ArrayList<Electrodomestico> electrodomesticos= new ArrayList<>();
		electrodomesticos.addAll(dbtLavarropa.getLavarropas());
		electrodomesticos.addAll(dbtTelevisor.getTelevisores());
		modelo.setElectrodomesticos(electrodomesticos);
		table.setModel(modelo);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSalir){
			VentanaPrincipal ventana= new VentanaPrincipal();
			ventana.setVisible(true);
			this.dispose();
		}
		
		if(e.getSource()==btnModificarSeleccionado){

			this.setVisible(false);
			this.ModificarLavarropa(table.getSelectedRow());
		}
		
	}
	
	
	public void ModificarLavarropa(int indice) {
		if (table.getSelectedRow() != -1) {
			
			//ArrayList<Lavarropa> lavarropas = new ArrayList<>();
			//lavarropas = dbtLavarropa.getLavarropas();
			electrodomesticos.addAll(dbtLavarropa.getLavarropas());
			electrodomesticos.addAll(dbtTelevisor.getTelevisores());
			ele = electrodomesticos.get(indice);
			
			if(ele instanceof Lavarropa){
				
				ModLavarropa modLava = new ModLavarropa(ele);
				modLava.setVisible(true);
			}
			
			else{
				ModTelevisor modTele = new ModTelevisor(ele);
				modTele.setVisible(true);
			}
			
			
			/*ArrayList<Lavarropa> lavarropas = new ArrayList<>();
			lavarropas = dbtLavarropa.getLavarropas();
			lavarropas.remove(indice);
			dbtLavarropa.ActualizarLavarropas(lavarropas);
			this.LoadTable();*/

		}
		
	}
}
