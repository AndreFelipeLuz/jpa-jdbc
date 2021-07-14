package br.fuctura.methods;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		int a;
		
		Automatizar aut = new Automatizar();
		System.out.println("oque deseja fazer?");
		System.out.println("1-Listar");
		System.out.println("2-Inserir");
		System.out.println("3-Atualizar");
		System.out.println("4-Deletar");
		a = ler.nextInt();
		switch (a) {
		case 1:
			aut.getListarTodos();
			break;
		case 2:
			aut.escolherInsercao();
			break;
		case 3:
			aut.escolherDeletar();
			break;
		case 4:
			aut.escolherAtualizar();
			break;
		default:
			main(args);
			break;
		}
	}
}
