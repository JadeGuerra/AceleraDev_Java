package codenation;

/**
 * Jogador é a classe com construtor, getters e setters para jogador.
 */

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {//all mine
    //Atributos
    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    private boolean capitao = false;
    //construtor

    public Jogador (Long id,
                         Long idTime,
                         String nome,
                         LocalDate dataNascimento,
                         Integer nivelHabilidade,
                         BigDecimal salario
                         ){
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }
    //setters getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean isCapitao() {
        return capitao;
    }

    public void setCapitao() {
        capitao = true;
    }

    public void deleteCapitao (){
        capitao = false;
    }

    //métodos

}
