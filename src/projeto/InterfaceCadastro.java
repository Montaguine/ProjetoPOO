package projeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class InterfaceCadastro {

	private static final Scanner INP = new Scanner(System.in);
	private static Pessoa aux = new Pessoa();

	private static Pessoa buscaPessoa(List<Pessoa> lista) {
		System.out.println("Insira nome, email ou rede social de quem está procurando:");
		INP.nextLine();
		String busca = INP.nextLine();
		for (Pessoa p : lista) {
			if (busca.equals(p.getNome()) || busca.equals(p.getEmail()) || busca.equals(p.getSocial())) {
				return p;
			}
		}
		return null;
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
		System.out.println("\nCadastro de " + Pessoa.class.getSimpleName() + "\n\n");
		System.out.println("(0)sair");
		System.out.println("(1)inserir " + Pessoa.class.getSimpleName());
		System.out.println("(2)listar  " + Pessoa.class.getSimpleName());
		System.out.println("(3)buscar  " + Pessoa.class.getSimpleName());
		System.out.println("(4)deletar " + Pessoa.class.getSimpleName());
		int menu = 0;
		ManipulaArquivo arqAux = new ManipulaArquivo();
		List<Pessoa> pessoas = arqAux.lista();

		try {
			menu = opcao();
		} catch (IllegalArgumentException e) {
			System.out.println("Opção inválida, tente novamente\n\n");
			menu();
		}

		if (menu == 1) {
			arqAux.insereNoFim(novaPessoa());
			menu();
		}

		if (menu == 2) {
			for (Pessoa p : pessoas) {
				System.out.println(p);
			}
			menu();
		}
		if (menu == 3) {
			aux = buscaPessoa(pessoas);
			System.out.println("\nImprimindo resultado da busca:\n" + aux.toString());
			menu();
		}
		if (menu == 4) {
			aux = buscaPessoa(pessoas);
			int index = pessoas.indexOf(aux);
			pessoas.remove(index);
			arqAux.lista().remove(index);
			arqAux.removeLinha(pessoas);
			menu();
		}
	}
}
