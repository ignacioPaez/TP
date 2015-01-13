package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Baja extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baja frame = new Baja();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Baja() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 252, 418, -239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 32, 402, 157);
		contentPane.add(table);
		
		JLabel lblListadoDeElectrodomesticos = new JLabel("Listado de Electrodomesticos");
		lblListadoDeElectrodomesticos.setBounds(10, 11, 241, 14);
		contentPane.add(lblListadoDeElectrodomesticos);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(220, 200, 91, 23);
		contentPane.add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(321, 200, 91, 23);
		contentPane.add(btnCancelar);
	}
}
