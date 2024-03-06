package br.com.ekan.testeEkan.domain.entity;

import br.com.ekan.testeEkan.domain.dto.DocumentoDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipoDocumento;
    private String descricao;
    private LocalDate dataInclusao = LocalDate.now();
    private LocalDate dataAtualizacao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    public Documento() {
        super();
    }

    public Documento(Integer id, String tipoDocumento, String descricao, LocalDate dataAtualizacao) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Documento(DocumentoDTO documentoDTO, Beneficiario beneficiario) {
        this.id = documentoDTO.getId();
        this.tipoDocumento = documentoDTO.getTipoDocumento();
        this.descricao = documentoDTO.getDescricao();
        this.beneficiario = beneficiario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }
}

