package projeto;

import java.time.LocalDate;

public class TestaCadastro extends InterfaceCadastro {

	public static void main(String[] args) {
		Pessoa p = new Pessoa("Tobias", LocalDate.of(1995, 3, 1));
		p.setEmail("tobias@email.to");
		p.setTrabalho(false);
		p.setSocial("@tobias");
		System.out.println(p.toString()+"\n");
		menu();
	}
}