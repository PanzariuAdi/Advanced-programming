package lab12;

import org.junit.Test;

import java.lang.reflect.Method;

public class MyTestFramework {
        public static void main(String[] args) throws Exception {
            int passed = 0, failed = 0;
            for(Method m : Class.forName(args[0]).getMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    try {
                        m.invoke();
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("Test %s is failed : %s %n", m, ex.getCause());
                    }
                }
            }
        }
}
