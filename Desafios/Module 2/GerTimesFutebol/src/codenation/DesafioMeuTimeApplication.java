package codenation;

import codenation.exceptions.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
    public List<Time> listaTimes = new ArrayList<Time>();
    public List<Jogador> listaJogadores = new ArrayList<Jogador>();

	/**
	 * Realiza a inclusão de um novo time.
	 *
	 * Long `id`* Identificador do time
	 * String `nome`* Nome do Time
	 * LocalDate `dataCriacao`* Data de criação do time
	 * String `corUniformePrincipal`* Cor do uniforme principal do time
	 * String `corUniformeSecundario`* Cor do uniforme secundário do time
	 *
	 * **Exceções:**
	 *
	 * Caso o `identificador` já exista, retornar IdentificadorUtilizadoException
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
	 * Long `id`* Identificador do Jogador
	 * Long `idTime`* Identificador do time
	 * String `nome`* Nome do Jogador
	 * LocalDate `dataNascimento`* Data de nascimento do Jogador
	 * Integer `nivelHabilidade`* Nível de habilidade do jogador (0 a 100)
	 * BigDecimal `salario`* Salário do jogador
	 *
	 * **Exceções:**
	 *
	 * Caso o `identificador` já exista, retornar IdentificadorUtilizadoException
	 * Caso o time informado não exista, retornar `TimeNaoEncontradoException
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
	 * Retorna o `nome` do jogador.
	 * Long `idJogador`* Identificador do jogador
	 * **Exceções**
	 * Caso o jogador informado não exista, retornar JogadorNaoEncontradoException
	 * @param idJogador
	 * @return
	 */
	public String buscarNomeJogador(Long idJogador) {
		for (Jogador jogador: listaJogadores){
			if (idJogador == jogador.getId(idJogador)){
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
	 * @return
	 */
	public String buscarNomeTime(Long idTime) {
		for (Time time : listaTimes){
			if (idTime == time.getId()){
				return time.getNome();
			}
		}
		throw new TimeNaoEncontradoException();
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
