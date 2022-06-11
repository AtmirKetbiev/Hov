package ru.ketbiev.hov.core.usecase.support;

import ru.ketbiev.hov.core.port.mq.Consumer;
import ru.ketbiev.hov.core.port.mq.Producer;

public class SupportRequestsService {
    private Consumer consumer;
    private Producer producer;

    public SupportRequestsService(Consumer consumer, Producer producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    public boolean sendLightPriority() {
        return false;
    }

    public String acceptLightPriority() {
        return "";
    }

    public boolean sendNormalPriority() {
        return false;
    }

    public String acceptNormalPriority() {
        return "";
    }

    public boolean sendCriticalPriority() {
        return false;
    }

    public String acceptCriticalPriority() {
        return "";
    }
}
