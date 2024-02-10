package MappingPassport.MappingPassportDemo.Service;
import MappingPassport.MappingPassportDemo.Model.Passport;
import MappingPassport.MappingPassportDemo.Model.Person;
import MappingPassport.MappingPassportDemo.PayLoad.PersonPassport;
import MappingPassport.MappingPassportDemo.Repository.PassportRepository;
import MappingPassport.MappingPassportDemo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;


    public void saveData(PersonPassport temp){

        Person p1=new Person();

        Passport pass=new Passport();


        p1.setPersonName(temp.getPersonName());
        p1.setPersonAge(temp.getPersonAge());
        p1.setPersonSalary(temp.getPersonSalary());

        pass.setPassportNumber(temp.getPassportNumber());
        pass.setPassportCountry(temp.getPassportCountry());


        p1.setPassportRef(pass);
        personRepository.save(p1);

    }
    public List<Person> getData(){
       return personRepository.findAll();
    }

    public List<Passport> getPassportInformation(){
       return passportRepository.findAll();
    }


    public void updatePassportNumber( int passportId, String passportNumber){

        passportRepository.updatePassportNumber(passportId,passportNumber);

    }
    public void updatePassportCountry( int perId, String country){
        Person p= personRepository.getPersonObject(perId);
        Passport pass= p.getPassportRef();
        pass.setPassportCountry(country);

        personRepository.save(p);

    }

    public Person getPersonDataById(int id){
        return personRepository.getPersonObject(id);
    }

    public void deleteById(int id) {
        Person person = personRepository.getPersonObject(id);
        if (person != null) {
            Passport passport = person.getPassportRef();
            personRepository.delete(person);
            passportRepository.delete(passport);
        }
    }
}
