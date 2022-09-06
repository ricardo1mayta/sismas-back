package com.spring.sigmaweb.backend.process.sintomatologia.task;

import com.spring.sigmaweb.backend.process.sintomatologia.dto.FichaSintomatologicaDTO;
import com.spring.sigmaweb.backend.process.sintomatologia.repository.IFichaSintomatologicaDao;
import com.spring.sigmaweb.backend.process.sintomatologia.service.impl.LocalService;
import com.spring.sigmaweb.backend.process.utils.Mail;
import com.spring.sigmaweb.backend.process.utils.Utils;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.util.IOUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.mail.internet.MimeMessage;
;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Slf4j
//@Profile("!dev")
//@Configuration
@Component
@RequiredArgsConstructor
public class NotificationTask {

    private final  IFichaSintomatologicaDao ficha;
    private final LocalService service;

    private final Environment env;
//    @Scheduled(cron = "0 30 16 * * 0-4", zone = "America/Lima")
    @Scheduled(cron = "0 01 16 * * 0-4", zone = "America/Lima")
    public void sendNotificactionPendingRegister(){
        Mail mail= new Mail();
        List<FichaSintomatologicaDTO> listPersonalNotification;
        List<FichaSintomatologicaDTO> listEmailNotification;
        List<FichaSintomatologicaDTO> fsFinal;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("America/Lima")));
        log.info(new Date().toString());
        log.info(cal.getTime().toString());
        listPersonalNotification = ficha.personalforSectoNotification("SECTOR");
        listEmailNotification = ficha.listMailNotification("SECTOR", cal.getTime());
        fsFinal= new ArrayList<>();
        String flgActiveTask = env.getProperty("flgActiveTask");
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

                log.info(flgActiveTask);
                if(flgActiveTask.equals("1")){
                    if(!dto.getEmailPers().isEmpty() || dto.getEmailPers()!=null || dto.getEmailPers().length()<5){
//                        sendMessageNotification(dto);
                    }
                }
//                log.info(dto.getEmailPers().concat(dto.getNombrePers()));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /*habilitar al subir*/
    //@Scheduled(cron = "0 0 19 * * 0-4", zone = "America/Lima")
    public void sendNotificationFichaRegistered() throws  Exception{
        Mail mail= new Mail();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate fecha=LocalDate.now();
        try {
            //sendReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendReport( )throws  Exception{
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("notificaciones.sigma@maristas.edu.pe");
        mailSender.setPassword("M@r54t452022");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true, StandardCharsets.UTF_8.name());
        helper.setFrom("notificaciones.sigma@maristas.edu.pe");
        helper.setTo("seguimiento.fichasint@maristas.edu.pe");
        helper.addAttachment("report.xlsx", new ByteArrayResource(IOUtils.toByteArray(service.exportFichasPersonaLNotification("SECTOR",new Date()))));
//        helper.setCc(new String[]{as.getEmail()});
        helper.setSubject("Notificación reporte de Ficha Sintomatológica");
        String notification =
                "<h1 style=\"color: #5e9ca0; text-align: left;\">SALUD OCUPACIONAL</h1>\n" +
                        "<h3>Notificaci&oacute;n, reporte de registro Ficha Sintomatológica </h3>\n" +
                        "<p>El siguiente correo es envíado automaticamente a las 19:00 horas con el reporte de registro de ficha sintomatológica correspondiente al día  <strong>DIA_REG</strong> .<br />Ingrese a la p&aacute;gina de Sigma para hacer el seguimiento.</p>\n" +
                        "<br>" +
                        "<p><strong>Hacer click en el siguiente enlace. <a href=https://maristas.sigmaversion.net/#/modulelegajo/fichasSintomatologica target=\"_blank\">Click Aqu&Iacute;</a></p>\n" +
                        "<p>&nbsp;</p>";
        String message=notification.replace("DIA_REG", Utils.toDateMoreDay(new Date()));
        helper.setText(message, true);
        // Envío Async de Correo
        new Thread(() -> mailSender.send(mimeMessage)).start();
    }

    public void sendMessageNotification( FichaSintomatologicaDTO fichaDTO ) throws Exception {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("notificaciones.sigma@maristas.edu.pe");
        mailSender.setPassword("M@r54t452022");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
        helper.setFrom("notificaciones.sigma@maristas.edu.pe");
        helper.setTo(fichaDTO.getEmailPers());
//        helper.setCc(new String[]{as.getEmail()});
        helper.setSubject("Notificación de Ficha Sintomatológica, registro pendiente");

        String notification =
                "<h1 style=\"color: #5e9ca0; text-align: center;\">GESTION DEL TALENTO</h1>\n" +
                "<h3>Notificaci&oacute;n de Ficha Sintomatológica </h3>\n" +
                "<p>Estimado(a) PERSONAL_NAME</p>\n" +
                "<p>Recordatorio, Usted. tiene pendiente el registro de la ficha sintomatológica correspondiente al día <strong>DIA_REG</strong> .<br />Ingrese a la p&aacute;gina de Sigma para realizar el registro.</p>\n" +
                "<br/>LINK FICHA SINTOMATOLÓGICA<br/>\n" +
                "<p><strong>Hacer click en el siguiente enlace. <a href=https://maristas.sigmaversion.net/#/ficha/buscar target=\"_blank\">Click Aqu&Iacute;</a></p>\n" +
                "<p>&nbsp;</p>";
        String message=notification.replace("PERSONAL_NAME", fichaDTO.getNombrePers())
                .replace("DIA_REG", Utils.toDateMoreDay(new Date()));
        helper.setText(message, true); // Use this or above line.
        // Envío Async de Correo
        log.info(fichaDTO.getEmailPers());
//         mailSender.send(mimeMessage);
    }

}
