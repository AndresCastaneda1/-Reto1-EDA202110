package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public  class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}
	
	public String toString()
	{
		String respuesta ="";
		int i=0;
		while(i<tamanoAct)
		{
			respuesta+=elementos[i]+"\n";
			i++;
		}
		return respuesta;
	}
	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		 
		return elementos[i];
	}

	@Override
	public void agregar( T dato )
	{
		
				if ( tamanoAct == tamanoMax )
				{ 
					tamanoMax = 2 * tamanoMax;
					T [ ] copia = elementos;
					elementos = (T[])new Comparable[tamanoMax];
					for ( int i = 0; i < tamanoAct; i++)
					{
						elementos[i] = copia[i];
					} 
					System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
				}	
				elementos[tamanoAct] = dato;
				tamanoAct++;
	}
	@Override
	public T buscar(T dato) {

	
		T respuesta=null;
		int i =0;
		boolean x = false;
		while(i<tamanoAct && !x)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				respuesta= elementos[i];
				x=true;
			}
			i++;
		}
		return respuesta;

	}
	@Override
	public T eliminar(T dato) {

		T buscado=null;
		int i =0;
		boolean centinel = false;
		while(i<tamanoAct && !centinel)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				buscado= elementos[i];
				centinel=true;

			}
			i++;
		}
		while(i<tamanoAct)
		{
			elementos[i-1]=elementos[i];
			i++;
		}
		tamanoAct--;
		return buscado;
	}
	public void invertirElementos()
	{
		T[]temp= (T[])new Object[tamanoMax];
		for(int i =tamanoAct; i>=0;i--)
		{
			temp[i]= elementos[i];
			
		}
		
	}

	@Override
	public int compareTo(T obj)
	{
		return 0;
	}
	public T darPrimer()
	{
		return elementos[0];
	}

	public T darUlt()
	{
		return elementos[tamanoAct-1];
	}
	public int darI(T o)
	{

		int i = 0;
		boolean cen = false;
		while(i<tamanoMax && !cen)
		{
			if(elementos[i].compareTo(o)==0)
			{
				cen = true;
			}
			else {
				i++;
			}
		}
		return i;
	}
		public int darSigI(T o)
	{
		int i =0;
		boolean cen = false;
		while(i<tamanoAct && !cen)
		{
			if(elementos[i].equals(o))
			{
				cen = true;
			}
			else {
				i++;
			}
		}
		return i++;
	}
	
	



}
