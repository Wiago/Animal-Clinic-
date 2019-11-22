package br.ufrpe.animal_clinic.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrpe.animal_clinic.exception.ExisteException;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private static GetInformacao i = new GetInformacao();
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 530);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					i.salvar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmSalvar);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmPerguntasFrequentes = new JMenuItem("Perguntas Frequentes");
		mnAjuda.add(mntmPerguntasFrequentes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 182, 193));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Cadastro de Usu\u00E1rio ");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD, 40));
		label.setBounds(182, 13, 432, 53);
		desktopPane.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(96, 161, 93, 16);
		desktopPane.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 19));
		textField.setColumns(10);
		textField.setBounds(182, 161, 150, 22);
		desktopPane.add(textField);
		
		JLabel label_2 = new JLabel("Login:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_2.setBounds(96, 225, 93, 33);
		desktopPane.add(label_2);
		
		JLabel label_3 = new JLabel("Senha:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_3.setBounds(96, 314, 93, 16);
		desktopPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 19));
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(182, 233, 150, 22);
		desktopPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object a = comboBox.getSelectedItem();
				
				System.out.println(a);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usu\u00E1rio", "M\u00E9dico", "Atendente"}));
		comboBox.setBounds(577, 310, 116, 24);
		desktopPane.add(comboBox);
		
		JLabel label_4 = new JLabel("Tipo de Usu\u00E1rio:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_4.setBounds(401, 311, 164, 22);
		desktopPane.add(label_4);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 19));
		passwordField.setBounds(182, 311, 150, 22);
		desktopPane.add(passwordField);
		
		JButton button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat f = DateFormat.getDateInstance();
				String nome = textField.getText();
				String login = textField_1.getText();
				String senha = passwordField.getText();
				String data = textField_2.getText();
				String cpf = textField_3.getText();
				
				Date data1 = null;
		
				try {
					data1 = f.parse(data);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
					
				int a = comboBox.getSelectedIndex();
				
				
				
				switch (a) {
				case 0:
					try {
						i.cadastrarU(nome, cpf, senha, login, data1);
						i.salvar();
					} catch (ExisteException | NullException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					break;

				default:
					break;
				}
			}
		});
		button.setForeground(new Color(154, 205, 50));
		button.setFont(new Font("Tahoma", Font.BOLD, 19));
		button.setBounds(309, 404, 136, 25);
		desktopPane.add(button);
		
		JLabel label_5 = new JLabel("Nascimento:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_5.setBounds(401, 162, 164, 16);
		desktopPane.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_2.setText("xx/xx/xxxx");
		textField_2.setColumns(10);
		textField_2.setBounds(577, 161, 150, 22);
		desktopPane.add(textField_2);
		
		JLabel label_6 = new JLabel("CPF:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_6.setBounds(401, 226, 56, 33);
		desktopPane.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_3.setText("xxx.xxx.xxx-xx");
		textField_3.setColumns(10);
		textField_3.setBounds(514, 232, 150, 22);
		desktopPane.add(textField_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaInicial().setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setForeground(Color.RED);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnVoltar.setBounds(60, 383, 136, 25);
		desktopPane.add(btnVoltar);
	}
}
