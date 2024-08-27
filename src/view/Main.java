package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		String[] opc = {"Listar Processos", "Finalizar por Pid", "Finalizar por Nome", "Sair"};
		int choice;
	
	KillController matar = new KillController();
	do {
		choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", 0, 0, null, opc, opc[0]);
		switch (choice){
		case 0:
			matar.listaProcessos();
			break;
		case 1:
			String pid = JOptionPane.showInputDialog("insira o PID");
			matar.mataPid(pid);
			break;
		case 2:
			String nome = JOptionPane.showInputDialog("insira o nome");
			matar.mataNome(nome);
			break;
		case 3:
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Escolha entre uma das três opções");
			break;
		}
	}while (choice !=3);	
	}

}
