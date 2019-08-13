package AOPdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount(){
        System.out.println(getClass() + " Dong stuff: add a membership account");
    }

    public String addAccount(String text){
        System.out.println(getClass() + " Dong stuff: add a membership account with text");
        return text + "From memebership";
    }

    public void goToSleep(){
        System.out.println(getClass() + "I'm going to sleep now..");
    }
}
