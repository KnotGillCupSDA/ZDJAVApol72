package com.sda.testingadvanced.awaitility;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageSender {

	private final BlockingQueue<String> queue;
	private final AtomicInteger messagesSent;
	private final AtomicBoolean isRunning;
	private final ExecutorService executorService;

	public MessageSender() {
		queue = new LinkedBlockingQueue<>();
		messagesSent = new AtomicInteger();
		isRunning = new AtomicBoolean(true);
		executorService = Executors.newSingleThreadExecutor();
		executorService.submit(() -> {
			while(isRunning.get()) {
				final String poll = queue.poll();
				if(send()) {
					messagesSent.incrementAndGet();
				}
			}
		});
	}

	private boolean send() {
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void enqueue(String message) {
		queue.add(message);
	}

	public int getMessagesSent() {
		return messagesSent.get();
	}
	public void close() {
		executorService.shutdownNow();
	}

}
