package projeto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
	private String nome;
	private LocalDate birthday;
	private String redeSocial;
	private String email;
	private boolean trabalha;

	public Pessoa() {
	}

	public Pessoa(String nome, LocalDate nascimento) {
		if (nascimento.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Data inválida");
		this.nome = nome;
		this.birthday = nascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return this.birthday;
	}

	public int getIdade() {
		return this.birthday.getYear();
	}

	public void setIdade(LocalDate idade) {
		if (idade.getYear() > LocalDate.now().getYear())
			throw new IllegalArgumentException("Data inválida");

		this.birthday = idade;
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

	public void setTrabalho(boolean trabalha) {
		this.trabalha = trabalha;
	}

	@Override
	public String toString() {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.getNome() + ";" + this.getNascimento().format(formater) + ";" + this.getEmail() + ";"
				+ this.getSocial() + ";" + this.seTrabalha();
	}
}