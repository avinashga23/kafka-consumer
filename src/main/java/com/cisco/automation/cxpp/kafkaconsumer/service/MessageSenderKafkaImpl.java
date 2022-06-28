package com.cisco.automation.cxpp.kafkaconsumer.service;

import com.cisco.automation.cxpp.kafkaconsumer.listeners.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class MessageSenderKafkaImpl implements MessageSender{

  private final KafkaTemplate<String, Message> kafkaTemplate;

  @Override
  public void sendMessage(String topic, Message message) {
    log.info("sending message {} to topic {}", message, topic);
    kafkaTemplate.send(topic, message).completable().whenComplete(((stringMessageSendResult, throwable) -> {
      if (throwable != null)
        log.info("exception {} while sending message {}", throwable.getMessage(), stringMessageSendResult.getProducerRecord().value());
      else
        log.info("sent message {}", stringMessageSendResult.getProducerRecord().value());
    }));
  }
}
