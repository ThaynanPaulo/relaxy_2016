package br.imd.modelo.Patricia;

/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 *  classe com operações da arvorepatricia 
 */
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import br.imd.controle.CaracterInvalidoException;
import br.imd.modelo.Patricia.NoPatricio;


public class ArvorePatricia extends OperacoesBasicasPatricia {
	
	 public NoPatricio raiz;
	 private ArvorePatricia[] arvore = new ArvorePatricia[27];
	 private ArvorePatricia pai;
	 private boolean igual;
	 
	 public ArvorePatricia() {
		 super();
		 this.igual = false;
			 
		 }
		 
		
	 
	 public NoPatricio getRaiz() {
		return raiz;
	}

	public void setRaiz(NoPatricio raiz) {
		this.raiz = raiz;
	}

	public ArvorePatricia[] getArvore() {
		return arvore;
	}

	public void setArvore(ArvorePatricia[] arvore) {
		this.arvore = arvore;
	}

	public ArvorePatricia getPai() {
		return pai;
	}

	public void setPai(ArvorePatricia pai) {
		this.pai = pai;
	}
	
	
	public boolean isIgual() {
		return igual;
	}



	public void setIgual(boolean igual) {
		this.igual = igual;
	}
	
	
	/**
	 * Calcular a primeira letra a partir da conversao
	 * @param nome
	 * @return
	 */
	
