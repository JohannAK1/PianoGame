package fit.johann.model.battleship;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.awt.*;

@Entity
public class ShipDataPer {
    @Id
    int id;
    @Column
    Point position;
    @Column
    int rotation;
    @Column
    Gameobject shipType;

    public ShipDataPer(Point position, int rotation, Gameobject shipType) {
        this.position = position;
        this.rotation = rotation;
        this.shipType = shipType;
    }

    public ShipDataPer() {
    }
}
