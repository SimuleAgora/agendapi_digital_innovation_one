package one.digitalinnovation.agendapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.agendapi.enums.FoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private FoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
