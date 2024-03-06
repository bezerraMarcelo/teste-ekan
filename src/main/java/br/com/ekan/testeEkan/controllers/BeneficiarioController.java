package br.com.ekan.testeEkan.controllers;

import br.com.ekan.testeEkan.domain.dto.BeneficiarioDTO;
import br.com.ekan.testeEkan.domain.dto.DocumentoDTO;
import br.com.ekan.testeEkan.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @PostMapping
    public ResponseEntity<BeneficiarioDTO> create(@RequestBody BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioDTO dto = service.create(beneficiarioDTO);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> getALl() {
        List<BeneficiarioDTO> listDTO = service.findAll();
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{beneficiarioId}/documentos")
    public ResponseEntity<List<DocumentoDTO>> getDocumentosByBeneficiarioId(@PathVariable Integer beneficiarioId) {
        List<DocumentoDTO> listDTO = service.findAllDocumentosByBeneficiarioId(beneficiarioId);
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BeneficiarioDTO> update(@PathVariable Integer id, @RequestBody BeneficiarioDTO beneficiarioDTO){
        BeneficiarioDTO obj = service.update(id, beneficiarioDTO);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BeneficiarioDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
