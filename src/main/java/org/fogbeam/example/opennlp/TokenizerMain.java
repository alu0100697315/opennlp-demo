package org.fogbeam.example.opennlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
/**
 * Clase TokenizerMain. Perteneciente al proyecto OpenNLP
 * Clase que integra los metodos para procesar uno o varios ficheros, separar en tokens y almacenarlo en un fichero.
 * @author Samuel
 *
 */
public class TokenizerMain {
	/**
	 * Metodo obtiene los distintos token que forman cierto fichero de texto
	 * Luego escribe los tokens en un fichero de salida.
	 * @param pw
	 * @param tokens
	 * @param b
	 * @param tokenizer
	 * @throws IOException
	 */
	public static void Tokenizer(PrintWriter pw,String[] tokens,BufferedReader b,Tokenizer tokenizer) throws IOException{
		String cadena;
		while((cadena = b.readLine())!=null) { //mientras no se llegue al final del fichero
			tokens = tokenizer.tokenize(cadena); //almacena en "tokens" los tokens
			
			for( String token : tokens ){	
				pw.println(token); //escribe en el fichero los tokens
				pw.flush();
			}	
		}
	}
	/**
	 * Metodo para mostrar el menu que indica al usuario que debe hacer
	 * @param aux
	 * @param s
	 * @return
	 */
	public static String LeerFichero (String aux){
		System.out.println(" ");
		System.out.println("Introduce el nombre de un fichero: ");
		System.out.println("Si quiere salir pulse 's'");
		return aux;
	}
	/**
	 * Funcion principal. 
	 * Se inicializa las distintas variables que vamos a necesitar y se llama a las funciones necesarias
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws IOException{
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		try{
			TokenizerModel model = new TokenizerModel( modelIn );
			Tokenizer tokenizer = new TokenizerME(model);
			
			Scanner s = new Scanner(System.in); //variable para leer desde teclado
			String aux = null; //variable para almacenar el nombre del fichero
			FileWriter fichero = null; //variable para crear el fichero de salida
			PrintWriter pw = null; //variable para escribir en fichero de salida
			fichero= new FileWriter ("fichero.txt");
			pw = new PrintWriter(fichero);
			
		while(aux != "s"){ //Con este bucle while permitimos que se puedas incluir varios ficheros
			
		LeerFichero(aux);
		aux=s.nextLine();
		
		File archivo = new File(aux);
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		
			String[] tokens = null;
			Tokenizer(pw,tokens,b, tokenizer); //llamada al metodo que separa los tokens y genera el fichero
			pw.println("\n---OTRO FICHERO --- \n"); //Separador en caso de que ingresemos otro fichero
			b.close();
		}
				pw.close();
				s.close();
			}

		catch( IOException e ){
			System.out.println("Error: Fichero no encontrado");
		}
		finally{
			if( modelIn != null ){
				try{
					modelIn.close();
				}
				catch( IOException e )
				{}
			}
		}
		System.out.println( "\n-----\ndone" );
	}
}
