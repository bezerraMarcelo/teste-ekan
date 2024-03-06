package br.com.ekan.testeEkan.repositories;

import br.com.ekan.testeEkan.domain.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository <Documento, Integer> {
    public List<Documento> findByBeneficiarioId(Integer beneficiarioId);

}
