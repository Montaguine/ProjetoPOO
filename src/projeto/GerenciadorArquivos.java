package projeto;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivos {
	private Path diretorio;

	public GerenciadorArquivos() {
		this.diretorio = Paths.get("arquivos");
	}

	public void criaDiretorio(String dir) throws IOException {
		Path dirNovo = this.diretorio.resolve(dir);
		if (!Files.exists(dirNovo)) {
			Files.createDirectory(dirNovo);
		}
	}

	public void criaArquivo(String nome) throws IOException {
		Path arquivo = this.diretorio.resolve(nome);
		if (!Files.exists(arquivo))
			Files.createFile(arquivo);
	}

	public void apagaArquivo(String nome) throws IOException {
		Path arquivo = this.diretorio.resolve(nome);
		Files.deleteIfExists(arquivo);
	}

	public void moveParaInterna(String dirDestino, String nome) throws IOException {
		Path arquivo = this.diretorio.resolve(nome);
		if (Files.exists(arquivo)) {
			Path destino = this.diretorio.resolve(Paths.get(dirDestino, nome));
			Files.move(arquivo, destino, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public void copiaParaInterna(String dirDestino, String nome) throws IOException {
		Path arquivo = this.diretorio.resolve(nome);
		if (Files.exists(arquivo)) {
			Path destino = this.diretorio.resolve(Paths.get(dirDestino, nome));
			Files.copy(arquivo, destino, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public List<String> listaDiretorio() throws IOException {
		List<String> retorno = new ArrayList<>();
		DirectoryStream<Path> conteudoDir = Files.newDirectoryStream(this.diretorio);
		for (Path p : conteudoDir) {
			retorno.add(p.toString());
		}
		return retorno;
	}
}