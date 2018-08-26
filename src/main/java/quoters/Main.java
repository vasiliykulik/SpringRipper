package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vasiliy Kylik (Lightning) on 26.08.2018.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        while (true) {
            Thread.sleep(100);
            context.getBean(Quoter.class).sayQuote();
        }
    }
}
