package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="matricula")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAluno")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();

public void setId(Long id) {
	this.id = id;
}

public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}

public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
	this.dataDaMatricula = dataDaMatricula;
}
  
  
}
