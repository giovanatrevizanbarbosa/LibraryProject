package br.edu.ifsp.arq.tsi.deoo.view;

import java.util.Scanner;

public class Menu {
    private final static Scanner scanner = new Scanner(System.in);
    private final static String line = "*****************************";

    private Menu() { }

    public static MenuOption menu() {
        System.out.println(line);
        System.out.println("\n[1] - CADASTRAR LIVRO");
        System.out.println("[2] - CADASTRAR USUÁRIO");
        System.out.println("[3] - EMPRESTAR LIVRO");
        System.out.println("[4] - RELATÓRIO DE LIVROS DA BIBLIOTECA");
        System.out.println("[5] - RELATÓRIO DE LIVROS EMPRESTADOS");
        System.out.println("[6] - RELATÓRIO DE EMPRÉSTIMOS ATRASADOS");
        System.out.println("[7] - RELATÓRIO DE USUÁRIOS COM LIVROS EMPRESTADOS");
        System.out.println("[8] - RELATÓRIO DE USUÁRIOS COM PENALIDADES");

        System.out.println("[0] - Sair");
        System.out.print("ESCOLHA SUA OPÇÃO: ");

        return switch(scanner.nextInt()) {
            case 1 -> MenuOption.CADASTRAR_LIVRO;
            case 2 -> MenuOption.CADASTRAR_USUARIO;
            case 3 -> MenuOption.EMPRESTAR;
            case 4 -> MenuOption.RELATORIO_LIVROS_DA_BIBLIOTECA;
            case 5 -> MenuOption.RELATORIO_LIVROS_EMPRESTADOS;
            case 6 -> MenuOption.RELATORIO_EMPRESTIMOS_ATRASADOS;
            case 7 -> MenuOption.RELATORIO_USUARIOS_COM_LIVROS_EMPRESTADOS;
            case 8 -> MenuOption.RELATORIO_USUARIOS_COM_PENALIDADES;
            default -> MenuOption.SAIR;
        };
    }
}
