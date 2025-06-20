package com.bingo.bingo.Servicios;

import com.bingo.bingo.Entidades.BingoCarton;
import com.bingo.bingo.Eventos.InscripcionExitosaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SftpService sftpService;

    @Value("${sftp.remote.directory}")
    private String directorioRemoto;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleInscripcionExitosa(InscripcionExitosaEvent event) {
        System.out.println("Transacción confirmada. Iniciando envío de correo a: " + event.getDestinatario());
        enviarCorreoConCartones(event.getDestinatario(), event.getCartones());
    }

    public void enviarCorreoConCartones(String destinatario, List<BingoCarton> cartones){

        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(destinatario);
            helper.setSubject("REGISTRO B1NG0 COMFAORIENTE");

            String contenidoHTML = "<h1>!Hola!</h1>" +
                                   "<p>Gracias por inscribirte a nuestro bingo. Adjunto encontrarás tus cartones.</p>" +
                                   "<p>¡Mucha suerte!</p>";
            helper.setText(contenidoHTML, true);

            for (BingoCarton carton : cartones) {
                String rutaCompleta = directorioRemoto + carton.getRutacarton();
                System.out.println("Descargando cartón: " + rutaCompleta);
                byte[] contenidoDelArchivo = sftpService.descargarArchivo(rutaCompleta);
                helper.addAttachment(carton.getRutacarton(), new ByteArrayResource(contenidoDelArchivo));
            }

            mailSender.send(mimeMessage);
            System.out.println("Correo enviado exitosamente a: "+ destinatario);


        }catch (MessagingException e){
            throw new RuntimeException("Error al enviar el correo con los cartones.",e);
        }
    }
}
