package codenation;

import codenation.exceptions.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;



public class DesafioMeuTimeApplication implements MeuTimeInterface {
	//TODO incluir um novo time *exeption identificador *retornar br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException
	public List<Time> times = new ArrayList<Time>();

	public boolean isTime(long id){
		for (Time time : times){
			if (id != time.getId()){
				return false;
		}
	}

	public boolean isJogador(Time time, long id) {
		for (Jogador jogador : time.getJogadores()) {
			if (id != jogador.getId()) {
				return false;
			}
	}

	/**
	 * @incluirTime inclui novo time
	 * se @id existe retorna @IdentificadorUtilizadoException
	 */

	public void incluirTime(Long id,
							String nome,
							LocalDate dataCriacao,
							String corUniformePrincipal,
							String corUniformeSecundario) {
		if (isTime(id)){
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


		for (Time time : times){
			//se id igual time
			if (idTime == time.getId()){
				//agora percorre o array jogadores dentro de time
				for (Jogador jogador: time.getJogadores()){
					//se idJogador já existir
					if (id == jogador.getId()){
						throw new IdentificadorUtilizadoException();
					}
					jogador = new Jogador();
				}
			}
			throw new TimeNaoEncontradoException();
		}
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
