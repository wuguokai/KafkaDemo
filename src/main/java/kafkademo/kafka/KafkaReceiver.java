package kafkademo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by WUGUOKAI on 2018/3/2.
 */
@Component
public class KafkaReceiver {
    @KafkaListener(topics = "test3")
    public void listen(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();

            System.out.println("record: "+record);
            System.out.println("message: "+message);
        }
    }
}
