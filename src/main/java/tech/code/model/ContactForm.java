package tech.code.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "contactform")
public class ContactForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name cannot be empty.")
	@Size(min = 3, max = 30, message = "Invalid Name size.")
	@Column(length = 30)
	private String name;
	
	@NotEmpty(message = "Email cannot be empty.")
	@Size(min = 5, max = 40, message = "Invalid Email size.")
	@Column(length = 40)
	private String email;
	
	@NotNull(message = "Phone no can't be empty.")
	@Min(value = 1000000000, message = "Phone no must be atleast 10 digits.")
	@Max(value = 9999999999L, message = "Phone no must be atleast 10 digits.")
	@Column(length = 10)
	private Long phone;
	
	@NotEmpty(message = "Message cannot be empty.")
	@Size(min = 4, max = 300, message = "Invalid Message size.")
	@Column(length = 300)
	private String message;
}
