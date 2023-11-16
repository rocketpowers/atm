package atmPackages.model;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	
	@Pattern(regexp = "[a-z]+")
	@NotBlank
	private String name;

	@NotBlank
	private String lastName;

	@Column(unique = true)
	@CPF
	@NotBlank
	private String cpf;

	@NotBlank
	private String phone;

}
