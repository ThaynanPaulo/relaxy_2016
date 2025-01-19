package br.imd.visao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import br.imd.modelo.AcessoArquivo.AcessoArquivoABB;
import br.imd.modelo.ABB.ArvoreBinaria;

public class TelaCadastro extends JPanel {
	
	private JTextField tID;
	private JTextField tEmail;
	private JTextField tSenha;

	/**
	 * Create the panel.
	 */
	public TelaCadastro(ArvoreBinaria arvore) {
		JFrame pp = new JFrame();
		setBackground(new Color(102, 204, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(0, 0, 704, 503);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Impact", Font.PLAIN, 15));
		lblId.setBounds(171, 133, 23, 14);
		panel.add(lblId);
		
		tID = new JTextField();
		tID.setBounds(204, 130, 276, 20);
		panel.add(tID);
		tID.setColumns(10);
		
		JLabel lblSenha = new JLabel("EMAIL :");
		lblSenha.setFont(new Font("Impact", Font.PLAIN, 15));
		lblSenha.setBounds(148, 208, 46, 14);
		panel.add(lblSenha);
		
		tEmail = new JTextField();
		tEmail.setBounds(204, 205, 276, 20);
		panel.add(tEmail);
		tEmail.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(148, 256, 46, 14);
		panel.add(label);
		
		JLabel lblSenha_1 = new JLabel("SENHA :");
		lblSenha_1.setFont(new Font("Impact", Font.PLAIN, 15));
		lblSenha_1.setBounds(148, 281, 46, 14);
		panel.add(lblSenha_1);
		
		tSenha = new JTextField();
		tSenha.setBounds(204, 278, 276, 17);
		panel.add(tSenha);
		tSenha.setColumns(10);
		
		JRadioButton rdbtnVip = new JRadioButton("VIP");
		rdbtnVip.setBackground(new Color(102, 204, 255));
		rdbtnVip.setBounds(235, 340, 63, 23);
		panel.add(rdbtnVip);
		
		JRadioButton rdbtnFree = new JRadioButton("FREE");
		rdbtnFree.setBackground(new Color(102, 204, 255));
		rdbtnFree.setBounds(371, 340, 109, 23);
		panel.add(rdbtnFree);
		

		ButtonGroup btgrp = new ButtonGroup();
		btgrp.add(rdbtnVip);
		btgrp.add(rdbtnFree);
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(tID.getText().equals("") || tSenha.getText().equals("") || tEmail.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Complete os campos !");
				}
				else{
					ArvoreBinaria arv = arvore.busca(Integer.parseInt(tID.getText()));
					if(rdbtnVip.isSelected() == false && rdbtnFree.isSelected() == false){
						JOptionPane.showMessageDialog(null, "Escolha o tipo de conta");
					}
					
					else if(rdbtnVip.isSelected() == true ) {
						
						AcessoArquivoABB aces1 = new AcessoArquivoABB();
						JOptionPane.showMessageDialog(null, "Usuário VIP cadastrado com sucesso !");
						arvore.insereCadastro(Integer.parseInt(tID.getText()), tEmail.getText(), tSenha.getText(), true);					
						aces1.EscreverArquivoABB(arvore);
						File asd = new File("./User/"+ tID.getText());
						asd.mkdir();
					}
					else if(rdbtnFree.isSelected() == true ){
						JOptionPane.showMessageDialog(null, "Usuário FREE cadastrado com sucesso !");
						AcessoArquivoABB aces1 = new AcessoArquivoABB();
						arvore.insereCadastro(Integer.parseInt(tID.getText()), tEmail.getText(), tSenha.getText(), false);					
						aces1.EscreverArquivoABB(arvore);
						File asd = new File("./User/"+ tID.getText());
						asd.mkdir();
					}
				}
			
			
			}
		});
		btnCadastrar.setBounds(171, 386, 107, 23);
		panel.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				JPanel panelContent = new TelaDefault(arvore);
				panelContent.setBounds(0, 0, 703, 504);
				add(panelContent);
				
				//updateUI();
				revalidate();
				repaint();
			}
		});
		btnCancelar.setBounds(411, 386, 107, 23);
		panel.add(btnCancelar);
		
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
		panel.add(btnLimpar);
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		Image img = new ImageIcon(this.getClass().getResource("/penguin-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 23));
		lblNewLabel.setBounds(235, 32, 202, 73);
		panel.add(lblNewLabel);
		
	}
}
