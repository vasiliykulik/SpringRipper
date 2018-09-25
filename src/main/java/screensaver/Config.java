package screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Vasiliy Kylik on(Rocket) on 25.09.2018.
 */
@Configuration
@ComponentScan(basePackages = "screensaver")
public class Config {
    @Bean
    @Scope(value = "prototype")
    public Color color(){
        Random random = new Random();
        // В XML так бы элегантно не получилось бы
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(100);
        }
    }

}
