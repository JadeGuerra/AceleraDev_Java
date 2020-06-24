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
		if(times.contains(id)){
			throw new IdentificadorUtilizadoException();
		}
		Time time = new Time();
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


		if (times.contains(idTime)) {

		}
		throw new TimeNaoEncontradoException();

		if (jogadores.contains) {
			throw new IdentificadorUtilizadoException();
		}
		Jogador jogador = new Jogador();


	}


	/**
	 * Define um jogador como capitão do seu time.
	 * Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.
	 * se jogador informado não exista, retornar JogadorNaoEncontradoException
	 */
	public void definirCapitao(Long idJogador) {
		for (Time time : times){
			for (Jogador jogador : time.getJogadores()){
				//
				//

			}
		}
		throw new UnsupportedOperationException();
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	/**
	* Retorna o `nome` do time.
	* Caso o time não exista, retornar TimeNaoEncontradoException
	*/
	public String buscarNomeTime(Long idTime) {
		for (Time time : times){
			//se id igual a time
			if (idTime == time.getId()){
				//retorna nome do time
				return time.getNome();
			}
			//retorna o erro
			throw new TimeNaoEncontradoException();
		}
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
	//time
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
