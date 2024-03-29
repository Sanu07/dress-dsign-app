package com.dress.payment.model;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class Payment {
	
	private String merchantId;
	private String merchantKey;
	private String channelId;
	private String website;
	private String industryTypeId;
	private String paytmUrl;
	private Map<String, String> details;
}
