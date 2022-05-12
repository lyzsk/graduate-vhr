package cn.sichu.mailserver;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cn.sichu.vhr.web.mbg.model.MailConstants;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@SpringBootApplication
public class MailserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailserverApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
