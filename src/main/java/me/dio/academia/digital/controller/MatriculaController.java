package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaServiceImpl service;
	
	@PostMapping
	public Matricula create(@RequestBody MatriculaForm form) {
		return service.create(form);
	}
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false)String bairro){
		return service.getAll(bairro);
	}
}
