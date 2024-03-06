package br.com.ekan.testeEkan.repositories;

import br.com.ekan.testeEkan.domain.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository <Beneficiario, Integer> {

}
