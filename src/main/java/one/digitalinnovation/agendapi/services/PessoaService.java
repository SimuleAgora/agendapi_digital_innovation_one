package one.digitalinnovation.agendapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.agendapi.entities.Pessoa;
import one.digitalinnovation.agendapi.exception.PessoaNotFoundException;
import one.digitalinnovation.agendapi.dto.mapper.PessoaMapper;
import one.digitalinnovation.agendapi.dto.request.PessoaDTO;
import one.digitalinnovation.agendapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.agendapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper;

    public MessageResponseDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        MessageResponseDTO messageResponse = createMessageResponse("Pessoa successfully created with ID ", savedPessoa.getId());

        return messageResponse;
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        return pessoaMapper.toDTO(pessoa);
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> people = pessoaRepository.findAll();
        return people.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        Pessoa updatedPessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(updatedPessoa);

        MessageResponseDTO messageResponse = createMessageResponse("Pessoa successfully updated with ID ", savedPessoa.getId());

        return messageResponse;
    }

    public void delete(Long id) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        pessoaRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
