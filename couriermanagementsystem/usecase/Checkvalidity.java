package couriermanagementsystem.usecase;


public class Checkvalidity {
    public Boolean onlydigits(float weight){
        return weight != 0 && !(weight < 0);
    }
}
