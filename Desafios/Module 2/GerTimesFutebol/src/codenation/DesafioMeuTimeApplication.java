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
	 * Inclui um novo time na listaTimes caso o time não exista na listaTimes
	 * @param id
	 * @param nome
	 * @param dataCriacao
	 * @param corUniformePrincipal
	 * @param corUniformeSecundario
	 *
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

	/**
	 * Deve retornar true ou acionar a exceção.
	 * @param idTime deve estar na listaTimes
	 * @exception TimeNaoEncontradoException
	 */
	public boolean validaTime (Long idTime){
        for (Time time : listaTimes){
            if (idTime == time.getId()){
                return true;
            }
        } throw new TimeNaoEncontradoException();
    }

	/**
	 * Se o id do time já existir deve retornar exceção.
	 * @param idTime não deve estar em listaTimes.
	 * @exception IdentificadorUtilizadoException
	 */
	public boolean validaIdTime (Long idTime){
		for (Time time : listaTimes){
			if (idTime == time.getId()){
				throw new IdentificadorUtilizadoException();
			}
		}
		return true;
	}

	/**
	 * Deve incluir um novo jogador na listaJogadores.
	 * @param id
	 * @param idTime
	 * @param nome
	 * @param dataNascimento
	 * @param nivelHabilidade
	 * @param salario
	 *
	 * @method validaIdJogador verifica se a id do jogador já existe na listaJogadores
	 * @exception IdentificadorUtilizadoException
	 * @method validaTime verifica se o time existe na listaTimes.
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

	/**
	 * Se o id do jogador já existir deve retornar exceção.
	 * @param idJogador não deve estar em listaJogadores.
	 * @exception IdentificadorUtilizadoException
	 */
	public boolean validaIdJogador (Long idJogador){
		for (Jogador jogador : listaJogadores){
			if (idJogador == jogador.getId()){
				throw new IdentificadorUtilizadoException();
			}
		} return true;
    }

	/**
	 * Verifica se o jogador existe na listaJogadores.
	 * @param idJogador deve existir na listaJogadores.
	 * @exception JogadorNaoEncontradoException
	 */
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

	/**
	 * Verifica qual é o time do jogador.
	 * @param idJogador irá ser o parâmetro de busca para retornar o time.
	 * @return time do jogador.
	 */
	public Long buscarTimeJogador (Long idJogador){
	    Long time = 0l;
	    for (Jogador jogador : listaJogadores){
	        if (jogador.equals(idJogador)){
	            time = jogador.getIdTime();
            }
        }
        return time;
    }

	/**
	 * Irá remover o capitão do time para poder definir um novo capitão para o time.
	 * @param idJogador para poder verificar qual o time e remover o capitão anterior.
	 */
    public void zeraCapitao (Long idJogador){
	    Long time = buscarTimeJogador(idJogador);
	    for (Jogador jogador : listaJogadores){
	        if (jogador.equals(time)){
	            jogador.deleteCapitao();
            }
        }
    }

	/**
	 * Busca o capitão do time caso exista.
	 * @param idTime é usado para verificar quem é o jogador nomeado como capitão.
	 * @return id do capitão do time.
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
	 * Busca o nome do jogador.
	 * @param idJogador é usado para buscar o nome do jogador.
	 * @return nome do jogador.
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
	 * Busca o nome do time.
	 * @param idTime é usado para buscar o nome do time.
	 * @return nome do time.
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
	 * Busca todos os jogadores do time e retorna uma lista com eles.
	 * @param idTime é usado para buscar os jogadores do time.
	 * @return uma lista com o id dos jogadores
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
	 * Busca pelo melhor jogador do time.
	 * @param idTime é usado para buscar o melhor jogador do time.
	 * @return a id do melhor jogador do time <Long></Long>
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
	 * Busca os times e retorna uma lista com o id dos times.
	 * @return lista com o id dos times.
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
	 * @return id do jogador com maior salário
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
	 * Busca o salário do jogador.
	 * @param idJogador é usado para buscar o valor do seu salário.
	 * @return valor do salário do jogador
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
	 * @return listaJogadores
	 */
	public List<Long> buscarTopJogadores(Integer top) {
        List<Long> stream = listaJogadores.stream().
                sorted(Comparator.comparingInt(Jogador::getNivelHabilidade).reversed()).
                limit(top).map(Jogador::getId).collect(Collectors.toList());
        return stream;
	}




}
