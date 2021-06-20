package one.digitalinnovation.agendapi.mapper;

import one.digitalinnovation.agendapi.dto.mapper.PessoaMapper;
import one.digitalinnovation.agendapi.dto.request.FoneDTO;
import one.digitalinnovation.agendapi.dto.request.PessoaDTO;
import one.digitalinnovation.agendapi.entities.Fone;
import one.digitalinnovation.agendapi.entities.Pessoa;
import one.digitalinnovation.agendapi.utils.PessoaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PessoaMapperTest {

    @Autowired
    private PessoaMapper pessoaMapper;

    @Test
    void testGivenPessoaDTOThenReturnPessoaEntity() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getFirstName(), pessoa.getFirstName());
        assertEquals(pessoaDTO.getLastName(), pessoa.getLastName());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Fone fone = pessoa.getPhones().get(0);
        FoneDTO foneDTO = pessoaDTO.getPhones().get(0);

        assertEquals(foneDTO.getType(), fone.getType());
        assertEquals(foneDTO.getNumber(), fone.getNumber());
    }

    @Test
    void testGivenPessoaEntityThenReturnPessoaDTO() {
        Pessoa pessoa = PessoaUtils.createFakeEntity();
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        assertEquals(pessoa.getFirstName(), pessoaDTO.getFirstName());
        assertEquals(pessoa.getLastName(), pessoaDTO.getLastName());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Fone fone = pessoa.getPhones().get(0);
        FoneDTO foneDTO = pessoaDTO.getPhones().get(0);

        assertEquals(fone.getType(), foneDTO.getType());
        assertEquals(fone.getNumber(), foneDTO.getNumber());
    }
}
