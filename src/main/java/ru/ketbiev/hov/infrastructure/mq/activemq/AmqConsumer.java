package ru.ketbiev.hov.infrastructure.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import ru.ketbiev.hov.core.port.mq.Consumer;

import javax.jms.*;

public class AmqConsumer implements Consumer {
    // =? "tcp://localhost:61616"
    private final String brokerURL;

    public AmqConsumer(String brokerURL) {
        this.brokerURL = brokerURL;
    }

    @Override
    public String acceptLightPriority() {
        return accept("light-priority");
    }

    @Override
    public String acceptNormalPriority() {
        return accept("normal-priority");
    }

    @Override
    public String acceptCriticalPriority() {
        return accept("critical-priority");
    }

    private String accept(String queueName) {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerURL);

        QueueConnection connection = null;
        try {
            connection = activeMQConnectionFactory.createQueueConnection();

            // start connection
            connection.start();

            // create session
            QueueSession session = (QueueSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // get queue
            ActiveMQQueue queue = new ActiveMQQueue(queueName);

            // create receiver
            QueueReceiver receiver = session.createReceiver(queue);

            String replyString = ((TextMessage) receiver.receiveNoWait()).getText();

            // end connection
            connection.close();

            return replyString;
        } catch (JMSException e) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e1) {
                    // ignore error
                }
            }
            e.printStackTrace();
            return null;
        }
    }
}