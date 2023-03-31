package kodlama.io.Kodlama.io.Devs.Business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.Business.abstracts.FrameworkService;
import kodlama.io.Kodlama.io.Devs.Business.requests.framework.CreateFrameworkRequest;
import kodlama.io.Kodlama.io.Devs.Business.requests.framework.UpdateFrameworkRequest;
import kodlama.io.Kodlama.io.Devs.Business.responses.framework.GetAllFrameworkResponse;
import kodlama.io.Kodlama.io.Devs.Business.responses.framework.GetByIdFrameworkResponse;
import kodlama.io.Kodlama.io.Devs.Business.rules.FrameworkBusinessRules;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAcces.abstracts.FrameworkRepository;
import kodlama.io.Kodlama.io.Devs.entities.Framework;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService{

	private FrameworkRepository frameworkRepository;
	private ModelMapperService modelMapperService;
	private FrameworkBusinessRules frameworkBusinessRules;
	
	@Override
	public List<GetAllFrameworkResponse> getAll() {
		List<Framework> frameworks = frameworkRepository.findAll();
		List<GetAllFrameworkResponse> getAllFrameworkResponses = frameworks.stream().map(framework->this.modelMapperService.forResponse().map(framework, GetAllFrameworkResponse.class)).collect(Collectors.toList());										
				
				
		return getAllFrameworkResponses;
	}
	@Override
	public void add(CreateFrameworkRequest createFrameworkRequest) {
		this.frameworkBusinessRules.checkIfFrameWorkNameExistsName(createFrameworkRequest.getName());               // gelen requestin namesinden alıcam ve koyucam 
		Framework framework = this.modelMapperService.forRequest().map(createFrameworkRequest, Framework.class);
		this.frameworkRepository.save(framework);
	}
	
		
	
	
	@Override
	public void delete(int id) {
		this.frameworkRepository.deleteById(id);
		
	}
	@Override
	public void update(UpdateFrameworkRequest updateFrameworkRequest) {
		Framework framework = this.modelMapperService.forRequest().map(updateFrameworkRequest, Framework.class);
		this.frameworkRepository.save(framework);
		
	}
	@Override
	public GetByIdFrameworkResponse getById(int id) {
		Framework framework = this.frameworkRepository.findById(id).orElseThrow();
		GetByIdFrameworkResponse getByIdFrameworkResponse = this.modelMapperService.forResponse().map(framework, GetByIdFrameworkResponse.class);
		
		return getByIdFrameworkResponse;
	}
	
	
	
}
