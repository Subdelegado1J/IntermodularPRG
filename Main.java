//Juan Carlos Espinosa Vázquez DAW-1J

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Medico nuevoMedico = new Medico();
    static ArrayList<Medico> listaDeMedicos = new ArrayList<>();

    public static void imprimirMenu() {

        System.out.println("-----------------------------------");
        System.out.println("Elige una opción del 0 al 6: ");
        System.out.println("0 - Salir del programa.");
        System.out.println("1 - Insertar nuevo médico.");
        System.out.println("2 - Eliminar médico existente.");
        System.out.println("3 - Actualizar médico.");
        System.out.println("4 - Consultar un médico.");
        System.out.println("5 - Imprimir todos los médicos.");
        System.out.println("6 - Volver a imprimir este menú.");
        System.out.println("-----------------------------------");
    }

    public static boolean buscarMedico(String medico) {
        boolean encontrado = false;

        for (Medico medi : listaDeMedicos) {
            if (medi.getNombreMed().equalsIgnoreCase(medico)) {
                encontrado = true;
            }
        }

        return encontrado;
    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("|-------------------------------------------|");
        System.out.println("|  BIENVENIDO/A AL MARAVILLOSO SISTEMA DE   |");
        System.out.println("|    GESTION DE MÉDICOS DE JUAN CARLOS      |");
        System.out.println("|-------------------------------------------|");
        System.out.println("Escoge un número del 0 al 6: ");
        System.out.println("0 - Salir del programa.");
        System.out.println("1 - Insertar nuevo médico.");
        System.out.println("2 - Eliminar médico existente.");
        System.out.println("3 - Actualizar médico.");
        System.out.println("4 - Consultar un médico.");
        System.out.println("5 - Imprimir todos los médicos.");
        System.out.println("6 - Volver a imprimir este menú.");
        System.out.println();

        boolean continuar = true;
        while (continuar) {
            try {
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo del programa. ¡ADIÓS!");
                        continuar = false;
                        break;
                    case 1:
                        System.out.println("¿Cómo se llama este médico?");
                        String nombreMedico = sc.nextLine();

                        int numeroDeMedico = -1;
                        boolean salir = false;

                        while (!salir) {
                            try {
                                System.out.println("Pon el número de médico que tiene el médico:");

                                numeroDeMedico = sc.nextInt();
                                sc.nextLine();

                                if (Medico.validarIDmedico(numeroDeMedico) == -1) {
                                    System.out.println("El número de médico no es válido. Vuelve a intentarlo: ");
                                } else {

                                    boolean numeroDuplicado = false;
                                    for (Medico m : listaDeMedicos) {
                                        if (m.getID_medico() == numeroDeMedico) {
                                            numeroDuplicado = true;
                                        }
                                    }

                                    if (numeroDuplicado) {
                                        System.out.println("Ya existe un médico con ese número. Vuelve a intentarlo: ");
                                        System.out.println();
                                    } else {
                                        salir = true;
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Debes ingresar un número.");
                                sc.nextLine();
                            }
                        }


                        String correoElectronico = "";
                        boolean salir2 = false;

                        while (!salir2) {
                            System.out.println("Pon el correo electrónico del médico:");
                            correoElectronico = sc.nextLine();

                            if (!Medico.validarEmail(correoElectronico)) {
                                System.out.println("El correo electrónico no es válido. Inténtalo de nuevo.");
                            } else {
                                boolean correoDuplicado = false;
                                for (Medico m : listaDeMedicos) {
                                    if (m.getEmail().equalsIgnoreCase(correoElectronico)) {
                                        correoDuplicado = true;
                                    }
                                }

                                if (correoDuplicado) {
                                    System.out.println("Ya existe un médico con ese correo. Inténtalo de nuevo.");
                                    System.out.println();
                                } else {
                                    salir2 = true;
                                }
                            }
                        }
                        
                        System.out.println("¿En qué está especializado este médico?");
                        String especialidadMedico = sc.nextLine();

                        Medico medico = new Medico(numeroDeMedico, correoElectronico, nombreMedico, especialidadMedico);

                        listaDeMedicos.add(medico);

                        System.out.println("El médico " + nombreMedico + " se ha añadido correctamente.");
                        System.out.println();
                        imprimirMenu();
                        break;
                    case 2:
                        System.out.println("Introduce el número de médico del médico deseas eliminar:");

                        int eliminar;
                        boolean encontrado = false;
                        boolean salir3 = false;

                        while (!salir3) {
                            try {
                                eliminar = sc.nextInt();

                                if (Medico.validarIDmedico(eliminar) == -1) {
                                    System.out.println("El número de médico no es válido. Inténtalo de nuevo:");
                                }

                                for (int i = 0; i < listaDeMedicos.size(); i++) {
                                    Medico medi = listaDeMedicos.get(i);
                                    if (medi.getID_medico() == eliminar) {
                                        listaDeMedicos.remove(i);
                                        System.out.println("El médico ha sido eliminado correctamente.");
                                        encontrado = true;
                                        salir3 = true;
                                    }
                                }

                                if (!encontrado) {
                                    System.out.println("No se encontró un médico con ese número.");
                                }
                                salir3 = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Debes ingresar un número.");
                                sc.nextLine();
                            }
                        }
                        imprimirMenu();
                        break;
                    case 3:
                        System.out.println("Introduce el número de médico que deseas actualizar:");

                        int idActualizar;
                        Medico medicoActualizar = null;

                        boolean salir4 = false;
                        while (!salir4) {
                            try {
                                idActualizar = sc.nextInt();
                                sc.nextLine();

                                if (Medico.validarIDmedico(idActualizar) == -1) {
                                    System.out.println("El número de médico no es válido. Inténtalo de nuevo:");
                                }

                                for (Medico medicob : listaDeMedicos) {
                                    if (medicob.getID_medico() == idActualizar) {
                                        medicoActualizar = medicob;
                                        salir4 = true;
                                    }
                                }

                                if (medicoActualizar == null) {
                                    System.out.println("No se encontró un médico con ese número. Prueba a poner otro número.");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Debes ingresar un número.");
                                sc.nextLine();
                            }
                        }

                        System.out.println("Introduce el nuevo nombre del médico: ");
                        String nuevoNombre = sc.nextLine();
                        if (!nuevoNombre.isEmpty()) {
                            medicoActualizar.setNombreMed(nuevoNombre);
                        }

                        String nuevoEmail;
                        boolean salir5 = false;
                        while (!salir5) {
                            System.out.println("Introduce el nuevo correo electrónico del médico: ");
                            nuevoEmail = sc.nextLine();

                            if (!Medico.validarEmail(nuevoEmail)) {
                                System.out.println("El correo electrónico no es válido. Inténtalo de nuevo.");
                            }

                            boolean emailDuplicado = false;
                            for (Medico medicoactualizar : listaDeMedicos) {
                                if (!medicoactualizar.equals(medicoActualizar) && medicoactualizar.getEmail().equalsIgnoreCase(nuevoEmail)) {
                                    emailDuplicado = true;
                                    salir5 = true;
                                }
                            }

                            if (emailDuplicado) {
                                System.out.println("Ya existe un médico con este correo. Inténtalo de nuevo.");
                            } else {
                                medicoActualizar.setEmail(nuevoEmail);
                                salir5 = true;
                            }
                        }

                        System.out.println("Introduce la nueva especialidad del médico: ");
                        String nuevaEspecialidad = sc.nextLine();
                        if (!nuevaEspecialidad.isEmpty()) {
                            medicoActualizar.setEspecialidad(nuevaEspecialidad);
                        }

                        System.out.println("Médico actualizado correctamente:");

                        System.out.println();
                        imprimirMenu();
                        break;
                    case 4:
                        System.out.println("Pon el nombre del médico que quieres consultar: ");
                        String nombreConsultar = sc.nextLine();

                        if (!buscarMedico(nombreConsultar)) {
                            System.out.println("No hay ningún médico con ese nombre");
                        } else {
                            for (Medico medi : listaDeMedicos) {
                                if (medi.getNombreMed().equalsIgnoreCase(nombreConsultar)) {
                                    System.out.println(medi);
                                }
                            }
                        }
                        imprimirMenu();
                        break;
                    case 5:
                        if (listaDeMedicos.isEmpty()) {
                            System.out.println("La lista está vacía.");
                            System.out.println();
                        } else {
                            System.out.println("Lista de medicos:");
                            for (Medico lista : listaDeMedicos) {
                                System.out.println(lista);
                            }
                            System.out.println();
                        }
                        imprimirMenu();
                        break;
                    case 6:
                        imprimirMenu();
                        break;
                    default:
                        System.out.println("ERROR. No hay tantas opciones. Indica un número del 0 al 6.");
                        System.out.println();
                        imprimirMenu();
                }
            } catch (InputMismatchException errorExcepcion) {
                System.out.println("ERROR. Solo se pueden números del 0 al 6. Vuelve a intentarlo.");
                System.out.println();
                imprimirMenu();
                sc.nextLine();
            }
        }
    }
}
