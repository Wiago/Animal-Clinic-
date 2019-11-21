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

public class ViewMedico2Tela {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMedico2Tela window = new ViewMedico2Tela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public ViewMedico2Tela() {
		initialize();
	}
		
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastrar = new JButton("Solicitar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBackground(new Color(211, 211, 211));
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(91, 189, 127, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnLogar = new JButton("Solicitar");
		btnLogar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBackground(new Color(211, 211, 211));
		btnLogar.setBounds(91, 92, 127, 23);
		frame.getContentPane().add(btnLogar);
		
		JButton btnSair = new JButton("Solicitar");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSair.setForeground(Color.BLACK);
		btnSair.setBackground(new Color(211, 211, 211));
		btnSair.setBounds(91, 141, 127, 23);
		frame.getContentPane().add(btnSair);
		
		JLabel lblAnimalClinic = new JLabel("M\u00E9dico");
		lblAnimalClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimalClinic.setFont(new Font("Century Schoolbook", Font.BOLD, 35));
		lblAnimalClinic.setBounds(0, 11, 434, 54);
		frame.getContentPane().add(lblAnimalClinic);
		
		JLabel lblNewLabel = new JLabel("Consultas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(21, 97, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblExames = new JLabel("Exames");
		lblExames.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExames.setBounds(21, 146, 71, 14);
		frame.getContentPane().add(lblExames);
		
		JLabel lblCirurgia = new JLabel("Cirurgia");
		lblCirurgia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCirurgia.setBounds(21, 191, 71, 18);
		frame.getContentPane().add(lblCirurgia);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(246, 92, 127, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(246, 141, 127, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setBounds(246, 189, 127, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
	
}	
}