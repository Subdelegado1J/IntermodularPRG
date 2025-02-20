//Juan Carlos Espinosa Vázquez DAW-1J

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Medico {

    private int ID_medico;
    private String email;
    private String nombreMed;
    private String especialidad;

    public Medico() {
    }

    public Medico(int ID_medico, String email, String nombreMed, String especialidad) {
        this.ID_medico = ID_medico;
        this.email = email;
        this.nombreMed = nombreMed;
        this.especialidad = especialidad;
    }

    public int getID_medico() {
        return ID_medico;
    }

    public void setID_medico(int ID_medico) {
        this.ID_medico = ID_medico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public static int validarIDmedico(int idmedico) {
        if (idmedico < 1 || idmedico > 999999999) {
            return -1;
        } else {
            return idmedico;
       }
    }


    //NO VOY A MENTIR. ESTA FUNCIÓN DE VALIDAR EMAIL CON EXPRESIONES REGULARES ME LA HA ENCONTRADO GOOGLE. :)
    public static boolean validarEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    @Override
    public String toString() {
        return "Nombre: " + nombreMed +
                ", número de médico: " + ID_medico +
                ", correo electrónico: " + email +
                ", especialidad: " + especialidad;
    }
}
