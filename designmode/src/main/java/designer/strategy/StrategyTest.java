package designer.strategy;

/**
 * Class StrategyTest ...
 *
 * @author LiJun
 * Created on 2019/4/13
 */
public class StrategyTest {
    public static void main(String[] args) {
        Strategy strategy = new ConcreateStrategyA();
        new Context(strategy).contextInterface();
    }

}
