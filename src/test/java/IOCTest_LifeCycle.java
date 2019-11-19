import com.lzh.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lzh
 * create 2019-10-26-11:22
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        //多实例在获取的时候才会初始化 prototype
        //applicationContext.getBean("car");

        //关闭容器
        applicationContext.close();
    }
}
