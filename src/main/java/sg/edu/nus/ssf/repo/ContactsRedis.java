package sg.edu.nus.ssf.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.ssf.model.Contact;

@Repository
public class ContactsRedis {
    
    @Autowired @Qualifier("myredis")
    private RedisTemplate<String,String> template;

    public void save(Contact contact){
        HashOperations<String, String, String> hashOps = template.opsForHash();
        hashOps.put(contact.getId(), "name", contact.getName());
        hashOps.put(contact.getId(), "email", contact.getEmail());
        hashOps.put(contact.getId(), "phoneNo", contact.getPhoneNo());
        hashOps.put(contact.getId(), "dateOfBirth", contact.getDateOfBirth().toString());

    }    

    public Map<String, String> listAll(){
        HashOperations<String, String, String> hashOps = template.opsForHash();
        Map<String, String> contactMap = new HashMap<>();

        if(template.keys("********") == null){
            return contactMap;
        }

        // System.out.println(hashOps.get("af058ade", "name"));

        for (String userId : template.keys("********")){
            String name = hashOps.get(userId, "name");
            contactMap.put(userId, name);
        }
        // for(String id : contactMap.keySet()){
        //     System.out.printf("Id: %s, Name: %s\n", id, contactMap.get(id));
        // }
        return contactMap;

    }

    public List<String> findById(String id){
        HashOperations<String, String, String> hashOps = template.opsForHash();
        List<String> details = new ArrayList<>();

        if(template.hasKey(id)){
            details.add(hashOps.get(id, "name"));
            details.add(hashOps.get(id, "email"));
            details.add(hashOps.get(id, "phoneNo"));
            details.add(hashOps.get(id, "dateOfBirth"));
        }

        return details;
    }
}
