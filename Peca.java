public class Peca {

    // Parametros/atributos dos objetos criados
    String cor;
    String tipo;
    int linha;
    int coluna;
    boolean jaMoveu = false;

    // Construtor dos objetos
    public Peca(String cor, String tipo, int linha,int coluna){
        this.cor = cor;
        this.tipo = tipo;
        this.linha = linha;
        this.coluna = coluna;
    }

    //Pega o caracter do tipo da peça
    public char getSimbolo(){
        char simbolo;

        switch (tipo) {
            case "Peao":
                simbolo = 'P';
                break;
            case "Torre":
                simbolo = 'T';
                break;
            case "Cavalo":
                simbolo = 'C';
                break;
            case "Bispo":
                simbolo = 'B';
                break;
            case "Rei":
                simbolo = 'R';
                break;
            case "Dama":
                simbolo = 'D';
                break;
            default:
                simbolo = '?';
                break;
            }
            if (cor.equals("Preto")){
                simbolo = Character.toLowerCase(simbolo);
            }
            return simbolo;
    }
}