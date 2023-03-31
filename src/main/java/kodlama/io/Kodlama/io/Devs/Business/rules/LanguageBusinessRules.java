package kodlama.io.Kodlama.io.Devs.Business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlama.io.Kodlama.io.Devs.dataAcces.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class LanguageBusinessRules{
	private LanguageRepository languageRepository;
	
	public void checkIfLanguageNameExist(String name) {
		if(this.languageRepository.existsByName(name)) {
			throw new BusinessException("Language name  already exist");
		}
	}
	
}