	@SuppressWarnings("finally")
	public int calculard(String nome) {
		
		char[] c = conversorStringChar(nome);
		int tamanho = nome.length();
		
		System.out.println(nome);
		System.out.println(tamanho);
		
		
		if(tamanho == 0)
		{
			//System.out.println(nome + "sdawa");
			return -1;		
		}
		for(int i = 0; i < tamanho; i++) {
			if (c[i] >= 'a' &&  c[i] <= 'z') {
			
			}
			else {
				try {
				throw new CaracterInvalidoException("A palavra " + nome + " apresenta digito inválido");
			} catch (CaracterInvalidoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			finally {
			return -2;
			}
			}
		}
		
		int d = conversor.get(c[0]);
		System.out.println(d);
		return d;
	}



	/**
	 * Inserção da arvore patricia
	 */
	// para a inserção dê certo, converter para minusculo String name; name.toLowerCase();
	//arvore.calculard(nome.substring(i))
	@Override
	public ArvorePatricia inserir(String nome, ArvorePatricia arvore, int t){
		// TODO Auto-generated method stub
		ArvorePatricia arv;
		arv = arvore.buscar(nome, arvore, t);
		if(arv == null) {
			System.out.println("sadwasdewfdthdtgtdytfdhtrdh");
			System.out.println(nome);
			return arvore.inserirPatricia(nome, arvore, t);
		}
		else {
			System.out.println("Palavra já inserida.");
			return null;
			
		}
		
	
			
}
	public ArvorePatricia inserirPatricia(String nome, ArvorePatricia arvore, int t) {
		if(t == -2) {
			System.out.println("Existe algum caracter inválido.");
			return null;
		}
		else if(t == -1) {
			System.out.println("Final da Palavra");
			System.out.println(nome);
			System.out.println(nome.length());
			arvore.getRaiz().setCaracterfinal(true);
			return arvore;
		}
		else {

			if(arvore.getArvore()[t] == null) {
	
				System.out.println("cdssddcd");
				System.out.println(nome);
				char[] c = conversorStringChar(nome);
				NoPatricio no = new NoPatricio(c[0]);
				arvore.arvore[t] = new ArvorePatricia();
				arvore.arvore[t].setRaiz(no);
				//arvore.arvore[t].getRaiz().setCaracterfinal(false);
				arvore.arvore[t].setPai(arvore);
				if(nome.length() == 1) {
					System.out.println(nome);
					System.out.println("hflkgf");
					arvore.arvore[t].getRaiz().setCaracterfinal(true);
					//return arvore;
				}
				return inserirPatricia(nome.substring(1), arvore.getArvore()[t], arvore.calculard(nome.substring(1)));
				
				
			}
			else {
				System.out.println("tertre");
				System.out.println(nome);
				return inserirPatricia(nome.substring(1), arvore.getArvore()[t], arvore.calculard(nome.substring(1)));
				
			}
		}

	}

	/**
	 * Busca da arvore patricia
	 */
	@Override
	public ArvorePatricia buscar(String nome, ArvorePatricia arvore, int t) {
		
		if(t == -1) {
			if(arvore.getRaiz().isCaracterfinal() == true) {
				System.out.println("Palavra encontrada.");
				System.out.println(nome);
				System.out.println(nome.length());
				return arvore;
			}
			else {
				System.out.println("Palavra não encontrada.");
				return null;
			}
			
		}
		else if(t == -2) {
			System.out.println("Existe algum caracter inválido.");
			return null;
		}
		else {
			System.out.println("kldfs");
			System.out.println(t);
			
			if(arvore.getArvore()[t] == null) {
				System.out.println("Palavra não encontrada.");
				System.out.println(nome);
				return null;	
			}
			else {
			
				return buscar(nome.substring(1), arvore.getArvore()[t], arvore.calculard(nome.substring(1)));
				
			}
			
		}		
}

	
	/**
	 * Remoção da arvore patricia
	 */
	@Override
	public ArvorePatricia remover(String nome, ArvorePatricia arvore, int t) {
		// TODO Auto-generated method stub
		
		ArvorePatricia arv;
		arv = arvore.buscar(nome, arvore, t);
		if(arv == null) {
			System.out.println("Palavra Não encontrada na arvore.");
			return null;
		}
		else {
			System.out.println("sadwasdewfdthdtgtdytfdhtrdh");
			System.out.println(nome);
			return arvore.removendo(nome, arv);
		}		
		
		
	}
				
		





	public ArvorePatricia removendo(String nome, ArvorePatricia arvore) {
	
		int pos;
		//System.out.println(arvore.getArvore()[calculard(nome2)].getRaiz().getNome());
		//ArvorePatricia arv = arvore.getPai();
		//arvore = null;
		//System.out.println(arvore.getRaiz().getCaracter());
		System.out.println(arvore.getRaiz().getCaracter());
		//System.out.println(arvore.getPai().getRaiz().getCaracter());
		//System.out.println(arvore.getPai().getArvore()[20].getRaiz().getCaracter());
		
		
		if( arvore.getPai() == null) {
			
			arvore = null;
			return null;
		}
		else if(arvore.getPai().getRaiz().isCaracterfinal() == true) {
			return arvore;
			
		}
		
		int j = 0;						//verificar se há algum caracter após - significa que não se pode excluir, apenas setar que a string não é mais final
		for(int i = 0; i < 26; i++) {
			
			if(arvore.getPai().getArvore()[i] != null)
			{
				j++;
				
			}
			
		}
		
		System.out.println(j);
		if(j != 0) {
			
			arvore.getRaiz().setCaracterfinal(false);
		}
		else {
			j = 0;								//não existindo caracteres depois, devemos ver se o pai tem outros filhos, se sim, apenas desconsideramos
			for(int i = 0; i < 26; i++) {
				
				if(arvore.getPai().getArvore()[i] != null)
				{
					if(arvore.getRaiz().getCaracter() == arvore.getPai().getArvore()[i].getRaiz().getCaracter()) {
					System.out.println("erressa");
					j++;
					arvore.getPai().getArvore()[i] = null;
					}
					else {
					System.out.println("adssa");
					System.out.println(arvore.getPai().getArvore()[i].getRaiz().getCaracter());
					j++;
					}
				}
				
			}
			System.out.println(j);
			if(j == 1)
			{
				return removendo(nome, arvore.getPai());
				
			}
			else
			{
				return arvore;
				
			}
			
		}
		return arvore;
		
		
		
		
		
		
	
	}
	
	/*pecorrimento!!!
	 * String palavra = "";
	arv.pecorrimentoArvorePatricia(arv, 0, palavra);
	*/

	public ArvorePatricia pecorrimentoArvorePatricia(ArvorePatricia arvore, int k, String palavra, PrintWriter gravarArquivo) {
		
		
		//System.out.println(k);
		if(arvore.getArvore()[k] != null) {
		
		palavra = palavra.concat(arvore.toString(arvore.getArvore()[k].getRaiz().getCaracter()));
		//System.out.println(palavra);
		//System.out.println("cdsa");
		return arvore.pecorrimentoArvorePatricia(arvore.getArvore()[k], 0, palavra, gravarArquivo);
		}
		else if(arvore.getArvore()[k] == null) {
			if(k == 26) {
				if(arvore.getPai() == null) {
					System.out.println("trrdsdsa");
					return arvore;
				}
				else {
					if(arvore.getRaiz().isCaracterfinal() == true) {
						gravarArquivo.println(palavra);
						System.out.println(palavra);
						System.out.println("fhfg");
				}
					//System.out.println(palavra);
					
				   char c[] = arvore.conversorStringChar(palavra.substring(palavra.length() - 1));
				   int d = conversor.get(c[0]);
				   
				   palavra = palavra.substring(0, palavra.length() - 1);
				   //System.out.println(palavra);
				   	
					
					
					
					arvore.pecorrimentoArvorePatricia(arvore.getPai(), d + 1, palavra, gravarArquivo);
				}
			}
			else {
				//System.out.println("dssacd");
				arvore.pecorrimentoArvorePatricia(arvore, k + 1, palavra, gravarArquivo);
				
			}
			
			
		}
		return null;
		
		//palavra = palavra.s
		        	
		
	}
	
	
public ArrayList<String> pecorrimentoArvorePatricia2(ArvorePatricia arvore, int k, String palavra, ArrayList<String> vetor) {
		
		
		System.out.println(k);
		if(arvore.getArvore()[k] != null) {
		
		palavra = palavra.concat(arvore.toString(arvore.getArvore()[k].getRaiz().getCaracter()));
		//System.out.println(palavra);
		//System.out.println("cdsa");
		return arvore.pecorrimentoArvorePatricia2(arvore.getArvore()[k], 0, palavra, vetor);
		}
		else if(arvore.getArvore()[k] == null) {
			if(k == 26) {
				if(arvore.getPai() == null) {
					System.out.println("trrdsdsa");
					return vetor;
				}
				else {
					if(arvore.getRaiz().isCaracterfinal() == true) {
						
						vetor.add(palavra);
						//DefaultListModel modelo = new DefaultListModel();
						//list = new JList(modelo);
						//modelo.addElement(palavra);
						//gravarArquivo.println(palavra);
						System.out.println(palavra);
						System.out.println("fhfg");
				}
					System.out.println(palavra);
					
				   char c[] = arvore.conversorStringChar(palavra.substring(palavra.length() - 1));
				   int d = conversor.get(c[0]);
				   
				   palavra = palavra.substring(0, palavra.length() - 1);
				   System.out.println(palavra);
				   	
					
					
					
					arvore.pecorrimentoArvorePatricia2(arvore.getPai(), d + 1, palavra, vetor);
				}
			}
			else {
				//System.out.println("dssacd");
				arvore.pecorrimentoArvorePatricia2(arvore, k + 1, palavra, vetor);
				
			}
			
			
		}
		return null;
		
		//palavra = palavra.s
		        	
		
	}



public ArvorePatricia pecorrimentoArvorePatricia3(ArvorePatricia arvore, int k, String palavra, DefaultListModel modelo) {
	
	//System.out.println(k);
	if(arvore.getArvore()[k] != null) {
	
	palavra = palavra.concat(arvore.toString(arvore.getArvore()[k].getRaiz().getCaracter()));
	//System.out.println(palavra);
	//System.out.println("cdsa");
	return arvore.pecorrimentoArvorePatricia3(arvore.getArvore()[k], 0, palavra, modelo);
	}
	else if(arvore.getArvore()[k] == null) {
		if(k == 26) {
			if(arvore.getPai() == null) {
				System.out.println("trrdsdsa");
				return arvore;
			}
			else {
				if(arvore.getRaiz().isCaracterfinal() == true) {
					//gravarArquivo.println(palavra);
					System.out.println(palavra);
					System.out.println("fhfg");
					if(!modelo.contains(palavra))// Testa se o item existe na lista 
			        {  
			              modelo.addElement(palavra);  
			        }
			}
				//System.out.println(palavra);
				
			   char c[] = arvore.conversorStringChar(palavra.substring(palavra.length() - 1));
			   int d = conversor.get(c[0]);
			   
			   palavra = palavra.substring(0, palavra.length() - 1);
			   //System.out.println(palavra);
			   	
				
				
				
				arvore.pecorrimentoArvorePatricia3(arvore.getPai(), d + 1, palavra, modelo);
			}
		}
		else {
			//System.out.println("dssacd");
			arvore.pecorrimentoArvorePatricia3(arvore, k + 1, palavra, modelo);
			
		}
		
		
	}
	return null;
	
	//palavra = palavra.s
	        	
	
	}
public ArvorePatricia pecorrimentoArvorePatricia33(ArvorePatricia arvore, int k, String palavra, DefaultListModel modelo, String nome) {
	
	//System.out.println(k);
	if(arvore.getArvore()[k] != null) {
	
	palavra = palavra.concat(arvore.toString(arvore.getArvore()[k].getRaiz().getCaracter()));
	//System.out.println(palavra);
	//System.out.println("cdsa");
	return arvore.pecorrimentoArvorePatricia33(arvore.getArvore()[k], 0, palavra, modelo, nome);
	}
	else if(arvore.getArvore()[k] == null) {
		if(k == 26) {
			if(arvore.getPai() == null) {
				System.out.println("trrdsdsa");
				return arvore;
			}
			else {
				if(arvore.getRaiz().isCaracterfinal() == true) {
					//gravarArquivo.println(palavra);
					System.out.println(palavra);
					System.out.println("fhfg");
					if(!modelo.contains(palavra))// Testa se o item existe na lista 
			        {  
			              modelo.addElement(nome.concat(palavra));  
			        }
					
			}
				System.out.println(palavra);
				
			   char c[] = arvore.conversorStringChar(palavra.substring(palavra.length() - 1));
			   int d = conversor.get(c[0]);
			   
			   palavra = palavra.substring(0, palavra.length() - 1);
			   //System.out.println(palavra);
			   	
				
				
				
				arvore.pecorrimentoArvorePatricia33(arvore.getPai(), d + 1, palavra, modelo, nome);
			}
		}
		else {
			//System.out.println("dssacd");
			arvore.pecorrimentoArvorePatricia33(arvore, k + 1, palavra, modelo, nome);
			
		}
		
		
	}
	return null;
	
	//palavra = palavra.s
	        	
	
	}

}

