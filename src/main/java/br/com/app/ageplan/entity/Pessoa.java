package br.com.app.ageplan.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /*----------------------------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*----------------------------------------------------------*/
    // Dados Pessoais
    private String nomeCompleto;
    private String dataNascimento;
    private String genero;
    private Boolean estrangeiro;
    /*----------------------------------------------------------*/
    // Documentos
    private String CPF;
    private String RG;
    private String outrosDocumentos;
    /*----------------------------------------------------------*/
    // Comunicação
    private String email;
    private String telefoneCelular;
    private String telefoneFixo;
    /*----------------------------------------------------------*/
    // Associação com a classe Endereco
    @ManyToOne
    @JoinColumn(name = "id_endereco_fk")
    private Endereco endereco;
    /*----------------------------------------------------------*/
    // Dados Acadêmicos e Profissionais
//    private Escolaridade escolaridade;
//    private NivelSerieEscolaridade nivelSerieEscolaridade;
//    private ProfissaoCargoFuncao profissaoCargoFuncao;
//    private OrgaoInstituicaoEmpresa orgaoInstituicaoEmpresa;

    /*----------------------------------------------------------*/
    // Construtor sem argumentos ou vazio
    public Pessoa() {}
    /*----------------------------------------------------------*/
    // Construtor com argumentos
    public Pessoa(
            Long id,
            String nomeCompleto, String dataNascimento, String genero, Boolean estrangeiro,
            String CPF, String RG, String outrosDocumentos,
            String email, String telefoneCelular, String telefoneFixo, Endereco endereco)
    {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.estrangeiro = estrangeiro;
        this.CPF = CPF;
        this.RG = RG;
        this.outrosDocumentos = outrosDocumentos;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.endereco = endereco;
    }

    /*----------------------------------------------------------*/
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setEstrangeiro(Boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }
    public void setOutrosDocumentos(String outrosDocumentos) {
        this.outrosDocumentos = outrosDocumentos;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    /*----------------------------------------------------------*/
    // HashCode e Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getId(), pessoa.getId()) &&
                Objects.equals(getNomeCompleto(), pessoa.getNomeCompleto()) &&
                Objects.equals(getDataNascimento(), pessoa.getDataNascimento()) &&
                Objects.equals(getGenero(), pessoa.getGenero()) &&
                Objects.equals(getEstrangeiro(), pessoa.getEstrangeiro()) &&
                Objects.equals(getCPF(), pessoa.getCPF()) &&
                Objects.equals(getRG(), pessoa.getRG()) &&
                Objects.equals(getOutrosDocumentos(), pessoa.getOutrosDocumentos()) &&
                Objects.equals(getEmail(), pessoa.getEmail()) &&
                Objects.equals(getTelefoneCelular(), pessoa.getTelefoneCelular()) &&
                Objects.equals(getTelefoneFixo(), pessoa.getTelefoneFixo()) &&
                Objects.equals(getEndereco(), pessoa.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getNomeCompleto(),
                getDataNascimento(),
                getGenero(),
                getEstrangeiro(),
                getCPF(), getRG(),
                getOutrosDocumentos(),
                getEmail(),
                getTelefoneCelular(),
                getTelefoneFixo(),
                getEndereco());
    }

}