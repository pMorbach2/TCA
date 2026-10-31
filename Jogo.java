import java.util.Scanner;
public class Jogo {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        Tabuleiro.inicializarTabuleiro();
        Tabuleiro.imprimirTabuleiro();

        System.out.print("Coluna de origem: ");
        char colunai = ler.next().charAt(0);

        System.out.print("Linha de origem: ");
        int linhai = ler.nextInt();

        System.out.print("Coluna de destino: ");
        char colunaf = ler.next().charAt(0);

        System.out.print("Linha de destino: ");
        int linhaf = ler.nextInt();

        Tabuleiro.moverPeca(colunai, colunaf, linhai, linhaf);
        Tabuleiro.imprimirTabuleiro();
    }
}