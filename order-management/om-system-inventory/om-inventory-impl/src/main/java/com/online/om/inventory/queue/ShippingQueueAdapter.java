package com.online.om.inventory.queue;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.online.om.inventory.config.ShippingQueueConfigProperties;

@Component
public class ShippingQueueAdapter {

	@Value("${jsa.activemq.broker.url}")
	private String brokerUrl;

	@Autowired
	ShippingQueueConfigProperties shippingQueueConfigProperties;

	public void sendInvoiceToShipping(String invoiceContent) throws JmsException, JMSException {
		this.jmsTemplate().convertAndSend(this.shippingQueueConfigProperties.getDestinationqueue(), invoiceContent);
	}

	@Bean
	private JmsTemplate jmsTemplate() throws JMSException {
		return new JmsTemplate(this.activeMQConnectionFactory());
	}

	@Bean
	@Profile("AMQ")
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(this.brokerUrl);
		factory.setTrustAllPackages(true);
		return factory;
	}
}
