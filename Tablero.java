import java.util.*;

public class Tablero {
    private Ficha[][] fichas;
    private int tamaño;

    public Tablero(int tamaño, String[] simbolos) {
        this.tamaño = tamaño;
        this.fichas = new Ficha[tamaño][tamaño];
        inicializar(simbolos);
    }

    //añade los simbolos al tablero de forma aleatoria
    private void inicializar(String[] simbolos) {
        List<String> lista = new ArrayList<>();
        for (String simbolo : simbolos) {
            lista.add(simbolo);
            lista.add(simbolo);
        }
        Collections.shuffle(lista);

        int index = 0;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                fichas[i][j] = new Ficha(lista.get(index++));
            }
        }
    }

    public boolean coordenadaValida(int x, int y) {
        return x >= 0 && x < tamaño && y >= 0 && y < tamaño;
    }

    public Ficha getFicha(int x, int y) {
        return fichas[x][y];
    }

    public String getEstadoTablero() {
        StringBuilder sb = new StringBuilder();
        sb.append(" 1 2 3 4 \n");
        for (int i = 0; i < tamaño; i++) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < tamaño; j++) {
                sb.append(fichas[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getEstadoTableroConSeleccion(int x1, int y1) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int col = 1; col <= tamaño; col++) {
            sb.append(col).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < tamaño; i++) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < tamaño; j++) {
                Ficha f = fichas[i][j];
                if (f.isEmparejada() || (i == x1 && j == y1)) {
                    sb.append(f.getSimbolo()).append(" ");
                } else {
                    sb.append("■ ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getEstadoTableroConDosSelecciones(int x1, int y1, int x2, int y2) {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int col = 1; col <= tamaño; col++) {
            sb.append(col).append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < tamaño; i++) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < tamaño; j++) {
                Ficha f = fichas[i][j];
                if (f.isEmparejada() || (i == x1 && j == y1) || (i == x2 && j == y2)) {
                    sb.append(f.getSimbolo()).append(" ");
                } else {
                    sb.append("■ ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    public boolean todasEmparejadas() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (!fichas[i][j].isEmparejada()) return false;
            }
        }
        return true;
    }
}
