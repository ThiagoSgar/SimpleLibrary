package Application;

import Entities.Book;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Program {

	static Scanner sc = new Scanner(System.in);
	static List<Book> acervo = new ArrayList<>();

	public static void main(String[] args) {

		biblioteca();

		// voidmain
	}
	// voidmain

//	METODO BIBLIOTECA
	public static void biblioteca() {
		int laco = 0;
		while (laco == 0) {

			System.out.println("***************************************");
			System.out.println("* Bem vindo à Biblioteca Torsche!     *");
			System.out.println("***************************************");
			System.out.println("* N |____Oque desejas?___________|");
			System.out.println("* 1 |____Cadastrar Livros________|");
			System.out.println("* 2 |____Excluir Livros__________|");
			System.out.println("* 3 |____Consultar Acervo________|");
			System.out.println("* 4 |____Consultar por nome______|");
			System.out.println("* 5 |____Consultar por autor_____|");
			System.out.println("* 6 |____Sair____________________|");
			System.out.println("*   ***********************************");
			System.out.println("*                                     *");
			System.out.println("***************************************");
			System.out.println("Insira o Numero da operação desejada:");
			int N = sc.nextInt();

			switch (N) {
			
			case 1:
				// Cadastro livro
				System.out.println("Cadastro");
				cadastroLivro(acervo);
				break;

			case 2:
				// EXCLUIR LIVRO
				excluirLivro(acervo);
				break;

			case 3:
				// CONSULTAR ACERVO
				consultar(acervo);
				break;
				
			case 4:
				// CONSULTAR POR TITULO
				buscatitulo(acervo);
				break;
				
			case 5:
//					// CONSULTAR POR AUTOR
				buscaautor(acervo);
				break;
				
			case 6:
				// SAIR
				laco = 1;
				break;

			}
			System.out.println("Deseja voltar ao menu inicial? (S/N)");
			String resp = sc.next();
			if (resp.equals("S")) {
				laco = 0;
			} else {
				laco = 1;
			}
		}
		System.out.println("Foi um prazer atende-la(o), tenha um ótimo dia!");
	}

	// MÉTODO CADASTRAR
	public static void cadastroLivro(List<Book> acervo) {

		int laco1 = 0;
		while (laco1 == 0) {
			System.out.println("Title: ");
			String title = sc.next();
			System.out.println("Author: ");
			String author = sc.next();
			System.out.println("Pages: ");
			int pages = sc.nextInt();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			System.out.println("ID: ");
			int id = sc.nextInt();
			Book book = new Book(title, author, pages, price, id);
			acervo.add(book);
			System.out.println("Deseja Cadastrar outro livro? (S/N)");
			String resp1 = sc.next().toUpperCase();
			if (resp1.equals("S")) {
				laco1 = 0;
			} else {
				laco1 = 1;
			}
		}
	}

	// MÉTODO EXCLUIR
	public static void excluirLivro(List<Book> acervo) {
		System.out.println("Qual livro deseja excluir?");
		System.out.println("#1 Buscar por Nome");
		System.out.println("#2 Buscar por ID");

		int resp = sc.nextInt();
		if (resp == 1) {

			System.out.println("Digite o nome do livro que deseja excluir: ");
			String excLivroNome = sc.next();

			for( Book b: acervo) {
				if(b.getTitle().equals(excLivroNome)) {
					acervo.remove(b);
					System.out.println("'"+b.getTitle()+"' removido do acervo");
					break;
				}
				else {
					System.out.println("O livro não se encontra no acervo");
					break;
				}
			}
		}
		if (resp == 2) {
			System.out.println("Digite o ID do livro que deseja excluir: ");
			int excLivroId = sc.nextInt();

			for( Book b: acervo) {
				if(b.getId() == excLivroId) {
					acervo.remove(b);
					System.out.println("'"+b.getTitle()+"' removido do acervo");
					break;
				}
				else {
					System.out.println("O livro não se encontra no acervo");
					break;
				}
			}
		}
	}

	// MÉTODO BUSCAR TITULO
	public static void buscatitulo(List<Book> acervo) {
		String title;
		System.out.println("Digite o nome do Livro:");
		title = sc.next();
		for (int i = 0; i < acervo.size(); i++) {
			if (acervo.get(i).getTitle().toUpperCase().equals(title.toUpperCase())) {
				System.out.println("#" + acervo.get(i).getId() + " - " + acervo.get(i).getTitle() + " - "
						+ acervo.get(i).getAuthor());
				break;
			} else {
				System.out.println("Nenhum livro de " + title + " foi encontrado");
				break;
			}
		}
	}
	
	// MÉTODO BUSCAR AUTOR
	public static void buscaautor(List<Book> acervo) {
		String autor;
		System.out.println("Digite o nome do Autor:");
		autor = sc.next();
		System.out.println("Livros de " + autor + "disponiveis:");
		for (int i = 0; i < acervo.size(); i++) {
			if (acervo.get(i).getAuthor().toUpperCase().equals(autor.toUpperCase())) {
				System.out.println("#" + acervo.get(i).getId() + " - " + acervo.get(i).getTitle() + " - "
						+ acervo.get(i).getAuthor());
				break;
			} else {
				System.out.println("Nenhum livro de " + autor + " foi encontrado");
				break;
			}
		}
	}

	// MÉTODO CONSULTAR ACERVO
	public static void consultar(List<Book> acervo) {
		System.out.println("#ID - Title - Author  ");
		for (int i = 0; i < acervo.size(); i++) {
			System.out.println(
					"#" + acervo.get(i).getId() + " - " + acervo.get(i).getTitle() + " - " + acervo.get(i).getAuthor());
		}
	}
}
