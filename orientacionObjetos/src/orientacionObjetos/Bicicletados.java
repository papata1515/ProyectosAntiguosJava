package orientacionObjetos;

public class Bicicletados {

	   // --- 1. ATRIBUTOS ---
    // Variables de instancia para guardar el estado de cada bicicleta
    private int velocidadActual;
    private int platoActual;
    private int pinonActual; // Usamos 'pinon' en lugar de 'piñon' por convención.

    // --- 2. CONSTRUCTOR ---
    // El constructor debe llamarse IGUAL que la clase
    public Bicicletados(int velocidadActual, int platoActual, int pinonActual) {
        this.velocidadActual = velocidadActual;
        this.platoActual = platoActual;
        this.pinonActual = pinonActual;
    }

    // --- 3. MÉTODOS BÁSICOS ---

    public void acelerar() {
        this.velocidadActual = this.velocidadActual * 2;
    }

    public void frenar() {
        this.velocidadActual = this.velocidadActual / 2;
    }

    public void cambiarPlato(int plato) {
        this.platoActual = plato;
    }

    public void cambiarPinon(int pinon) {
        this.pinonActual = pinon;
    }

    public void imprimirEstado() {
        System.out.println("Bici -> Velocidad: " + velocidadActual + 
                           " | Plato: " + platoActual + 
                           " | Piñón: " + pinonActual);
    }

    // --- 4. NUEVO MÉTODO PARA LIMPIAR EL MAIN ---
    public void ejecutarRutina(int velocidadObjetivo, int platoObjetivo, int pinonObjetivo) {
        // 1. Lógica de aceleración
        while (this.velocidadActual < velocidadObjetivo) {
            this.acelerar();
        }
        
        // 2. Ajuste de marchas
        this.cambiarPlato(platoObjetivo);
        this.cambiarPinon(pinonObjetivo);
        
        // 3. Imprimir resultado final
        this.imprimirEstado();
    }

    // --- 5. MÉTODO MAIN (EJECUCIÓN) ---
    public static void main(String[] args) {
        
        System.out.println("=== 1. OBJETOS INDIVIDUALES ===");
        // Actualizamos las referencias a la nueva clase 'Bicicletados'
        Bicicletados miBicicleta = new Bicicletados(10, 2, 4);
        Bicicletados tuBicicleta = new Bicicletados(20, 3, 1);
        miBicicleta.imprimirEstado();
        tuBicicleta.imprimirEstado();

        System.out.println("\n=== 2. ARRAY DE 5 BICICLETAS ===");
        // Actualizamos el tipo del array
        Bicicletados[] bicicletas = new Bicicletados[5];
        
        System.out.println("\n--- Bicicleta 1 ---");
        bicicletas[0] = new Bicicletados(14, 2, 5); 
        bicicletas[0].ejecutarRutina(28, 1, 1);

        System.out.println("\n--- Bicicleta 2 ---");
        bicicletas[1] = new Bicicletados(10, 3, 3);
        bicicletas[1].ejecutarRutina(40, 1, 1);

        System.out.println("\n--- Bicicleta 3 ---");
        bicicletas[2] = new Bicicletados(14, 1, 2);
        bicicletas[2].ejecutarRutina(28, 2, 1);

        System.out.println("\n--- Bicicleta 4 ---");
        bicicletas[3] = new Bicicletados(14, 2, 4);
        bicicletas[3].ejecutarRutina(28, 3, 3);

        System.out.println("\n--- Bicicleta 5 ---");
        bicicletas[4] = new Bicicletados(14, 1, 1);
        bicicletas[4].ejecutarRutina(28, 3, 2);
    }
}