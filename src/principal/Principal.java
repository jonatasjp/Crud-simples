package principal;

import java.util.Scanner;

import dao.PessoaDAO;
import model.Pessoa;

public class Principal {

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {

		System.out.println("informe o menu que deseja acessar");
		System.out.println("1 - inserir pessoa");
		System.out.println("2 - atualizar pessoa");
		System.out.println("3 - remover pessoa");
		System.out.println("4 - listar pessoa");
		System.out.println("5 - encerrar aplicação");

		Scanner scan = new Scanner(System.in);

		int i = scan.nextInt();
		scan.nextLine();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		switch (i) {

		case 1:
			System.out.println("Informe o nome da pessoa");
			String nome = scan.nextLine();
			System.out.println("Informe o CPF da pessoa");
			String cpf = scan.nextLine();

			pessoaDAO.inserir(new Pessoa(nome, cpf));
			menu();
			break;

		case 2:
			System.out.println("informe o ID da pessoa que deseja atualizar");
			Long id = scan.nextLong();
			scan.nextLine();
			System.out.println("informe o nome a ser modificado");
			String nome1 = scan.nextLine();
			System.out.println("informe o cpf a ser modificado");
			String cpf1 = scan.nextLine();

			pessoa.setNome(nome1);
			pessoa.setCpf(cpf1);
			pessoa.setId(id);
			pessoaDAO.atualizar(pessoa);
			menu();
			break;

		case 3:
			System.out.println("informe o id da pessoa a ser excluida");
			Long id1 = scan.nextLong();
			scan.nextLine();
			pessoaDAO.remover(id1);
			menu();
			break;

		case 4:
			for (Pessoa p : pessoaDAO.buscarTodos()) {
				System.out.println(p);
			}
			menu();
			break;
		case 5:
			System.out.println("Fim");
			System.exit(0);

		default:
			System.out.println("Menu inválido, informe um menu válido.");
			menu();
		}

	}

}
