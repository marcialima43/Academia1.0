package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
	/**
	   *
	   * @param bairro bairro referência para o filtro
	   * @return lista de alunos matriculados que residem no bairro passado como parâmetro
	   */
	
	@Query(value = "SELECT * FROM MATRICULA M" +
			"INNER JOIN ALUNO A ON M.ID_ALUNO = A.ID" +
			"WHERE A.BAIRRO = :bairro", nativeQuery = true)
	List<Matricula> findAlunosMatriculadosBairro(@Param("bairro")String bairro);
}
