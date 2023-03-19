package kodlama.io.devs.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {

    private int id;

    @NotNull
    @NotBlank
    @Size(min=2,max = 20)
    private String name;

    private int programmingLanguageId;
}
