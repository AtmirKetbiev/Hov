package ru.ketbiev.hov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import ru.ketbiev.hov.core.port.mq.Consumer;
import ru.ketbiev.hov.core.port.mq.Producer;
import ru.ketbiev.hov.core.service.SupportRequestsService;
import ru.ketbiev.hov.infrastructure.mq.activemq.AmqConsumer;
import ru.ketbiev.hov.infrastructure.mq.activemq.AmqProducer;

public class MqConfig {
    Consumer consumer = new AmqConsumer("tcp://localhost:61616");
    Producer producer = new AmqProducer("tcp://localhost:61616");

    @Bean
    public SupportRequestsService createSupportRequestsService() {
        return new SupportRequestsService(consumer, producer) {
            @Override
            @Scheduled
            public String acceptLightPriority() {
                return super.acceptLightPriority();
            }

            @Override
            @Scheduled
            public String acceptNormalPriority() {
                return super.acceptNormalPriority();
            }

            @Override
            @Scheduled
            public String acceptCriticalPriority() {
                return super.acceptCriticalPriority();
            }
        };
    }
}
