package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vasiliy Kylik (Lightning) on 26.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(TerminatorQuoter.class).sayQuote();
    }
}
