package br.com.ekan.testeEkan.domain.dto;

import br.com.ekan.testeEkan.domain.entity.Beneficiario;
import br.com.ekan.testeEkan.domain.entity.Documento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeneficiarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String telefone;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private List<DocumentoDTO> documentos = new ArrayList<>();

    public BeneficiarioDTO() {
        super();
    }
    public BeneficiarioDTO(Beneficiario beneficiario) {
        this.id = beneficiario.getId();
        this.nome = beneficiario.getNome();
        this.telefone = beneficiario.getTelefone();
        this.dataNascimento = beneficiario.getDataNascimento();
        this.documentos = beneficiario.getDocumentos().stream().map(obj -> new DocumentoDTO(obj)).collect(Collectors.toList());
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

    public List<DocumentoDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoDTO> documentos) {
        this.documentos = documentos;
    }
}
