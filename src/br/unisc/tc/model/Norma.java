package br.unisc.tc.model;

import java.util.List;

public class Norma {
	public void passoAPasso(List<String> lstRotulos, List<String> lstNorma, int a, int b, int c) {
		int aux=1;
		lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
		while (aux != 7) {
			String split[] = lstRotulos.get(aux-1).split(":");
			if(split[1].substring(1, 3).equals("fa")) {
				if(split[1].substring(6, 7).equals("F")) {
					a--;
					aux = Integer.parseInt(split[1].substring(16, 17));
					lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
				}else if(split[1].substring(6, 7).equals("G")) {
					b--;
					aux = Integer.parseInt(split[1].substring(16, 17));
					lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
				}else if(split[1].substring(6, 7).equals("H")) {
					c++;
					aux = Integer.parseInt(split[1].substring(16, 17));
					lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
				}
			}else if(split[1].substring(1, 3).equals("se")) {
				if(split[1].substring(4, 6).equals("T1")) {
					if(a != 0) {
						aux = Integer.parseInt(split[1].substring(37, 38));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
					}else {
						aux = Integer.parseInt(split[1].substring(21, 22));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
					}
				}else if(split[1].substring(4, 6).equals("T2")) {
					if(b != 0) {
						aux = Integer.parseInt(split[1].substring(37, 38));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
					}else {
						aux = Integer.parseInt(split[1].substring(21, 22));
						lstNorma.add("(" + (aux) + ", (" + a + ", " + b + ", " + c + "))");
					}
				}
			}
		}
	}

}
