package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;



public class SeleccionarElectro extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton cancelar,aceptar;
	private JComboBox comboBox;

	public SeleccionarElectro() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Seleccionar Electrodomestico");
		setBounds(100, 100, 371, 148);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Televisor", "Lavarropas"}));
		comboBox.setBounds(70, 27, 221, 22);
		contentPane.add(comboBox);

		aceptar = new JButton("Aceptar");
		aceptar.setBounds(10, 78, 170, 23);
		contentPane.add(aceptar);
		aceptar.addActionListener(this);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(190, 78, 165, 23);
		contentPane.add(cancelar);
		cancelar.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==aceptar){
			if(comboBox.getSelectedItem()=="Televisor"){
				
				AgregarTelevisor agregarTele= new AgregarTelevisor();
				agregarTele.setVisible(true);
				this.dispose();
				
			}
			else{
				AgregarLavarropas agregarLava= new AgregarLavarropas();
				agregarLava.setVisible(true);
				this.dispose();
			}
			
		
		}
		
		if(e.getSource()==cancelar){
			
			VentanaPrincipal ventana= new VentanaPrincipal();
			ventana.setVisible(true);
			this.dispose();
		}
		
		
	}
}
