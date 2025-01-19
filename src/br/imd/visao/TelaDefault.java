package br.imd.visao;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import br.imd.modelo.ABB.ArvoreBinaria;
import br.imd.modelo.AcessoArquivo.AcessoArquivoABB;
import br.imd.modelo.Patricia.ArvorePatricia;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaDiretorio;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaDiretorioMusica;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaMusica;
import br.imd.modelo.PatriciaAcesso.AcessoArquivoPatriciaPasta;

public class TelaDefault extends JPanel {
	private JTextField textField;
	TocaMP3 dj = new TocaMP3();
	private String arquivo;
	/**
	 * Create the panel.
	 */
	public TelaDefault(ArvoreBinaria arvore) {
		setLayout(null);
		
		HashMap<Character, Integer> conversor = new HashMap<Character, Integer>();
		
		
		char a = 'a';
		for(int i = 0; i < 26; i++) {
			
			//System.out.println(a);
			conversor.put( a, i);
			a++;
		}
		
		conversor.put('$', 26);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 703, 504);
		add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 703, 21);
		panel.add(menuBar);
		
		JMenu mnSignUp = new JMenu("Sign up");
		menuBar.add(mnSignUp);
		
		JMenuItem mntmVip = new JMenuItem("Cadastrar");
		mntmVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCad pp = new TelaCad();
				
				pp.setVisible(true);
				
				//updateUI();
				revalidate();
			//	repaint();
			
			}
		});
		mnSignUp.add(mntmVip);
		
		JMenu mnPlay = new JMenu("Play");
		menuBar.add(mnPlay);
		
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dj.Stop();
				System.exit(0);
				JOptionPane.showMessageDialog(null, "Até a próxima !");
				
			}
		});
		mnExit.add(mntmLogOut);
		
		JButton btnCriarPlaylist = new JButton("New Playlist");
		btnCriarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCriarPlaylist.setBounds(557, 441, 110, 23);
		panel.add(btnCriarPlaylist);
		
		textField = new JTextField();
		textField.setBounds(547, 410, 129, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooserArquivo = new JFileChooser();
				int escolha = chooserArquivo.showOpenDialog(null);
				if(escolha == JFileChooser.APPROVE_OPTION){
				arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();
				dj.Play(arquivo);
				}
			}
		});
		btnPlay.setBounds(77, 441, 89, 23);
		panel.add(btnPlay);
		
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
            	System.out.println("yut");
            	String nome = "";
            	boolean vazio = false;
            	char var = evt.getKeyChar();
            	nome = (tMusica.getText());
            	 if(KeyEvent.VK_BACK_SPACE == evt.getKeyCode()) {
            		tMusica.setText("");
            		nome = "";
	            	}
	            	
            	if(var >= 'a' && var <= 'z') {
	            	
	            	System.out.println(evt.getKeyChar());
	            	System.out.println(tMusica.getText());
	            	System.out.println(tMusica.getText() + evt.getKeyChar() );
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
					System.out.println(nome);
	        		if(arvorePten.getArvore()[d] == null) {
	        			vazio = true;
	        			break;
	        		}
	        		else {
	        		arvorePten = arvorePten.getArvore()[d];
	        		}
	        		nome = nome.substring(1);
	        		System.out.println("bmn");
	        		System.out.println(nome);
	        		System.out.println(arvorePten.getRaiz().getCaracter());
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
		ArvorePatricia arvoreP3 = acessoG3.LerArquivoPatricia(arvore, "reggae");
		
		
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
					System.out.println("Double-clicked on: " + o.toString());
					list_2.setBounds(500, 59, 179, 270);
					panel.add(list_2);
					
					
					panel.revalidate();
					panel.repaint();
		            System.out.println("Double-clicked on: " + o.toString());
		          }
		        }
		      }
		    };
		    list_1.addMouseListener(mouseListener);
		    
		
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dj.Pause();
			}
		});
		btnPause.setBounds(191, 441, 89, 23);
		panel.add(btnPause);
		
		JLabel lblMusicas = new JLabel("Musicas");
		lblMusicas.setBounds(151, 43, 60, 14);
		panel.add(lblMusicas);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 86, 47, 23);
		panel.add(btnNewButton);
		
	
		
		
	
	}
}
