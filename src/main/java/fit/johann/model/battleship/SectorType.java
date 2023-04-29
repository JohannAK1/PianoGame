package fit.johann.model.battleship;

public enum SectorType {
    MINE (1), WATER (1), CRUISER(2), CARRIER(4), UBOAT(3), BATTLESHIP(4);

    // Normal Length of SectorType
    public final int length;

    SectorType(int length) {
        this.length = length;
    }
}
