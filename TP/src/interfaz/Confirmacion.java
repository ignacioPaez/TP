package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Confirmacion extends JFrame {

	private JPanel contentPane;

	
	public Confirmacion() {
		setTitle("Confirmacion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 117);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u00BFEst\u00E1 seguro que desea salir?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 22, 252, 14);
		contentPane.add(lblNewLabel);

		JButton btnSi = new JButton("SI");
		btnSi.setBounds(40, 58, 91, 23);
		contentPane.add(btnSi);

		JButton btnNo = new JButton("NO");
		btnNo.setBounds(137, 58, 91, 23);
		contentPane.add(btnNo);
	}

}

