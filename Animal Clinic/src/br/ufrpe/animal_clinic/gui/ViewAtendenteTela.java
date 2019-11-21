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

public class ViewAtendenteTela {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAtendenteTela window = new ViewAtendenteTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewAtendenteTela() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 558, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogar = new JButton("Marca Cirurgia");
		btnLogar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogar.setForeground(Color.BLACK);
		btnLogar.setBackground(new Color(211, 211, 211));
		btnLogar.setBounds(42, 129, 166, 36);
		btnLogar.doClick();
		frame.getContentPane().add(btnLogar);
		
		JLabel lblAnimalClinic = new JLabel("Atendente");
		lblAnimalClinic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimalClinic.setFont(new Font("Century Schoolbook", Font.BOLD, 35));
		lblAnimalClinic.setBounds(0, 11, 540, 67);
		frame.getContentPane().add(lblAnimalClinic);
		
		JButton btnMarcaConsulta = new JButton("Marca Consulta");
		btnMarcaConsulta.setForeground(Color.BLACK);
		btnMarcaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMarcaConsulta.setBackground(new Color(211, 211, 211));
		btnMarcaConsulta.setBounds(42, 213, 166, 36);
		frame.getContentPane().add(btnMarcaConsulta);
		
		JButton btnMarcaExame = new JButton("Marca Exame");
		btnMarcaExame.setForeground(Color.BLACK);
		btnMarcaExame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMarcaExame.setBackground(new Color(211, 211, 211));
		btnMarcaExame.setBounds(42, 296, 166, 36);
		frame.getContentPane().add(btnMarcaExame);
		
		JButton btnAlterarCirurgia = new JButton("Alterar Cirurgia");
		btnAlterarCirurgia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlterarCirurgia.setForeground(Color.BLACK);
		btnAlterarCirurgia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterarCirurgia.setBackground(new Color(211, 211, 211));
		btnAlterarCirurgia.setBounds(305, 129, 166, 36);
		frame.getContentPane().add(btnAlterarCirurgia);
		
		JButton btnAlterarConsulta = new JButton("Alterar Consulta");
		btnAlterarConsulta.setForeground(Color.BLACK);
		btnAlterarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterarConsulta.setBackground(new Color(211, 211, 211));
		btnAlterarConsulta.setBounds(305, 213, 166, 36);
		frame.getContentPane().add(btnAlterarConsulta);
		
		JButton btnAlterarExame = new JButton("Alterar Exame");
		btnAlterarExame.setForeground(Color.BLACK);
		btnAlterarExame.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterarExame.setBackground(new Color(211, 211, 211));
		btnAlterarExame.setBounds(305, 296, 166, 36);
		frame.getContentPane().add(btnAlterarExame);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(-2, 0, 542, 401);
		frame.getContentPane().add(panel);
	
}	
}