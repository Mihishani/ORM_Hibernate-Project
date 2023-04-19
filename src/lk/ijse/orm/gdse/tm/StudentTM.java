package lk.ijse.orm.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTM {

    private String StuId;
    private String StuName;
    private String StuAddress;
    private int telNumber;
    private LocalDate DateOfBirth;
    private String Gender;
}
