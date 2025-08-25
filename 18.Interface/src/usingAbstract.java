abstract class Computer{
    public abstract String device();
}
class Laptop extends Computer{

    @Override
    public String device() {
        return "Laptop";
    }
}
class Desktop extends Computer{
    @Override
    public String device() {
        return "Desktop";
    }
}

class Developer{
    public void requireForCode(Computer obj){

        System.out.println("Now Developer have " + obj.device() +", Now they can start Coding...");
    }
}
public class usingAbstract{
    public static void main(String[] args) {
            Computer obj = new Desktop();
            Computer obj1 = new Laptop();
            Developer obj2 = new Developer();
            obj2.requireForCode(obj1);
    }
}
