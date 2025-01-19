package br.imd.visao;

/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Classe De cadastro do usuario 
 */

import br.imd.controle.IDNegativoException;

public class Cadastro {
	private String id;
	private String email;
	private String senha;
	private Boolean vip;
	
	public Cadastro(String id,String email,String senha, boolean vip) throws IDNegativoException{
		if((Integer.parseInt(id) < 0)) {
			throw new  IDNegativoException("Valor do Id deve ser positivo;");
		}
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.vip = vip;
	}

	

	public Boolean getVip() {
		return vip;
	}



	public void setVip(Boolean vip) {
		this.vip = vip;
	}



	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
