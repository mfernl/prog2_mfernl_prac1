/**
 * 
 */
package implementacionesPilas;

/**
 * @author adolfo
 *
 */
public class PilaFija implements IPilaFija {

	
    /* Almacena los elementos de la Pila */
    private int[] elemento;

    /* La capacidad máxima de la Pila */
    private int capacidad;

    /* El número actual de elementos en la Pila */
    private int nelems;
    
	/* Invariante de clase */
	{assert 0 <= nelems && nelems <= capacidad;
     assert (nelems > 0)?elemento[nelems-1] == cima():true; // invariante interno de clase	
	}
	
    /** Crea una nueva pila con capacidad n */
	public PilaFija (int n){
		//Precondiciones
		assert n >= 1:"Pila: capacidad debe ser positiva";

		elemento = new int[n];
		capacidad = n;

		//Postcondiciones
		assert capacidad == n; // aseguro que la pila tiene una capacidad de n elementos
		assert elemento != null; // la pila no es nula
		assert esVacia() == true; // la pila esta vacía: ¿es esto verdad? ¿por qué?
		assert estaLlena() == false;
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
		
		return elemento[nelems-1];
		// de nuevo la postcondición no se puede trasladar a un assert
	}

	
	/* Observar que la postcondición establece una relación entre entidades externas, que pueden ser accesibles
	 * por el agente que usa la clase Pila. Es evidente que la postcondición también se podría establecer como
	 * result == true si y sólo si nelems == elemento.length
	 * pero elemento es una entidad de la implementación de PilaFija no de su interfaz
	 */ 
	
	// Postcondición: result == true si y sólo si this.nelems == capacidad
	@Override
	public boolean estaLlena() {
		return nelems == capacidad;
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
	public void poner(int x) {
		// precondición
		assert !estaLlena(): "poner: ¡pila llena!, no puedo añadir ningún elemento más.";

		elemento[nelems] = x; // se infringe el invariante interno de clase: ahora cima() != elemento[nelems-1]
		nelems++;             // esto repone el invariante

		assert !esVacia();
		assert cima() == x;

	}

	//asignación en la precondición: (this.nelems >1) => old.poner(y).poner(x) == this
	//Postcondición: this.cima() == y
	@Override
	public void sacar() {
		assert !esVacia(): "sacar: ¡pila vacía!"; //Precondición
		
		nelems--;
		
		assert !estaLlena();
		// la postcondición de sacar establece que ahora la cima es el penúltimo elemento de this si existe, pero assert no
		// permite escribirlo

	}

}
