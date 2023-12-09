// package sg.edu.nus.ssf.repo;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.FileReader;
// import java.io.IOException;
// import java.io.OutputStream;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.stereotype.Repository;

// import sg.edu.nus.ssf.model.Contact;

// @Repository
// public class ContactRepository {
    
//     private List<Contact> contacts = new ArrayList();

//     private List<String> contactDetails;

//     private String dataDir = "/Users/shersica/vttp/data";

//     public void save(Contact contact) throws IOException{
//         contacts.add(contact);
//         File file = new File(dataDir + "/" + contact.getId() + ".txt");
//         OutputStream os = new FileOutputStream(file);
//         PrintWriter pw = new PrintWriter(os);
//         pw.println(contact.getName());
//         pw.println(contact.getEmail());
//         pw.println(contact.getPhoneNo());
//         pw.println(contact.getDateOfBirth());
//         pw.flush();
//         pw.close();
//         os.close();

//     }

//     public List<String> findById(String id) {
//         File f = new File(dataDir);
//         File[] files = f.listFiles();
//         for(File file : files){
//             if(file.getName().equals(id + ".txt")){
//                 f = file;
//             } 
//         }

//         if(f.isDirectory()){
//             contactDetails = new ArrayList();
//             return contactDetails;
//         }

//         // List<String> contactDetails = new ArrayList();

//         try(FileReader fr = new FileReader(f)){
//             BufferedReader br = new BufferedReader(fr);
//             contactDetails = br.lines().toList();
//         } catch (FileNotFoundException e) {
//             System.out.println("Error file exception");
//         } catch (IOException e){
//             System.out.println("IO exception");
//         }

//         return contactDetails;

//     }

//     public Map<String, String> listAll() throws IOException{
//         Map<String,String> contactMap = new HashMap();
//         File f = new File(dataDir);
//         for(File file : f.listFiles()){
//             FileReader fr = new FileReader(file);
//             BufferedReader br = new BufferedReader(fr);
//             contactMap.put(file.getName().substring(0,(file.getName().length()-4)), br.readLine()); //key is id, value is name
//             fr.close();
//         }

//         // for(String key : contactMap.keySet()){
//         //     System.out.printf("Key: %s, Value: %s\n", key, contactMap.get(key));
//         // }
//         return contactMap;
//     }


// }
