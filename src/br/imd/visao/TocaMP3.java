/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Versão 1.0
 * Classe para rocar mp3 
 */

package br.imd.visao;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class TocaMP3 {
	FileInputStream FIS;
	BufferedInputStream BIS;
	
	public Player player;
	public long pauseLocation;
	public long tamanhoMusica;
	
	public String fileLocation;
	
	public void Stop(){
		if(player != null){
			player.close();
			
			pauseLocation = 0;
			tamanhoMusica = 0;
			
		}
	
	}
	
	public void Pause(){
		if(player != null){
				try {
					pauseLocation = FIS.available();
					player.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
		}
	}
	
	public void resume(){
		try {
			FIS = new FileInputStream(fileLocation);
			BIS = new BufferedInputStream(FIS);
			
			player = new Player(BIS);
			
			FIS.skip(tamanhoMusica - pauseLocation);
			
		} catch (FileNotFoundException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(){
			public void run(){
				try {
					player.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					}
		
				
			}
		}.start();
	}
		
	public void Play(String path){
		try {
			if(BIS != null) {
				Stop();
			}
			FIS = new FileInputStream("Musica/" + path + ".mp3");
			BIS = new BufferedInputStream(FIS);
			
			player = new Player(BIS);
			
			tamanhoMusica = FIS.available();
			
			fileLocation = "Musica/" + path + ".mp3";
			
		} catch (FileNotFoundException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		new Thread(){
			public void run(){
				try {
					player.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					}
		
				
			}
		}.start();
		
	}

}
