import java.util.Scanner;

public class GestionPedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Nuestras dos pilas manuales como exige la rúbrica
        PilaPedidos pilaPrincipal = new PilaPedidos(); // Para el Undo
        PilaPedidos pilaSecundaria = new PilaPedidos(); // Para el Redo

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- 🍕 SISTEMA DE PEDIDOS PIZZA-TRACK 🍕 ---");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            // Verificamos que el usuario ingrese un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } else {
                System.out.println("⚠️ Por favor, ingresa un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la pizza: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrediente 1: ");
                    String ing1 = scanner.nextLine();
                    System.out.print("Ingrediente 2: ");
                    String ing2 = scanner.nextLine();
                    System.out.print("Ingrediente 3: ");
                    String ing3 = scanner.nextLine();

                    Pizza nuevaPizza = new Pizza(nombre, ing1, ing2, ing3);
                    pilaPrincipal.push(nuevaPizza); // push() a la pila principal
                    
                    // Al registrar algo nuevo, vaciamos la pila de rehechos 
                    pilaSecundaria = new PilaPedidos(); 
                    System.out.println("✅ Pizza registrada con éxito.");
                    break;

                case 2: // Deshacer (Undo)
                    if (!pilaPrincipal.isEmpty()) {
                        Pizza pizzaDeshecha = pilaPrincipal.pop(); // pop() de la principal
                        pilaSecundaria.push(pizzaDeshecha); // push() a la secundaria
                        System.out.println("↩️ Deshecho: " + pizzaDeshecha.getNombre());
                    } else {
                        System.out.println("⚠️ No hay pedidos para deshacer.");
                    }
                    break;

                case 3: // Rehacer (Redo)
                    if (!pilaSecundaria.isEmpty()) {
                        Pizza pizzaRehecha = pilaSecundaria.pop(); // pop() de la secundaria
                        pilaPrincipal.push(pizzaRehecha); // push() a la principal
                        System.out.println("↪️ Rehecho: " + pizzaRehecha.getNombre());
                    } else {
                        System.out.println("⚠️ No hay pedidos para rehacer.");
                    }
                    break;

                case 4: // Mostrar Pedido Actual
                    if (!pilaPrincipal.isEmpty()) {
                        System.out.println("🍕 Pedido en tope listo para producción:");
                        System.out.println(pilaPrincipal.peek().toString()); // peek()
                    } else {
                        System.out.println("📭 No hay pedidos activos en este momento.");
                    }
                    break;

                case 0:
                    System.out.println("👋 Saliendo de Pizza-Track... ¡Buen trabajo!");
                    break;

                default:
                    System.out.println("❌ Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
}