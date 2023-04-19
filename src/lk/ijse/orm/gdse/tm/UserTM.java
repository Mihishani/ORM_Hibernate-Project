package lk.ijse.orm.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTM {
    private String UserId;
    private String UserName;
    private int TelNumber;
    private String email;
    private String password;
}
