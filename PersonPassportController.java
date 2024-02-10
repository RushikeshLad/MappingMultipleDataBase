package MappingPassport.MappingPassportDemo.Controller;

import MappingPassport.MappingPassportDemo.Model.Passport;
import MappingPassport.MappingPassportDemo.Model.Person;
import MappingPassport.MappingPassportDemo.PayLoad.PersonPassport;
import MappingPassport.MappingPassportDemo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonPassportController {
    @Autowired
    private Service service;

    @PostMapping("/saveData")
    public void saveInformation( @RequestBody PersonPassport temp){
        service.saveData(temp);
    }
    // get person and passport info & person info
    @GetMapping("/getData")
    public List<Person> getData(){
       return service.getData();
    }

    // get particular information of passport
    @GetMapping("/getPassportInfo")
   public List<Passport> getPassportInformation(){
       return service.getPassportInformation();
    }

    // delete Person Information By id
    @DeleteMapping("/deleteById/{perId}")
    public void deleteById( @PathVariable(name = "perId") int id){
        service.deleteById(id);
    }

    // update passport data
    @PutMapping("/updatePassportNumber")
    public void updatePassportData( @RequestParam int pId,@RequestParam String pNumber){
        service.updatePassportNumber(pId,pNumber);
    }

    // UPDATE PASSPORT COUNTRY BY ID
    @PutMapping("/updatePassportCountryById/{perId}/{country}")
    public void updatePassportCountry(@PathVariable int perId,@PathVariable String country ){
        service.updatePassportCountry(perId,country);

    }
    // get person data by id
    @GetMapping("/getPersonObject/{perId}")
    public Person getPersonObject(@PathVariable(name = "perId") int perId){
       return service.getPersonDataById(perId);
    }


}
