package org.example;

public class BuildingMaterialsLocation extends BuildingMaterials{
    private Coordinates position;

    public BuildingMaterialsLocation(String name,long extractionTime, int constructionValue, Coordinates position){
        super(name, extractionTime, constructionValue);
        this.position = position;
    }

    /***
     *
     * @return Coordinates of location
     */
    public Coordinates getPosition() {
        return position;
    }
}
