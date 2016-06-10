import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.fogbeam.example.opennlp.TokenizerMain;
import org.junit.Test;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class MyTests {
	
	
	@Test
	/**
	 * Test para un objeto de tipo TokenizerMain
	 */
	public final void testMain(){
		TokenizerMain t = new TokenizerMain();
		assertTrue(t != null);
	}

	@Test
	/**
	 * Test comprobar si crea bien un fichero
	 */
	public void CrearFichero() {
		File archivo = new File("hola.txt");
		assertTrue(archivo != null);
	}
	
	//@Test
	/**
	 * Test para comprobar si se lee bien un fichero de entrada
	 * @throws FileNotFoundException
	 */
	/*public void LecturaFichero() throws FileNotFoundException {
		System.out.println("Probando si se lee el fichero");
		File archivo = new File("hola.txt");
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		assertTrue( f != null);
	}
	*/
	/**
	 * Test para el metodo menu
	 */
	@Test
	public void menu(){
		Scanner s = new Scanner(System.in);
		assertTrue(TokenizerMain.LeerFichero("hola.txt", s) != null);
	}
}
