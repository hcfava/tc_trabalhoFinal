package br.unisc.tc;

import java.util.ArrayList;
import java.util.List;

import br.unisc.tc.model.Composta;
import br.unisc.tc.model.LeituraEntrada;
import br.unisc.tc.model.Norma;

public class App {
	public static void main(String[] args) {
		List<String> lstRotulos = new ArrayList<String>();
		List<String> lstSaida = new ArrayList<String>();
		List<String> lstNorma = new ArrayList<String>();
		LeituraEntrada reader = new LeituraEntrada();
		Composta composta = new Composta();
		Norma norma = new Norma();
		
		
		//leitura da instrução rotulada do arquivo
		reader.leArquivo(lstRotulos);
		
		//printa as instruções
		for (int i = 0; i < lstRotulos.size(); i++) {
			System.out.println(lstRotulos.get(i));
		}
		
		composta.rotulosComposta(lstRotulos, lstSaida);
		
		int a = 2, b = 0;
		norma.passoAPasso(lstRotulos, lstNorma, a, b);
		
		
		System.out.println(System.lineSeparator());
		
		System.out.println("-----------SAIDA----------");
		for (int i = 0; i < lstSaida.size(); i++) {
			System.out.println(lstSaida.get(i));
		}
		
		
		System.out.println();
		System.out.println("-----------SAIDA NORMA----------");
		for (int i = 0; i < lstNorma.size(); i++) {
			System.out.println(lstNorma.get(i));
		}
	}
}
