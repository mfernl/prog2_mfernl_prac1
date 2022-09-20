/**
 * 
 */
package implementacionesPilas;

/**
 * Interfaz de un contenedor 
 *  pila de tamaño fijo que tiene una política LIFO: 
 *  último en entrar primero en salir. 
 * @author adolfo
 *
 */
public interface IPilaFija {
	
	//Invariantes del Tipo Abastracto de Datos que queremos definir con el Interfaz IPila:
	// vacia(n) es la pila vacía (Este es el "constructor" para poder crear cualquier pila de capacidad n)
	// vacia(n).nelems == 0
	// !p.estaLlena() => (p.poner(x)).nelems() == p.nelems() + 1
	//  p.estaLlena() <=> p.nelems() == n
	// !p.estaLlena() => (p.poner(x)).esVacia() == false
	// !p.estaLlena() => (p.poner(x)).cima() == x
	// !p.estaLlena() => (p.poner(x)).sacar() == p
	//  p.estaLlena() => p.poner(x) == p
	

	/** Devuelve el número de elementos en la Pila */
	//Precondición: pila no nula (this no nulo)
	//Postcondición: result == número de elementos que contiene la pila 
	public int nelems();

	/** Devuelve el último elemento introducido en la pila */
	//Precondición: pila no nula
	//Postcondición: result == último elemento introducido en la pila	
	public int cima();

	/** Devuelve true si y sólo si la pila está llena */
	//Precondición: pila no nula
	//Postcondición: result == true si y sólo si la pila no admite más elementos
	public boolean estaLlena();

	/** Devuelve false si y sólo si la pila está vacía */
	//Precondición: pila no nula
	//Postcondición: result == true si y sólo si la pila no tiene elementos
	public boolean esVacia();

	/** Introduce x en la pila, que pasa a ser el último elemento introducido en la pila */
	//Precondición: pila no nula && pila no llena
	//Postcondición: x == último elemento introdución en la pila == cima() && vacia() == false
	public void poner (int x);

	/** Elimina el último elemento introducido en la pila  */
	//Precondición: pila no nula && pila no vacía && (nelems > 1)?this == old.poner(y).poner(x):this==old.poner(x)
	//Postcondición: llena() == false && (!this.vacia())? this.cima() == old.poner(y).cima():this.vacia()==true
	public void sacar();
}
