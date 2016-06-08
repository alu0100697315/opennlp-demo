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

public class TokenizerMain {
	
	public static void Tokenizer(PrintWriter pw,String[] tokens,BufferedReader b,Tokenizer tokenizer) throws IOException{
		String cadena;
		while((cadena = b.readLine())!=null) {
			tokens = tokenizer.tokenize(cadena);
			
			for( String token : tokens ){	
				pw.println(token);
				pw.flush();
			}	
		}
	}
	
	public static String LeerFichero (String aux,Scanner s){
		System.out.println(" ");
		System.out.println("Introduce el nombre de un fichero: ");
		System.out.println("Si quiere salir pulse 's'");
		return aux;
	}
	
	public static void main( String[] args ) throws Exception{
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		try{
			TokenizerModel model = new TokenizerModel( modelIn );
			Tokenizer tokenizer = new TokenizerME(model);
			
			Scanner s = new Scanner(System.in);
			String aux = null;
			FileWriter fichero = null;
			PrintWriter pw = null;
			fichero= new FileWriter ("fichero.txt");
			pw = new PrintWriter(fichero);
			
		while(aux != "s"){
		LeerFichero(aux,s);	
		aux=s.nextLine();

		File archivo = new File(aux);
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		
			String[] tokens = null;
			Tokenizer(pw,tokens,b, tokenizer);
			pw.println("\n---OTRO FICHERO --- \n");
			b.close();
		}
				pw.close();
				s.close();
			}

		catch( IOException e ){
			e.printStackTrace();
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
