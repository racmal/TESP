package br.unibh.entidades;

import java.math.BigDecimal;

public class Professor extends Pessoa {

	private BigDecimal salario;
	

	public Professor(){
		
	}
	
	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	public Professor(Long id, String nome, String cpf) {
		super(id, nome, cpf);
	}

	public static Double BONUS = 0.10;
	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString() + "Professor [salario=" + salario + "]";
	}

}
