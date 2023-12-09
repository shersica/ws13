// package sg.edu.nus.ssf.controller;

// import java.io.IOException;
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Map;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.FieldError;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import jakarta.validation.Valid;
// import sg.edu.nus.ssf.model.Contact;
// import sg.edu.nus.ssf.repo.ContactRepository;

// @Controller
// @RequestMapping(value={"/", "index.html"})
// public class ContactController {

//     @Autowired
//     ContactRepository contactRepo;

//     @GetMapping("/add")
//     public String addInfo(Model model){
//         Contact contact = new Contact();
//         model.addAttribute("contact", contact);
//         // System.out.println("Get mapping success");
//         return "index";
//     }
    
//     @PostMapping("/contact")
//     public ModelAndView saveContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult binding, Model model) throws IOException{

//         ModelAndView mav = new ModelAndView();

//         if(binding.hasErrors()){
//             mav.setViewName("index");
//             return mav;
//         }

//         UUID uuid = UUID.randomUUID();
//         String id = uuid.toString().split("-")[0];  //or String id = uuid.toString().substring(0,8);
//         contact.setId(id);

//         //Check if age >= 10 and <= 100
//         Integer age = LocalDate.now().getYear() - contact.getDateOfBirth().getYear();
//         // System.out.println(age);
//         if(age < 10 || age > 100){
//             FieldError err = new FieldError("contact", "dateOfBirth", "Cannot be younger than 10 or older than 100");
//             binding.addError(err);
//             // model.addAttribute("ageError","Age must be more than 10 or less than 100");
//             mav.setViewName("index");
//             mav.setStatus(HttpStatus.BAD_REQUEST);
//             return mav;
//         } 

//         contactRepo.save(contact);
//         model.addAttribute("savedContact", contact);
//         mav.setStatus(HttpStatusCode.valueOf(201));
//         mav.setViewName("success");
//         return mav;
//     }

//     @GetMapping("/contact/{id}")
//     public ModelAndView getContact(@PathVariable("id") String id, Model model ){
//         ModelAndView mav = new ModelAndView();
//         List<String> contactInfo = contactRepo.findById(id);

//         if(contactInfo == null || contactInfo.isEmpty()){     
//             mav.setStatus(HttpStatusCode.valueOf(404));
//             mav.setViewName("error404");
//             return mav;
//         }

//         model.addAttribute("name", contactInfo.get(0));
//         model.addAttribute("email", contactInfo.get(1));
//         model.addAttribute("phoneNo", contactInfo.get(2));
//         model.addAttribute("dateOfBirth", contactInfo.get(3));

//         mav.setViewName("contactdetails");
//         return mav;
//     }

//     @GetMapping("/list")
//     public String list(Model model) throws IOException{
//         Map<String,String> contacts = contactRepo.listAll();
//         model.addAttribute("contacts", contacts);
//         return "contacts";
//     }

// }
