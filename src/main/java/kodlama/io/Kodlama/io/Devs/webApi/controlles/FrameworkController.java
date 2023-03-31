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

import kodlama.io.Kodlama.io.Devs.Business.abstracts.FrameworkService;
import kodlama.io.Kodlama.io.Devs.Business.requests.framework.CreateFrameworkRequest;
import kodlama.io.Kodlama.io.Devs.Business.requests.framework.UpdateFrameworkRequest;
import kodlama.io.Kodlama.io.Devs.Business.responses.framework.GetAllFrameworkResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/frameworks")
@AllArgsConstructor
public class FrameworkController {

	private FrameworkService frameworkService;
	
	@GetMapping()
	public List<GetAllFrameworkResponse> getAll(){
		return frameworkService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateFrameworkRequest createFrameworkRequest) {
		this.frameworkService.add(createFrameworkRequest);
	}
	@PutMapping()
	public void update(@RequestBody() @Valid() UpdateFrameworkRequest updateFrameworkRequest) {
		this.frameworkService.update(updateFrameworkRequest);
	}
	@GetMapping("/{id}")
	public void getById(@PathVariable int id) {
		this.frameworkService.getById(id);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.frameworkService.delete(id);
	}
	
}
