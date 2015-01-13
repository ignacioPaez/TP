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

import negocio.NegocioLavarropa;
import negocio.NegocioTelevisor;
import mySqlData.LavarropaDao;
import mySqlData.TelevisorDao;
import entidades.Electrodomestico;
import entidades.InterfaceDbt;

public class Listado extends JFrame implements InterfaceDbt, ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JButton btnSalir;
	TelevisorDao telDao = new TelevisorDao();
	LavarropaDao lavaDao = new LavarropaDao();
	NegocioLavarropa negLavarropa = new  NegocioLavarropa();
	

	public Listado() {
		setResizable(false);
		setTitle("Listado de Electrodomesticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 11, 497, 217);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(416, 239, 91, 23);
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

		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		this.dispose();

	}
}