package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="aluno")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

	
  private String nome;
  
  @Column(unique = true)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;
  
  
  
  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

public void setNome(String nome) {
	this.nome = nome;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public void setDataDeNascimento(LocalDate dataDeNascimento) {
	this.dataDeNascimento = dataDeNascimento;
}


public Long getId() {
	return id;
}

public String getNome() {
	return nome;
}

public String getCpf() {
	return cpf;
}

public String getBairro() {
	return bairro;
}

public LocalDate getDataDeNascimento() {
	return dataDeNascimento;
}



public List<AvaliacaoFisica> getAvaliacoes() {
	return avaliacoes;
}

public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
	this.avaliacoes = avaliacoes;
}

@Override
public String toString() {
	return "Aluno [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", bairro=" + bairro + ", dataDeNascimento="
			+ dataDeNascimento + "]";
}

  
  
  

}
