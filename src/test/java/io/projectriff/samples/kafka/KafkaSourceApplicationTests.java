package io.projectriff.samples.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;


@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaSourceApplicationTests {

//	static final String TOPIC = "events";
//
//
//	@ClassRule
//	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TOPIC);

	@Autowired
	private Supplier<Flux<ConsumerRecord>> consumerRecords;

	@Test
	//@Ignore
	public void contextLoads() throws InterruptedException {
		consumerRecords.get().subscribe(cr -> System.out.println("got:" + cr.toString()));
		Thread.sleep(5000);
	}

}
