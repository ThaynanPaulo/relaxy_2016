package br.imd.modelo.ABB;

import br.imd.visao.Cadastro;
/**
 * No da arvore binaria
 * @author Thaynan
  @Thaynan e Eulle
	 * 27//11/2016
	 * Vers�o 1.0
	 * Classe de exce��o para caracteres inv�lidos 
 */

public class No{
	
	private Cadastro cadastro;
	

    public No(Cadastro cadastro) {
        this.setCadastro(cadastro);
               
    }


	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

   
	
    
}
