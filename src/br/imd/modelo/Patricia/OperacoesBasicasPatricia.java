package br.imd.modelo.Patricia;

import java.util.HashMap;
//import java.util.Map;
/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Classe abstrata da arvore patricia 
 */



abstract class OperacoesBasicasPatricia{

	//para a arvore patricia
	
	HashMap<Character, Integer> conversor = new HashMap<Character, Integer>();
	
	public OperacoesBasicasPatricia() {

		char a = 'a';
		for(int i = 0; i < 26; i++) {
			
			//System.out.println(a);
			conversor.put( a, i);
			a++;
		}
		
		conversor.put('$', 26);
		
	}
	
	public char[] conversorStringChar (String nome) {
		
		char b[] = nome.toCharArray();
		
		return b;	
		
	}
	
	public String toString(char caracter) {
		
		return String.valueOf(caracter);
	}
	
	public HashMap<Character, Integer> getConversor() {
		return conversor;
	}
	public void setConversor(HashMap<Character, Integer> conversor) {
		this.conversor = conversor;
	}
	
	public abstract ArvorePatricia inserir(String nome, ArvorePatricia arvore, int d);
	public abstract ArvorePatricia buscar(String nome, ArvorePatricia arvore, int d);
	public abstract ArvorePatricia remover(String nome, ArvorePatricia arvore, int d);
	
	
}


