package kafkademo;

import kafkademo.kafka.KafkaSender;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

        //主程序中调用kafka的发送者发送消息，模拟生产者
        KafkaSender sender = context.getBean(KafkaSender.class);
        for (int i=0; i<3; i++){
            sender.send();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}
