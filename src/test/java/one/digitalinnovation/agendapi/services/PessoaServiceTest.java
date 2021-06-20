package one.digitalinnovation.agendapi.services;

import one.digitalinnovation.agendapi.dto.mapper.PessoaMapper;
import one.digitalinnovation.agendapi.dto.request.PessoaDTO;
import one.digitalinnovation.agendapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.agendapi.entities.Pessoa;
import one.digitalinnovation.agendapi.repositories.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.agendapi.utils.PessoaUtils.createFakeDTO;
import static one.digitalinnovation.agendapi.utils.PessoaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPessoaDTOThenReturnSuccessSavedMessage() {
        PessoaDTO pessoaDTO = createFakeDTO();
        Pessoa expectedSavedPessoa = createFakeEntity();

        when(pessoaMapper.toModel(pessoaDTO)).thenReturn(expectedSavedPessoa);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPessoa);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPessoa.getId());
        MessageResponseDTO successMessage = pessoaService.create(pessoaDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPessoaId) {
        return MessageResponseDTO.builder()
                .message("Pessoa susseco na criacao com ID " + savedPessoaId)
                .build();
    }

}
