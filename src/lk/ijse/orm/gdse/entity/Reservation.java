package lk.ijse.orm.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Cacheable
public class Reservation {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ResId;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "StuId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    private Room room;

    private String status;
}
