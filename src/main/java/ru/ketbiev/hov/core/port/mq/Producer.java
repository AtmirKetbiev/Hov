package ru.ketbiev.hov.core.port.mq;

public interface Producer {
    boolean sendLightPriority(String message);

    boolean sendNormalPriority(String message);

    boolean sendCriticalPriority(String message);
}
