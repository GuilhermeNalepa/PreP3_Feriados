package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FeriadosController implements IFeriadosController {

	public FeriadosController() {
		
		super();
	
	}

	@Override
	public void readFile(String path, String nome, String nameUsu) throws IOException {
		
		File arq = new File(path, nome);
		boolean encontrado = false;
		String data = "";
		
		if (arq.exists() && arq.isFile()) {
			
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha != null) {
				
				String[] quebraLinha = linha.split("}");
				int tamanho = quebraLinha.length;
				
				for (int i = 0; i < tamanho; i++) {
				
					String[] separacao = quebraLinha[i].split("\"");
					String date = separacao[3];
					String name = separacao[11];
				
					if (name.contains(nameUsu)) {
						
						encontrado = true;
						data = date;
						i = tamanho - 2;
					
					}
					
					if (i == tamanho - 2) {
						
						if (encontrado == true) {
							
							System.out.println("Data = " + data);
							break;
							
						} else {
							
							throw new IOException("Feriado não encontrado");
							
						}
						
					}
					
				}
				
				linha = buffer.readLine();
				
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		
		} else {
			
			throw new IOException("Arquivo inválido");
			
		}
	}
}