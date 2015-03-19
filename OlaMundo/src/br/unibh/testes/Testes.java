package br.unibh.testes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;


public class Testes {
	
	AlunoDAO alunodao = new AlunoDAO();
	ProfessorDAO professordao = new ProfessorDAO();
	
	@Test
	public void testeInserirAluno() {
		
		Aluno a = new Aluno();
		a.setNome("JOAO");
		a.setCpf("101010");
		a.setMatricula(11311020L);
		alunodao.insert(a);
		
		Assert.assertEquals(a.getCpf(),alunodao.findByCPF("101010").getCpf());
		
	}
	@Test
	public void testeInserirProfessor() {
		
		Professor p = new Professor();
		p.setNome("MARIA");
		p.setCpf("202020");
		p.setSalario(new BigDecimal(1000));
		professordao.insert(p);
		
		Assert.assertEquals(p.getCpf(),professordao.findByCPF("202020").getCpf());
		
	}
	@Test
	public void testeupdateAluno() {
		
		Aluno a = alunodao.findByCPF("101010");
		a.setNome("JOAO DA SILVA");
		alunodao.update(a);
		
		Aluno b = alunodao.findByCPF("101010");
		
		Assert.assertEquals(b.getNome(), "JOAO DA SILVA");
		
	}
	@Test
	public void testeupdateProfessor() {
		
		Professor p = professordao.findByCPF("202020");
		p.setNome("MARIA DA GRAÇA");
		professordao.update(p);
		
		Professor b = professordao.findByCPF("202020");
		
		Assert.assertEquals(b.getNome(), "MARIA DA GRAÇA");
		
	}
	@Test
	public void ztestedeleteAluno() {
		
		Aluno a = alunodao.findByCPF("101010");
		alunodao.delete(a);
		
		Aluno row = alunodao.findByCPF("101010");
		
		Assert.assertNull(row);
		
	}
	@Test
	public void testedeleteProfessor() {
		
		Professor p = professordao.findByCPF("202020");
		professordao.delete(p);
		
		Professor row = professordao.findByCPF("202020");
		
		Assert.assertNull(row);
		
	}
	
	@Test
	public void todosAlunos(){
		
		List<Aluno> listaAlunos = alunodao.findAll();		
		Assert.assertEquals(listaAlunos.size(), 1);
	}
	
	@Test
	public void todosProfessores(){
		
		List<Professor> listaProfessor = professordao.findAll();		
		Assert.assertEquals(listaProfessor.size(), 1);
	}
}
