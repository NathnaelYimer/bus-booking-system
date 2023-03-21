public class Location {

    int Lid;
    String locationName;

    Location(int Lid,String locationName){
        this.Lid = Lid;
        this.locationName = locationName;
    }
    @Override
    public String toString(){
        return locationName;
    }


    
}
