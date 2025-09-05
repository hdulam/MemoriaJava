public class Juego {
    private Jugador[] jugadores;
    private int turnoActual;
    private Tablero tablero;

    public Juego(String nombre1, String nombre2, int tamaño, String[] simbolos) {
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador(nombre1);
        jugadores[1] = new Jugador(nombre2);
        turnoActual = 0;
        tablero = new Tablero(tamaño, simbolos);
    }

    public Ficha getFicha(int x, int y){
        return tablero.getFicha(x, y);
    }

    public Jugador getJugadorActual() {
        return jugadores[turnoActual];
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean jugarTurno(int x1, int y1, int x2, int y2) {
        if (!tablero.coordenadaValida(x1, y1) || !tablero.coordenadaValida(x2, y2)) {
            return false;
        }
        if (x1 == x2 && y1 == y2) {
            return false; // misma casilla
        }

        Ficha f1 = tablero.getFicha(x1, y1);
        Ficha f2 = tablero.getFicha(x2, y2);

        if (f1.isEmparejada() || f2.isEmparejada()) {
            return false;
        }

        f1.mostrar();
        f2.mostrar();

        if (f1.esIgual(f2)) {
            f1.marcarEmparejada();
            f2.marcarEmparejada();
            getJugadorActual().sumarPunto();
            return true; // conserva turno
        } else {
            f1.ocultar();
            f2.ocultar();
            cambiarTurno();
            return false;
        }
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual + 1) % 2;
    }

    public boolean terminado() {
        return tablero.todasEmparejadas();
    }

    public Jugador determinarGanador() {
        if (jugadores[0].getPuntaje() > jugadores[1].getPuntaje()) return jugadores[0];
        if (jugadores[1].getPuntaje() > jugadores[0].getPuntaje()) return jugadores[1];
        return null; // empate
    }

    public String getEstadoTablero() {
        return tablero.getEstadoTablero();
    }   
    public String getEstadoTableroConSeleccion(int x1, int y1) {
        return tablero.getEstadoTableroConSeleccion(x1, y1);
    }
    public String getEstadoTableroConDosSelecciones(int x1, int y1, int x2, int y2) {
        return tablero.getEstadoTableroConDosSelecciones(x1, y1, x2, y2);
    }
}
