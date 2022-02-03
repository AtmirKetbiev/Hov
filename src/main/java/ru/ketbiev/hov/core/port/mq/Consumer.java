package ru.ketbiev.hov.core.port.mq;

public interface Consumer {
    String acceptLightPriority();

    String acceptNormalPriority();

    String acceptCriticalPriority();
}
