import java.util.Scanner;
public class Jogo {
    static Scanner ler = new Scanner(System.in);

    // Validar posicação digitada
    public static boolean validarPosicao(String posicao) {
        if (posicao.length() != 2) {
            return false;
        }

        char coluna = Character.toLowerCase(posicao.charAt(0));
        char linha = posicao.charAt(1);

        if (coluna < 'a' || coluna > 'h') {
            return false;
        }

        if (linha < '1' || linha > '8') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Tabuleiro.inicializarTabuleiro();
        Tabuleiro.imprimirTabuleiro();
        String turnoAtual = "Branco";
        while (true) {
            System.out.println("Turno: " + turnoAtual);
            // Lendo a posição de origem
            System.out.print("Posição de origem: ");
            String posicaoI = ler.nextLine();
            if (validarPosicao(posicaoI) == false) {
                System.out.println("Posição inválida!");
                continue;
            }
            char colunai = Character.toLowerCase(posicaoI.charAt(0));
            int linhai = posicaoI.charAt(1) - '0';

            // Lendo a posição de destino
            System.out.print("Posição de destino: ");
            String posicaoF = ler.nextLine();
            if (validarPosicao(posicaoF) == false) {
                System.out.println("Posição inválida!");
                continue;
            }
            char colunaf = Character.toLowerCase(posicaoF.charAt(0));
            int linhaf = posicaoF.charAt(1) - '0';

            Peca peca = Tabuleiro.buscarPeca(colunai, linhai);
            if (peca == null) {
                System.out.println("Não existe peça nessa posição!");
                continue;
            }
            if (peca.cor.equals(turnoAtual) == false && peca != null) {
                System.out.println("Está peça não é sua");
                continue;
            }

            String corAdversario;
            if (peca.cor.equals("Branco")) {
                corAdversario = "Preto";
            } else {
                corAdversario = "Branco";
            }
            if (Tabuleiro.moverPeca(colunai, colunaf, linhai, linhaf) == true) {
                Tabuleiro.imprimirTabuleiro();
                if (turnoAtual.equals("Branco")) {
                    turnoAtual = "Preto";
                } else {
                    turnoAtual = "Branco";
                }
                if (Movimentos.verificarXeque(corAdversario) == true) {
                    if (Movimentos.verificarXequeMate(corAdversario) == true) {
                        System.out.println("XEQUE-MATE!");
                        System.out.println("Vitória das: " + turnoAtual);
                        break;
                    } else {
                        System.out.println("XEQUE!");
                    }
                }
            }
        }
    }
}