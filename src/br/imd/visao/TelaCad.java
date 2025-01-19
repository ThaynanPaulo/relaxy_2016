package br.imd.visao;

/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Tela do ususario default 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.imd.modelo.ABB.ArvoreBinaria;
import br.imd.modelo.AcessoArquivo.AcessoArquivoABB;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class TelaCad extends JFrame {

	private JPanel contentPane;
	private JTextField tID;
	private JTextField tEmail;
	private JTextField tSenha;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCad frame = new TelaCad();
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
	public TelaCad() {
		
		setBounds(100, 100, 703, 504);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Impact", Font.PLAIN, 15));
		lblId.setBounds(171, 133, 23, 14);
		contentPane.add(lblId);
		
		tID = new JTextField();
		tID.setBounds(204, 130, 276, 20);
		contentPane.add(tID);
		tID.setColumns(10);
		
		JLabel lblSenha = new JLabel("EMAIL :");
		lblSenha.setFont(new Font("Impact", Font.PLAIN, 15));
		lblSenha.setBounds(148, 208, 46, 14);
		contentPane.add(lblSenha);
		
		tEmail = new JTextField();
		tEmail.setBounds(204, 205, 276, 20);
		contentPane.add(tEmail);
		tEmail.setColumns(10);
	
		JLabel lblSenha_1 = new JLabel("SENHA :");
		lblSenha_1.setFont(new Font("Impact", Font.PLAIN, 15));
		lblSenha_1.setBounds(148, 281, 46, 14);
		contentPane.add(lblSenha_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 280, 276, 20);
		contentPane.add(passwordField);
		
		JRadioButton rdbtnVip = new JRadioButton("VIP");
		rdbtnVip.setBackground(new Color(102, 204, 255));
		rdbtnVip.setBounds(235, 340, 63, 23);
		contentPane.add(rdbtnVip);
		
		JRadioButton rdbtnFree = new JRadioButton("FREE");
		rdbtnFree.setBackground(new Color(102, 204, 255));
		rdbtnFree.setBounds(371, 340, 109, 23);
		contentPane.add(rdbtnFree);
		
		ButtonGroup btgrp = new ButtonGroup();
		btgrp.add(rdbtnVip);
		btgrp.add(rdbtnFree);
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		Image img = new ImageIcon(this.getClass().getResource("/penguin-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 23));
		lblNewLabel.setBounds(235, 32, 202, 73);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(tID.getText().equals("") || passwordField.getPassword().equals("") || tEmail.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Complete os campos !");
				}
				else{
					
					AcessoArquivoABB aces1 = new AcessoArquivoABB();
					ArvoreBinaria arvore = new ArvoreBinaria();
					arvore = aces1.LerArquivoABB();
					ArvoreBinaria arv = arvore.busca(Integer.parseInt(tID.getText()));
					if(rdbtnVip.isSelected() == false && rdbtnFree.isSelected() == false){
						JOptionPane.showMessageDialog(null, "Escolha o tipo de conta");
					}
					else if(arv != null) {
						JOptionPane.showMessageDialog(null, "ID já cadastrado. Escreva outro.");
						System.out.println("Id já cadastrado.");
					}
					else if(rdbtnVip.isSelected() == true ) {
						JOptionPane.showMessageDialog(null, "Usuário VIP cadastrado com sucesso !");
						System.out.println(Integer.parseInt(tID.getText()));
						System.out.println(tEmail.getText());
						System.out.println(passwordField.getPassword());
						System.out.println(true);
						arvore.insereCadastro(Integer.parseInt(tID.getText()), tEmail.getText(), String.valueOf(passwordField.getPassword()), true);
						aces1.EscreverArquivoABB(arvore);
						File asd = new File("./User/"+ tID.getText());
						asd.mkdir();
					
					}
					else if(rdbtnFree.isSelected() == true ){
						JOptionPane.showMessageDialog(null, "Usuário FREE cadastrado com sucesso !");
						arvore = aces1.LerArquivoABB();
						arvore.insereCadastro(Integer.parseInt(tID.getText()), tEmail.getText(),  String.valueOf(passwordField.getPassword()), false);
						aces1.EscreverArquivoABB(arvore);
						File asd = new File("./User/"+ tID.getText());
						asd.mkdir();
					
					}
				}
			
			
			}
		});
		btnCadastrar.setBounds(171, 386, 107, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(411, 386, 107, 23);
		contentPane.add(btnCancelar);
		
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta2;
				resposta2 = JOptionPane.showConfirmDialog(null, "Você deseja limpar as informações?");
				
				tID.setText("");
				tEmail.setText("");
				tSenha.setText("");
				if(resposta2 == JOptionPane.YES_OPTION){
					 JOptionPane.showMessageDialog(null, "Suas informações foram apagadas!");
				}
			}
		});
		btnLimpar.setBounds(299, 386, 89, 23);
		contentPane.add(btnLimpar);
		
	}
}
