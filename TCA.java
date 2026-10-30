import java.util.*;

public class TCA {

    
}

class tabuleiro{
    static char[][] tabuleiro = new char[8][8];
    public static void inicializarTabuleiro(){
        char[] pecas = new char[]{'T', 'C', 'B', 'D', 'R', 'B', 'C', 'T'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        for (int i = 0; i < pecas.length; i++) {
            tabuleiro[0][i] = Character.toLowerCase(pecas[i]);
        }
        for (int i = 0; i < 8; i++) {
                tabuleiro[1][i] = 'p';
        }
        for (int i = 0; i < pecas.length; i++) {
            tabuleiro[6][i] = 'P';
        }
        for (int i = 0; i < pecas.length; i++) {
                tabuleiro[7][i] = pecas[i];
        }
    }

    public static void imprimirTabuleiro(){
        System.out.println("  a b c d e f g h");

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.println((8 - i) + " ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.print();
        }
    }
}


class movimento{

     //Metodos de verificação de movimento das peças
     
    public static boolean verificarMovimentoPeao(){
        return true;
    }
}