import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //pide los nomrbes y crea el juego
        System.out.print("Nombre del jugador 1: ");
        String j1 = sc.nextLine();
        System.out.print("Nombre del jugador 2: ");
        String j2 = sc.nextLine();
        String[] simbolos = {"😀","🐶","🍎","🚗","🌟","🎵","⚽","📚"};
        Juego juego = new Juego(j1, j2, 4, simbolos);

        //loop que maneja el juego siempre y cuando no haya terminado
        while (!juego.terminado()) {
            System.out.println("\nTablero:");
            System.out.println(juego.getEstadoTablero());

            Jugador actual = juego.getJugadorActual();
            System.out.println("Turno de " + actual.getNombre());
            
            //pide coordenada, y muesrta el tablero con la ficha seleccionada, igual con la segunda, el for es para limpiar la terminal
            System.out.print("Fila 1: ");
            int x1 = (sc.nextInt()-1);
            System.out.print("Columna 1: ");
            int y1 = (sc.nextInt()-1);
            for(int i = 0; i < 20; i++){ System.out.println(); }
            System.out.println("Tablero actual: \n " + juego.getEstadoTableroConSeleccion(x1, y1));
            System.out.print("Fila 2: ");
            int x2 = (sc.nextInt()-1);
            System.out.print("Columna 2: ");
            int y2 = (sc.nextInt()-1);
            for(int i = 0; i < 20; i++){ System.out.println(); }
            System.out.println("Tablero actual: \n " + juego.getEstadoTableroConDosSelecciones(x1, y1, x2, y2));

            //revisa el acierto y muestra resultado
            boolean acierto = juego.jugarTurno(x1, y1, x2, y2);
            if (acierto) {
                System.out.println("¡Par encontrado! Punto para " + actual.getNombre());
            } else {
                System.out.println("No coinciden, turno del otro jugador.");
            }
            System.out.println("Presiona Enter para continuar...");
            sc.nextLine();
            sc.nextLine();
            for(int i = 0; i < 20; i++){ System.out.println(); }
        }

        Jugador ganador = juego.determinarGanador();
        System.out.println("\nJuego terminado.");
        if (ganador != null) {
            System.out.println("Ganó " + ganador.getNombre() + " con " + ganador.getPuntaje() + " puntos.");
        } else {
            System.out.println("¡Es un empate!");
        }

        sc.close();
    }
}
