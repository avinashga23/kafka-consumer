package com.cisco.automation.cxpp.kafkaconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer1 {

  @KafkaListener(topics = "${topic1}",
  properties = "spring.json.value.default.type=com.cisco.automation.cxpp.kafkaconsumer.listeners.Message")
  public void onMessage(Message message) {
    log.info("handling message from consumer1, {}", message);
  }

}
