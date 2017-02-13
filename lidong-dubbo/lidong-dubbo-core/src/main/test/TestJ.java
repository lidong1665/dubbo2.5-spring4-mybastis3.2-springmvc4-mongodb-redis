import org.junit.Test;

public class TestJ {


    @Test
    public  void  send(){
        System.out.println("dddd");
        int a =10;
        int b =20;
        Me me = new Me().invoke();
        a = me.getA();
        b = me.getB();
        System.out.print("a="+a);
        System.out.print("b="+b);
    }


    private class Me {
        private int a;
        private int b;

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public Me invoke() {
            a = 100;
            b = 200;
            return this;
        }
    }
}
