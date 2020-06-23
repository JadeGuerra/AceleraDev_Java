package codenation;

import codenation.exceptions.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;



public class DesafioMeuTimeApplication implements MeuTimeInterface {
	//TODO incluir um novo time *exeption identificador *retornar br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException
	public List<Time> times = new ArrayList<Time>();

	/**
	 * @incluirTime inclui novo time
	 * se @id existe retorna @IdentificadorUtilizadoException
	 */

	public void incluirTime(Long id,
							String nome,
							LocalDate dataCriacao,
							String corUniformePrincipal,
							String corUniformeSecundario) {
		//para cada time no objeto time
		for (Time time : times){
			//id time recebe o id do time
			long idTime = time.getId();
			//se id igual a time
			if (id == idTime){
				//chama a exceção
				throw new IdentificadorUtilizadoException();
			}
			//adiciona um objeto time no array time
			time = new Time();


		}

	}
	/**
	 * Se @id exista, retornar IdentificadorUtilizadoException
	 * Se @time  não exista, retornar TimeNaoEncontradoException
	 */
	public void incluirJogador(Long id,
							   Long idTime,
							   String nome,
							   LocalDate dataNascimento,
							   Integer nivelHabilidade,
							   BigDecimal salario) {
		for (Jogador jogador : jogadores){
			//id jogador recebe o id do jogador
			long idJogador = jogador.getId();
			//se id igual a jogador
			if (id == idJogador){
				//chama a exceção
				throw new IdentificadorUtilizadoException();
			}
			//senão
			else {
				//adiciona um objeto time no array time

				throw new IdentificadorUtilizadoException();

				throw new TimeNaoEncontradoException();
			}
	}

	public void definirCapitao(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTimes() {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}



}
