import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;


import org.fogbeam.example.opennlp.TokenizerMain;
import org.junit.Test;




public class MyTests {
	
	@org.junit.Test
	public final void testMain() {
		TokenizerMain t = new TokenizerMain();
		assertTrue(t != null); // TODO
	}

	@Test
	public void CrearFichero() {
		File archivo = new File("hola.txt");
		assertTrue(archivo != null);
	}
	
	@Test
	public void LecturaFichero() throws FileNotFoundException {
		System.out.println("Probando si se lee el fichero");
		File archivo = new File("hola.txt");
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		assertTrue( f != null);
	}
	
	 

}
