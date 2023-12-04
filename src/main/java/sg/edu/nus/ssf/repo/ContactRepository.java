package sg.edu.nus.ssf.repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.ssf.model.Contact;

@Repository
public class ContactRepository {
    
    private List<Contact> contacts;

    private String dataDir = "/Users/shersica/vttp/data";

    public void save(Contact contact) throws IOException{

        File file = new File(dataDir + "/" + contact.getId() + ".txt");
        OutputStream os = new FileOutputStream(file);
        PrintWriter pw = new PrintWriter(os);
        pw.println(contact.getName());
        pw.println(contact.getEmail());
        pw.println(contact.getPhoneNo());
        pw.println(contact.getDateOfBirth());
        pw.flush();
        pw.close();
        os.close();

    }

}
