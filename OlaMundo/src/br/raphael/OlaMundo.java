package br.raphael;

import java.math.BigDecimal;
import java.util.Date;

public class OlaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + " Olá Mundo");	
		}
		/*int i = 0;
		while (i < 10) {
			System.out.println(i + 1 + " Olá Mundo");
			i++;
		}*/
	
	Aluno a1 = new Aluno(11316789L, "Maria Filisbina", "12345678", new Date());
	Aluno a2 = new Aluno(9813045L, "Golaço merece placa", "04395485890");
	Aluno a3 = new Aluno(9813045L, "Golaço merece placa");
	
	Professor p1 = new Professor("Humberto Cruvinel", "982354875", new BigDecimal("9587"));
	Professor p2 = new Professor("Humberto Cruvinel", "982354875");
	
	System.out.println("Bonos do professor: " + Professor.BONUS);
	System.out.println("Bonos do professor: " + Professor.BONUS);
	
	System.out.println("Verifica Matricula 1 ====== " + Aluno.verificaMatricula("12345"));
	System.out.println("Verifica Matricula 2 ====== " + Aluno.verificaMatricula("12345678"));
	
	System.out.println(a1);
	System.out.println(a2);
	System.out.println(a3);
	System.out.println(p1);
	System.out.println(p2);
	}
}
