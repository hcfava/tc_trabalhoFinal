package br.unisc.tc.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LeituraEntrada {
	public void leArquivo(List<String> lstRotulos) {
		try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream("Rotulos.txt"), "UTF-8"));
            
            String linha;
            while((linha = br.readLine()) != null){
            	lstRotulos.add(linha);
            }
            br.close();
            
        } catch (FileNotFoundException ex){
            System.err.println("ERRO: Arquivo não existe");
        } catch (IOException ex){
            System.err.println("ERRO: " + ex.getMessage());
        }
	}
}
