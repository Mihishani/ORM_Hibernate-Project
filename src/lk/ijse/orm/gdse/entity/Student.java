package lk.ijse.orm.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Data
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String StuId;
    private String StuName;
    private String StuAddress;
    private int telNumber;
    private LocalDate DateOfBirth;
    private String Gender;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Reservation>reservations=new ArrayList<>();


    public Student(String stuId, String stuName, String stuAddress, int telNumber, LocalDate dateOfBirth, String gender) {
    }


}
