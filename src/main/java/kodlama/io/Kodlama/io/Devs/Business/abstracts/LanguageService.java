package kodlama.io.Kodlama.io.Devs.Business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.Business.requests.Language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.Business.requests.Language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.Business.responses.Language.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.Business.responses.Language.GetByIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();
	GetByIdLanguageResponse getById(int id);
	void add(CreateLanguageRequest createLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest);
	void Delete(int id);
}
