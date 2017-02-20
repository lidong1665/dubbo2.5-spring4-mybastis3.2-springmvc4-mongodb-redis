import org.junit.Test;

public class TestJ {


    @Test
    public  void  send(){
        System.out.println("dddd");
        int a =10;
        int b =20;
        method(a,b);
        System.out.print("a="+a);
        System.out.print("b="+b);
    }

    void method(int a,int b){
        System.out.print("a=100,b=200");
        System.exit(0);
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
    @Test
    public void testString(){
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b);//false
        System.out.println(a == c);//true
        System.out.println(a.equals(b));//true
        System.out.println(a.equals(c));//true

        System.out.println(a.intern() == b.intern());//true
    }
}
