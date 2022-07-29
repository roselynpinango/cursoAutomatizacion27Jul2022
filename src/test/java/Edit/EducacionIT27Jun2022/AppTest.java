package Edit.EducacionIT27Jun2022;					// En qué paquete está el archivo

import org.testng.annotations.Test;

/**
 * Comentarios de 
 * más de una línea
 * 
 * Clase ejemplo para comprobar mi configuración de Java y Eclipse
 */
public class AppTest 
{
	String frase = "Mi Primera Clase de Automatización";		// Variable de tipo cadena de caracteres que se llama "frase"
	int numero = 35;
	
    // Comentario sólo puede tener una línea
    @Test							// Significa que lo que viene es una prueba
    public void imprimirEnConsola()    		// Es un método
    {
        // Instruccion para imprimir algo en la consola
    	System.out.println(frase);
    }
}
