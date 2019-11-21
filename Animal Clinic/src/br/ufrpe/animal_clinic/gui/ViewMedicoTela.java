package br.ufrpe.animal_clinic.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class ViewMedicoTela {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMedicoTela window = new ViewMedicoTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public ViewMedicoTela() {
		initialize();
	}
		
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Alterar Dados");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBackground(new Color(211, 211, 211));
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(91, 189, 251, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnLogar = new JButton("Visualizar Lista de Pacientes");
		btnLogar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBackground(new Color(211, 211, 211));
		btnLogar.setBounds(91, 92, 251, 23);
		frame.getContentPane().add(btnLogar);
		
		JButton btnSair = new JButton("Agenda M\u00E9dica");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setForeground(Color.BLACK);
		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setBounds(91, 141, 251, 23);
		frame.getContentPane().add(btnSair);
		
		JLabel lblAnimalClinic = new JLabel("M\u00E9dico");
		lblAnimalClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimalClinic.setFont(new Font("Century Schoolbook", Font.BOLD, 35));
		lblAnimalClinic.setBounds(0, 11, 434, 54);
		frame.getContentPane().add(lblAnimalClinic);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
	
}	
}
