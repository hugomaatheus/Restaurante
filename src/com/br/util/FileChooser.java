package com.br.util;
//package com.br.view;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//
//
//public class FileChooser {
//	
//	String newline = System.getProperty("line.separator");
//	
//	public void salvarComo(Cliente c) throws IOException {
//		
//		JFileChooser saveFile = new JFileChooser();
//		int resultado = saveFile.showSaveDialog(null);
//		
//		if(resultado != JFileChooser.APPROVE_OPTION) {
//			return;
//		}
//		
//		try {
//			File arquivoEscolhido = saveFile.getSelectedFile();
//			PrintWriter pw = new PrintWriter(new FileWriter(arquivoEscolhido));
//			pw.write("Nome: " + c.getNome() + newline);
//			pw.write("Idade: " + c.getIdade());
//			pw.close();
//		}catch(Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//	}
//
//}
