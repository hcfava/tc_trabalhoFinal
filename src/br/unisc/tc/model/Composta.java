package br.unisc.tc.model;

import java.util.List;

public class Composta {
	public void rotulosComposta(List<String> lstRotulos, List<String> lstSaida) {
		int cont = 1;
		for (int i = 0; i < lstRotulos.size(); i++) {
			String split[] = lstRotulos.get(i).split(":");
			if(split[1].substring(1, 3).equals("fa")) {
				lstSaida.add(cont + ": (" + split[1].substring(6, 7) + ", " + split[1].substring(16, 17) + "), " + 
						"(" + split[1].substring(6, 7) + ", " + split[1].substring(16, 17) + ")");
				cont++;
			}else if(split[1].substring(1, 3).equals("se")) {
				int linha = Integer.parseInt(split[1].substring(21, 22));
				int linha2 = Integer.parseInt(split[1].substring(37, 38));
				if(linha < lstRotulos.size() && linha2 < lstRotulos.size()) {
					String splitAux[] = lstRotulos.get(i+1).split(":");
					lstSaida.add(cont + ": (" + lstRotulos.get(linha-1).substring(8, 9) + ", " + split[1].substring(21, 22) + "), " +
							"(" + splitAux[1].substring(6, 7) + ", " + split[1].substring(37, 38) + ")");
					cont++;
				}else {
					if(linha >= lstRotulos.size()) {
						lstSaida.add(cont + ": (parada, ε), " + "(" + lstRotulos.get(linha2-1).substring(8, 9) + ", " + split[1].substring(37, 38) + ")");
					}else {
						lstSaida.add(cont + ": (" + lstRotulos.get(linha-1).substring(1, 2) + ", " + split[1].substring(21, 22) + "), " +
								"(parada, ε)");
					}
					cont++;
				}
			}
		}
	}
}
