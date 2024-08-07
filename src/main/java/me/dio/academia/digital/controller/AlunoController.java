package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoServiceImpl service;
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value= "dataDeNascimento", required = false) String dataDeNascimento){
		return service.getAll(dataDeNascimento);
	}
   
//	@GetMapping()
//	public List<Aluno> buscarTodos(){
//		return service.listaTodosAlunos();
//	}
	@PostMapping
	public Aluno create(@RequestBody AlunoForm form) {
		return service.create(form);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAvaliacaoFisicaId(@PathVariable Long id){
		return service.getAllAvaliacaoFisicaId(id);
	}
	
	
}
