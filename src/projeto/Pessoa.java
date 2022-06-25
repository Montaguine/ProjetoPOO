package projeto;

import java.time.LocalDate;

public class Pessoa {
	private final String nome;
	private final LocalDate birthday;
	private String redeSocial;
	private String email;
	private boolean trabalha;

	public Pessoa(String nome, LocalDate nascimento) {
		if (nascimento.getYear() > LocalDate.now().getYear())
			throw new IllegalArgumentException("Data inválida");
		this.nome = nome;
		this.birthday = nascimento;
	}

	public Pessoa(String nome, LocalDate nascimento, String email, String redeSocial) {
		if (nascimento.getYear() > LocalDate.now().getYear())
			throw new IllegalArgumentException("Data inválida");
		this.nome = nome;
		this.birthday = nascimento;
		this.redeSocial = redeSocial;
		this.email = email;
	}

	public Pessoa(String nome, LocalDate nascimento, String email, boolean emprego, String redeSocial) {
		if (nascimento.getYear() > LocalDate.now().getYear())
			throw new IllegalArgumentException("Data inválida");
		this.nome = nome;
		this.birthday = nascimento;
		this.redeSocial = redeSocial;
		this.email = email;
		this.trabalha = emprego;
	}

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.birthday.getYear();
	}

	public String getSocial() {
		return this.redeSocial;
	}

	public void setSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean seTrabalha() {
		return this.trabalha;
	}

	public void setTrabalha(boolean trabalha) {
		this.trabalha = trabalha;
	}

	@Override
	public String toString() {
		return this.getNome() + ";" + this.getIdade() + ";" + this.getEmail() + ";" + this.getSocial() + ";"
				+ this.seTrabalha();
	}
}