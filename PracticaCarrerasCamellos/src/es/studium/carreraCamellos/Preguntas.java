package es.studium.carreraCamellos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Preguntas {
	static int numeroCamellos=0;
	static int distanciaMeta=0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		pidiendoNumeroDeCamellos(br);
		pidiendoDistancia(br);
		System.out.println("La cantidad de camellos son "+getNumeroCamellos());
		System.out.println("La distancia de camellos son "+getDistanciaMeta());
		new Competicion(getNumeroCamellos(),getDistanciaMeta());
	}
	private static void pidiendoDistancia(BufferedReader br) {
		boolean tercerFlag=false;
		while(tercerFlag==false) {
			System.out.println("¿Cuanta distancia en km iran estos?");
			try {
				setDistanciaMeta(Integer.parseInt(br.readLine()));			
			}
			catch(Exception e)
			{
				System.out.println("No se leyo bien el numero");
				System.out.println(e);
			}
			if(distanciaMeta!=0) {
				tercerFlag=true;
			}
			else {
				System.out.println("Por favor, escriba algo que no sea 0");
			}
		}
	}
	private static void pidiendoNumeroDeCamellos(BufferedReader br) {
		boolean primerFlag=false;
		boolean segundoFlag=false;
		while(segundoFlag==false) {
			primerFlag=false;
			while(primerFlag==false) {
				System.out.println("¿Cuántos camellos participarán?");
				try {
					setNumeroCamellos(Integer.parseInt(br.readLine()));			
				}
				catch(Exception e)
				{
					System.out.println("No se leyo bien el numero");
					System.out.println(e);
				}
				if(getNumeroCamellos()!=0) {
					primerFlag=true;
				}
				else {
					System.out.println("Por favor, escriba algo que no sea 0");
				}
			}
			switch(getNumeroCamellos()) {
			case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
				System.out.println("En la competición habrán "+numeroCamellos+" camellos");
				segundoFlag=true;
				break;
			default:
				System.out.println("Actualmente solo es compatible en torno a 2 a 10 camellos");
				System.out.println("Escriba entre el rango actual");
				break;
			}
		}
	}
	static int getNumeroCamellos(){
		return numeroCamellos;	
	}
	static int getDistanciaMeta() {
		return distanciaMeta;
	}
	static void setNumeroCamellos(int numero){
		numeroCamellos=numero;
	}
	static void setDistanciaMeta(int numero){
		distanciaMeta=numero;
	}
}
