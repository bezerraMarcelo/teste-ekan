package br.com.ekan.testeEkan.domain.entity;

import br.com.ekan.testeEkan.domain.dto.BeneficiarioDTO;
import br.com.ekan.testeEkan.domain.dto.DocumentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Beneficiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(length = 15)
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataInclusao = LocalDate.now();
    private LocalDate dataAtualizacao;
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "beneficiario")
    private List<Documento> documentos = new ArrayList<>();
    public Beneficiario() {
        super();
    }
    public Beneficiario(Integer id, String nome, String telefone, LocalDate dataNascimento, LocalDate dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Beneficiario(BeneficiarioDTO beneficiarioDTO) {
        this.id = beneficiarioDTO.getId();
        this.nome = beneficiarioDTO.getNome();
        this.telefone = beneficiarioDTO.getTelefone();
        this.dataNascimento = beneficiarioDTO.getDataNascimento();
        this.documentos = beneficiarioDTO.getDocumentos().stream().map(obj -> new Documento(obj, this  )).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiario that = (Beneficiario) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
