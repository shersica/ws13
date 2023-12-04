package sg.edu.nus.ssf.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @AllArgsConstructor
@NoArgsConstructor
public class Contact {
    
    @NotBlank(message = "Please enter your name")
    @Size(min = 3, max = 64, message = "Name must be from 3 to 64 characters")
    private String name;

    @NotBlank(message = "Please enter your email address")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Please enter your phone number")
    // @Digits(integer = 7, fraction = 0)
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number")
    private String phoneNo;

    @NotBlank(message = "Please enter your date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date dateOfBirth;

    private String id;

    public Contact(String name, String email, String phoneNo, Date dateOfBirth, String id){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
        this.id = null;
    }
}
