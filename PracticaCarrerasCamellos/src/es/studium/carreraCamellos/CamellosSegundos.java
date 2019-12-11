package es.studium.carreraCamellos;

import java.util.Comparator;

public class CamellosSegundos implements Comparable<CamellosSegundos>{
	int name;
	int distanciaFalta;
	public CamellosSegundos(int nombre, int distanciafaltante) {
		name=nombre;
		distanciaFalta=distanciafaltante;
	}
	public int getName(){
		return name;
	}
	public int getDistanciaFalta(){
		return distanciaFalta;
	}
	
	@Override
	public int compareTo(CamellosSegundos o) {
		int cantidadComparar=((CamellosSegundos)o).getDistanciaFalta();
		return this.getDistanciaFalta()-cantidadComparar;		
	}
	public static Comparator<CamellosSegundos>distanciaFaltaComparador=new Comparator<CamellosSegundos>() {
		public int compare(CamellosSegundos c1, CamellosSegundos c2) {
			return c1.compareTo(c2);
		}
	};
}
