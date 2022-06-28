package com.cisco.automation.cxpp.kafkaconsumer.listeners;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * The type Message.
 */
@Data
public class Message {

  private int id;

  @NotBlank
  private String content;

}
