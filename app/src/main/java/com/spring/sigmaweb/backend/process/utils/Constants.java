package com.spring.sigmaweb.backend.process.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public  class Constants {

    public  static class ESTADO_SOLICITUD{
        public static final Integer PENDIENTE=35110;
        public static final Integer AUTORIZADO=35111;
        public static final Integer ANULADO=35112;
        public static final Integer PAGADO=35113;
        public static final Integer NO_AUTORIZADO=35114;
    }
    public static  class  FLAG_ESTADO{
        public static  final Boolean ACTIVO=true;
        public static  final Boolean INACTIVO=false;
    }
    public static class OBJETO_NAME {
        public static  final String SOLICITUD_GENERAL="mt_solicitud_general";
    }

    public static class TIPO_MODO_PAGO{
        public static  final Integer CHEQUE=15801;
        public static  final Integer TRANSFERENCIA=15802;
        public static  final Integer CARTA_ORDEN=15804;
        public static  final Integer TARJETA_CREDITO=15808;
    }

}
