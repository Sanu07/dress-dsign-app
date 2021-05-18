package com.dress.notification.service;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.dress.notification.model.User;

import reactor.core.publisher.Mono;

@Service
public class EmailService {

	private final TemplateEngine templateEngine;

	private final JavaMailSender javaMailSender;

	public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
		this.templateEngine = templateEngine;
		this.javaMailSender = javaMailSender;
	}

	public String sendMail(User user) throws MessagingException {
		Context context = new Context();
		context.setVariable("user", user);

		String process = templateEngine.process("email-templates/welcome", context);
		javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject("Welcome " + user.getName());
		helper.setText(process, true);
		helper.setTo(user.getEmail());
		javaMailSender.send(mimeMessage);
		return "Sent";
	}

	public Mono<User> getUserAsync() {
		CompletableFuture<User> future = CompletableFuture.supplyAsync(() -> {
			User user = new User();
			try {
				user.setEmail("test@test.com");
				Thread.sleep(1000);
				user.setName("Jack");
				Thread.sleep(2000);
				user.setUsername("jack0123");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("created!!" + LocalTime.now());
			return user;
		});
		Mono<User> monoFromFuture = Mono.fromFuture(future);
		System.out.println("exiting!!" + LocalTime.now());
		return monoFromFuture;
	}
}