package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="avaliacaoFisica")
public class AvaliacaoFisica {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="id_Aluno")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();
  
  @Column(name = "pesoAtual")
  private double peso;
 
  @Column(name="alturaAtual")
  private double altura;

public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}

public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
	this.dataDaAvaliacao = dataDaAvaliacao;
}

public void setPeso(double peso) {
	this.peso = peso;
}

public void setAltura(double altura) {
	this.altura = altura;
}

public Long getId() {
	return id;
}

public Aluno getAluno() {
	return aluno;
}

public LocalDateTime getDataDaAvaliacao() {
	return dataDaAvaliacao;
}

public double getPeso() {
	return peso;
}

public double getAltura() {
	return altura;
}


  
  

}
