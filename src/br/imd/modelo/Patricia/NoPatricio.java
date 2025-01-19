package br.imd.modelo.Patricia;

/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * No da arvore patricia 
 */
public class NoPatricio {
	
	private char caracter;
	private int tamanho;
	private boolean caracterfinal;
	
	public NoPatricio(char caracter) {
		
		this.caracter = caracter;
		this.caracterfinal = false;
	}

	public char getCaracter() {
		return caracter;
	}

	public void setCaracter(char caracter) {
		this.caracter = caracter;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isCaracterfinal() {
		return caracterfinal;
	}

	public void setCaracterfinal(boolean caracterfinal) {
		this.caracterfinal = caracterfinal;
	}
	
	

}