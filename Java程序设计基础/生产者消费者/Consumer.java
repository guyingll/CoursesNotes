package storeHome;

public class Consumer implements Runnable{
    private String consumerName = null;  //消费者名字
    private StoreHome storeHome = null;  //公共缓冲区

    //构造方法
    public Consumer(String consumerName,StoreHome storeHome){
        this.consumerName = consumerName;
        this.storeHome = storeHome;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        while (true){
            Product product = storeHome.pop(); //取出产品，即消费
            //输出对应信息
            System.out.println(getConsumerName() + "消费了" + product);
            try{
                Thread.sleep(5000);  //线程延时5000ms
            }catch (InterruptedException e){
                return;
            }
        }
    }
}
