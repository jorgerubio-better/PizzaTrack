public class Nodo {
    private Pizza pizza; // El objeto que guardamos
    private Nodo siguiente; // El "hilo" que apunta al nodo de abajo

    // Constructor
    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null; // Al principio no apunta a nada
    }

    // Getters y Setters
    public Pizza getPizza() {
        return pizza;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}