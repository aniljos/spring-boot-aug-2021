package com.training.config;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskComponent {

	@Scheduled(fixedRate = 3000)
	public void log() {
		System.out.println("TaskComponent.log() " + LocalTime.now());
	}
}
