package AOPdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//Configuration (NO .xml) - pure Java
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("AOPdemo")
public class DemoConfig {
}
