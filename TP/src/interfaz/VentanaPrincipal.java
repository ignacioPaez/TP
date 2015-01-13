package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton agregar, listado, modificar, eliminar;
	private JPanel contentPane;
	

	public VentanaPrincipal() {
	
		
		setType(Type.POPUP);
		setTitle("Menu principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		agregar = new JButton("Agregar Electrodomestico");
		agregar.setBounds(45, 28, 209, 33);
		contentPane.add(agregar);
		agregar.addActionListener(this);

		listado = new JButton("Listado de Electrodomesticos");
		listado.setBounds(45, 84, 209, 33);
		contentPane.add(listado);
		listado.addActionListener(this);

		modificar = new JButton("Modificar Electrodomestico");
		modificar.setBounds(45, 144, 209, 33);
		contentPane.add(modificar);
		modificar.addActionListener(this);

		eliminar = new JButton("Eliminar Electrodomestico");
		eliminar.setBounds(45, 202, 209, 33);
		contentPane.add(eliminar);
		eliminar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == agregar) {
			

			SeleccionarElectro selecc = new SeleccionarElectro();
			selecc.setVisible(true);
			this.dispose();

		}
		if (e.getSource() == listado) {
			
			Listado listado= new Listado();
			listado.setVisible(true);
			this.dispose();

		}
		if (e.getSource() == eliminar) {
			ListadoEliminar list= new ListadoEliminar();
			list.setVisible(true);
			this.dispose();

		} if(e.getSource()==modificar){
			ListadoModificar lista= new ListadoModificar();
			lista.setVisible(true);
			this.dispose();}
			
			

		}

	}
