package lk.ijse.orm.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String RoomId;
    private String RoomType;
    private double keyMoney;
    private int qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Reservation> reservations=new ArrayList<>();

    public Room(String roomId, String roomType, double keyMoney, int qty) {
    }
}
