package projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastraPessoa {
	private Path arquivo;
	private Charset encode;

	public CadastraPessoa() {
		Path pasta = Paths.get("ProjetoPOO");
		this.arquivo = pasta.resolve("cadastros.csv");
		this.encode = Charset.forName("UTF-8");
		try {
			if (!Files.exists(pasta)) {
				Files.createDirectory(pasta);
			}
			if (!Files.exists(this.arquivo)) {
				Files.createFile(this.arquivo);
			}
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro: problemas ao abrir o arquivo:");
		}
	}

	public void insereNoFim(Pessoa c) {
		String aux = c.toString() + "\n";
		try {
			Files.writeString(this.arquivo, aux, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro: problemas ao abrir o arquivo:");
		}
	}

	public String leUmaLinha() {
		try {
			BufferedReader leitor = Files.newBufferedReader(this.arquivo);
			return leitor.readLine();
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro: problemas ao abrir o arquivo:");
		}
	}

	public List<Pessoa> lista() {
		List<String> dadosArquivo;
		List<Pessoa> cadastros = new ArrayList<>();
		try {
			dadosArquivo = Files.readAllLines(this.arquivo, this.encode);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro! Problemas ao abrir o arquivo:");
		}
		for (String linha : dadosArquivo) {
			String[] campos = linha.split(";");
			Pessoa c = new Pessoa();
			// formato: Nome;Idade;Email;RedeSocial;Empregado
			c.setNome(campos[0]);
			String[] data = campos[1].split("/");
			c.setIdade(LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])));
			c.setEmail(campos[2]);
			c.setSocial(campos[3]);
			c.setTrabalho(Boolean.parseBoolean(campos[4]));
			cadastros.add(c);
		}
		return cadastros;
	}
}