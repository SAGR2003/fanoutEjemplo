package co.edu.unisabana.bomberos.servicio;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BomberosServicio {
    private int numeroBomberoOcupado = 6;

    @RabbitListener(queues = "filaEmergencias")
    public void alertarIncendio(String incendio) {
        System.out.println("Hay un " + incendio);
        asignarBomberos();
    }

    private void asignarBomberos() {
        String[] bomberos = {"Pepito Pérez", "Juan Valderrama", "Sergio González", "Juanita Sarmiento", "Maria José"};
        System.out.println("Los bomberos " + bomberos[seleccionarBombero()] + " y " + bomberos[seleccionarBombero()] + " van en camino");
    }

    private int seleccionarBombero() {
        int bomberoSeleccionado = (int) (Math.random() * 5);
        while (numeroBomberoOcupado == bomberoSeleccionado) {
            bomberoSeleccionado = (int) (Math.random() * 5);
        }
        numeroBomberoOcupado = bomberoSeleccionado;
        return bomberoSeleccionado;
    }
}
