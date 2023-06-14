package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.FeriadosController;
import controller.IFeriadosController;

public class Principal {

	public static void main(String[] args) {
		
		IFeriadosController ferCont = new FeriadosController();
		String path = "C:\\TEMP";
		String nome = "hol.json";
		String nameUsuario = JOptionPane.showInputDialog("Digite o nome do feriado");
		
		try {
			
			ferCont.readFile(path, nome, nameUsuario);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		
		}

	}

}
