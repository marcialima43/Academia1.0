package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Campo obrigatório")
  private String nome;
  
  @CPF()
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  
  //getters
  
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
}
