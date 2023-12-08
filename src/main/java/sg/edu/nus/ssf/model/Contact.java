package sg.edu.nus.ssf.model;

import java.time.LocalDate;
// import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    
    @NotNull(message = "Please enter your name")
    @Size(min = 3, max = 64, message = "Name must be from 3 to 64 characters")
    private String name;

    @NotBlank(message = "Please enter your email address")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Please enter your phone number")
    // @Digits(integer = 7, fraction = 0)
    //@Size(min=7, message = "at least 7 digits")
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number")
    private String phoneNo;

    @NotNull(message = "Please enter your date of birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    private String id;

    public Contact(String name, String email, String phoneNo, LocalDate dateOfBirth, String id){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
        this.id = null;
    }
}
