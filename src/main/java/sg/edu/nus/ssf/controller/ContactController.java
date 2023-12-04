package sg.edu.nus.ssf.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import sg.edu.nus.ssf.model.Contact;
import sg.edu.nus.ssf.repo.ContactRepository;

@Controller
@RequestMapping(value={"/", "index.html"})
public class ContactController {

    @Autowired
    ContactRepository contactRepo;

    @GetMapping("/add")
    public String addInfo(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);

        return "index";
    }
    
    @PostMapping("/contact")
    public ModelAndView saveContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult binding, Model model) throws IOException{

        ModelAndView mav = new ModelAndView();

        if(binding.hasErrors()){
            mav.setViewName("index");
            return mav;
        }

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().split("-")[0];  //or String id = uuid.toString().substring(0,8);
        contact.setId(id);
        
        contactRepo.save(contact);
        model.addAttribute("savedContact", contact);
        mav.setStatus(HttpStatusCode.valueOf(201));
        mav.setViewName("success");
        return mav;
  
    }

}
