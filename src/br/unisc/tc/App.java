package br.unisc.tc;

import java.util.ArrayList;
import java.util.List;

import br.unisc.tc.model.LeituraEntrada;

public class App {
	public static void main(String[] args) {
		List<String> lstRotulos = new ArrayList<String>();
		LeituraEntrada reader = new LeituraEntrada();
		
		reader.leArquivo(lstRotulos);
		
		for (int i = 0; i < lstRotulos.size(); i++) {
			System.out.println(lstRotulos.get(i));
		}
		
	}
}
