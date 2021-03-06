package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

import mySqlData.LavarropaDao;
import mySqlData.TelevisorDao;
import negocio.NegocioLavarropa;
import negocio.NegocioTelevisor;
import entidades.Lavarropa;
import entidades.Televisor;




public class AgregarTelevisor extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPeso, txtResolucion, txtPrecio;
	private JButton aceptar, cancelar;
	private JComboBox txtColor, txtConsumo, txtSintonizador;

	ArrayList<Televisor> televisores= new ArrayList<>();

	public AgregarTelevisor() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Agregar Televisor");
		setBounds(100, 100, 273, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtPeso = new JTextField();
		txtPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPeso.setBounds(130, 11, 107, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(32, 14, 46, 14);
		contentPane.add(lblPeso);

		txtColor = new JComboBox();
		txtColor.setModel(new DefaultComboBoxModel(new String[] { "", "Blanco",
				"Rojo", "Negro", "Azul", "Gris" }));
		txtColor.setBounds(130, 42, 107, 22);
		contentPane.add(txtColor);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(32, 46, 46, 14);
		contentPane.add(lblColor);

		txtPrecio = new JTextField();
		txtPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecio.setBounds(130, 75, 107, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioBase.setBounds(32, 77, 75, 14);
		contentPane.add(lblPrecioBase);

		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setBounds(32, 109, 75, 14);
		contentPane.add(lblConsumo);

		txtConsumo = new JComboBox();
		txtConsumo.setModel(new DefaultComboBoxModel(new String[] { "", "A",
				"B", "C", "D", "E", "F" }));
		txtConsumo.setBounds(170, 105, 67, 22);
		contentPane.add(txtConsumo);

		txtSintonizador = new JComboBox();
		txtSintonizador.setModel(new DefaultComboBoxModel(new String[] { "Si",
				"No" }));
		txtSintonizador.setBounds(170, 138, 67, 22);
		contentPane.add(txtSintonizador);

		JLabel lblSintonizador = new JLabel("Sintonizador");
		lblSintonizador.setHorizontalAlignment(SwingConstants.LEFT);
		lblSintonizador.setBounds(32, 142, 96, 14);
		contentPane.add(lblSintonizador);

		txtResolucion = new JTextField();
		txtResolucion.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResolucion.setBounds(130, 167, 107, 20);
		contentPane.add(txtResolucion);
		txtResolucion.setColumns(10);

		JLabel lblResolucon = new JLabel("Resolucion");
		lblResolucon.setBounds(32, 170, 96, 14);
		contentPane.add(lblResolucon);

		aceptar = new JButton("Aceptar");
		aceptar.setBounds(32, 206, 91, 23);
		contentPane.add(aceptar);
		aceptar.addActionListener(this);

		cancelar = new JButton("Salir");
		cancelar.setBounds(140, 206, 97, 23);
		contentPane.add(cancelar);
		cancelar.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == aceptar) {

			TelevisorDao telDao = new TelevisorDao();
			NegocioTelevisor negTele= new NegocioTelevisor();
			
			
			double peso = Double.parseDouble(txtPeso.getText());
			double precio = Double.parseDouble(txtPrecio.getText());
			String color = (String) txtColor.getSelectedItem();

			String consumo =(String) txtConsumo.getSelectedItem();
			char con=consumo.charAt(0);

			boolean sintonizador;
			double resolucion = Double.parseDouble(txtResolucion.getText());
			

			if (txtSintonizador.getSelectedItem() == "Si") {
				sintonizador = true;
			} else {
				sintonizador = false;
			}
			Televisor televisor=new Televisor(precio, peso, color, con, sintonizador, resolucion);
			
			telDao.registrarTelevisor(televisor);
			
			
			negTele.Registrar(televisor);
			
			JOptionPane.showMessageDialog(null, "Televisor Agregado");
			txtPeso.setText(null);
			txtPrecio.setText(null);
			txtResolucion.setText(null);
			txtColor.setSelectedIndex(0);
			txtConsumo.setSelectedIndex(0);

		} else {
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			this.dispose();

		}

	}

}
