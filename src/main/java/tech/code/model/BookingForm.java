package tech.code.model;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "bookingform")
public class BookingForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name can't be empty")
	@NotBlank(message = "Name can't be blank")
	@Size(min = 2, max = 30, message = "invalid name length")
	@Pattern(regexp = "^[A-za-z]+$", message = "Name must contain only alphabet")
	@Column(length = 30)
	private String name;

	@NotEmpty(message = "Source can't be empty")
	@NotBlank(message = "Source can't be blank")
	@Size(min = 4, max = 30, message = "invalid source length")
	@Column(length = 30)
	private String source;
	
	@NotEmpty(message = "Email can't be empty")
	@NotBlank(message = "Email can't be blank")
	@Size(min = 8, max = 50, message = "invalid email length")
	@Column(length = 50)
	private String email;
	
	@NotEmpty(message = "Desination can't be empty")
	@NotBlank(message = "Desination can't be blank")
	@Size(min = 4, max = 30, message = "invalid Desination length")
	@Column(length = 30)
	private String destination;
	
	@NotNull(message = "Time can't be empty")
	private LocalTime time;
	
	@NotNull(message = "Date can't be empty")
	private LocalDate date;
	
	@NotEmpty(message = "Comfort can't be empty")
	@Column(length = 20)
	private String comfort;
	
	@Min(value=1, message="Adult can be at least 1")
	@Max(value=4, message="Adult can be at most 4")
	private int adult;
	
	@Max(value = 3, message = "Children can be at most 3")
	private int children;
	
	@NotEmpty(message = "Message can't be empty")
	@NotBlank(message = "Message can't be blank")
	@Size(min = 5, max = 1000, message = "invalid message length")
	@Column(length = 1000)
	private String message;
}
