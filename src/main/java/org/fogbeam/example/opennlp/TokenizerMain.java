package org.fogbeam.example.opennlp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerMain {
	
	public static void main( String[] args ) throws Exception{
		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );
		// the model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
          
		try{
			TokenizerModel model = new TokenizerModel( modelIn );
			Tokenizer tokenizer = new TokenizerME(model);
			Scanner s = new Scanner(System.in);
			String aux = null;
			FileWriter fichero = null;
			PrintWriter pw = null;
			Writer out=null;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fichero_salida.txt"),"UTF-8"));
			fichero= new FileWriter ("fichero.txt");
			pw = new PrintWriter(fichero);
		while(aux != "s"){
		System.out.println("Introduce el nombre de un fichero: ");
		System.out.println("Si quiere salir pulse 's'");
		aux=s.nextLine();

		File archivo = new File(aux);
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);

			String[] tokens = null;
			while((cadena = b.readLine())!=null) {
				tokens = tokenizer.tokenize(cadena);
				
				for(int i=0;i<tokens.length;i++){
			//	for( String token : tokens ){
				System.out.println(tokens[i]);
			//	out.write(token);
				for (int j = 0; j < tokens.length; j++)
	                pw.println(tokens[j]);
				
				}
			}		
			b.close();
			}
				out.close();
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
