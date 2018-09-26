package screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.*;

/**
 * Created by Vasiliy Kylik (Lightning) on 26.09.2018.
 */
// 6. Получается полноценный Scope Resolver
public class PeriodicalScopeConfigurer implements Scope {
    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int secondsSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            // 5. Проверяю не истекло ли время хранения
            if (secondsSinceLastRequest > 3) {
                map.put(name, new Pair(now(), objectFactory.getObject()));
            }
        } else {
            // 4. сейчас и Объкет из objectFactory, вот здесь создается новый объект
            map.put(name, new Pair(now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
        // 7. Теперь его надо зарегистрировать. (Прописать в XML не получиться).
        // Сказать надо будет контесксту о новом виде Scope. Я хочу это сделать до создания Context,
        // тоесть BeanFactoryPostProcessor
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
