package lk.ijse.orm.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Cacheable
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String UserId;
    private String UserName;
    private int TelNumber;
    private String email;
    private String password;

}
