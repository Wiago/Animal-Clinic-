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

import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Login;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class ViewPrimeiraTela {

	private Servico s = new Servico();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrimeiraTela window = new ViewPrimeiraTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public ViewPrimeiraTela() {
		initialize();
	}
		
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(107, 92, 52, 20);
		frame.getContentPane().add(lblLogin);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 250, 250));
		textField.setBounds(155, 92, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSenha.setBounds(107, 123, 56, 20);
		frame.getContentPane().add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 250, 250));
		textField_1.setBounds(155, 123, 111, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBackground(new Color(255, 204, 255));
		btnCadastrar.setForeground(new Color(255, 105, 180));
		btnCadastrar.setBounds(162, 227, 104, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnLogar = new JButton("LOGAR");
		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogar.setBackground(new Color(153, 255, 102));
		btnLogar.setForeground(new Color(0, 100, 0));
		btnLogar.setBounds(70, 173, 89, 23);
		
		btnLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String login = textField.getText();
				String senha = textField_1.getText();
				
				Login a = new Login(login, senha);
				
				try {
					s.efetuarLoginMedico(a);
				} catch (NullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		frame.getContentPane().add(btnLogar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSair.setForeground(new Color(204, 0, 0));
		btnSair.setBackground(new Color(255, 102, 102));
		btnSair.setBounds(270, 173, 89, 23);
		frame.getContentPane().add(btnSair);
		
		JLabel lblAnimalClinic = new JLabel("ANIMAL CLINIC");
		lblAnimalClinic.setFont(new Font("Colonna MT", Font.PLAIN, 35));
		lblAnimalClinic.setBounds(91, 11, 294, 54);
		frame.getContentPane().add(lblAnimalClinic);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
	
}	
}