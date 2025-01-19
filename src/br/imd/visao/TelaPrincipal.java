package br.imd.visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

import br.imd.modelo.Patricia.ArvorePatricia;
import br.imd.modelo.ABB.ArvoreBinaria;


import br.imd.modelo.AcessoArquivo.AcessoArquivoABB;
import br.imd.modelo.AcessoArquivo.AcessoArquivoPatricia;


/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Tela Principal 
 */
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public TelaPrincipal() {
		
		
	
		ArvoreBinaria arvore = new ArvoreBinaria();
		AcessoArquivoABB acesso = new AcessoArquivoABB();
		arvore = acesso.LerArquivoABB();
		
		
		
		
		//arvore.percorrerInOrder(arvore);
		//arvore.remocaoCadatro(150);
		//aces1.EscreverArquivoABB(arvore);
		
		
		
		/*
		AcessoArquivoPatricia aces2 = new AcessoArquivoPatricia();
		ArvorePatricia arvore2 = new ArvorePatricia();
		arvore2 = aces2.LerArquivoPatricia();
		arvore2.inserir("joao", arvore2, arvore2.calculard("joao"));
		arvore2.inserir("manuel", arvore2, arvore2.calculard("manuel"));
		arvore2.inserir("zeca", arvore2, arvore2.calculard("zeca"));
		aces2.EscreverArquivoPatricia(arvore2);
		*/
		setBackground(new Color(255, 255, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 504);
		setResizable(false);
		setTitle("Relaxy");
		File user = new File("User");
		if(!user.exists()){
		user.mkdirs();
		}
		contentPane = new TelaLogin(arvore);
		contentPane.setBackground(new Color(102, 204, 255));
		//contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		//contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

}
