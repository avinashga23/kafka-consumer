package com.cisco.automation.cxpp.kafkaconsumer.controller;

import com.cisco.automation.cxpp.kafkaconsumer.listeners.Message;
import com.cisco.automation.cxpp.kafkaconsumer.service.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping("/message")
@Slf4j
class MessageController {

  private final MessageSender messageSender;

  @PostMapping("/{topic}")
  String sendMessage(@PathVariable String topic, @RequestBody Message message) {
    log.info("sending message {} to topic {}", message, topic);
    this.messageSender.sendMessage(topic, message);

    return "MESSAGE SENT";
  }

}
