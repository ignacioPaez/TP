package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

import data.DbtLavarropa;
import mySqlData.IdentificadorDao;
import mySqlData.LavarropaDao;
import negocio.NegocioLavarropa;
import entidades.Color;
import entidades.ConsumoEnergetico;
import entidades.Electrodomestico;
import entidades.Identificador;
import entidades.Lavarropa;

public class ModLavarropa extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtPeso, txtPrecio, txtCarga;
	private JComboBox txtColor, txtConsumo;
	private JButton aceptar, cancelar;

	ArrayList<Lavarropa> lavarropas = new ArrayList<>();
	Lavarropa lava;

	public ModLavarropa(Electrodomestico ele) {
		setResizable(false);
		setTitle("Agregar Lavarropas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 266, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(36, 23, 46, 14);
		contentPane.add(lblPeso);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(36, 57, 46, 14);
		contentPane.add(lblColor);

		JLabel lblPrecioBase = new JLabel("Precio Base");
		lblPrecioBase.setBounds(36, 93, 74, 14);
		contentPane.add(lblPrecioBase);

		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setBounds(36, 126, 74, 14);
		contentPane.add(lblConsumo);

		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(36, 163, 58, 14);
		contentPane.add(lblCarga);

		txtPeso = new JTextField();
		txtPeso.setBounds(145, 20, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		txtColor = new JComboBox();
		txtColor.setModel(new DefaultComboBoxModel(new String[] { "", "Blanco",
				"Negro", "Azul", "Gris", "Rojo" }));
		txtColor.setBounds(145, 53, 86, 22);
		contentPane.add(txtColor);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(145, 90, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtConsumo = new JComboBox();
		txtConsumo.setModel(new DefaultComboBoxModel(new String[] { "", "A",
				"B", "C", "D", "E", "F" }));
		txtConsumo.setBounds(160, 122, 71, 22);
		contentPane.add(txtConsumo);

		txtCarga = new JTextField();
		txtCarga.setBounds(145, 160, 86, 20);
		contentPane.add(txtCarga);
		txtCarga.setColumns(10);

		aceptar = new JButton("Aceptar");
		aceptar.setBounds(26, 204, 91, 23);
		contentPane.add(aceptar);
		aceptar.addActionListener(this);

		cancelar = new JButton("Salir");
		cancelar.setBounds(140, 204, 91, 23);
		contentPane.add(cancelar);
		cancelar.addActionListener(this);

		lava = (Lavarropa) ele;
		modifica(ele);
		
	}

	private void modifica(Electrodomestico ele) {
		// TODO Auto-generated method stub
		txtPeso.setText(Double.toString(ele.getPeso()));
		txtPrecio.setText(Double.toString(ele.getPrecioBase()));
		txtCarga.setText(Double.toString(((Lavarropa) ele).getCarga()));
		txtColor.setToolTipText(ele.getColor().getColor());
		char c = ele.getConsumoEnergetico().getConsumoEner();
		String s = String.valueOf(c);
		txtConsumo.setToolTipText(s);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == aceptar) {

			lava.setPeso(Double.parseDouble(txtPeso.getText()));
			lava.setPrecioBase( Double.parseDouble(txtPrecio.getText()));
			String color = (String) txtColor.getSelectedItem();
			Color c = new Color();
			c.setColor(color);
			lava.setColor(c);
			String consumo = (String) txtConsumo.getSelectedItem();
			char con = consumo.charAt(0);
			ConsumoEnergetico ce = new ConsumoEnergetico();
			ce.setConsumoEner(con);
			lava.setConsumoEnergetico(ce);
			lava.setCarga(Double.parseDouble(txtCarga.getText()));

			LavarropaDao lavDao = new LavarropaDao();
			lavDao.modificarLavarropa(lava);

			NegocioLavarropa negLavarropa = new NegocioLavarropa();

			negLavarropa.modificarLavarropa(lava);

			txtPrecio.setText(null);
			txtPeso.setText(null);
			txtCarga.setText(null);
			txtColor.setSelectedIndex(0);
			txtConsumo.setSelectedIndex(0);

		}

		else {
			VentanaPrincipal ventana = new VentanaPrincipal();
			ventana.setVisible(true);
			this.dispose();
		}

	}

}
