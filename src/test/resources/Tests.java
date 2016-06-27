import static org.junit.Assert.*;
import org.junit.*;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import org.fogbeam.example.opennlp.TokenizerMain;


public class Tests {
	
	
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
	
	@Test
	/**
	 * Test para comprobar si se lee bien un fichero de entrada
	 * @throws FileNotFoundException
	 */
	public void LecturaFichero() throws IOException {
		File archivo = new File("texto1.txt");
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		assertTrue( f != null);
		b.close();
	}
	
	/**
	 * Test para el metodo menu
	 */
	@Test
	public void menu(){
		assertTrue(TokenizerMain.LeerFichero("hola.txt") != null);
	}
}