package designpatterns.proxy.dynamic;

public class HumenImpl implements Humen {
    
    @Override
    public void eat(String food) {
        System.out.println("eat " + food);
    }

}
