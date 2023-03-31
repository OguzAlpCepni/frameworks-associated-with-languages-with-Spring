package kodlama.io.Kodlama.io.Devs.Business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlama.io.Kodlama.io.Devs.dataAcces.abstracts.FrameworkRepository;
import lombok.AllArgsConstructor;
@AllArgsConstructor																	// Autowired sağlar
@Service																			// IOC yerlesindiye
public class FrameworkBusinessRules {
	
	private FrameworkRepository frameworkRepository;								// FrameworkRepository'e gidip ordan ismin almak için kullan
	public void checkIfFrameWorkNameExistsName(String name) {
			if(this.frameworkRepository.existsByName(name))	{						// eger dikkat edersen if(frameworkRepository.find.. name) kısmı yoktur 
					throw new BusinessException("framework already exists");			//JpaRepository implementasyonu burda işleri kolaylaştırıyor .
		
		
			}
	}

}
