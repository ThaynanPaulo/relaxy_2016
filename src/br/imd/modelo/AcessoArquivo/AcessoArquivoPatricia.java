package br.imd.modelo.AcessoArquivo;

/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Classe de acesso a arvore patricia 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.imd.modelo.Patricia.ArvorePatricia;
import br.imd.modelo.Patricia.NoPatricio;
import br.imd.visao.Cadastro;


public class AcessoArquivoPatricia extends ArvorePatricia {
	
	public AcessoArquivoPatricia() {
		
	}
	
	/**
	 * Leitura do arquivo
	 * @return
	 */
	public ArvorePatricia LerArquivoPatricia()  {
		ArvorePatricia arvore = new ArvorePatricia();
		String linha = null;
		
		FileReader arquivo;
		try {
		arquivo = new FileReader("ArquivoNome/ArquivoNome.txt");
		BufferedReader lerArq = new BufferedReader(arquivo);
		System.out.println("Ndeeblas");
		
		
		
		linha = lerArq.readLine();
		System.out.println(linha);
		while (linha != null) {
			System.out.println(linha);
			arvore.inserir(linha.toLowerCase(), arvore, arvore.calculard(linha.toLowerCase()));
			linha = lerArq.readLine();			
			}
		
		
		arquivo.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		 System.out.println("Não foi possível abrir arquivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Erro na leitura ou no fechamento do arquivo.");
		}
		finally {
			System.out.println("Fechando arquivo após leitura.");
		}
	
		return arvore;
		
	}
	
	/**
	 * escrita no arquivo
	 * @param arvore
	 * @return
	 */
	public ArvorePatricia EscreverArquivoPatricia(ArvorePatricia arvore)  {	
		
		try {
				FileWriter arquivo = new FileWriter ("ArquivoNome/ArquivoNome.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				pecorrimentoArvorePatricia(arvore,  0, "", gravarArquivo);
				gravarArquivo.close();
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			 e.printStackTrace();
			 System.out.println("Não foi possível abrir arquivo");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro na leitura ou no fechamento do arquivo.");
		}
		finally {
		System.out.println("Fechando arquivo após escrita.");
		}
		return null;
	}
	
	
}