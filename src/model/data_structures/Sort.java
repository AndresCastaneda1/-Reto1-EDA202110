package model.data_structures;


public class Sort<T> {

	public static void sorting(Comparable[] a) {
		int tamano = a.length;

		int index = 1;
		while (index < tamano/3) index = 3*index + 1; 

		while (index >= 1) {

			for (int i = index; i < tamano; i++) {
				for (int j = i; j >= index && menor(a[j], a[j-index]); j -= index) {
					cambiar(a, j, j-index);
				}
			}
			index++;
		}
	}

	public static void invertir(Comparable[] a)
	{
		Comparable[] A = new Comparable[a.length];
		int i = 0;
		int j= a.length-1;
		while(i<a.length)
		{
			A[i]=a[j];
			j--;
			i++;

		}
		for (int j2 = 0; j2 < a.length; j2++) {
			a[j2]=A[j2];
		}



	}
	private static boolean menor(Comparable v, Comparable w) {
		if(v!=null && w!=null) {
			return v.compareTo(w) < 0;
		}
		return false;
	}

	private static void cambiar(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}


