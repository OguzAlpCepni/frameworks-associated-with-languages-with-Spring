package kodlama.io.Kodlama.io.Devs.Business.requests.framework;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameworkRequest {
	@NotBlank
	@NotNull
	@Size(min=3,max=20)
	private String name;
	@NotBlank
	@NotNull
	private int languageId;

}
