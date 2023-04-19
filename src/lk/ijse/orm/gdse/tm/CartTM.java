package lk.ijse.orm.gdse.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartTM {
    private String RoomId;
    private String RoomType;
    private double keyMoney;
    private String status;
}
