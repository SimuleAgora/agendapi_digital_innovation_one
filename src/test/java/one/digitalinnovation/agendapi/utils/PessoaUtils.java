package one.digitalinnovation.agendapi.utils;

import one.digitalinnovation.agendapi.dto.request.PessoaDTO;
import one.digitalinnovation.agendapi.entities.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String FIRST_NAME = "William";
    private static final String LAST_NAME = "Silva";
    private static final String CPF_NUMBER = "376.218.077-65";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2009, 10, 1);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(FoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(FoneUtils.createFakeEntity()))
                .build();
    }




}
