public class Peca {

    // Parametros/atributos dos objetos criados
    String cor;
    String tipo;
    int linha;
    int coluna;
    boolean jaMoveu = false;

    // Construtor dos objetos
    public Peca(String cor, String tipo, int linha, int coluna) {
        this.cor = cor;
        this.tipo = tipo;
        this.linha = linha;
        this.coluna = coluna;
    }

    // Pega o caracter do tipo da peça
    public String getSimbolo() {
        String simbolo = "";

        switch (tipo) {
            case "Rei":
                simbolo = "♚";
                break;
            case "Dama":
                simbolo = "♛";
                break;
            case "Torre":
                simbolo = "♜";
                break;
            case "Bispo":
                simbolo = "♝";
                break;
            case "Cavalo":
                simbolo = "♞";
                break;
            case "Peao":
                simbolo = "♟";
                break;
        }

        if (cor.equals("Branco")) {
            return "\u001B[97m" + simbolo + "\u001B[39m";
        } else {
            return "\u001B[30m" + simbolo + "\u001B[39m";
        }
    }
}
