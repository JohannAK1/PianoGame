package fit.johann.model.battleship;

public class Sector {

    // Sector hit, Explored
    private boolean wasHit;
    private final SectorType sectorType;

    /**
     * Create new Sector with a specific Type
     * @param sectorType Type (SHIP,MINE, Water)
     */
    public Sector(SectorType sectorType){
        this.sectorType = sectorType;
        wasHit = false;
    }

    /**
     * @return the Type of teh Sector
     */
    public SectorType getSectorType() {
        return sectorType;
    }

    /**
     * @return if sector was hit / explored or not
     */
    public boolean isWasHit() {
        return wasHit;
    }

    /**
     * Sector was hit, change of attribute has to occur
     */
    public void wasHit() {
        this.wasHit = true;
    }



}
