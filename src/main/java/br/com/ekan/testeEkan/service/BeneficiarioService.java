package br.com.ekan.testeEkan.service;

import br.com.ekan.testeEkan.domain.dto.BeneficiarioDTO;
import br.com.ekan.testeEkan.domain.dto.DocumentoDTO;
import br.com.ekan.testeEkan.domain.entity.Beneficiario;
import br.com.ekan.testeEkan.domain.entity.Documento;
import br.com.ekan.testeEkan.repositories.BeneficiarioRepository;
import br.com.ekan.testeEkan.repositories.DocumentoRepository;
import br.com.ekan.testeEkan.service.exceptions.DataIntegrityViolationException;
import br.com.ekan.testeEkan.service.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    @Autowired
    private DocumentoRepository documentoRepository;

    public void validarDocumentos(BeneficiarioDTO beneficiarioDTO) {
        if (beneficiarioDTO.getDocumentos().isEmpty()) {
            throw new DataIntegrityViolationException("Beneficiário sem documentos");
        }
    }

    public BeneficiarioDTO create(BeneficiarioDTO beneficiarioDTO) {
        this.validarDocumentos(beneficiarioDTO);
        Beneficiario beneficiarioEntity = repository.save(new Beneficiario(beneficiarioDTO));
        BeneficiarioDTO beneficiarioDTOReturn = new BeneficiarioDTO(beneficiarioEntity);
        return beneficiarioDTOReturn;
    }

    public List<BeneficiarioDTO> findAll() {
        List<Beneficiario> lista = repository.findAll();
        List<BeneficiarioDTO> listaDTO = lista.stream().map(obj -> new BeneficiarioDTO(obj)).collect(Collectors.toList());
        return listaDTO;
    }

    public List<DocumentoDTO> findAllDocumentosByBeneficiarioId(Integer beneficiarioId) {
        List<Documento> lista =  documentoRepository.findByBeneficiarioId(beneficiarioId);
        List<DocumentoDTO> listaDTO = lista.stream().map(obj -> new DocumentoDTO(obj)).collect(Collectors.toList());
        return listaDTO;
    }

    private Beneficiario findById(Integer id) {
        Optional<Beneficiario> beneficiarioEntity = repository.findById(id);
        return beneficiarioEntity.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não foi encontrado! Id: " + id));
    }

    private void setarAlteracoes(Integer beneficiarioId, Beneficiario beneficiario, BeneficiarioDTO beneficiarioDTO) {
        beneficiario.setDataAtualizacao(LocalDate.now());
        beneficiario.setNome(beneficiarioDTO.getNome());
        beneficiario.setTelefone(beneficiario.getTelefone());
        beneficiario.setDataNascimento(beneficiario.getDataNascimento());

        for (Documento documento : beneficiario.getDocumentos()) {
            for (DocumentoDTO documentoDTO : beneficiarioDTO.getDocumentos()) {
                if (documento.getId() == documentoDTO.getId()) {
                    documento.setDataAtualizacao(LocalDate.now());
                    documento.setTipoDocumento(documentoDTO.getTipoDocumento());
                    documento.setDescricao(documentoDTO.getDescricao());
                }
            }
        }
    }

    public BeneficiarioDTO update(Integer id, BeneficiarioDTO beneficiarioDTO) {
        Beneficiario beneficiarioOld = findById(id);
        this.setarAlteracoes(id, beneficiarioOld, beneficiarioDTO);
        Beneficiario beneficiario = repository.save(beneficiarioOld);
        BeneficiarioDTO dtoReturn = new BeneficiarioDTO(repository.save(beneficiarioOld));
        return dtoReturn;
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ObjectNotFoundExceptions("Beneficiario não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }

}
