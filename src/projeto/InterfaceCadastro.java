package projeto;

import java.util.Scanner;

public class InterfaceCadastro {

	public static final Scanner INP = new Scanner(System.in);

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

		try {
			int menu = 0;
			menu = opcao();
		} catch (IllegalArgumentException e) {
			System.out.println("Opção inválida, tente novamente\n\n");
			menu();
		}
	}
}
