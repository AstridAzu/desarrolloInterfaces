package formulario.SolicitudBeca;

public class datos {
    private static datos instancia;
    private String NOMBRE;
    private String APELLIDOS;
    private String DNI;
    private String DIRECCION;
    private String CORREO_ELECTRONICO;
    private String TELEFONO;
    private String FECHA_NACIMIENTO;
    private String CENTRO_DE_ESTUDIOS;
    private String TITULACION;
    private String AÑO;
    private String NOMBRE_PADRE;
    private String DNI_PADRE;
    private String NOMBRE_MADRE;
    private String DNI_MADRE;
    private String RENTA_TOTAL;
    private String NUMERO_COMPONENTES_UNIDAD_FAMILIAR;
    public static datos getInstancia() {
        if (instancia == null) {
            instancia = new datos();
        }
        return instancia;
    }
    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getCORREO_ELECTRONICO() {
        return CORREO_ELECTRONICO;
    }

    public void setCORREO_ELECTRONICO(String CORREO_ELECTRONICO) {
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(String FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    public String getCENTRO_DE_ESTUDIOS() {
        return CENTRO_DE_ESTUDIOS;
    }

    public void setCENTRO_DE_ESTUDIOS(String CENTRO_DE_ESTUDIOS) {
        this.CENTRO_DE_ESTUDIOS = CENTRO_DE_ESTUDIOS;
    }

    public String getTITULACION() {
        return TITULACION;
    }

    public void setTITULACION(String TITULACION) {
        this.TITULACION = TITULACION;
    }

    public String getAÑO() {
        return AÑO;
    }

    public void setAÑO(String AÑO) {
        this.AÑO = AÑO;
    }

    public String getNOMBRE_PADRE() {
        return NOMBRE_PADRE;
    }

    public void setNOMBRE_PADRE(String NOMBRE_PADRE) {
        this.NOMBRE_PADRE = NOMBRE_PADRE;
    }

    public String getDNI_PADRE() {
        return DNI_PADRE;
    }

    public void setDNI_PADRE(String DNI_PADRE) {
        this.DNI_PADRE = DNI_PADRE;
    }

    public String getNOMBRE_MADRE() {
        return NOMBRE_MADRE;
    }

    public void setNOMBRE_MADRE(String NOMBRE_MADRE) {
        this.NOMBRE_MADRE = NOMBRE_MADRE;
    }

    public String getDNI_MADRE() {
        return DNI_MADRE;
    }

    public void setDNI_MADRE(String DNI_MADRE) {
        this.DNI_MADRE = DNI_MADRE;
    }

    public String getRENTA_TOTAL() {
        return RENTA_TOTAL;
    }

    public void setRENTA_TOTAL(String RENTA_TOTAL) {
        this.RENTA_TOTAL = RENTA_TOTAL;
    }

    public String getNUMERO_COMPONENTES_UNIDAD_FAMILIAR() {
        return NUMERO_COMPONENTES_UNIDAD_FAMILIAR;
    }

    public void setNUMERO_COMPONENTES_UNIDAD_FAMILIAR(String NUMERO_COMPONENTES_UNIDAD_FAMILIAR) {
        this.NUMERO_COMPONENTES_UNIDAD_FAMILIAR = NUMERO_COMPONENTES_UNIDAD_FAMILIAR;
    }
}
