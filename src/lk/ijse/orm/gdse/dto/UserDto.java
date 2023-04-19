package lk.ijse.orm.gdse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String UserId;
    private String UserName;
    private int TelNumber;
    private String email;
    private String password;
}
