package kodlama.io.Kodlama.io.Devs.Business.requests.Language;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageRequest {
	@NotNull												// ben simdi bu name alanına veri girilmesini istiyorum . gerekli alan 
	@NotBlank
	private String name;
}
