package model.logic;
import java.io.BufferedReader;
import model.data_structures.Nodo;
import model.data_structures.Sort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.data_structures.ArregloDinamico; 
import model.data_structures.IArregloDinamico;
import model.data_structures.YoutubeVideo;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;





/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */




	private ArregloDinamico videos;
	private ListaEncadenada<Nodo<YoutubeVideo>> listaVideos;





	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		videos = new ArregloDinamico<YoutubeVideo>(120);
		listaVideos= new ListaEncadenada<Nodo<YoutubeVideo>>();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		videos = new ArregloDinamico(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return videos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		videos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */


	public Object buscar(String dato)
	{
		return videos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Object eliminar(String dato)
	{
		return videos.eliminar(dato);
	}



	public String tendenciaPais(int x, int atributo, int ordenamiento, String Pais)
	{
		String respuesta="";
		int i =0;

		YoutubeVideo[] arreglo = new YoutubeVideo[x];

		while (i<videos.darTamano())
		{

			if(atributo==1)
			{
				YoutubeVideo actual=(YoutubeVideo) videos.darElemento(i);

				if(isFull(arreglo))
				{
					Sort.sorting(arreglo);
					if(actual.darcountry().compareTo(arreglo[arreglo.length-1].darcountry())>0)
					{
						arreglo[arreglo.length-1]=actual;
					}

				}
				if(i<x-1)
				{
					arreglo[i]=actual;
				}
			}
			if(atributo==2)
			{
				YoutubeVideo actual=(YoutubeVideo) videos.darElemento(i);
				if(isFull(arreglo))
				{
					Sort.sorting(arreglo);
					if(actual.darviews().compareTo(arreglo[arreglo.length-1].darviews())>0)
					{
						arreglo[arreglo.length-1]=actual;
					}

				}
				if(i<x-1)
				{
					arreglo[i]=actual;
				}

			}


			i++;
		}
		if(ordenamiento==1)
		{
			Sort.sorting(arreglo);
		}
		if(ordenamiento==2)
		{
			Sort.invertir(arreglo);
		}

		for (int j = 0; j < arreglo.length-1; j++) {
			if(arreglo[j]!=null)
			{
				respuesta+= arreglo[j].darcountry()+ arreglo[j].darTitle()+ arreglo[j].darchannelTitle()+arreglo[j].darviews()+arreglo[j].darlikes()+arreglo[j].dardislikes();

			}

		}
		return respuesta;
	}

	public String likesPorTag (String Pais, int n, String pTag)
	{

		ArregloDinamico <String> arreglo = new ArregloDinamico<String>(n);
		String respuesta1 = null;

		boolean encontrado = false;
		for (int i=0; i< videos.darTamano();i++)
		{ 
			YoutubeVideo actual1 = (YoutubeVideo) videos.darElemento(i);
			String Pai = actual1.darcountry();
			String tagg = actual1.dartags();

			if(Pai.contains(Pais))
			{
				if ( tagg.contains(pTag))
				{				
					encontrado = true;
					arreglo.agregar(actual1.darTitle()+actual1.darchannelTitle()+actual1.darpublishTime()+actual1.darviews()+actual1.darlikes()+actual1.dardislikes()+actual1.dartags());

				}

			}
		}
		if (encontrado)
		{
			respuesta1 = ""+ arreglo;

		}
		else
		{
			respuesta1 = "El tag no fue encontrado o el pais no fue encontrado";
		}

		return respuesta1 ;
	}
	
	
	public String videomastiempoTrending(String Pais)
	{
		YoutubeVideo[] arreglo = new YoutubeVideo[videos.darCapacidad()];
		String respuesta;
		boolean encontrado = false;
		for (int i=0; i< videos.darTamano()||encontrado!= true;i++)
		{ 
			YoutubeVideo actual = (YoutubeVideo) videos.darElemento(i);
			String act =actual.darcountry();
			if (act.equals(Pais))
			{
				encontrado = true;
				Sort.sorting(arreglo);
				if(actual.dartrendingDate().compareTo(arreglo[arreglo.length-1].dartrendingDate())>0)
				{
					arreglo[arreglo.length-1]=actual;
				}
			}			

		}
				if(encontrado)
		{
			respuesta = arreglo[0].darTitle()+ arreglo[0].darchannelTitle()+arreglo[0].darcountry()+arreglo[0].dartrendingDate();
		}
		else
		{
			respuesta = "El pais no se encontro";
		}

		return respuesta;
	}






	public boolean isFull(YoutubeVideo[] a)
	{
		boolean respuesta=false;


		if(a[a.length-1]!=null)
		{
			respuesta=true;
		}

		return respuesta;
	}

	public void cargar() throws IOException 
	{

		String pRuta = "./data/videos-all.csv";

		BufferedReader br = null;
		BufferedReader pr = null;
		String line = "";
		String salto = ",";


		try {
			br= new BufferedReader(new FileReader(pRuta));

			while((line= br.readLine()) !=null)
			{
				String[] video=line.split(salto);
				String videoId=video[0];
				String trendingDate=video[1];
				String Title=video[2];
				String channelTitle=video[3];
				String categoryId=video[4];
				String publishTime=video[5];
				String tags=video[6];
				String views=video[7];
				String likes=video[8];
				String dislikes=video[9];
				String commentCount=video[10];
				String thumbnailLink=video[11];
				String comments=video[12];
				String ratingsDisabled=video[13];
				String viodeoError=video[14];
				String description=video[15];
				String country=video[16];
			}}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}




	}
}

