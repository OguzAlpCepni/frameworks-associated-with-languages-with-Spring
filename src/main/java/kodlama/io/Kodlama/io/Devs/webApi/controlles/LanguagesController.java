package kodlama.io.Kodlama.io.Devs.webApi.controlles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.Business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.Business.requests.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.Business.requests.Language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.Business.responses.Language.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.Business.responses.Language.GetByIdLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
	private LanguageService languageService;
	
	@GetMapping()
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdLanguageResponse getById(@PathVariable int id) { // path den al kullan
		return languageService.getById(id);
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid() CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	@PutMapping()
	public void Update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		this.languageService.update(updateLanguageRequest);
	}
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable int id) {
		this.languageService.Delete(id);
	}
	
}
