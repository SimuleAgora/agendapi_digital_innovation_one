package one.digitalinnovation.agendapi.utils;

import one.digitalinnovation.agendapi.dto.request.FoneDTO;
import one.digitalinnovation.agendapi.entities.Fone;
import one.digitalinnovation.agendapi.enums.FoneType;

public class FoneUtils {

    private static final String PHONE_NUMBER = "3599140-0209";
    private static final FoneType PHONE_TYPE = FoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static FoneDTO createFakeDTO() {
        return FoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Fone createFakeEntity() {
        return Fone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
