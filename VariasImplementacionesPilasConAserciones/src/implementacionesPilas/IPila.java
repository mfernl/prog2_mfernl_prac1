/**
 * 
 */
package implementacionesPilas;

/**
 * Interfaz de un contenedor 
 *  pila que tiene una política LIFO: 
 *  último en entrar primero en salir. 
 * @author adolfo
 *
 */
public interface IPila<T> {
	
	//Invariantes del Tipo Abastracto de Datos que queremos definir con el Interfaz IPilaVariable:
	// vacia es la pila vacía (Este es el "constructor" para poder crear cualquier pila)
	// esVacia(vacia) == true
	// p.apilar(x).esVacia() == false
	// (p.apilar(x)).cima() == x
	// (p.apilar(x)).desapilar() == p
	// vacia.nelems == 0
	// p.apilar(x).nelems == p.nelems + 1
	// !p.esVacia => p.desapilar().nelems == p.nelems - 1

	/** Devuelve el número de elementos en la Pila */
	//Precondición: pila no nula (this no nulo)
	//Postcondición: result == número de elementos que contiene la pila 
	public int nelems();

	/** Devuelve el último elemento introducido en la pila */
	//Precondición: pila no nula
	//Postcondición: result == último elemento introducido en la pila	
	public T cima();

	/** Devuelve false si y sólo si la pila está vacía */
	//Precondición: pila no nula
	//Postcondición: result == true si y sólo si la pila no tiene elementos
	public boolean esVacia();

	/** Introduce x en la pila, que pasa a ser el último elemento introducido en la pila */
	//Precondición: pila no nula
	//Postcondición: x == último elemento introdución en la pila == cima() && vacia() == false
	public void apilar (T x);

	/** Elimina el último elemento introducido en la pila  */
	//Precondición: pila no nula && pila no vacía && this == old.apilar(x)
	//Postcondición: llena() == false && this.cima() == old.cima()
	public void desapilar();
}
