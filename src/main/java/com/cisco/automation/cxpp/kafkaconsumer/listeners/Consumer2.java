package com.cisco.automation.cxpp.kafkaconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * The type Consumer 2.
 */
@Component
@Slf4j
public class Consumer2 {

  /**
   * On message.
   *
   * @param message the message
   */
  @KafkaListener(topics = "${topic2}",
      properties = "spring.json.value.default.type=com.cisco.automation.cxpp.kafkaconsumer.listeners.Message")
  public void onMessage(Message message) {
    log.info("handling message from consumer2, {}", message);
  }

}
