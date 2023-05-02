package co.edu.unisabana.policia.servicio;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PoliciaServicio {
    @RabbitListener(queues = "filaEmergencias")
    public void notificarEmergencia(String emergencia) {
        System.out.println("Atencion!!! " + emergencia + ", es necesario evacuar");
        asignarPatrulla();
    }

    private void asignarPatrulla() {
        System.out.println("Patrulla numero: " + (int) ((Math.random() * 9) + 1) + " atienda la emergencia");
    }
}
