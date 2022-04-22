package com.spring.sigmaweb.backend.process.sintomatologia.task;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.model.FichaExport;
import com.spring.sigmaweb.backend.process.sintomatologia.repository.IFichaSintomatologicaDao;
import com.spring.sigmaweb.backend.utils.Mail;
import com.spring.sigmaweb.backend.utils.Utils;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationTask {

    private final  IFichaSintomatologicaDao ficha;

    @Scheduled(cron = "0 25 15 * * 0-5", zone = "America/Lima")
    public void reportPresonal(){

        Mail mail= new Mail();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate fecha=LocalDate.now();
        List<FichaSintomatologicaDTO> listPersonalNotification = ficha.personalforSectoNotification("SANLUI");
        List<FichaSintomatologicaDTO> listEmailNotification = ficha.listMailNotification("SANLUI", new Date());
        List<FichaSintomatologicaDTO> fsFinal= new ArrayList<>();
        //VALIDACION DE PERSONAL SIN FICHA
        boolean flag= false;
        for (FichaSintomatologicaDTO f: listPersonalNotification){

            for (FichaSintomatologicaDTO f2: listEmailNotification){
                if (Objects.equals(f.getIdPersonal(), f2.getIdPersonal())){
                    flag=true;
                }
            }
            if (!flag){fsFinal.add(f);}
            flag=false;
        }


        for (FichaSintomatologicaDTO dto: fsFinal){
            try {
//                sendMesasge(dto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMesasge( FichaSintomatologicaDTO fichaDTO ) throws Exception {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("roberth.vega@maristas.edu.pe");
        mailSender.setPassword("R0B3RTH*2021&&gma");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setFrom("roberth.vega@maristas.edu.pe");
        helper.setTo(fichaDTO.getEmailPers());
//        helper.setCc(new String[]{as.getEmail()});
        helper.setSubject("Notificación de Ficha Sintomatológica ,pendiente registro!");

        String notification =
                "<h1 style=\"color: #5e9ca0; text-align: center;\">RECURSOS HUMANOS - MARISTAS</h1>\n" +
                "<h3>Notificaci&oacute;n de Ficha Sintomatológica </h3>\n" +
                "<p>Sr(a). PERSONAL_NAME</p>\n" +
                "<p>Recordatorio, Usted. tiene pendiente el registro de la ficha sintomatológica correspondiente al día <strong>DIA_REG</strong> .<br />Ingrese a la p&aacute;gina de Sigman para realizar el registro.</p>\n" +
                "<br/>LINK FICHA SINTOMATOLÓGICA<br/>\n" +
                "<p><strong>hacer click en el siguiente enlace. <a href=http://localhost:4200/#/ficha/buscar target=\"_blank\">Click Aqu&Iacute;</a></p>\n" +
                "<p>&nbsp;</p>";
        String message=notification.replace("PERSONAL_NAME", fichaDTO.getNombrePers())
                .replace("DIA_REG", Utils.toDateMoreDay(new Date()));
        helper.setText(message, true); // Use this or above line.
        // Envío Async de Correo
        new Thread(() -> mailSender.send(mimeMessage)).start();
    }

}
