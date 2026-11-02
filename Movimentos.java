public class Movimentos {
    public static boolean verificarPeao(char colunai, char colunaf, int linhai, int linhaf) {
        Peca peao = Tabuleiro.buscarPeca(colunai, linhai);
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

        if ((peao.cor.equals("Branco") && (linhaf < linhai) && (colunaf == colunai) && (Math.abs(linhaf - linhai) == 1 || ((peao.jaMoveu == false) && Math.abs(linhaf - linhai) == 2) && Tabuleiro.tabuleiro[linhaIntermediaria][colunai] == null) && Tabuleiro.tabuleiro[linhaf][colunaf] == null) || (peao.cor.equals("Branco") && (linhaf < linhai) && (Math.abs(colunaf - colunai)) == 1 && (Math.abs(linhaf - linhai) == 1) && Tabuleiro.tabuleiro[linhaf][colunaf] != null && !Tabuleiro.tabuleiro[linhaf][colunaf].cor.equals(peao.cor))) {
            return true;
        } else if ((peao.cor.equals("Preto") && (linhaf > linhai) && (colunaf == colunai) && (Math.abs(linhaf - linhai) == 1 || ((peao.jaMoveu == false) && Math.abs(linhaf - linhai) == 2) && Tabuleiro.tabuleiro[linhaIntermediaria][colunai] == null) && Tabuleiro.tabuleiro[linhaf][colunaf] == null) || (peao.cor.equals("Preto") && (linhaf > linhai) && (Math.abs(colunaf - colunai)) == 1 && (Math.abs(linhaf - linhai) == 1) && Tabuleiro.tabuleiro[linhaf][colunaf] != null && !Tabuleiro.tabuleiro[linhaf][colunaf].cor.equals(peao.cor))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verificarTorre(char colunai, char colunaf, int linhai, int linhaf) {
        Peca torre = Tabuleiro.buscarPeca(colunai, linhai);
        if (torre == null) {
            return false;
        }
        colunaf = Character.toLowerCase(colunaf);
        colunai = Character.toLowerCase(colunai);
        colunaf -= 'a';
        colunai -= 'a';
        linhaf = 8 - linhaf;
        linhai = 8 - linhai;
        Peca destino = Tabuleiro.tabuleiro[linhaf][colunaf];

        if (linhai != linhaf && colunai != colunaf || linhai == linhaf && colunai == colunaf) {
            return false;
        }
        if (destino != null && destino.cor.equals(torre.cor)) {
            return false;
        }
        if (linhai > linhaf) {
            for (int i = linhai - 1; i > linhaf; i--) {
                if (Tabuleiro.tabuleiro[i][colunai] != null) {
                    return false;
                }
            }
            return true;
        } else if (linhai < linhaf) {
            for (int i = linhai + 1; i < linhaf; i++) {
                if (Tabuleiro.tabuleiro[i][colunai] != null) {
                    return false;
                }
            }
            return true;
        } else if (colunai > colunaf) {
            for (int i = colunai - 1; i > colunaf; i--) {
                if (Tabuleiro.tabuleiro[linhai][i] != null) {
                    return false;
                }
            }
            return true;
        } else if (colunai < colunaf) {
            for (int i = colunai + 1; i < colunaf; i++) {
                if (Tabuleiro.tabuleiro[linhai][i] != null) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean verificarCavalo(char colunai, char colunaf, int linhai, int linhaf) {
        Peca cavalo = Tabuleiro.buscarPeca(colunai, linhai);
        if (cavalo == null) {
            return false;
        }
        colunaf = Character.toLowerCase(colunaf);
        colunai = Character.toLowerCase(colunai);
        colunaf -= 'a';
        colunai -= 'a';
        linhaf = 8 - linhaf;
        linhai = 8 - linhai;
        Peca destino = Tabuleiro.tabuleiro[linhaf][colunaf];

        if (destino != null && destino.cor.equals(cavalo.cor)) {
            return false;
        }
        if ((Math.abs(linhai - linhaf) == 2 && Math.abs(colunai - colunaf) == 1) ||
                (Math.abs(linhai - linhaf) == 1 && Math.abs(colunai - colunaf) == 2)) {

            return true;
        } else {
            return false;
        }
    }
    public static boolean verificarBispo(char colunai, char colunaf, int linhai, int linhaf){
        Peca bispo = Tabuleiro.buscarPeca(colunai, linhai);
        if (bispo == null) {
            return false;
        }
        colunaf = Character.toLowerCase(colunaf);
        colunai = Character.toLowerCase(colunai);
        colunaf -= 'a';
        colunai -= 'a';
        linhaf = 8 - linhaf;
        linhai = 8 - linhai;
        int auxlinha = linhai;
        int auxColuna = colunai;
        Peca destino = Tabuleiro.tabuleiro[linhaf][colunaf];

        if (destino != null && destino.cor.equals(bispo.cor)) {
            return false;
        }
        if (Math.abs(linhai - linhaf) != Math.abs(colunai - colunaf) || linhai == linhaf && colunai == colunaf) {
            return false;
        }
        if (linhai > linhaf && colunai < colunaf) {
            auxlinha --;
            auxColuna ++;
            for (int i = linhai - 1; i > linhaf; i--) {
                if (Tabuleiro.tabuleiro[auxlinha][auxColuna] != null) {
                    return false;
                }
                auxlinha --;
                auxColuna ++;
            }
            return true;
        } else if (linhai < linhaf && colunai < colunaf) {
            auxlinha ++;
            auxColuna ++;
            for (int i = linhai + 1; i < linhaf; i++) {
                if (Tabuleiro.tabuleiro[auxlinha][auxColuna] != null) {
                    return false;
                }
                auxlinha ++;
                auxColuna ++;
            }
            return true;
        } else if (colunai > colunaf && linhai < linhaf) {
            auxlinha ++;
            auxColuna --;
            for (int i = colunai - 1; i > colunaf; i--) {
                if (Tabuleiro.tabuleiro[auxlinha][auxColuna] != null) {
                    return false;
                }
                auxlinha ++;
                auxColuna --;
            }
            return true;
        } else if (linhai > linhaf && colunai > colunaf) {
            auxlinha --;
            auxColuna --;
            for (int i = linhai - 1; i > linhaf; i--) {
                if (Tabuleiro.tabuleiro[auxlinha][auxColuna] != null) {
                    return false;
                }
                auxlinha --;
                auxColuna --;
            }
            return true;
        } else {
            return false;
        }
    }
    public static boolean verificarDama(char colunai, char colunaf, int linhai, int linhaf){
        Peca dama = Tabuleiro.buscarPeca(colunai, linhai);
        if (dama == null) {
            return false;
        }
        if (verificarTorre(colunai, colunaf, linhai, linhaf) == true || verificarBispo(colunai, colunaf, linhai, linhaf) == true) {
            return  true;
        } else {
            return false;
        }
    }
    public static boolean verificarRei(char colunai, char colunaf, int linhai, int linhaf){
        Peca rei = Tabuleiro.buscarPeca(colunai, linhai);
        if (rei == null) {
            return false;
        }
        char auxcolunaf = Character.toLowerCase(colunaf);
        char auxcolunai = Character.toLowerCase(colunai);
        auxcolunaf -= 'a';
        auxcolunai -= 'a';
        int auxlinhaf = 8 - linhaf;
        int auxlinhai = 8 - linhai;
        if (Math.abs(auxlinhai - auxlinhaf) > 1 || Math.abs(auxcolunai - auxcolunaf) > 1 || (Math.abs(auxlinhai - auxlinhaf) == 0) && Math.abs(auxcolunai - auxcolunaf) == 0){
            return false;
        }
        if (verificarDama(colunai, colunaf, linhai, linhaf)) {
            return  true;
        } else {
            return false;
        }
    }

    public static boolean verificarXeque(String cor){
        Peca rei = null;
        String corInimigo;

        for (int i = 0; i < Tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro.tabuleiro[i].length; j++) {
                if (Tabuleiro.tabuleiro[i][j] != null && Tabuleiro.tabuleiro[i][j].tipo.equals("Rei") && Tabuleiro.tabuleiro[i][j].cor.equals(cor)) {
                    rei = Tabuleiro.tabuleiro[i][j];
                }
            }
        }
        if (rei == null) {
            return false;
        }
        if (rei.cor.equals("Branco")) {
            corInimigo = "Preto";
        } else {
            corInimigo = "Branco";
        }

        for (int i = 0; i < Tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro.tabuleiro[i].length; j++) {
                if ( Tabuleiro.tabuleiro[i][j] != null && Tabuleiro.tabuleiro[i][j].cor.equals(corInimigo)) {
                    Peca peca = Tabuleiro.tabuleiro[i][j];
                    if (verificarAtaque(peca, rei.linha, rei.coluna) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Metodo Auxiliar
    public static boolean verificarAtaque(Peca peca, int linhaRei, int colunaRei){
        char colunaP = (char)(peca.coluna + 'a');
        int linhaP = 8 - peca.linha;
        char colunaReiC = (char) (colunaRei + 'a');
        int linhaReiN = 8 - linhaRei;
        switch (peca.tipo) {
            case "Peao":
                    if ((peca.cor.equals("Branco") && (linhaRei < peca.linha) && (Math.abs(colunaRei - peca.coluna)) == 1 && (Math.abs(linhaRei - peca.linha) == 1))) {
                        return true;
                    } else if ((peca.cor.equals("Preto") && (linhaRei > peca.linha) && (Math.abs(colunaRei - peca.coluna)) == 1 && (Math.abs(linhaRei - peca.linha) == 1))) {
                        return true;
                    } else {
                        return false;
                    }
            case "Torre":
                if (verificarTorre(colunaP, colunaReiC, linhaP, linhaReiN) == true) {
                    return true;
                } else {
                    return false;
                }
            case "Cavalo":
                if (verificarCavalo(colunaP, colunaReiC, linhaP, linhaReiN)) {
                    return true;
                } else { 
                    return false;
                }
            case "Bispo":
                if (verificarBispo(colunaP, colunaReiC, linhaP, linhaReiN)) {
                    return true;
                } else { 
                    return false;
                }
            case "Dama":
                if (verificarDama(colunaP, colunaReiC, linhaP, linhaReiN)) {
                    return true;
                } else { 
                    return false;
                }
            case "Rei":
                if (verificarRei(colunaP, colunaReiC, linhaP, linhaReiN)) {
                    return true;
                } else { 
                    return false;
                }
            default:
                return false;
        }
    }

    public static boolean verificarXequeMate(String cor){
        // Confere um possivel afogamento
        if (verificarXeque(cor) == false) {
            return false;
        }
        // Percorre o tabuleiro procurando peças da cor desejada
        for (int i = 0; i < Tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < Tabuleiro.tabuleiro[i].length; j++) {
                if (Tabuleiro.tabuleiro[i][j] != null &&
                    Tabuleiro.tabuleiro[i][j].cor.equals(cor)) {
                    // Testa todas as casas como possíveis destinos para a peça encontrada
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            if (testarSaidaDoMate(Tabuleiro.tabuleiro[i][j], x, y)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    // Metodo Auxiliar
    public static boolean testarSaidaDoMate(Peca peca, int linhaDestino, int colunaDestino){
        // Antes de qualquer coisa testa se o movimento é valido
        if (verificarMovimento(peca, linhaDestino, colunaDestino) == false) {
            return false;
        }
        Peca destino = Tabuleiro.tabuleiro[linhaDestino][colunaDestino];
        int linhaAntiga = peca.linha;
        int colunaAntiga = peca.coluna;
        boolean jaMoveuAntigo = peca.jaMoveu;
        // Simulando o movimento    
        Tabuleiro.tabuleiro[linhaDestino][colunaDestino] = peca;
        Tabuleiro.tabuleiro[linhaAntiga][colunaAntiga] = null;
        peca.linha = linhaDestino;
        peca.coluna = colunaDestino;
        peca.jaMoveu = true;
        boolean xequeSimOuNao = verificarXeque(peca.cor);
        // Voltando pras posições iniciais
        Tabuleiro.tabuleiro[linhaAntiga][colunaAntiga] = peca;
        Tabuleiro.tabuleiro[linhaDestino][colunaDestino] = destino;
        peca.linha = linhaAntiga;
        peca.coluna = colunaAntiga; 
        peca.jaMoveu = jaMoveuAntigo;

        if (xequeSimOuNao == false) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo Auxiliar
    public static boolean verificarMovimento(Peca peca, int linhaDestino, int colunaDestino){
        char colunai = (char) (peca.coluna + 'a');
        int linhai = 8 - peca.linha;
        char colunaf = (char) (colunaDestino + 'a');
        int linhaf = 8 - linhaDestino;
        switch (peca.tipo) {
            case "Peao":
                if (verificarPeao(colunai, colunaf, linhai, linhaf) == true) {
                    return true;
                } else {
                    return false;
                }
            case "Torre":
                if (verificarTorre(colunai, colunaf, linhai, linhaf) == true) {
                    return true;
                } else {
                    return false;
                }
            case "Cavalo":
                if (verificarCavalo(colunai, colunaf, linhai, linhaf) == true) {
                    return true;
                } else {
                    return false;
                }
            case "Bispo":
                if (verificarBispo(colunai, colunaf, linhai, linhaf) == true) {
                    return true;
                } else {
                    return false;
                }
            case "Dama":
                if (verificarDama(colunai, colunaf, linhai, linhaf) == true) {
                    return true;
                } else {
                    return false;
                }
            case "Rei":
                if (verificarRei(colunai, colunaf, linhai, linhaf) == true) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}