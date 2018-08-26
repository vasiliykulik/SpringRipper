package quoters;

/**
 * Created by Vasiliy Kylik (Lightning) on 26.08.2018.
 */
public class TerminatorQuoter implements Quoter {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println("message = " + message);
    }
}
