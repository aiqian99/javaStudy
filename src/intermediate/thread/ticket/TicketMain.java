package intermediate.thread.ticket;

/**
 * @Description 三个窗口 模拟卖票
 * @Author huangjw
 * @Date 2020/2/6 14:21
 */
public class TicketMain {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("窗口一：");
        t2.setName("窗口二：");
        t3.setName("窗口三：");

        t1.start();
        t2.start();
        t3.start();
    }
}
