/*
 * Copyright 2018 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package io.projectriff.samples.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

/**
 * @author David Turanski
 **/
@Component
public class KafkaSourceFunction implements Supplier<Flux<ConsumerRecord>> {

	public static Logger logger = LoggerFactory.getLogger(KafkaSourceFunction.class);

	EmitterProcessor<ConsumerRecord> consumerRecords = EmitterProcessor.create();

	@Override
	public Flux<ConsumerRecord> get() {
		return consumerRecords;
	}

	@KafkaListener(topics = "${kafka.topics}")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("Received Message:" + cr.toString());
		}
		consumerRecords.onNext(cr);
	}
}
