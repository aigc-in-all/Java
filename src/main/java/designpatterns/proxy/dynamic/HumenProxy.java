package designpatterns.proxy.dynamic;

public class HumenProxy implements Humen {
    
    private Humen humen;
    
    public HumenProxy() {
        this.humen = new HumenImpl();
    }
    
    @Override
    public void eat(String food) {
        before();
        humen.eat(food);
        after();
    }
    
    private void before() {
        System.out.println("cook");
    }
    
    private void after() {
        System.out.println("swap");
    }

}
