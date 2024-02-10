package MappingPassport.MappingPassportDemo.PayLoad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonPassport {
    private String personName;
    private int personAge;
    private double personSalary;
    private String passportNumber;
    private String passportCountry;
}
