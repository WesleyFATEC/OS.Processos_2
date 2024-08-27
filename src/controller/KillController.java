package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {
	private String os(){
		return System.getProperty("os.name");	
	}
	
	public void listaProcessos () {
		String os = os();
		String cmd = "";
		
		if (os.contains("dows")) {
			cmd = "TASKLIST /FO TABLE";
		}else
		{
			cmd = "ps -ef";
		}
		
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            	System.out.println(line);
            }
            reader.close();
            process.waitFor();
			
		}catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}

	public void mataNome(String nome) {
		String os = os();
		String cmd = "";
		
		if (os.contains("dows")) {
			cmd = "TASKKILL /F /IM" + " " + nome;
		}else
		{
			cmd = "pkill -f "+ nome;
		}
		
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			System.out.println(nome + " finalizado");
		}catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}
		
	
	public void mataPid(String pid) {
		String os = os();
		String cmd = "";
		
		if (os.contains("dows")) {
			cmd = "TASKKILL /F /PID" + " " + pid;
		}else
		{
			cmd = "kill -9"+ " " + pid;
		}
		
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			System.out.println(pid + " finalizado");
		}catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}
	
}
