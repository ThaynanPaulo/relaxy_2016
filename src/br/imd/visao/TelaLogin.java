package br.imd.visao;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.SystemColor;

import br.imd.controle.IDNegativoException;
import br.imd.modelo.ABB.ArvoreBinaria;
import br.imd.modelo.AcessoArquivo.AcessoArquivoABB;

import javax.swing.JPasswordField;

/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Tela de acesso ao login 
 */
public class TelaLogin extends JPanel {
	private JTextField tID;
	public ArrayList<Cadastro> listaCadastros;
	
	/**
	 * Create the panel.
	 */
	
	
	private JPasswordField passwordField;
	
	public TelaLogin(ArvoreBinaria arvore) {
		
		Cadastro cliente;
		ArvoreBinaria arv = null;
		arv = arvore.busca(123);
		//System.out.println(arv.getRaiz().getCadastro().getEmail());
		
		setBackground(new Color(102, 204, 255));
		setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Impact", Font.PLAIN, 15));
		lblId.setBounds(188, 140, 26, 14);
		add(lblId);
		
		JLabel lblSenha = new JLabel("SENHA :");
		lblSenha.setFont(new Font("Impact", Font.PLAIN, 15));
		lblSenha.setBounds(168, 225, 46, 14);
		add(lblSenha);
		

		JRadioButton rdVIP = new JRadioButton("VIP");
		rdVIP.setFont(new Font("Georgia", Font.BOLD, 12));
		rdVIP.setBackground(new Color(102, 204, 255));
		rdVIP.setBounds(168, 316, 48, 23);
		add(rdVIP);
		
		JRadioButton rdbtnFree = new JRadioButton("FREE");
		rdbtnFree.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnFree.setBackground(new Color(102, 204, 255));
		rdbtnFree.setBounds(288, 316, 68, 23);
		add(rdbtnFree);
		
		JRadioButton rdbtnDefault = new JRadioButton("DEFAULT");
		rdbtnDefault.setFont(new Font("Georgia", Font.BOLD, 12));
		rdbtnDefault.setBackground(new Color(102, 204, 255));
		rdbtnDefault.setBounds(420, 316, 89, 23);
		add(rdbtnDefault);
		
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		btnEntrar.setBackground(SystemColor.menu);
		btnEntrar.setBounds(188, 385, 98, 23);
		add(btnEntrar);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(231, 224, 258, 20);
		add(passwordField);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArvoreBinaria arv = arvore.busca(Integer.parseInt(tID.getText()));
				if(rdbtnDefault.isSelected() == true && arv.getRaiz().getCadastro().getSenha().equals(new String(passwordField.getPassword()) )){
					JOptionPane.showMessageDialog(null, "Suas informações estão corretas!");
					//JFileChooser fileChooser = new JFileChooser();
					System.out.println(arv.getRaiz().getCadastro().getSenha());
					removeAll();
					JPanel panelContent = new TelaDefault(arvore);
					panelContent.setBounds(0, 0, 703, 504);
					add(panelContent);
					
					//updateUI();
					revalidate();
					repaint();
			}
				else if(rdVIP.isSelected() && arv.getRaiz().getCadastro().getVip() == true ){
					removeAll();
					JPanel panelContent = new TelaVIP(arvore,tID.getText());
					panelContent.setBounds(0, 0, 703, 504);
					add(panelContent);
					
					//updateUI();
					revalidate();
					repaint();
				}
				else if(rdbtnFree.isSelected() && arv.getRaiz().getCadastro().getVip() == false){
					removeAll();
					JPanel panelContent = new TelaFree(arvore,tID.getText());
					panelContent.setBounds(0, 0, 703, 504);
					add(panelContent);
					
					//updateUI();
					revalidate();
					repaint();
				}
				else if(tID.getText().equals("") || new String(passwordField.getPassword()).equals("")){
					JOptionPane.showMessageDialog(null, "Você não completou os campos/Não colocou as informações corretas !!");
				}
				else{
					JOptionPane.showMessageDialog(null, "Você não completou os campos/Colocou as informações corretas !!");
				}
			
			}
		
		});
			
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		btnLimpar.setBackground(SystemColor.menu);
		btnLimpar.setBounds(411, 385, 98, 23);
		add(btnLimpar);
		

		tID = new JTextField();
		tID.setBounds(231, 139, 258, 20);
		add(tID);
		tID.setColumns(10);
		
	
		JLabel lblNewLabel = new JLabel("Relaxy");
		Image img = new ImageIcon(this.getClass().getResource("/penguin-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(267, 45, 173, 59);
		add(lblNewLabel);
		
		ButtonGroup btgrp = new ButtonGroup();
		btgrp.add(rdbtnDefault);
		btgrp.add(rdVIP);
		btgrp.add(rdbtnFree);
		
	}
}
