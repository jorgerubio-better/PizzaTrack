public class PilaPedidos {
    private Nodo tope; // El plato que está hasta arriba de la pila

    public PilaPedidos() {
        this.tope = null; // Cuando la pila nace, está vacía
    }

    // 1. isEmpty(): Valida si la pila de pedidos se encuentra vacía
    public boolean isEmpty() {
        return tope == null;
    }

    // 2. push(): Inserta un objeto Pizza en el tope de la pila
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza); // Metemos la pizza en una cajita (Nodo)
        nuevoNodo.setSiguiente(tope); // El hilo del nuevo nodo apunta al que antes era el tope
        tope = nuevoNodo; // Ahora el nuevo nodo es el tope oficial
    }

    // 3. pop(): Retira el objeto del tope y devuelve su contenido
    public Pizza pop() {
        if (isEmpty()) {
            return null; // Si no hay pizzas, no devolvemos nada
        }
        Pizza pizzaRetirada = tope.getPizza(); // Guardamos la pizza de arriba
        tope = tope.getSiguiente(); // El tope pasa a ser el nodo de abajo
        return pizzaRetirada; // Entregamos la pizza
    }

    // 4. peek(): Visualiza la pizza en el tope sin retirarla
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.getPizza();
    }
}