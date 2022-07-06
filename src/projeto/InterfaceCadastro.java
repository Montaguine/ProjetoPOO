package projeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class InterfaceCadastro {

	private static final Scanner INP = new Scanner(System.in);

	private static int linha() {
		System.out.println("Digite o indice desejado:\n");
		return INP.nextInt();
	}

	private static LocalDate data() {
		try {
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Digite o dia de nascimento da pessoa:\n");
			String dia = INP.next();
			System.out.println("Digite o mês de nascimento da pessoa:\n");
			String mes = INP.next();
			System.out.println("Digite o ano de nascimento da pessoa:\n");
			String ano = INP.next();
			return LocalDate.parse(dia + "/" + mes + "/" + ano, formater);
		} catch (DateTimeParseException e) {
			System.out.println(
					"Data inválida. \nTente dois dígitos para dia, dois dígitos para mês e quatro dígitos para ano");
			return data();
		}
	}

	private static Pessoa novaPessoa() {
		Pessoa p = new Pessoa();
		System.out.println("Digite o nome da pessoa:\n");
		INP.nextLine();
		String nome = INP.nextLine();
		p.setNome(nome);
		p.setIdade(data());
		System.out.println("Digite o email da pessoa:\n");
		String email = INP.next();
		p.setEmail(email);
		System.out.println("Digite uma rede social da pessoa:\n");
		String social = INP.next();
		p.setSocial(social);
		System.out.println("Informe se a pessoa trabalha\nDigite TRUE ou FALSE:\n");
		Boolean trabalho = INP.nextBoolean();
		p.setTrabalho(trabalho);
		return p;
	}

	private static int opcao() {
		int opcao = INP.nextInt();
		if (opcao > 4 || opcao < 0)
			throw new IllegalArgumentException("Digite uma opção válida");
		return opcao;
	}

	public static void menu() {
		System.out.println("\nCadastro de Pessoa\n");
		System.out.println("(0)sair");
		System.out.println("(1)inserir Pessoa");
		System.out.println("(2)listar Pessoa");
		System.out.println("(3)buscar Pessoa");
		System.out.println("(4)deletar Pessoa");
		int menu = 0;

		try {
			menu = opcao();
		} catch (IllegalArgumentException e) {
			System.out.println("Opção inválida, tente novamente\n\n");
			menu();
		}

		if (menu == 1) {
			ManipulaArquivo arqAux = new ManipulaArquivo();
			arqAux.insert(novaPessoa());
			menu();
		}

		if (menu == 2) {
			ManipulaArquivo arqAux = new ManipulaArquivo();
			List<Pessoa> pessoas = arqAux.list();

			for (Pessoa p : pessoas) {
				System.out.println(p);
			}
			menu();
		}

		if (menu == 3) {
			ManipulaArquivo arqAux = new ManipulaArquivo();
			System.out.println(arqAux.get(linha()));
			menu();
		}
		if (menu == 4) {
			ManipulaArquivo arqAux = new ManipulaArquivo();
			arqAux.delete(linha());
			menu();
		}
	}

}
