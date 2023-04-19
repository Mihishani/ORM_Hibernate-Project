package lk.ijse.orm.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomTM {
    private String RoomId;
    private String RoomType;
    private double keyMoney;
    private int qty;

}
