package br.ufrpe.animal_clinic.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;

public class ViewCadastro {

	private JFrame frame;
	private JTextField txtCompleto;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField txtXxxxxxxx;
	private JTextField txtXxxxxxxxxxx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro window = new ViewCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		mnArquivo.add(mntmSalvar);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmPerguntasFrequentes = new JMenuItem("Perguntas Frequentes");
		mnAjuda.add(mntmPerguntasFrequentes);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 182, 193));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblCadastro = new JLabel("Cadastro de Usu\u00E1rio ");
		lblCadastro.setForeground(Color.DARK_GRAY);
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCadastro.setBounds(122, 14, 339, 53);
		desktopPane.add(lblCadastro);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(43, 143, 56, 16);
		desktopPane.add(lblNome);
		
		txtCompleto = new JTextField();
		txtCompleto.setBounds(111, 142, 116, 22);
		desktopPane.add(txtCompleto);
		txtCompleto.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(43, 191, 56, 33);
		desktopPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(43, 252, 56, 16);
		desktopPane.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(111, 198, 116, 22);
		desktopPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usu\u00E1rio", "M\u00E9dico", "Atendente"}));
		comboBox.setBounds(454, 254, 86, 24);
		desktopPane.add(comboBox);
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de Usu\u00E1rio:");
		lblTipoDeUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDeUsurio.setBounds(311, 253, 131, 22);
		desktopPane.add(lblTipoDeUsurio);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 251, 116, 22);
		desktopPane.add(passwordField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(231, 391, 97, 25);
		desktopPane.add(btnCadastrar);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNascimento.setBounds(311, 144, 116, 16);
		desktopPane.add(lblNascimento);
		
		txtXxxxxxxx = new JTextField();
		txtXxxxxxxx.setText("xx/xx/xxxx");
		txtXxxxxxxx.setBounds(424, 143, 116, 22);
		desktopPane.add(txtXxxxxxxx);
		txtXxxxxxxx.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(311, 192, 56, 33);
		desktopPane.add(lblCpf);
		
		txtXxxxxxxxxxx = new JTextField();
		txtXxxxxxxxxxx.setText("xxx.xxx.xxx-xx");
		txtXxxxxxxxxxx.setColumns(10);
		txtXxxxxxxxxxx.setBounds(363, 199, 116, 22);
		desktopPane.add(txtXxxxxxxxxxx);
	}
}
