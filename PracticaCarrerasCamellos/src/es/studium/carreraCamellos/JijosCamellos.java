package es.studium.carreraCamellos;

import java.util.Random;

public class JijosCamellos implements Runnable{
	Camello camello;
	int distanciaFinal;
	boolean terminoPrimero=false;
	public JijosCamellos(int a, int distancia) {
		camello=new Camello(a);
		distanciaFinal=distancia;
	}
	@Override
	public void run() {
		int posicionResultante=0;
		todoElMetodo(posicionResultante);		
	}
	private void todoElMetodo(int posicionResultante){
		int avance;
		while(!Competicion.acabo) 
		{
			if(posicionResultante>=getDistanciaFinalMandada()) 
			{
				Competicion.acabo=true;
				terminoPrimero=true;
			}
			else
			{
				if(!Competicion.acabo) {
					avance=comprobanteDeAvance();
					posicionResultante=anvanzandoTal(avance);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					avanzando(posicionResultante, avance);					
				}
			}
		}
		anadirCamellos(posicionResultante);
	}
	private void anadirCamellos(int posicionResultante) {
		int distanciafaltante=getDistanciaFinalMandada()-posicionResultante+1;
		CamellosSegundos cs= new CamellosSegundos(camello.getNombre(),distanciafaltante);
		Competicion.listaDeSegundos.add(cs);
	}
	private synchronized void avanzando(int posicionResultante, int avance) {
		if(!Competicion.acabo) {
			camello.setPosicionActual(posicionResultante);
			System.out.println("El camello "+camello.getNombre()+" ha avanzado "+avance+" metros y va en "+posicionResultante+" metro");
		}
	}
	private  int anvanzandoTal(int avance) {
		int posicionActual=camello.damePosicionActual();
		int posicionResultante=posicionActual+avance;
		return posicionResultante;
	}
	private int sacadaNumeroAleatorio() {
		int numeroSacado;
		Random numeroAleatiorio = new Random();
		numeroSacado = numeroAleatiorio.nextInt(100);
		return numeroSacado;
	}
	private int comprobanteDeAvance() {
		int avance=0;
		int numeroSacado=sacadaNumeroAleatorio();
		if((numeroSacado>=0)&&(numeroSacado<=30)) {
			avance=0;
		}else if((numeroSacado>=31)&&(numeroSacado<=70)) {
			avance=1;
		}else if((numeroSacado>=71)&&(numeroSacado<=90)) {
			avance=2;
		}else if((numeroSacado>=91)&&(numeroSacado<=100)) {
			avance=3;
		}
		return avance;
	}
	int getDistanciaFinalMandada(){
		return distanciaFinal;
	}
}
