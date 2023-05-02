package co.edu.unisabana.lineaemergencia.servicio;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class PublicaEmergenciaServicio {
    private RabbitTemplate rabbitTemplate;

    public PublicaEmergenciaServicio(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void crearMensajeEmergencia(String direccion) {
        publicarEmergencia("Incendio en la direccion: " + direccion);
    }
    private void publicarEmergencia(String emergencia) {
        rabbitTemplate.convertAndSend("exchangeEmergencia", "Emergencia", emergencia);
    }

}
