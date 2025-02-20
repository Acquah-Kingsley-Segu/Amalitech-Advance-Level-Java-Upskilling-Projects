package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@ComponentScan("org.example")
@Component
public class Main{
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        Service service = ctx.getBean(Service.class);
        service.doSomething();
    }

    @Component
    class Service{
        @LogExecutionTime
        public void doSomething(){
            System.out.println("Doing something");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}