package projeto;

import java.time.LocalDate;

public class Pessoa {
	private final String nome;
	private final LocalDate birthday;
	private String redeSocial;
	private String email;
	private boolean trabalha;

	public Pessoa(String nome, LocalDate nascimento) {
		this.nome = nome;
		this.birthday = nascimento;
	}

	public Pessoa(String nome, LocalDate nascimento, String email, String redeSocial) {
		this.nome = nome;
		this.birthday = nascimento;
		this.redeSocial = redeSocial;
		this.email = email;
	}
	public Pessoa(String nome, LocalDate nascimento, String email, boolean emprego, String redeSocial) {
		this.nome = nome;
		this.birthday = nascimento;
		this.redeSocial = redeSocial;
		this.email = email;
		this.trabalha = emprego;
	}

}
