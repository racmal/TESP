package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_PROFESSOR")
@NamedQueries({	@NamedQuery(name="Professor.findByName", query="SELECT p FROM Professor p WHERE p.nome LIKE :nome")})
public class Professor extends Pessoa {
	
	@NotNull
	@DecimalMin("500.00")
	@DecimalMax("50000.00")
	@Column(name="SALARIO", nullable=false)
	private BigDecimal salario;
	
	public static Double BONUS = 0.10;
	
	public Professor(){
		
	}
	
	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	public Professor(Long id, String nome, String cpf) {
		super(id, nome, cpf);
	}

	public Professor(Long id, BigDecimal salario) {
		super(id, null, null);
		this.salario = salario;
	}
	
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
