package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {
	
	@Autowired
	private AlunoRepository repository;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		return repository.save(aluno);
	}

	@Override
	public Aluno buscarPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Aluno> alunoOptional = repository.findById(id);
		if(alunoOptional.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		System.out.println(alunoOptional.toString());
		return alunoOptional.get();
	}

//	@Override
//	public List<Aluno> listaTodosAlunos() {
//		// retornar lista de alunos
//		List<Aluno> alunos = new ArrayList<Aluno>();
//		alunos.add((Aluno) repository.findAll());
//		return alunos;
//	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento){
		if(dataDeNascimento == null) {
			return repository.findAll();
		}else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		}
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		// 
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();
	}
	

}
