package fit.johann.model.battleship;

/**
 * Data about a specific ship
 * @param type SectorType (ShipType)
 * @param xCord x Coordinate of startpostion
 * @param yCord y Coordinate of startpostion
 * @param rotation rotation of the ship
 */
public record ShipData(SectorType type, int xCord,int yCord, int rotation) {}
