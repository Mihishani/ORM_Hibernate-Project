package lk.ijse.orm.gdse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String StuId;
    private String StuName;
    private String StuAddress;
    private int telNumber;
    private LocalDate DateOfBirth;
    private String Gender;
}
