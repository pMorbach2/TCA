public class Tabuleiro {

    static Peca[][] tabuleiro = new Peca[8][8];

    public static void inicializarTabuleiro(){
        //Torres Pretas
        tabuleiro[0][0] = new Peca("Preto", "Torre", 0, 0);
        tabuleiro[0][7] = new Peca("Preto", "Torre", 0, 7);
        //Cavalos Pretos
        tabuleiro[0][1] = new Peca("Preto", "Cavalo", 0, 1);
        tabuleiro[0][6] = new Peca("Preto", "Cavalo", 0, 6);
        //Bispos Pretos
        tabuleiro[0][2] = new Peca("Preto", "Bispo", 0, 2);
        tabuleiro[0][5] = new Peca("Preto", "Bispo", 0, 5);
        //Rei Preto
        tabuleiro[0][4] = new Peca("Preto", "Rei", 0, 4);
        //Dama Preta
        tabuleiro[0][3] = new Peca("Preto", "Dama", 0, 3);

        //Torres Brancas
        tabuleiro[7][0] = new Peca("Branco", "Torre", 7, 0);
        tabuleiro[7][7] = new Peca("Branco", "Torre", 7, 7);
        //Cavlos Brancos
        tabuleiro[7][1] = new Peca("Branco", "Cavalo", 7, 1);
        tabuleiro[7][6] = new Peca("Branco", "Cavalo", 7, 6);
        //Bispos Brancos
        tabuleiro[7][2] = new Peca("Branco", "Bispo", 7, 2);
        tabuleiro[7][5] = new Peca("Branco", "Bispo", 7, 5);
        //Rei Branco
        tabuleiro[7][4] = new Peca("Branco", "Rei", 7,4);
        //Dama Branca
        tabuleiro[7][3] = new Peca("Branco", "Dama", 7, 3);

        //Peões
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[1][i] = new Peca("Preto", "Peao", 1, i);
            tabuleiro[6][i] = new Peca("Branco", "Peao", 6, i);
        }
    }

    public static void imprimirTabuleiro(){
        System.out.println("  A B C D E F G H");

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == null) {
                    System.out.print(". " );
                } else {
                    System.out.print(tabuleiro[i][j].getSimbolo() + " ");
                }
            }
            System.out.println();
        }
    }

    public static Peca buscarPeca(char coluna, int linha){
        coluna = Character.toLowerCase(coluna);
        coluna -= 'a';
        linha = 8 - linha;
        
        return tabuleiro[linha][coluna];
    }

    public static void moverPeca(char colunai, char colunaf, int linhai, int linhaf){
        Peca peca = buscarPeca(colunai, linhai);
        if (peca == null) {
            System.out.println("Não existe peça nesta posicão");
            return;
        }
        switch (peca.tipo) {
            case "Peao":
                    if (verificarPeao(colunai, colunaf, linhai, linhaf) == false) {
                        System.out.println("Movimento inválido");
                        return;
                    }
                    break;
            default:
        }
        Peca destino = buscarPeca(colunaf, linhaf);
        if (destino != null && peca.cor.equals(destino.cor)) {
                System.out.println("Movimento inválido");
                return;
        }
        colunaf = Character.toLowerCase(colunaf);
        colunai = Character.toLowerCase(colunai);
        colunaf -= 'a';
        colunai -= 'a';
        linhaf = 8 - linhaf;
        linhai = 8 - linhai;

        tabuleiro[linhai][colunai] = null;
        tabuleiro[linhaf][colunaf] = peca;
        peca.linha = linhaf;
        peca.coluna = colunaf;
        peca.jaMoveu = true;
    }

    public static boolean verificarPeao(char colunai, char colunaf, int linhai, int linhaf){
        Peca peao = buscarPeca(colunai, linhai);
        if (peao == null) {
            return false;
        }
        colunaf = Character.toLowerCase(colunaf);
        colunai = Character.toLowerCase(colunai);
        colunaf -= 'a';
        colunai -= 'a';
        linhaf = 8 - linhaf;
        linhai = 8 - linhai;
        int linhaIntermediaria = (linhai + linhaf) / 2;

        if ((peao.cor.equals("Branco") && (linhaf < linhai) && (colunaf == colunai) && (Math.abs(linhaf - linhai) == 1 || ((peao.jaMoveu == false) && Math.abs(linhaf - linhai) == 2) && tabuleiro[linhaIntermediaria][colunai] == null) && tabuleiro[linhaf][colunaf] == null) || (peao.cor.equals("Branco") && (linhaf < linhai) && (Math.abs(colunaf - colunai)) == 1 && (Math.abs(linhaf - linhai) == 1) && tabuleiro[linhaf][colunaf] != null && !tabuleiro[linhaf][colunaf].cor.equals(peao.cor))) {
            return true;
        } else if ((peao.cor.equals("Preto") && (linhaf > linhai) && (colunaf == colunai) && (Math.abs(linhaf - linhai) == 1 || ((peao.jaMoveu == false) && Math.abs(linhaf - linhai) == 2) && tabuleiro[linhaIntermediaria][colunai] == null) && tabuleiro[linhaf][colunaf] == null)  || (peao.cor.equals("Preto") && (linhaf > linhai) && (Math.abs(colunaf - colunai)) == 1 && (Math.abs(linhaf - linhai) == 1) && tabuleiro[linhaf][colunaf] != null && !tabuleiro[linhaf][colunaf].cor.equals(peao.cor))) {
            return true;
        } else { 
            return false;
        }
    }
}