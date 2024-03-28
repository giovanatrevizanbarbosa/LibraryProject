package br.edu.ifsp.arq.tsi.deoo.view;

import java.util.Scanner;

import br.edu.ifsp.arq.tsi.deoo.controller.BookController;
import br.edu.ifsp.arq.tsi.deoo.controller.LoanController;
import br.edu.ifsp.arq.tsi.deoo.controller.UserController;

public class Console {
    
    Scanner scanner = new Scanner(System.in);

    private BookController bookController;
    private LoanController loanController;
    private UserController userController;

    public Console() {
        this.bookController = new BookController();
        this.loanController = new LoanController();
        this.userController = new UserController();
    }

    public void run() {
        MenuOption option;
        bookController.load();

        do {
            option = Menu.menu();

            switch (option) {
                case CADASTRAR_LIVRO:
                    System.out.println(">>> Cadastro de Livro <<<");
                    System.out.println("Digite o título: ");
                    String title = scanner.nextLine();

                    System.out.println("Digite o autor: ");
                    String author = scanner.nextLine();

                    System.out.println("Digite a edição: ");
                    String edition = scanner.nextLine();

                    if (bookController.registerBook()) {
                        System.out.println("\nLivro salvo com sucesso.\n");
                    } else {
                        System.out.println("\nErro ao cadastrar livro.\n");
                    }
                    break;
                case CADASTRAR_USUARIO:
                    System.out.println(">>> Cadastro de Usuário <<<");
                    System.out.println("Digite o nome: ");
                    String name = scanner.nextLine();

                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();

                    System.out.println("Digite o número do celular: ");
                    String phoneNumber = scanner.nextLine();

                    if (userController.registerUser()) {
                        System.out.println("\nUsuário salvo com sucesso.\n");
                    } else {
                        System.out.println("\nErro ao cadastrar usuário.\n");
                    }
                    break;
                case EMPRESTAR:
                    System.out.println(">>> Empréstimo <<<");
                    userController.allUsers();
                    System.out.println("Digite o id do usuário: ");
                    String username = scanner.nextLine();

                    bookController.allBooks();
                    System.out.println("Digite o id do livro: ");
                    String bookId = scanner.nextLine();

                    System.out.println("Digite o título do livro: ");
                    String bookTitle = scanner.nextLine();

                    if (loanController.createLoan()) {
                        System.out.println("\nEmpréstimo realizado com sucesso.\n");
                    } else {
                        System.out.println("\nErro ao realizar empréstimo.\n");
                    }
                    break;
                case RELATORIO_LIVROS_DA_BIBLIOTECA:
                    System.out.println(">>> Relatório de Livros da Biblioteca <<<");
                    bookController.allBooks();
                    break;
                case RELATORIO_LIVROS_EMPRESTADOS:
                    System.out.println(">>> Relatório de Livros Emprestados <<<");
                    bookController.lentBooks();
                    break;
                case RELATORIO_EMPRESTIMOS_ATRASADOS:
                    System.out.println(">>> Relatório de Empréstimos Atrasados <<<");
                    loanController.lateLoans();
                    break;
                case RELATORIO_USUARIOS_COM_LIVROS_EMPRESTADOS:
                    System.out.println(">>> Relatório de Usuários com Livros Emprestados <<<");
                    userController.usersWithLentBooks();
                    break;
                case RELATORIO_USUARIOS_COM_PENALIDADES:
                    System.out.println(">>> Relatório de Usuários com Penalidades <<<");
                    userController.usersServingPenalties(); 
                    break;
                default:
                    break;
            }
        } while (option != MenuOption.SAIR);
    }
}
