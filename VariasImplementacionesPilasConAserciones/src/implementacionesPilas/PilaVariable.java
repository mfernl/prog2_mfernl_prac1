/**
 * 
 */
package implementacionesPilas;

import java.util.ArrayList;

/**
 * @author adolfo
 *
 */
public class PilaVariable implements IPilaVariable {

	
    /* Almacena los elementos de la Pila */
    private ArrayList<Integer> elemento;


    /* El número actual de elementos en la Pila */
    private int nelems;
    
	/* Invariante de clase */
	{
     assert (nelems > 0)?elemento.get(nelems-1) == cima():true; // invariante interno de clase	
	}
	
    /** Crea una nueva pila con capacidad n */
	public PilaVariable (){

		elemento = new ArrayList<Integer>();

		//Postcondiciones
		assert elemento != null; // la pila no es nula
		assert esVacia() == true; // la pila esta vacía: ¿es esto verdad? ¿por qué?
		// recordar que el invariante de clase debe ser verdad al finalizar la ejecución de cualquier método
	}

    /* Observar que nelems es un método de consulta, no altera nada, no necesita precondiciones.
     * La postcondición sería que el resultado del método es el número de elementos de la pila
     * pero eso no se puede establecer en una assert de Java.  
     */
	
    // Postcondición: result == this.nelems
	@Override
	public int nelems() {
		return nelems;
	}

	// Postcondición: result == "último elemento de la pila"
	@Override
	public int cima() {
		assert nelems > 0; //Precondición
		
		return elemento.get(nelems-1);
		// de nuevo la postcondición no se puede trasladar a un assert
	}


	// Postcondición: result == true si y sólo si this.nelems == 0
	@Override
	public boolean esVacia() {
		return nelems == 0;
	}

	/* El siguiente método es de modificación (no de consulta como los anteriores). Los invariantes de clase y las 
	 * precondiciones/postcondiciones deben ayudarnos a construir correctamente.
	 */
	@Override
	public void apilar(int x) {

		elemento.add(x); // se infringe el invariante interno de clase: ahora cima() != elemento[nelems-1]
		nelems++;        // esto repone el invariante

		assert !esVacia();
		assert cima() == x;

	}

	//asignación en la precondición: (this.nelems >1) => old.poner(y) == this
	//Postcondición: this.cima() == old.cima()
	@Override
	public void desapilar() {
		assert !esVacia(): "desapilar: ¡pila vacía!";
		
		nelems--; // Observar que no eliminamos el elemento, esto, si no lo hacemos bien, puede dar a errores 
		          // con elementos antiguos no sobrescritos
		
		// la postcondición de sacar establece que ahora la cima es el penúltimo elemento de this si existe, pero assert no
		// permite escribirlo

	}

}
