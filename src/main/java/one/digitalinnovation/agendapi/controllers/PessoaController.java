package one.digitalinnovation.agendapi.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.agendapi.dto.request.PessoaDTO;
import one.digitalinnovation.agendapi.exception.PessoaNotFoundException;
import one.digitalinnovation.agendapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.agendapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaController {

    private PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.create(pessoaDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaDTO findById(@PathVariable Long id) throws PessoaNotFoundException {
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> listAll() {
                return pessoaService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        return pessoaService.update(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PessoaNotFoundException {
        pessoaService.delete(id);
    }
}
