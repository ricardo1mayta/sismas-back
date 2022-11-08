package com.spring.sigmaweb.backend.process.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public  class Constants {

    public  static class ESTADO_SOLICITUD{
        public static final Integer PENDIENTE=50401;
        public static final Integer AUTORIZADO=50402;
        public static final Integer ANULADO=50403;
        public static final Integer PAGADO=50404;
        public static final Integer NO_AUTORIZADO=50405;
    }

    public  static class TIPO_MONEDA{
        public static final Integer SOLES=50101;
        public static final Integer DOLARES=50102;
        public static final Integer EUROS=50103;
    }

//    public  static class ESTADO_SOLICITUD{
//        public static final Integer PENDIENTE=35110;
//        public static final Integer AUTORIZADO=35111;
//        public static final Integer ANULADO=35112;
//        public static final Integer PAGADO=35113;
//        public static final Integer NO_AUTORIZADO=35114;
//    }

    public static  class  FLAG_ESTADO{
        public static  final Boolean ACTIVO=true;
        public static  final Boolean INACTIVO=false;
    }
    public static class OBJETO_NAME {
        public static  final String SOLICITUD_GENERAL="mt_solicitud_general";
        public static final String CAJA_CHICA_LIQUIDACION="mt_caja_chica_liquidacion";
    }

    public static class TIPO_MODO_PAGO{
        public static  final Integer CHEQUE=50301;
        public static  final Integer TRANSFERENCIA=50302;
        public static  final Integer CARTA_ORDEN=50303;
        public static  final Integer TARJETA_CREDITO=50307;
    }

//    public static class TIPO_MODO_PAGO{
//        public static  final Integer CHEQUE=15801;
//        public static  final Integer TRANSFERENCIA=15802;
//        public static  final Integer CARTA_ORDEN=15804;
//        public static  final Integer TARJETA_CREDITO=15808;
//    }

    public static final String MSJ_DIF_SOL = "(Diferencia A rendir)";
    public static  class TIPO_DISTRIBUCION{
        public static final Integer DIVISION=50501;
        public static final Integer ASIGNACION_DIRECTA=50502;
        public static final Integer PERSONALIZADA =50503;
    }

//    public static  class TIPO_DISTRIBUCION{
//        public static final Integer DIVISION=40100;
//        public static final Integer ASIGNACION_DIRECTA=40101;
//        public static final Integer PERSONALIZADA =4002;
//    }

    public static class TIPO_ESTADO_RENDIMIENTO{
        public static  final Integer INICIADO=50701;
        public static  final Integer FINALIZADO=50702;
    }

//    public static class TIPO_ESTADO_RENDIMIENTO{
//        public static  final Integer INICIADO=40301;
//        public static  final Integer FINALIZADO=40302;
//    }

}
