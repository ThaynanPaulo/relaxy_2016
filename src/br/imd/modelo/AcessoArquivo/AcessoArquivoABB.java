package br.imd.modelo.AcessoArquivo;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.imd.modelo.ABB.ArvoreBinaria;
import br.imd.modelo.ABB.No;
import br.imd.visao.Cadastro;
/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Classe de acesso a arvore binaria 
 */



public class AcessoArquivoABB extends ArvoreBinaria {
	
	public AcessoArquivoABB() {
		
	}
	
	/**
	 * Leitura do arquivo para arvorebinaria
	 * @return
	 */
	public ArvoreBinaria LerArquivoABB()  {
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		String nome1 = "";
		String nome2 = "";
		String nome3 = "";
		String nome4 = "";
		String linha = null;
		String subnome = null;
		char b[];
		int i = 0;
		int k = 0;
		int tamanho;
		FileReader arquivo;
		boolean tf = false;
		try {
			arquivo = new FileReader("ArquivoLogin/ArquivoLogin.txt");
		
		BufferedReader lerArq = new BufferedReader(arquivo);
		System.out.println("Ndeeblas");
		
		/*
		linha = lerArq.readLine();
		primeiroespaco = linha.indexOf(' ');
		segundoespaco = linha.lastIndexOf(' ');
		System.out.println(Integer.parseInt(linha.substring(0, primeiroespaco)));
		System.out.println(linha.substring(primeiroespaco + 1, segundoespaco));
		System.out.println(linha.substring(segundoespaco +1));
		arvore.insereCadastro(Integer.parseInt(linha.substring(0, primeiroespaco)), linha.substring(primeiroespaco, segundoespaco), linha.substring(segundoespaco));
		*/
		
		
		linha = lerArq.readLine();
		while (linha != null) {
			b = linha.toCharArray();
			tamanho = linha.length();
			
			for(i = 0; i < tamanho; i++)
			{
				
				if(k == 0) {
					
					if(b[i] == ' ') {
						k = 1;
						
					}
					else {
						System.out.println(linha);
						System.out.println(b[i]);
						System.out.println(k);
						nome1 = nome1.concat(String.valueOf(b[i]));
					}
				}
				
				else if(k == 1) {
					if(b[i] == ' ') {
						k = 2;
					}
					else {
						nome2 = nome2.concat(String.valueOf(b[i]));
					}
				}
				
				else if(k == 2) {
					if(b[i] == ' ') {
						k = 3;
					}
					else {
						nome3 = nome3.concat(String.valueOf(b[i]));
					}
				}
				
				else if(k == 3) {
					if(i == linha.length() - 1) {
						nome4 = nome4.concat(String.valueOf(b[i]));
						k = 0;
					}
					else {
						nome4 = nome4.concat(String.valueOf(b[i]));
					}
				}
				
				
			}
			
			
			System.out.println(linha);
			System.out.println(nome1);
			System.out.println(nome2);
			System.out.println(nome3);
			System.out.println(nome4);
			
			
			if(nome4.equals("true")) {
				tf = true;
			}
			else if (nome4.equals("false")) {
				tf = false;
			}
			
			System.out.println(tf);
			arvore.insereCadastro(Integer.parseInt(nome1), nome2, nome3, tf);
			linha = lerArq.readLine();
			nome1 = "";
			nome2 = "";
			nome3 = "";
			nome4 = "";
			
			 
			 
			
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
			System.out.println(arvore.getRaiz().getCadastro().getID());
			System.out.println(arvore.getRaiz().getCadastro().getVip());
			System.out.println("Fechando arquivo após leitura.");
		}
		
		
		
		return arvore;
		
	}
	
/**
 * Escrita na arvore binaria
 * @param arvore
 * @return
 */
	public ArvoreBinaria EscreverArquivoABB(ArvoreBinaria arvore)  {	
		
		try {
				FileWriter arquivo = new FileWriter ("ArquivoLogin/ArquivoLogin.txt");
				PrintWriter gravarArquivo = new PrintWriter(arquivo);
				
				percorrerInOrderInserirArquivo(arvore, gravarArquivo);
				gravarArquivo.close();
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			 e.printStackTrace();
			 System.out.println("Não foi possível abrir arquivo");
		} 
		catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	
	
	
	/*
	  System.out.println(linha);
	 
	primeiroespaco = linha.indexOf(' ');
	segundoespaco = linha.substring(primeiroespaco + 1).indexOf(' ');
	terceiroespaco = linha.substring(segundoespaco + 1).indexOf(' ');
	
	System.out.println(linha.indexOf(' '));
	System.out.println(linha.substring(primeiroespaco + 1).indexOf(' '));
	System.out.println(linha.substring(segundoespaco + 1).indexOf(' '));
	
	System.out.println(linha.substring(primeiroespaco + 1));
	System.out.println(linha.substring(primeiroespaco + segundoespaco + 2));
	System.out.println(linha.substring(primeiroespaco + segundoespaco + terceiroespaco + 3 ));
	
	
	System.out.println(Integer.parseInt(linha.substring(0, primeiroespaco)));
	Syste m.out.println(linha.substring(primeiroespaco + 1, primeiroespaco + segundoespaco));
	System.out.println(linha.substring(primeiroespaco + segundoespaco + 2, primeiroespaco + segundoespaco + terceiroespaco + 1 ));
	System.out.println(linha.substring(primeiroespaco + segundoespaco + terceiroespaco + 3));
	*/
	
	
}