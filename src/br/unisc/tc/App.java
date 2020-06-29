package br.unisc.tc;

import java.util.ArrayList;
import java.util.List;

import br.unisc.tc.model.LeituraEntrada;

public class App {
	public static void main(String[] args) {
		List<String> lstRotulos = new ArrayList<String>();
		List<String> lstSaida = new ArrayList<String>();
		List<String> lstNorma = new ArrayList<String>();
		LeituraEntrada reader = new LeituraEntrada();
		int a = 2, b = 0;
		
		reader.leArquivo(lstRotulos);
		
		for (int i = 0; i < lstRotulos.size(); i++) {
			System.out.println(lstRotulos.get(i));
		}
		
		for (int i = 0; i < lstRotulos.size(); i++) {
			String split[] = lstRotulos.get(i).split(":");
			if(split[1].substring(1, 3).equals("fa")) {
				lstSaida.add("(" + split[1].substring(6, 7) + ", " + split[1].substring(16, 17) + "), " + 
						"(" + split[1].substring(6, 7) + ", " + split[1].substring(16, 17) + ")");
			}else if(split[1].substring(1, 3).equals("se")) {
				int linha = Integer.parseInt(split[1].substring(21, 22));
				int linha2 = Integer.parseInt(split[1].substring(37, 38));
				if(linha < lstRotulos.size() && linha2 < lstRotulos.size()) {
					String splitAux[] = lstRotulos.get(i+1).split(":");
					lstSaida.add("(" + lstRotulos.get(linha-1).substring(8, 9) + ", " + split[1].substring(21, 22) + "), " +
							"(" + splitAux[1].substring(6, 7) + ", " + split[1].substring(37, 38) + ")");
				}else {
					if(linha >= lstRotulos.size()) {
						lstSaida.add("(parada, ε), " + "(" + lstRotulos.get(linha2-1).substring(8, 9) + ", " + split[1].substring(37, 38) + ")");
					}else {
						lstSaida.add("(" + lstRotulos.get(linha-1).substring(1, 2) + ", " + split[1].substring(21, 22) + "), " +
								"(parada, ε)");
					}
				}
			}
		}
		
		int aux=1;
		lstNorma.add("(" + aux + ", (" + a + ", " + b + "))");
		while (aux != 5) {
			String split[] = lstRotulos.get(aux-1).split(":");
			if(split[1].substring(1, 3).equals("fa")) {
				if(split[1].substring(6, 7).equals("F")) {
					a--;
					aux = Integer.parseInt(split[1].substring(16, 17));
					lstNorma.add("(" + (aux) + ", (" + a + ", " + b + "))");
				}else if(split[1].substring(6, 7).equals("G")) {
					b++;
					aux = Integer.parseInt(split[1].substring(16, 17));
					lstNorma.add("(" + (aux) + ", (" + a + ", " + b + "))");
				}
			}else if(split[1].substring(1, 3).equals("se")) {
				if(split[1].substring(4, 6).equals("T1")) {
					if(a != 0) {
						aux = Integer.parseInt(split[1].substring(37, 38));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + "))");
					}else {
						aux = Integer.parseInt(split[1].substring(21, 22));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + "))");
					}
				}else if(split[1].substring(4, 6).equals("T2")) {
					if(b != 2) {
						aux = Integer.parseInt(split[1].substring(37, 38));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + "))");
					}else {
						aux = Integer.parseInt(split[1].substring(21, 22));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + "))");
					}
				}
			}
		}
		
		System.out.println();
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
