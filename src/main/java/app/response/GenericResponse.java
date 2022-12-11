package app.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {
    String message;
    Object data;
}
