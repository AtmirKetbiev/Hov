package ru.ketbiev.hov.infrastructure.mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import ru.ketbiev.hov.core.port.mq.Producer;

import javax.jms.*;

public class AmqProducer implements Producer {
    // =? "tcp://localhost:61616"
    private final String brokerURL;

    public AmqProducer(String brokerURL) {
        this.brokerURL = brokerURL;
    }

    @Override
    public boolean sendLightPriority(String message) {
        return send(message, "light-priority");
    }

    @Override
    public boolean sendNormalPriority(String message) {
        return send(message, "normal-priority");
    }

    @Override
    public boolean sendCriticalPriority(String message) {
        return send(message, "critical-priority");
    }

    private boolean send(String message, String queueName) {
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

            // create sender
            QueueSender sender = session.createSender(queue);

            // create message
            TextMessage messageForMq = session.createTextMessage(message);

            // send message
            sender.send(messageForMq);

            // end connection
            connection.close();

        } catch (JMSException e) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e1) {
                    // ignore error
                }
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
