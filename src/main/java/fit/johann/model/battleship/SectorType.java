package fit.johann.model.battleship;

public enum SectorType {
    MINE (1, "", false, "Mine"),
    WATER (1, "src/main/resources/boat_Img/water",false, "Water"),
    CRUISER(2, "src/main/resources/boat_Img/cruiser", true, "Cruiser"),
    CARRIER(4, "src/main/resources/boat_Img/carrier", true, "Carrier"),
    UBOAT(3, "src/main/resources/boat_Img/uboat", true, "U-Boat"),
    BATTLESHIP(4, "src/main/resources/boat_Img/battleship", true, "Battleship");



    // Normal Length of SectorType
    public final int length;

    // Files of sector image
    public final String[] pngFiles;

    // Condition if Element is a Ship
    public final boolean isShip;

    // Name of Sector
    public final String name;
    SectorType(int length, String filePath, boolean isShip, String name) {
        this.name = name;
        this.isShip = isShip;
        this.length = length;
        this.pngFiles = new String[length];
        for(int i = 0; i < length; i++){
            int part = i+1;
            this.pngFiles[i] = (filePath + part + ".png");
        }
    }
}
