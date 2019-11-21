package br.ufrpe.animal_clinic.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ViewUsuario2Tela {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUsuario2Tela window = new ViewUsuario2Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ViewUsuario2Tela() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogar = new JButton("Solicitar Consulta");
		btnLogar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBackground(new Color(211, 211, 211));
		btnLogar.setBounds(125, 93, 184, 23);
		frame.getContentPane().add(btnLogar);
		
		JButton btnSair = new JButton("Visualizar Prontu\u00E1rio");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setForeground(Color.BLACK);
		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setBounds(125, 192, 184, 23);
		frame.getContentPane().add(btnSair);
		
		JLabel lblAnimalClinic = new JLabel("Usu\u00E1rio");
		lblAnimalClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimalClinic.setFont(new Font("Century Schoolbook", Font.BOLD, 35));
		lblAnimalClinic.setBounds(0, 11, 434, 54);
		frame.getContentPane().add(lblAnimalClinic);
		
		JButton btnNewButton = new JButton("Altera\u00E7\u00E3o de Consulta");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(125, 143, 184, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
	
}	
}