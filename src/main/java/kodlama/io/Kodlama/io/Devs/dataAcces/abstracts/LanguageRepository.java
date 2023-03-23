package kodlama.io.Kodlama.io.Devs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer>{ // primary key integer 
	boolean existsByName(String name);
	
	
}
