package tech.code.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "service")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String image;
	
	@NotEmpty(message = "Title can't be empty")
	@NotBlank(message = "Title can't be blank")
	@Size(min = 3, max = 50, message = "invalid message length")
	@Column(length = 50)
	private String title;
	
	@NotEmpty(message = "Description can't be empty")
	@NotBlank(message = "Description can't be blank")
	@Size(min = 5, max = 500, message = "invalid message length")
	@Column(length = 500)
	private String description;
	
}
