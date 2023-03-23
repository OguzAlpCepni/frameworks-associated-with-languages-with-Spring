package kodlama.io.Kodlama.io.Devs.Business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.Business.requests.framework.CreateFrameworkRequest;
import kodlama.io.Kodlama.io.Devs.Business.requests.framework.UpdateFrameworkRequest;
import kodlama.io.Kodlama.io.Devs.Business.responses.framework.GetAllFrameworkResponse;
import kodlama.io.Kodlama.io.Devs.Business.responses.framework.GetByIdFrameworkResponse;

public interface FrameworkService {
	
	List<GetAllFrameworkResponse> getAll();
	void add(CreateFrameworkRequest createFrameworkRequest);
	void update(UpdateFrameworkRequest updateFrameworkRequest);
	GetByIdFrameworkResponse getById(int id);
	void delete(int id);
}
