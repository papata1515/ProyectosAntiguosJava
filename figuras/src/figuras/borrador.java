package figuras;

public class borrador {
	public class Bicicleta {

	    private int velocidadActual;
	    private int platoActual;
	    private int piñonActual;

	    // Constructor 1: Recibe velocidad, pero asegura que plato y piñón sean 1
	    public Bicicleta(int velocidadActual) {
	        this.velocidadActual = velocidadActual;
	        this.platoActual = 1;
	        this.piñonActual = 1;
	    }

	    // Constructor 2: Todo por defecto
	    public Bicicleta() {
	        this.velocidadActual = 0;
	        this.piñonActual = 1;
	        this.platoActual = 1;
	    }

	    public void acelerar() {
	        velocidadActual = velocidadActual * 2;
	    }

	    public void frenar() {
	        velocidadActual = velocidadActual / 2;
	    }

	    // --- CORRECCIÓN IMPORTANTE AQUÍ ---
	    public void cambiarPlato(int plato) {
	        // Asignamos a platoActual, NO a velocidadActual
	        this.platoActual = plato; 
	    }

	    public void cambiarPiñon(int piñon) {
	        // Asignamos a piñonActual, NO a velocidadActual
	        this.piñonActual = piñon;
	    }
	    
	    // Método extra para poder ver el estado de la bici en consola
	    public void imprimirEstado() {
	        System.out.println("Velocidad: " + velocidadActual + 
	                           " | Plato: " + platoActual + 
	                           " | Piñón: " + piñonActual);
	    }

	    public static void main(String[] args) {
	        
	        // CORRECCIÓN: Usamos valores reales (no existe plato 0)
	        int plato = 2; 
	        int piñon = 3;
	        
	        Bicicleta miBicicleta = new Bicicleta();
	        Bicicleta tuBicicleta = new Bicicleta(10); // Esta nace con velocidad 10
	        
	        // Modificamos miBicicleta
	        miBicicleta.cambiarPiñon(piñon);
	        miBicicleta.cambiarPlato(plato);
	        miBicicleta.acelerar(); // Aceleramos (0*2 sigue siendo 0, ojo)
	        
	        // Modificamos tuBicicleta
	        tuBicicleta.cambiarPiñon(5);
	        tuBicicleta.acelerar(); // 10 * 2 = 20

	        // Imprimimos para ver los resultados
	        System.out.println("--- Mi Bicicleta ---");
	        miBicicleta.imprimirEstado();
	        
	        System.out.println("--- Tu Bicicleta ---");
	        tuBicicleta.imprimirEstado();
	    }
	}
