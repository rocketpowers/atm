package atmPackages.model;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	
	@NotBlank(message = "fill in the field !")
	@Pattern(regexp = "[a-z]+", message = "only lowercase letters")
	private String name;
	
	@Pattern(regexp = "[a-z]+", message = "only lowercase letters")
	@NotBlank(message=" fill in the field !")
	private String lastName;

	@Column(unique = true)
	@CPF
	@NotBlank(message=" fill in the field !")
	private String cpf;

	@Pattern(regexp = "[0-9]+", message = "only numbers ")
	//@Min(value = 10)
	//@Max(value = 11)
	@NotBlank(message=" fill in the field !")
	private String phone;

}
