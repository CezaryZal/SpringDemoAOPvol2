package AOPdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public AccountDAO() {
    }

    public AccountDAO(String name, String serviceCode) {
        this.name = name;
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println(getClass() + " :in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " :in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " :in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " :in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void  addAccount(){
        System.out.println(getClass() + " :Doing my db work: adding an account");
    }

    public String makeSomething(){
        System.out.println(getClass() + " :made something else");
        return "It's done";
    }
}
