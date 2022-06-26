package projeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InterfaceCadastro {

	public static final Scanner INP = new Scanner(System.in);

	public static Pessoa novaPessoa() {
		Pessoa p = new Pessoa();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Digite o nome da pessoa:\n");
		INP.nextLine();
		String nome = INP.nextLine();
		p.setNome(nome);
		System.out.println("Digite o dia de nascimento da pessoa:\n");
		String dia = INP.next();
		System.out.println("Digite o mês de nascimento da pessoa:\n");
		String mes = INP.next();
		System.out.println("Digite o ano de nascimento da pessoa:\n");
		String ano = INP.next();
		LocalDate data = LocalDate.parse(dia + "/" + mes + "/" + ano, formater);
		p.setIdade(data);
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

	public static int opcao() {
		int opcao = INP.nextInt();
		if (opcao > 4 || opcao < 0)
			throw new IllegalArgumentException("Digite uma opção válida");
		return opcao;
	}

	public static void menu() {
		System.out.println("Cadastro de " + Pessoa.class.getSimpleName() + "\n\n");
		System.out.println("(0)sair");
		System.out.println("(1)inserir " + Pessoa.class.getSimpleName());
		System.out.println("(2)listar  " + Pessoa.class.getSimpleName());
		System.out.println("(3)buscar  " + Pessoa.class.getSimpleName());
		System.out.println("(4)deletar " + Pessoa.class.getSimpleName());
		int menu = 0;

		try {
			menu = opcao();
		} catch (IllegalArgumentException e) {
			System.out.println("Opção inválida, tente novamente\n\n");
			menu();
		}

		if (menu == 1) {
			novaPessoa();
		}
	}
}
