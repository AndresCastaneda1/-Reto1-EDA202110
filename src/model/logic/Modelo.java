package model.logic;
import java.io.BufferedReader;
import model.data_structures.Nodo;

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

