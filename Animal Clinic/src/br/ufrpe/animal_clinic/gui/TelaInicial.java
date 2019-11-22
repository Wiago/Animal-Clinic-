package br.ufrpe.animal_clinic.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufrpe.animal_clinic.dados.RepositorioUsuarios;
import br.ufrpe.animal_clinic.exception.NullException;
import br.ufrpe.animal_clinic.negocio.Servico;
import br.ufrpe.animal_clinic.negocio.beans.Alimentacao;
import br.ufrpe.animal_clinic.negocio.beans.Animal;
import br.ufrpe.animal_clinic.negocio.beans.Atendente;
import br.ufrpe.animal_clinic.negocio.beans.Especie;
import br.ufrpe.animal_clinic.negocio.beans.Genero;
import br.ufrpe.animal_clinic.negocio.beans.Login;
import br.ufrpe.animal_clinic.negocio.beans.Medico;
import br.ufrpe.animal_clinic.negocio.beans.TempoDeVida;
import br.ufrpe.animal_clinic.negocio.beans.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Servico s;
	private static GetInformacao i = new GetInformacao();
	private RepositorioUsuarios u;

	/**
	 * Launch the application.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					u.salvarDados("HistoricoDeUsuarios.txt");
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
		
		JLabel label = new JLabel("ANIMAL CLINIC");
		label.setFont(new Font("Colonna MT", Font.PLAIN, 50));
		label.setBounds(207, 13, 429, 84);
		desktopPane.add(label);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(207, 166, 89, 23);
		desktopPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 250, 250));
		textField.setBounds(308, 164, 219, 25);
		desktopPane.add(textField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSenha.setBounds(207, 224, 89, 23);
		desktopPane.add(lblSenha);
		
		JButton button = new JButton("LOGAR");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String senha, id;
				id = textField.getText();
				senha = passwordField.getText();
				if(id != null && senha != null && id != "" && senha != "") {
				 	Login l = new Login(id, senha);
					try {
						switch (id.charAt(0)) {
						case '1':
							
							break;
						case '2':
							s.efetuarLoginRecepcionista(l);
							break;
						case '3':
							i.loginU(id, senha);
							break;

						default:
							break;
						}
					} catch (NullException e1) {
						e1.printStackTrace();
					}	
				}
				
			}
		});
		button.setForeground(new Color(0, 100, 0));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(new Color(153, 255, 102));
		button.setBounds(151, 331, 100, 23);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("CADASTRAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastro().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setForeground(new Color(255, 105, 180));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBackground(new Color(255, 204, 255));
		button_1.setBounds(326, 379, 135, 25);
		desktopPane.add(button_1);
		
		JButton button_2 = new JButton("SAIR");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_2.setForeground(new Color(204, 0, 0));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_2.setBackground(new Color(255, 102, 102));
		button_2.setBounds(558, 331, 100, 23);
		desktopPane.add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passwordField.setBounds(308, 224, 219, 25);
		desktopPane.add(passwordField);
	}
}
