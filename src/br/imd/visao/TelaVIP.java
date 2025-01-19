package br.imd.visao;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.imd.modelo.ABB.ArvoreBinaria;
import br.imd.modelo.Patricia.ArvorePatricia;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaDiretorio;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaDiretorioMusica;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaMusica;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaPasta;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;


/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Classe da tela vip 
 */

public class TelaVIP extends JPanel {
	
	
	TocaMP3 dj = new TocaMP3();
	private String arquivo;
	private String pasta;
	/**
	 * Create the panel.
	 */
	public TelaVIP(ArvoreBinaria arvore,String id) {
		
		HashMap<Character, Integer> conversor = new HashMap<Character, Integer>();
		
		
		char a = 'a';
		for(int i = 0; i < 26; i++) {
			
			//System.out.println(a);
			conversor.put( a, i);
			a++;
		}
		
		conversor.put('$', 26);
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 704, 503);
		add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 704, 21);
		panel.add(menuBar);
		
		JMenu mnSignUp = new JMenu("Sign up");
		menuBar.add(mnSignUp);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCad pp = new TelaCad();
				
				pp.setVisible(true);
			}
		});
		mnSignUp.add(mntmCadastrar);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dj.Stop();
				JOptionPane.showMessageDialog(null, "Até a próxima !");
				System.exit(0);
			}
		});
		mnExit.add(mntmLogOut);
		
		AcessoArquivoPatriciaPasta acessoG = new  AcessoArquivoPatriciaPasta();
		ArvorePatricia arvoreP = new ArvorePatricia();
		ArvorePatricia arvoreP2 = new ArvorePatricia();
		ArvorePatricia arvP = new ArvorePatricia();
		
		acessoG  = new AcessoArquivoPatriciaMusica();
		arvoreP = acessoG.LerArquivoPatricia(arvore);
		
		JTextField tMusica = new JTextField();
		tMusica.setBounds(84, 30, 169, 15);
		panel.add(tMusica);
		tMusica.setColumns(20);
		
		JList list = new JList();
		DefaultListModel modelo = new DefaultListModel();
		list = new JList(modelo);
		//list.setVisibleRowCount(10);	//Quantidade de items
		list.setBounds(84, 59, 169, 270);
		arvP = arvoreP.pecorrimentoArvorePatricia3(arvoreP, 0, "", modelo);
		panel.add(list);
		
		tMusica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
           
            	String nome = "";
            	boolean vazio = false;
            	char var = evt.getKeyChar();
            	nome = (tMusica.getText());
            	 if(KeyEvent.VK_BACK_SPACE == evt.getKeyCode()) {
            		tMusica.setText("");
            		nome = "";
	            	}
	            	
            	if(var >= 'a' && var <= 'z') {
	            	
	            
	            	nome = (tMusica.getText() + evt.getKeyChar());
	            	}
            	String nome2 = nome;
	            modelo.removeAllElements();
		        panel.revalidate();
				panel.repaint();
				
	            AcessoArquivoPatriciaMusica acessoGer  = new AcessoArquivoPatriciaMusica();
	        	ArvorePatricia arvorePten = acessoGer.LerArquivoPatricia(arvore);
	        	
	        	ArvorePatricia arv = new ArvorePatricia();
	        	
	        	while(nome.length() != 0) {
	        		  char c[] = arvorePten.conversorStringChar(nome);
					   int d = conversor.get(c[0]);
				
	        		if(arvorePten.getArvore()[d] == null) {
	        			vazio = true;
	        			break;
	        		}
	        		else {
	        		arvorePten = arvorePten.getArvore()[d];
	        		}
	        		nome = nome.substring(1);
	        	
	        	}
	        	if (vazio == true ) {
	        		
	        	}
	        	else {
	        	//arv = arvorePten.buscar(nome.toLowerCase(), arvorePten, arvorePten.calculard(nome.toLowerCase()));
	        	//System.out.println("yttr");
				JList list = new JList();
				//list.setVisibleRowCount(10);	//Quantidade de items
				list.setBounds(84, 59, 169, 270);
				
				arvorePten = arvorePten.pecorrimentoArvorePatricia33(arvorePten, 0, "", modelo, nome2);
				//System.out.println(arv.getRaiz().getCaracter());
				panel.add(list);
				panel.revalidate();
				panel.repaint();
				
            }
            	//nome = nome.concat(evt.getKeyChar());
               
         }
      });
		
		
		acessoG = new AcessoArquivoPatriciaDiretorio();
		arvoreP2 = acessoG.LerArquivoPatricia(arvore);
		
		
		
		JList list_1 = new JList();
		DefaultListModel modelo2 = new DefaultListModel();
		list_1 = new JList(modelo2);
		//list.setVisibleRowCount(10);	//Quantidade de items
		arvP = arvoreP.pecorrimentoArvorePatricia3(arvoreP2, 0, "", modelo2);
		list_1.setBounds(279, 59, 179, 270);
		panel.add(list_1);
		
		AcessoArquivoPatriciaDiretorioMusica acessoG3 = new AcessoArquivoPatriciaDiretorioMusica();
		ArvorePatricia arvoreP3 = acessoG3.LerArquivoPatricia(arvore, "");
		
		JList list_2 = new JList();
		DefaultListModel modelo3 = new DefaultListModel();
		list_2 = new JList(modelo3);
		arvP = arvoreP.pecorrimentoArvorePatricia3(arvoreP3, 0, "", modelo3);
		list_2.setBounds(500, 59, 179, 270);
		panel.add(list_2);
		

		MouseListener mouseListener = new MouseAdapter() {
		      public void mouseClicked(MouseEvent mouseEvent) {
		        JList theList = (JList) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2) {
		          int index = theList.locationToIndex(mouseEvent.getPoint());
		          if (index >= 0) {
		        	modelo3.removeAllElements();
		        	panel.revalidate();
					panel.repaint();
		            
					
		            Object o = theList.getModel().getElementAt(index);
		            AcessoArquivoPatriciaDiretorioMusica aces = new AcessoArquivoPatriciaDiretorioMusica();
		            ArvoreBinaria arvore2 = null;
		            ArvorePatricia arv2 = new ArvorePatricia(); 
					ArvorePatricia arv = aces.LerArquivoPatricia(arvore2, o.toString());
					JList list_2 = new JList();
					list_2 = new JList(modelo3);
					arv2 = arv.pecorrimentoArvorePatricia3(arv, 0, "", modelo3);
					
					list_2.setBounds(500, 59, 179, 270);
					panel.add(list_2);
					
					
					panel.revalidate();
					panel.repaint();
		            
		          }
		        }
		      }
		    };
		    list_1.addMouseListener(mouseListener);
		    
		    MouseListener mouseListener1 = new MouseAdapter() {
			      public void mouseClicked(MouseEvent mouseEvent) {
			        JList theList = (JList) mouseEvent.getSource();
			        if (mouseEvent.getClickCount() == 2) {
			          int index = theList.locationToIndex(mouseEvent.getPoint());
			          if (index >= 0) {
			            Object o = theList.getModel().getElementAt(index);
			           
			             dj.Play(o.toString());
			          }
			        }
			      }
			    };
			
		list.addMouseListener(mouseListener1);
		list_2.addMouseListener(mouseListener1);
		

		 JButton btnAddDiretrio = new JButton("Add Diret\u00F3rio");
		 btnAddDiretrio.setBounds(358, 430, 100, 23);
		 panel.add(btnAddDiretrio);
		 btnAddDiretrio.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		    JFileChooser chooserDiretorio = new JFileChooser();
		    chooserDiretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		    int res = chooserDiretorio.showOpenDialog(null);
		    if(res == JFileChooser.APPROVE_OPTION){
		    pasta = chooserDiretorio.getSelectedFile().getName();
		    
		    AcessoArquivoPatriciaDiretorio acess = new AcessoArquivoPatriciaDiretorio();
		    ArvorePatricia arvo = acess.LerArquivoPatricia(arvore);
		    arvo.inserir(pasta.toLowerCase(), arvo, arvo.calculard(pasta.toLowerCase()));
		    modelo2.addElement(pasta);
		    arvo = acess.EscreverArquivoPatricia(arvo, arvore);
		    
		    }
		   }
		  });
		
		 JButton btnNewButton_2 = new JButton("Add Music");
		 btnNewButton_2.setBounds(484, 430, 89, 23);
		 panel.add(btnNewButton_2);
		 
		  btnNewButton_2.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		    JFileChooser chooserArquivo = new JFileChooser();
		    chooserArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    int escolha = chooserArquivo.showOpenDialog(null);
		    if(escolha == JFileChooser.APPROVE_OPTION){
		    arquivo = chooserArquivo.getSelectedFile().getName();
		   int pos = arquivo.lastIndexOf('.');
		   arquivo = arquivo.substring(0,pos);
		    AcessoArquivoPatriciaMusica acess = new AcessoArquivoPatriciaMusica();
		    ArvorePatricia arvo = acess.LerArquivoPatricia(arvore);
		    arvo.inserir(arquivo.toLowerCase(), arvo, arvo.calculard(arquivo.toLowerCase()));
		   
		    modelo.addElement(arquivo);
		    arvo = acess.EscreverArquivoPatricia(arvo, arvore);		   
		    }
		   }
		  });

		 
		JButton btnNewButton = new JButton("Resume");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dj.resume();
				}
			
		});
		btnNewButton.setBounds(60, 430, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pause");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dj.Pause();
			}
		});
		btnNewButton_1.setBounds(164, 430, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblVip = new JLabel("VIP");
		lblVip.setFont(new Font("Verdana", Font.BOLD, 13));
		lblVip.setBounds(500, 32, 44, 14);
		panel.add(lblVip);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooserArquivo = new JFileChooser();
				int escolha = chooserArquivo.showOpenDialog(null);
				if(escolha == JFileChooser.APPROVE_OPTION){
				arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();
				dj.Play(arquivo);
				}
			}
		});
		btnNewButton_3.setBounds(0, 96, 44, 23);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("ID:" + id);
		lblNewLabel.setBounds(573, 34, 56, 14);
		panel.add(lblNewLabel);
		
		
	}
}
