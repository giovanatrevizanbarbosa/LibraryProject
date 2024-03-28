package br.edu.ifsp.arq.tsi.deoo.view;

public enum MenuOption {
    SAIR(0),
    CADASTRAR_LIVRO(1),
    CADASTRAR_USUARIO(2),
    EMPRESTAR(3),
    RELATORIO_LIVROS_DA_BIBLIOTECA(4),
    RELATORIO_LIVROS_EMPRESTADOS(5),
    RELATORIO_EMPRESTIMOS_ATRASADOS(6),
    RELATORIO_USUARIOS_COM_LIVROS_EMPRESTADOS(7),
    RELATORIO_USUARIOS_COM_PENALIDADES(8);

    private final int value;

    MenuOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}