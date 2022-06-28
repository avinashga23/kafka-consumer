package com.cisco.automation.cxpp.kafkaconsumer.service;

import com.cisco.automation.cxpp.kafkaconsumer.listeners.Message;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * The interface Message sender.
 */
@Validated
public interface MessageSender {

  /**
   * Send message.
   *
   * @param topic   the topic
   * @param message the message
   */
  void sendMessage(@NotNull String topic, @Valid Message message);

}
