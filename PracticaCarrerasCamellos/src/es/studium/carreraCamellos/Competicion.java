package es.studium.carreraCamellos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Competicion {
	static boolean acabo=false;
	static ArrayList<CamellosSegundos> listaDeSegundos=new ArrayList<CamellosSegundos>();
	int numeroCamellol;
	public Competicion(int numeroCamellos, int distanciaMeta) {
		Scanner sc = new Scanner(System.in);
		numeroCamellol=numeroCamellos;
		System.out.println("DALE A AR INTRO PA QUE EMPIECE HUEON");
		sc.nextLine();
		for(int a=1; a<=numeroCamellos; a++) {
			new Thread(new JijosCamellos(a,distanciaMeta)).start();
		}
		while(!acabo) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			String sentenciaFinal = "-----------FINALIZADO-----------"+"\n";
			System.out.println(sentenciaFinal);
			int esperarACamellos = numeroCamellol*1000;
			System.out.println("Espere "+(esperarACamellos/1000)+" segundos para calcular el resultado");
			Thread.sleep(esperarACamellos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Solucion Posible por falso primero (imprimir el primero antes de ordenar)
		String sentencia="1º camello ha sido camello"+listaDeSegundos.get(0).getName();				
		System.out.println(sentencia);
		listaDeSegundos.remove(0);
		Collections.sort(listaDeSegundos);
		for(CamellosSegundos cam : listaDeSegundos){
				System.out.println((listaDeSegundos.indexOf(cam)+2)+"º"+" El camello "+cam.getName()+ 					
						" se quedo a "+cam.getDistanciaFalta()+" metros del Final");
		}
	}
}
