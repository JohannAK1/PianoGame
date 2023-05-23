package fit.johann.model.battleship;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class GameBoardPre {
    @Id
    private int id;

    @ElementCollection
    private List<Point> shots;
    @ElementCollection
    private List<ShipDataPer> shipLocations;
    @Column
    private int size;

    public GameBoardPre() {
    }

    public GameBoardPre(int size) {
        this.size = size;
        this.shipLocations = new ArrayList<>();
        this.shots = new ArrayList<>();
    }

    public void shoot(Point hitPos){
        shots.add(hitPos);
    }

    public void setObject(Gameobject object, Point pos, int rotation){
        if(rotation == 0 && (size-1 < pos.y-1+object.length)) return;
        if(rotation == 1 && (0 > pos.x+1-object.length)) return;
        for (int i = 0; i < object.length; i++){
            if(rotation == 0){
                if(hasShip(new Point(pos.x, pos.y+i))) return;
            }
            else {
                if(hasShip(new Point(pos.x+1, pos.y))) return;
            }
        }
        ShipDataPer newObject = new ShipDataPer(pos,rotation,object);
        shipLocations.add(newObject);
    }

    private boolean hasShip(Point pos){
        for (ShipDataPer data: shipLocations){
            int dataShipLength = data.shipType.length;
            if(data.rotation == 0){
                for (int i = 0; i < dataShipLength; i++){
                    if(pos.equals(new Point(data.position.x,data.position.y+i))) return true;
                }
            }
            else {
                for (int i = 0; i < dataShipLength; i++){
                    if(pos.equals(new Point(data.position.x+i,data.position.y))) return true;
                }
            }
        }
        return false;
    }


}
