package kodlama.io.Kodlama.io.Devs.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.Framework;

public interface FrameworkRepository extends JpaRepository<Framework, Integer>{
	boolean existsByName(String name);  // Spring jpa bizim özel keyWord sunar "exists" gördüğü an bize bir sordu oluşturuyor
}										//"find " Spring JPA keywords bakman yeterli olur 
