package br.imd.modelo.ABB;

/**
 * Interface da arvore binaria
 * @author Thaynan e Eulle
 *
 */
public interface OperacoesBasicasABB {
	
	
	//para a arvore binária
	public ArvoreBinaria busca(int matricula);
	public void inserir(No no);
	public ArvoreBinaria remove(int id, ArvoreBinaria d);
	

}
