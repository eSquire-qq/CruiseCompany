package validation;

import com.example.cruisecompany.entity.User;
import com.example.cruisecompany.service.ValidationForm;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    User user = new User();

    @Test
    public void isValidate(){
        ValidationForm.validate(user);
    }

}
