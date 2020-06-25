package codenation;

import codenation.exceptions.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;



public class DesafioMeuTimeApplication implements MeuTimeInterface {
	public List<Time> listaTimes = new ArrayList<Time>();
	public List<Jogador> listaJogadores = new ArrayList<Jogador>();

	//tentando resolver as chamadas de classe

	public long validaJogador(long idJogador){
	    for (Jogador jogador : listaJogadores){
	        if (idJogador == jogador.getId()){
	            return jogador.getId();
            }
        }throw new JogadorNaoEncontradoException();
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
		if(listaTimes.contains(id)){
			throw new IdentificadorUtilizadoException();
		}
		Time time = new Time();
		listaTimes.add(time);
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


		if (listaTimes.contains(idTime)) {
			if (listaJogadores.contains(id)) {
			throw new IdentificadorUtilizadoException();
			}
			Jogador jogador = new Jogador();
			listaJogadores.add(jogador);
		}
		throw new TimeNaoEncontradoException();
	}


	/**
	 * Define um jogador como capitão do seu time.
	 * Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.
	 * se jogador informado não exista, retornar JogadorNaoEncontradoException
	 */
	public void definirCapitao(Long idJogador) {
	    if (validaJogador(idJogador) == idJogador){
            }
	    }

	}

	/**
	 * Mostra o `identificador` do capitão do time.
     * Long `idTime`* Identificador do Time
     * Caso o time informado não exista, retornar TimeNaoEncontradoException
     * Caso o time informado não tenha um capitão, retornar CapitaoNaoInformadoException
	 */
	public Long buscarCapitaoDoTime(Long idTime) {
	    if (listaTimes.contains(idTime)){
	        listaTimes.getClass();

        } throw new TimeNaoEncontradoException();
	}

	/**
	* `nome` do jogador.
    * jogador informado não exista, retornar JogadorNaoEncontradoException
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
	* Caso o time não exista, retornar TimeNaoEncontradoException
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
     * lista com o `identificador` de todos os jogadores do time, ordenada pelo `id`
     * Long `idTime`* Identificador do Time
     * time informado não exista, retornar TimeNaoEncontradoException
     * */
	public List<Long> buscarJogadoresDoTime(Long idTime) {
	    for (Jogador jogador: listaJogadores){
	        if(idTime == jogador.getIdTime()){
	            return jogador.getId();
            }
        }

		throw new TimeNaoEncontradoException();
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
