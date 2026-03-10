public class Pizza {
    private String nombre;
    private String[] ingredientes;

    // Constructor
    public Pizza(String nombre, String ing1, String ing2, String ing3) {
        this.nombre = nombre;
        // Inicializamos el arreglo con tamaño fijo de 3 como exige la rúbrica
        this.ingredientes = new String[3];
        this.ingredientes[0] = ing1;
        this.ingredientes[1] = ing2;
        this.ingredientes[2] = ing3;
    }

    // Métodos Getters
    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    // Método para mostrar la información de la pizza fácilmente
    @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: [" + ingredientes[0] + ", " + 
               ingredientes[1] + ", " + ingredientes[2] + "]";
    }
}