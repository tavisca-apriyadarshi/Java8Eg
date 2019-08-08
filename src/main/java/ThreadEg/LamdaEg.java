package ThreadEg;

public class LamdaEg {
    public static void main(String[] args) {
        LamdaEg l = new LamdaEg();
        Thread t1 = new Thread(() -> l.printNo());
        t1.start();
        Thread t2 = new Thread(() -> l.printNo());
        t2.start();
    }
    void printNo(){
        for(int i =0; i<10; i++) {
            System.out.println(i+"->"+i*i);
        }
    }
}
