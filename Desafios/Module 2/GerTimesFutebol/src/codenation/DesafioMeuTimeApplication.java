package codenation;

import codenation.exceptions.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
    public List<Time> listaTimes = new ArrayList<Time>();
    public List<Jogador> listaJogadores = new ArrayList<Jogador>();

	/**
	 * @param id
	 * @param nome
	 * @param dataCriacao
	 * @param corUniformePrincipal
	 * @param corUniformeSecundario
	 *
	 * @create new Time()
	 * @add time to listaTimes
	 * @exception  IdentificadorUtilizadoException
	 */
    public void incluirTime(Long id,
							String nome,
							LocalDate dataCriacao,
							String corUniformePrincipal,
							String corUniformeSecundario) {
		if(listaTimes.contains(id)) {
			throw new IdentificadorUtilizadoException();
		}
		Time time = new Time();
		listaTimes.add(time);
	}

	/**
	 * @param id
	 * @param idTime
	 * @param nome
	 * @param dataNascimento
	 * @param nivelHabilidade
	 * @param salario
	 *
	 * @create new Jogador
	 * @add jogador to listaJogadores
	 * @exception IdentificadorUtilizadoException
	 * @exception TimeNaoEncontradoException
	 */
	public void incluirJogador(Long id,
							   Long idTime,
							   String nome,
							   LocalDate dataNascimento,
							   Integer nivelHabilidade,
							   BigDecimal salario) {
		if (listaJogadores.contains(id)){
			throw new IdentificadorUtilizadoException();
		}else
			if (listaTimes.contains(idTime)){
				Jogador jogador = new Jogador();
				listaJogadores.add(jogador);
			} throw new TimeNaoEncontradoException();
	}

	/**
	 * Define um jogador como capitão do seu time.
	 * Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.
	 * Long `idJogador`* Identificador do jogador.
	 * **Exceções:**
	 * Caso o jogador informado não exista, retornar JogadorNaoEncontradoException
	 */
	public void definirCapitao(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Mostra o `identificador` do capitão do time.
	 * - Long `idTime`* Identificador do Time
	 * **Exceções:**
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * Caso o time informado não tenha um capitão, retornar CapitaoNaoInformadoException
	 * @param idTime
	 * @return
	 */

	public Long buscarCapitaoDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param idJogador
	 * @return String jogador.getNome()
	 * @exception JogadorNaoEncontradoException
	 */
	public String buscarNomeJogador(Long idJogador) {
		for (Jogador jogador: listaJogadores){
			if (idJogador == jogador.getId()){
				return jogador.getNome();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	/**
	 * Retorna o `nome` do time.
	 * Long `idTime`* Identificador do Time
	 * **Exceções**
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * @param idTime
	 * @return String time.getNome()
	 * @exception TimeNaoEncontradoException
	 */
	public String buscarNomeTime(Long idTime) {
		for (Time time : listaTimes){
			if (idTime == time.getId()){
				return time.getNome();
			}
		}
		throw new TimeNaoEncontradoException();
	}

	/**
	 * Retorna a lista com o `identificador` de todos os jogadores do time, ordenada pelo `id`.
	 * Long `idTime`* Identificador do Time
	 * **Exceções**
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * @param idTime
	 * @return
	 */
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna o `identificador` do melhor jogador do time.
	 * Long `idTime`* Identificador do time.
	 * **Exceções**:
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * @param idTime
	 * @return
	 */
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna o `identificador` do jogador mais velho do time. Usar o menor `identificador` como critério de desempate.
	 * Long idTime* Identificador do time
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * @param idTime
	 * @return
	 */
	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna uma lista com o `identificador` de todos os times cadastrado, ordenada pelo `identificador`.
	 * Retornar uma lista vazia caso não encontre times cadastrados.
	 * @return
	 */
	public List<Long> buscarTimes() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna o `identificador` do jogador com maior salário do time.
	 * Usar o menor `identificador` como critério de desempate.
	 * Long `idTime`* Identificador do time.
	 * **Exceções**:
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * @param idTime
	 * @return
	 */
	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna o `salário` do jogador.
	 * Long `idJogador`* Identificador do jogador
	 * **Exceções**:
	 * Caso o jogador informado não exista, retornar JogadorNaoEncontradoException
	 * @param idJogador
	 * @return
	 */
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna uma lista com o `identificador` dos `top` melhores jogadores,
	 * utilizar o menor `identificador` como critério de desempate.
	 * Integer `top`* Quantidade de jogares na lista
	 * **Exceções**:
	 * Caso não exista nenhum jogador cadastrado, retornar uma lista vazia.
	 * @param top
	 * @return
	 */
	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}

}
