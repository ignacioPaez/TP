package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import mySqlData.LavarropaDao;
import mySqlData.TelevisorDao;
import entidades.Electrodomestico;
import entidades.InterfaceDbt;
import entidades.Lavarropa;
import entidades.Televisor;

public class ListadoEliminar extends JFrame implements InterfaceDbt,
		ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JButton btnEliminarSeleccionado;
	private JButton btnSalir;
	Electrodomestico ele;
	public ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
	LavarropaDao lavaDao = new LavarropaDao();
	TelevisorDao teleDao = new TelevisorDao();

	public ListadoEliminar() {
		setResizable(false);
		setTitle("Eliminar Electrodomestico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 11, 544, 218);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setBounds(274, 240, 179, 23);
		contentPane.add(btnEliminarSeleccionado);
		btnEliminarSeleccionado.addActionListener(this);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(463, 240, 91, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);

		LoadTable();
	}

	private void LoadTable() {
		TableModelListado modelo = new TableModelListado();
		ArrayList<Electrodomestico> electrodomesticos= new ArrayList<>();
		electrodomesticos.addAll(dbtLavarropa.getLavarropas());
		electrodomesticos.addAll(dbtTelevisor.getTelevisores());
		modelo.setElectrodomesticos(electrodomesticos);
		table.setModel(modelo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == btnEliminarSeleccionado) {

			this.EliminarLavarropa(table.getSelectedRow());

		}

	}

	public void EliminarLavarropa(int indice) {
		if (table.getSelectedRow() != -1) {
			
			electrodomesticos.addAll(dbtLavarropa.getLavarropas());
			electrodomesticos.addAll(dbtTelevisor.getTelevisores());
			ele = electrodomesticos.get(indice);
			
			if(ele instanceof Lavarropa){
								
				ArrayList<Lavarropa> lavarropas = new ArrayList<Lavarropa>();
				lavarropas.addAll(dbtLavarropa.getLavarropas());
				lavarropas.remove(indice);
				dbtLavarropa.ActualizarLavarropas(lavarropas);
				lavaDao.eliminarLavarropa((Lavarropa)ele);
				this.LoadTable();
				
			}
			
			else{
				ArrayList<Televisor> televisores = new ArrayList<>();
				televisores.addAll(dbtTelevisor.getTelevisores());
				televisores.remove((Televisor)ele);
				dbtTelevisor.ActualizarTelevisor(televisores);
				teleDao.eliminarLavarropa((Televisor)ele);
				LoadTable();
			}

		}
	}
}
