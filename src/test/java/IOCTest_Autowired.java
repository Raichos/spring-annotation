import com.lzh.bean.Boss;
import com.lzh.bean.Car;
import com.lzh.bean.Color;
import com.lzh.config.MainConfigOfAutowired;
import com.lzh.dao.BookDao;
import com.lzh.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lzh
 * create 2019-10-26-11:22
 */
public class IOCTest_Autowired {

    @Test
    public void test01(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
        //BookDao bean = applicationContext.getBean(BookDao.class);
        //System.out.println(bean);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
        applicationContext.close();
    }
}
