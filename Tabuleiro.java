public class Tabuleiro {

    static Peca[][] tabuleiro = new Peca[8][8];

    public static void inicializarTabuleiro() {
        // Torres Pretas
        tabuleiro[0][0] = new Peca("Preto", "Torre", 0, 0);
        tabuleiro[0][7] = new Peca("Preto", "Torre", 0, 7);
        // Cavalos Pretos
        tabuleiro[0][1] = new Peca("Preto", "Cavalo", 0, 1);
        tabuleiro[0][6] = new Peca("Preto", "Cavalo", 0, 6);
        // Bispos Pretos
        tabuleiro[0][2] = new Peca("Preto", "Bispo", 0, 2);
        tabuleiro[0][5] = new Peca("Preto", "Bispo", 0, 5);
        // Rei Preto
        tabuleiro[0][4] = new Peca("Preto", "Rei", 0, 4);
        // Dama Preta
        tabuleiro[0][3] = new Peca("Preto", "Dama", 0, 3);

        // Torres Brancas
        tabuleiro[7][0] = new Peca("Branco", "Torre", 7, 0);
        tabuleiro[7][7] = new Peca("Branco", "Torre", 7, 7);
        // Cavlos Brancos
        tabuleiro[7][1] = new Peca("Branco", "Cavalo", 7, 1);
        tabuleiro[7][6] = new Peca("Branco", "Cavalo", 7, 6);
        // Bispos Brancos
        tabuleiro[7][2] = new Peca("Branco", "Bispo", 7, 2);
        tabuleiro[7][5] = new Peca("Branco", "Bispo", 7, 5);
        // Rei Branco
        tabuleiro[7][4] = new Peca("Branco", "Rei", 7, 4);
        // Dama Branca
        tabuleiro[7][3] = new Peca("Branco", "Dama", 7, 3);

        // Peões
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[1][i] = new Peca("Preto", "Peao", 1, i);
            tabuleiro[6][i] = new Peca("Branco", "Peao", 6, i);
        }
    }

    public static void imprimirTabuleiro() {
        System.out.println("  A B C D E F G H");

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(tabuleiro[i][j].getSimbolo() + " ");
                }
            }
            System.out.println();
        }
    }

    public static Peca buscarPeca(char coluna, int linha) {
        // As linhas a seguir são feitas para que a notação do xadrez seja convertida em llinhas da matriz
        coluna = Character.toLowerCase(coluna);
        coluna -= 'a';
        linha = 8 - linha;

        return tabuleiro[linha][coluna];
    }

    public static boolean moverPeca(char colunai, char colunaf, int linhai, int linhaf) {
        colunaf = Character.toLowerCase(colunaf);
        colunai = Character.toLowerCase(colunai);
        Peca peca = buscarPeca(colunai, linhai);
        if (peca == null) {
            System.out.println("Não existe peça nesta posicão");
            return false;
        }
        // Verificação de movimentação das peças
        switch (peca.tipo) {
            case "Peao":
                if (Movimentos.verificarPeao(colunai, colunaf, linhai, linhaf) == false) {
                    System.out.println("Movimento inválido");
                    return false;
                }
                break;
            case "Torre":
                if (Movimentos.verificarTorre(colunai, colunaf, linhai, linhaf) == false) {
                    System.out.println("Movimento inválido");
                    return false;
                }
                break;
            case "Cavalo":
                    if (Movimentos.verificarCavalo(colunai, colunaf, linhai, linhaf) == false) {
                        System.out.println("Movimento inválido");
                        return false;
                    }
                    break;
            case "Bispo":
                if (Movimentos.verificarBispo(colunai, colunaf, linhai, linhaf) == false) {
                    System.out.println("Movimento inválido");
                    return false;
                    }
                    break;
            case "Dama":
                if (Movimentos.verificarDama(colunai, colunaf, linhai, linhaf) == false) {
                    System.out.println("Movimento inválido");
                    return false;
                    }
                    break;
            case "Rei":
                if (Movimentos.verificarRei(colunai, colunaf, linhai, linhaf) == false) {
                    System.out.println("Movimento inválido");
                    return false;
                }
                break;
            default:
                System.out.println("Tipo de peça desconhecido");
                return false;
        }
        Peca destino = buscarPeca(colunaf, linhaf);
        if (destino != null && peca.cor.equals(destino.cor)) {
            System.out.println("Movimento inválido");
            return false;
        }
        colunaf -= 'a';
        colunai -= 'a';
        linhaf = 8 - linhaf;
        linhai = 8 - linhai;
        // Simulação do movimento pra verificar um possível xeque
        int linhaAntiga = peca.linha;
        int colunaAntiga = peca.coluna;
        boolean jaMoveuAntigo = peca.jaMoveu;
        tabuleiro[linhai][colunai] = null;
        tabuleiro[linhaf][colunaf] = peca;
        peca.linha = linhaf;
        peca.coluna = colunaf;
        peca.jaMoveu = true;
        // Se der xeque o movimento é desfeito
        if (Movimentos.verificarXeque(peca.cor) == true){
            tabuleiro[linhai][colunai] = peca;
            tabuleiro[linhaf][colunaf] = destino;
            peca.linha = linhaAntiga;
            peca.coluna = colunaAntiga;
            peca.jaMoveu = jaMoveuAntigo;
            System.out.println("Seu Rei ficará em xeque");
            return false;
        }
        return true;
    }
}