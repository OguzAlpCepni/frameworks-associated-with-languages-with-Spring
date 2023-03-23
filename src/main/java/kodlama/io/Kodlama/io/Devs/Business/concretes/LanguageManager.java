package kodlama.io.Kodlama.io.Devs.Business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.Business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.Business.requests.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.Business.requests.Language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.Business.responses.Language.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.Business.responses.Language.GetByIdLanguageResponse;
import kodlama.io.Kodlama.io.Devs.Business.rules.LanguageBusinessRules;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAcces.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;
	private LanguageBusinessRules languageBusinessRules;
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> getAllLanguageResponses = languages.stream().map(language->this.modelMapperService.forResponse().map(language, GetAllLanguageResponse.class)).collect(Collectors.toList());										
				
				
		return getAllLanguageResponses;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = this.languageRepository.findById(id).orElseThrow();
		GetByIdLanguageResponse getByIdLanguageResponse = this.modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
		return getByIdLanguageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageBusinessRules.checkIfLanguageNameExist(createLanguageRequest.getName());
		Language language = this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
		
		this.languageRepository.save(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = this.modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
		
		this.languageRepository.save(language);
	}

	@Override
	public void Delete(int id) {
		this.languageRepository.deleteById(id);
		
	}
	
}
