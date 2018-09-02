package memory;

public class SyncTest {

    public static void main(String[] args) {
        System.out.println("gogogo");
    }

    /**
     *  方法上加
     * @param obj
     * @return
     */
    public synchronized boolean test(Object obj) {
        return this.equals(obj);
    }

    public void test2(){
        synchronized (this){
            System.out.println("代码里面加");
        }
    }
}
