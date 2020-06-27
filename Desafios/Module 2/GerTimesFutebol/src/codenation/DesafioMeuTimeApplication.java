package codenation;

import codenation.exceptions.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
    public List<Time> listaTimes = new ArrayList<>();
    public List<Jogador> listaJogadores = new ArrayList<>();

	/**
	 * @param id <Long></Long>
	 * @param nome <String></String>
	 * @param dataCriacao <LocalDate></LocalDate>
	 * @param corUniformePrincipal <String></String>
	 * @param corUniformeSecundario <String></String>
	 *
	 * @create new Time()
	 * @add time to listaTimes
	 * @exception  IdentificadorUtilizadoException
	 */
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        if (listaTimes.contains(id)){
            throw new IdentificadorUtilizadoException();
        }
        Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        listaTimes.add(time);
	}

	public boolean validaTime (Long idTime){
        for (Time time : listaTimes){
            if (idTime == time.getId()){
                return true;
            }
        } throw new TimeNaoEncontradoException();
    }

	/**
	 * @param id <Long></Long>
	 * @param idTime <Long></Long>
	 * @param nome <String></String>
	 * @param dataNascimento <LocalDate></LocalDate>
	 * @param nivelHabilidade <Integer></Integer>
	 * @param salario <BigDecimal></BigDecimal>
	 *
	 * @create <new> Jogador
	 * @add jogador to listaJogadores
	 * @exception IdentificadorUtilizadoException
	 * @exception TimeNaoEncontradoException
	 */
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (validaIdJogador(id)){
			if (validaTime(idTime)){
				Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
				listaJogadores.add(jogador);
			}
		}
	}

	public boolean validaIdJogador (Long idJogador){
		for (Jogador jogador : listaJogadores){
			if (idJogador == jogador.getId()){
				throw new IdentificadorUtilizadoException();
			}
		} return true;
    }

    public boolean validaJogador (Long idJogador){
		for (Jogador jogador : listaJogadores){
			if (idJogador.equals(jogador.getId())){
				return true;
			}
		} throw new JogadorNaoEncontradoException();
    }

	/**
	 * Define um jogador como capitão do seu time.
	 * Um time deve ter apenas um capitão, por tanto o capitão anterior voltará a ser apenas jogador.
	 * Long `idJogador`* Identificador do jogador.
	 * **Exceções:**
	 * Caso o jogador informado não exista, retornar
	 * @param idJogador Long
	 * @call jogador.setCapitao()
	 * @exception JogadorNaoEncontradoException
	 */
	public void definirCapitao(Long idJogador) {
	    validaJogador(idJogador);
	    zeraCapitao(idJogador);
        for (Jogador jogador : listaJogadores){
            if (!jogador.isCapitao()){
                jogador.setCapitao();
            }
        }

	}

	public Long buscarTimeJogador (Long idJogador){
	    Long time = 0l;
	    for (Jogador jogador : listaJogadores){
	        if (jogador.equals(idJogador)){
	            time = jogador.getIdTime();
            }
        }
        return time;
    }

	public void zeraCapitao (Long idJogador){
	    Long time = buscarTimeJogador(idJogador);
	    for (Jogador jogador : listaJogadores){
	        if (jogador.equals(time)){
	            jogador.deleteCapitao();
            }
        }
    }

	/**
	 * @param idTime
	 * @return Long jogador.getId() if jogador.isCapitao()
	 * @exception CapitaoNaoInformadoException
	 * @exception TimeNaoEncontradoException
	 */
	public Long buscarCapitaoDoTime(Long idTime) {
	   	validaTime(idTime);
	   	for (Jogador jogador : listaJogadores){
			if (idTime.equals(jogador.getIdTime())){
				if (jogador.isCapitao()){
					return jogador.getId();
				}
			}
		}
	   	throw new CapitaoNaoInformadoException();
	}


	/**
	 * @param idJogador
	 * @return String jogador.getNome()
	 * @exception JogadorNaoEncontradoException
	 */
	public String buscarNomeJogador(Long idJogador) {
		for (Jogador jogador : listaJogadores){
			if (idJogador.equals(jogador.getId())){
				return jogador.getNome();
			}
		}
		throw new JogadorNaoEncontradoException();
	}

	/**
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
	 * @param idTime
	 * @return List <Long>idJogadores</Long>
	 * @exception  TimeNaoEncontradoException
	 */
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		List<Long> idJogadores = new ArrayList<>();
		if (validaTime(idTime)){
			for (Jogador jogador : listaJogadores){
				if (idTime.equals(jogador.getIdTime())){
					idJogadores.add(jogador.getId());
				}
			}
		}
		return idJogadores;
	}

	/**
	 * @param idTime
	 * @return idMelhorJogadorTime <Long></Long>
     * @exception TimeNaoEncontradoException
	 */
	public Long buscarMelhorJogadorDoTime(Long idTime) {
	    int habilidade = 0;
	    Long idMelhorJogadorDoTime = 0l;
		if (validaTime(idTime)){
		    for (Jogador jogador : listaJogadores){
		        if (habilidade < jogador.getNivelHabilidade()){
		            habilidade = jogador.getNivelHabilidade();
		            idMelhorJogadorDoTime = jogador.getId();
                }
            }
        }
		return idMelhorJogadorDoTime;
	}

	/**
	 * Retorna o `identificador` do jogador mais velho do time.
     * Usar o menor `identificador` como critério de desempate.
	 * Long idTime* Identificador do time
	 * Caso o time informado não exista, retornar TimeNaoEncontradoException
	 * @param idTime
	 * @return jogador.getId()
	 */
	public Long buscarJogadorMaisVelho(Long idTime) {
		Long jogadorMaisVelho = 0l;
		LocalDate dataNascimento = LocalDate.now();
	    validaTime(idTime);
	    for (Jogador jogador : listaJogadores){
	        if (idTime == jogador.getIdTime()){
		        if (dataNascimento.isAfter(jogador.getDataNascimento()) || dataNascimento.isEqual(jogador.getDataNascimento()) && jogadorMaisVelho > jogador.getId()){
		            dataNascimento = jogador.getDataNascimento();
		            jogadorMaisVelho = jogador.getId();
		        }
	        }
	    }return jogadorMaisVelho;
	}

	/**
	 * @return List <Long></Long>
	 */
	public List<Long> buscarTimes() {
		List <Long> listaIdTime = new ArrayList<Long>();
		for(Time time : listaTimes){
		    listaIdTime.add(time.getId());
        }
		return listaIdTime;
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
        Long jogadorComMaiorSalario = 100l;
        BigDecimal maiorSalario = null;
        validaTime(idTime);
            for (Jogador jogador : listaJogadores) {
                if (jogador.getIdTime() == idTime) {
                    if (maiorSalario.compareTo(jogador.getSalario()) < 0 || (maiorSalario.compareTo(jogador.getSalario()) == 0 && jogadorComMaiorSalario > jogador.getId())) {
                        maiorSalario = jogador.getSalario();
                        jogadorComMaiorSalario = jogador.getId();
                    }
                }
            }
        return jogadorComMaiorSalario;

	}

	/**
	 * @param idJogador
	 * @return jogador.getSalario() <BigDecimal></BigDecimal>
     * @exception JogadorNaoEncontradoException
	 */
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        for (Jogador jogador : listaJogadores){
            if (idJogador == jogador.getId()){
                return jogador.getSalario();
            }
        }
        throw new JogadorNaoEncontradoException();
	}

	/**
	 * Retorna uma lista com o `identificador` dos `top` melhores jogadores,
	 * utilizar o menor `identificador` como critério de desempate.
	 * Integer `top`* Quantidade de jogares na lista
	 * **Exceções**:
	 * Caso não exista nenhum jogador cadastrado, retornar uma lista vazia.
	 * @param top
	 * @return List <Long></Long>
	 */
	public List<Long> buscarTopJogadores(Integer top) {
        List<Long> stream = listaJogadores.stream().
                sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed()).
                limit(top).map(Jogador::getId).collect(Collectors.toList());
        return stream;
	}




}
