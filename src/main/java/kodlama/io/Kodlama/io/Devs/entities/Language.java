package kodlama.io.Kodlama.io.Devs.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id yi sen otomatik arttır 
	@Column(name="id")  // Languages tablosundaki id sutunusun
    private int id;
	
	@Column(name="name")
    private String name;
	
	@OneToMany(mappedBy = "language")
	private List<Framework>frameworks;
	
	
   
}