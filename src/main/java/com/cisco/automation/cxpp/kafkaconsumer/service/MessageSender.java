package com.cisco.automation.cxpp.kafkaconsumer.service;

import com.cisco.automation.cxpp.kafkaconsumer.listeners.Message;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface MessageSender {

  void sendMessage(@NotNull String topic, @Valid Message message);

}
