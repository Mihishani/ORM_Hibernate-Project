package lk.ijse.orm.gdse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private String ResId;
    private LocalDate date;
    private String status;
    private String StuId;
    private String StuName;
    private String RoomId;
    private String RoomType;
    private double keyMoney;
}
