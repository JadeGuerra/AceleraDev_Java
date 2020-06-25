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

