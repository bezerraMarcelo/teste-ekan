package br.com.ekan.testeEkan.domain.dto;

import br.com.ekan.testeEkan.domain.entity.Documento;

import java.io.Serializable;

public class DocumentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tipoDocumento;
    private String descricao;
	
    public DocumentoDTO() {
        super();
    }
	
    public DocumentoDTO(Documento documento) {
        this.id = documento.getId();
        this.tipoDocumento = documento.getTipoDocumento();
        this.descricao = documento.getDescricao();
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

}
