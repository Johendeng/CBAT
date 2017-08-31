package com.yk.cbat.util.kafka_storm;

import com.yk.cbat.util.PropertiesUtil;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by JohenTeng on 2017/8/28.
 */
@Component
public class KafkaProducer {

    private Producer<String,String> producer;

    private KafkaProducer() throws Exception{
        Properties properties = new Properties();
        String path = PropertiesUtil.class.getClassLoader().getResource("kafka.properties").getPath();
        FileInputStream in = new FileInputStream(path);
        properties.load(in);
        ProducerConfig config = new ProducerConfig(properties);
        producer = new Producer<String, String>(config);
    }

    public void sendToKafka(String userName , String info){
        KeyedMessage<String , String> data = new KeyedMessage<String, String>(userName,info);
        producer.send(data);
//        producer.close();
    }

}
