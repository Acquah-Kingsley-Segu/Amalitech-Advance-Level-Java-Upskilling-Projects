package com.kingsley.Config.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigClientApplication.class, args);
	}

	@RestController
	@RefreshScope
	public static class ServerTypeController {
		@Value("${server.url}")
		private String serverUrl;

		@RequestMapping("/server/url")
		public String serverUrl() {
			return this.serverUrl;
		}
	}
}
