package projeto;

//import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManipulaArquivo {
	private Path arquivo;
	private Charset encode;

	public ManipulaArquivo() {
		Path pasta = Paths.get("Cadastros");
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

	public void insert(Pessoa c) {
		String aux = c.toString() + "\n";
		try {
			Files.writeString(this.arquivo, aux, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro: problemas ao abrir o arquivo:");
		}
	}

	public Pessoa get(int l) {
		List<String> dadosArquivo;
		try {
			dadosArquivo = Files.readAllLines(this.arquivo, this.encode);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro! Problemas ao abrir o arquivo:");
		}
		try {
			String objeto = dadosArquivo.get(l);
			String[] campos = objeto.split(";");
			Pessoa c = new Pessoa();
			// formato: Nome;Idade;Email;RedeSocial;Empregado
			c.setNome(campos[0]);
			String[] data = campos[1].split("/");
			c.setIdade(LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0])));
			c.setEmail(campos[2]);
			c.setSocial(campos[3]);
			c.setTrabalho(Boolean.parseBoolean(campos[4]));
			return c;
		} catch (IndexOutOfBoundsException e) {
			throw new MinhaException("O indice digitado não existe:");
		}
	}

	public void delete(int linha) {
		List<String> dadosArquivo;
		try {
			dadosArquivo = Files.readAllLines(this.arquivo, this.encode);
			dadosArquivo.remove(linha);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro! Problemas ao abrir o arquivo:");
		}
		try {
			Files.write(this.arquivo, dadosArquivo, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("Erro! Problemas ao salvar arquivo:");
		}
	}

	public List<Pessoa> list() {
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