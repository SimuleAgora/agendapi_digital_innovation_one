package one.digitalinnovation.agendapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
