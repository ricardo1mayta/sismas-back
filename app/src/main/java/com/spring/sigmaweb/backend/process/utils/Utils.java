package com.spring.sigmaweb.backend.process.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String like(String name) {
        return "%" + name.trim().replace(" ", "%") + "%";
    }

    public static String calculateYear(String fechaNac2){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNac2, fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        //System.out.printf("Tu edad es: %s años, %s meses y %s días",
        //       periodo.getYears(), periodo.getMonths(), periodo.getDays());
        return  String.valueOf(periodo.getYears()) ;
    }

    public static Date toDateRegister(String date){
        DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date dateRegister = null;
        try {
            dateRegister =dateFormat.parse(date);
        } catch (ParseException ex){
            ex.printStackTrace();
        }

        return dateRegister;
    }

    public static String toDateMoreDay(Date date) {
        Date tomorrow = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(tomorrow);
    }

    public static String toDateSring(Date date){
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        return  dateFormat.format(date);
    }
    public static String toDateSringHour(Date date){
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return  dateFormat.format(date);
    }

    public static Integer toYear(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }
    public static Integer toMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }

    public static boolean isTrue(Boolean condition) {
        if (condition == null) return false;
        return condition;
    }

    public static Integer idObraNumerico (String idobra){
        Integer rtn= -1;
        switch (idobra) {
            case "BARINA" :
                rtn = 1; break;
            case "CHAMPC" :
                rtn = 2; break;
            case "CHAMPS" :
                rtn = 3; break;
            case "SANJOC" :
                rtn = 4; break;
            case "SANJOH" :
                rtn = 5; break;
            case "SANJOS" :
                rtn = 6; break;
            case "SANLUI" :
                rtn = 7; break;
            case "STAROS" :
                rtn = 8; break;
            case "SECTOR" :
                rtn = 0; break;
        }
        return rtn;
    }

    public static Integer idTipoDocLegajoNumerico(String documento){
        Integer rtn= -1;
        switch (documento) {
            case "CARGO" :
                rtn = 1; break;
            case "CONTRATO" :
                rtn = 2; break;
            case "DESVINCULA" :
                rtn = 3; break;
            case "CONVENIO" :
                rtn = 4; break;
            case "FAMILIARES":
                rtn = 5; break;
            case "PERSONALES" :
                rtn = 6; break;
            case "DESVINCDOC":
                rtn = 31; break;

        }
        return rtn;
    }



    public static String addNumberCorrelativeAndOne(Integer number){
        return String.format("%010d",number+1);
    }



}
