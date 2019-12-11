package es.studium.carreraCamellos;

public class Camello{
	int nombre;
	int posicionActual;
	Camello(){
		nombre=0;
		posicionActual=0;
	}
	Camello(int nom){
		nombre=nom;	
		posicionActual=0;
	}
	int getNombre() {
		return nombre;
	}
	int damePosicionActual() {
		return posicionActual;
	}
	void setPosicionActual(int pos) {
		posicionActual=pos;
	}
	void avanzarCamello(int pos) {
		posicionActual+=pos;
	}
}
