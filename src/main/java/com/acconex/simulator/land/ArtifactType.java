package com.acconex.simulator.land;

public enum ArtifactType {
 Plain("o",1,1,0,0),
 Rocky("r",2,2,0,0),
 Tree("t",2,2,2,0),
 ProtectTree("T",0,0,10,10);
 
 private ArtifactType(String type,int fuelForClear,int fuelForVisit,int creditForVisit,int creditForClear) {
   
}
 
}
