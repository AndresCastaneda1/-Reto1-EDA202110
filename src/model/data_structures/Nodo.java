package model.data_structures;

public class Nodo<T> {

	private T datos;
	private Nodo<T> siguiente;
	private int posicion;
	private Nodo<T> anterior;

	public Nodo (T Pdatos, Nodo<T> Psiguiente, Nodo<T> Panterior, int Pposicion){
		this.datos=Pdatos;
		this.siguiente=Psiguiente;
		this.anterior=Panterior;
		this.posicion = Pposicion;

	}

	public void cambiarPosicion(int Pposicion)
	{
		posicion=Pposicion;
	}
	public T darDatos()
	{
		return this.datos;

	}

	public Nodo<T> darSiguiente()
	{
		return siguiente;
	}
	public void cambiarSiguiente(Nodo<T> Siguiente)
	{
		siguiente= Siguiente;
	}
	public Nodo<T> darAnterior()
	{
		return anterior;
	}

	public void cambiarAnterior(Nodo<T> Anterior)
	{
		anterior=Anterior;
	}
	public int darPosicion ()
	{
		return posicion;
	}
	public void changeInfo(T info)
	{
		datos=info;
	}

	public String toString()
	{
		return ""+datos.toString();
	}	

}