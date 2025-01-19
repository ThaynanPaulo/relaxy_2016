package br.imd.modelo.ABB;

import br.imd.visao.Cadastro;
/**
 * No da arvore binaria
 * @author Thaynan
  @Thaynan e Eulle
	 * 27//11/2016
	 * Versão 1.0
	 * Classe de exceção para caracteres inválidos 
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
