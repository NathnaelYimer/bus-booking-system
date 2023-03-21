public class Bus {
    String name;
    String busNo;
    

    Bus(String name,String busNo){

        this.name= name;
        this.busNo=busNo;

    }

    @Override
    public String toString(){
        return name;
    }
    public String getId(){
        return busNo;
    }


    
}
