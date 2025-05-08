package com.example.rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.domain.Message;
import com.example.rest.domain.MessageList;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@GetMapping
	public MessageList getMsgsInXml() {
		List<Message> messages = List.of(
			new Message(1, "메시지 #1", new Date()),
			new Message(2, "메시지 #2", new Date())
		);
		System.out.println(messages);
		return new MessageList(messages);
	}

	@PostMapping
	public MessageList postMsgsInXml(@RequestBody MessageList messageList) {
		System.out.println(messageList.toString());
		
		messageList.getMessages().get(0).setContent("수정된 메시지");
		return messageList;
	}
}
