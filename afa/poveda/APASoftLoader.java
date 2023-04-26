package afa.poveda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class APASoftLoader {

    static final String BASE_PATH = "C:\\Users\\jiglesias\\Downloads\\";
    static final String SOCIOS_SOURCE_FILE = "Tutores_export.csv";
    static final String SOCIOS_TARGET_FILE = "Importar_Socios.csv";
    static final String ALUMNOS_SOURCE_FILE = "Alumnos_export.csv";
    static final String ALUMNOS_TARGET_FILE = "Importar_Alumnos.csv";
    static final String SEP = ";";
    static final String MADRID = "MADRID";

    public static void main(String[] args) {

        loadSocios();
        loadAlumnos();

    }

    private static void loadSocios() {

        try (BufferedReader br = new BufferedReader(
                new FileReader(BASE_PATH + SOCIOS_SOURCE_FILE, StandardCharsets.UTF_8));
                PrintWriter pw = new PrintWriter(new FileWriter(SOCIOS_TARGET_FILE, StandardCharsets.UTF_8))) {

            String line = br.readLine(); // cabecera
            line = br.readLine();
            String[] part;
            StringBuilder sb = new StringBuilder();
            String nombre = "";
            String apellidos = "";

            while (line != null) {
                part = line.split(SEP);

                sb.append(part[0]).append(SEP); // id o Nº Socio
                sb.append("").append(SEP); // fecha de alta

                if (part[1].indexOf(",") > -1) {
                    nombre = part[1].substring(part[1].indexOf(",") + 1).trim();
                    apellidos = part[1].substring(0, part[1].indexOf(",")).trim();
                } else if (part[1].indexOf(" ") > -1) {
                    nombre = part[1].substring(0, part[1].indexOf(" ")).trim();
                    apellidos = part[1].substring(part[1].indexOf(" ") + 1).trim();
                } else {
                    nombre = part[1].trim();
                    apellidos = "";
                }
                sb.append(nombre).append(SEP); // nombre
                sb.append(apellidos).append(SEP); // apellidos

                sb.append(part[3].replace("-", "")).append(SEP); // dni
                sb.append("").append(SEP); // sexo
                sb.append(part[18]).append(SEP); // email
                sb.append(part[6]).append(SEP); // direccion
                sb.append(MADRID).append(SEP); // ciudad
                sb.append(part[10]).append(SEP); // telefono
                sb.append(part[8]).append(SEP); // movil
                sb.append(MADRID).append(SEP); // provincia
                sb.append("").append(SEP); // cp
                sb.append(part[0]).append(SEP); // CCC
                sb.append("").append(SEP); // fecha firma
                sb.append(part[2]).append(SEP); // notas

                sb.append("").append(SEP); // ene
                sb.append("").append(SEP); // feb
                sb.append("").append(SEP); // mar
                sb.append("").append(SEP); // abr
                sb.append("").append(SEP); // may
                sb.append("").append(SEP); // jun
                sb.append("").append(SEP); // jul
                sb.append("").append(SEP); // ago
                sb.append("").append(SEP); // sep
                sb.append("").append(SEP); // oct
                sb.append("45").append(SEP); // nov
                sb.append("").append(SEP); // dic

                if (part[4].indexOf(",") > -1) {
                    nombre = part[4].substring(part[4].indexOf(",") + 1).trim();
                    apellidos = part[4].substring(0, part[4].indexOf(",")).trim();
                } else if (part[4].indexOf(" ") > -1) {
                    nombre = part[4].substring(0, part[4].indexOf(" ")).trim();
                    apellidos = part[4].substring(part[4].indexOf(" ") + 1).trim();
                } else {
                    nombre = part[4].trim();
                    apellidos = "";
                }
                sb.append(nombre).append(SEP); // nombre
                sb.append(apellidos).append(SEP); // apellidos

                sb.append(part[5].replace("-", "")).append(SEP); // dni
                sb.append("").append(SEP); // sexo
                sb.append(part[19]).append(SEP); // email
                sb.append(part[7]).append(SEP); // direccion
                sb.append(MADRID).append(SEP); // ciudad
                sb.append(part[11]).append(SEP); // telefono
                sb.append(part[9]).append(SEP); // movil
                sb.append(MADRID).append(SEP); // provincia
                sb.append("").append(SEP); // cp
                sb.append("").append(SEP); // notas

                pw.println(sb.toString());
                sb.setLength(0);
                line = br.readLine();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private static void loadAlumnos() {

        try (BufferedReader br = new BufferedReader(
                new FileReader(BASE_PATH + ALUMNOS_SOURCE_FILE, StandardCharsets.UTF_8));
                PrintWriter pw = new PrintWriter(new FileWriter(ALUMNOS_TARGET_FILE, StandardCharsets.UTF_8))) {

            String line = br.readLine(); // cabecera
            line = br.readLine();
            String[] part;
            StringBuilder sb = new StringBuilder();
            String nombre = "";
            String apellidos = "";
            while (line != null) {
                part = line.split(SEP);

                if (part[0].indexOf(",") > -1) {
                    nombre = part[1].substring(part[0].indexOf(",") + 1).trim();
                    apellidos = part[0].substring(0, part[0].indexOf(",")).trim();
                } else if (part[0].indexOf(" ") > -1) {
                    nombre = part[0].substring(0, part[0].indexOf(" ")).trim();
                    apellidos = part[0].substring(part[0].indexOf(" ") + 1).trim();
                } else {
                    nombre = part[0].trim();
                    apellidos = "";
                }

                sb.append(nombre).append(SEP); // Nombre
                sb.append(apellidos).append(SEP); // Apellidos

                sb.append(formatoFecha(part[4])).append(SEP); // Fecha de nacimiento

                if ("M".equals(part[10])) { // Sexo
                    sb.append("Mujer").append(SEP);
                } else if ("H".equals(part[10])) {
                    sb.append("Varón").append(SEP);
                } else {
                    sb.append("").append(SEP);
                }

                sb.append("").append(SEP); // Teléfono
                sb.append("").append(SEP); // Email
                sb.append("").append(SEP); // Etapa
                sb.append("").append(SEP); // Curso
                sb.append("").append(SEP); // Aula
                sb.append(part[2]).append(SEP); // Num Socio
                sb.append(formatoFecha(part[4])).append(SEP); // Fecha Alta

                sb.append("").append(SEP); // Apellidos y Nombre Padre/Madre
                sb.append("").append(SEP); // Teléfono
                sb.append("").append(SEP); // Apellidos y Nombre(2) Padre/Madre
                sb.append("").append(SEP); // Teléfono (2)
                sb.append("").append(SEP); // Cta Corriente
                sb.append("").append(SEP); // Fecha firma orden domiciliación

                sb.append("").append(SEP); // Código Actividad
                sb.append("").append(SEP); // Código Actividad
                sb.append("").append(SEP); // Código Actividad
                sb.append("").append(SEP); // Código Actividad
                sb.append("").append(SEP); // Código Actividad

                sb.append(part[25]).append(SEP); // Comentarios

                pw.println(sb.toString());
                sb.setLength(0);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String formatoFecha(String org) {
        String[] part = org.split("-");
        if (part.length < 3) {
            return "";
        } else {
            String month = "";
            switch (part[1]) {
                case "ene":
                    month = "01";
                    break;
                case "feb":
                    month = "02";
                    break;
                case "mar":
                    month = "03";
                    break;
                case "abr":
                    month = "04";
                    break;
                case "may":
                    month = "05";
                    break;
                case "jun":
                    month = "06";
                    break;
                case "jul":
                    month = "07";
                    break;
                case "ago":
                    month = "08";
                    break;
                case "sep":
                    month = "09";
                    break;
                case "oct":
                    month = "10";
                    break;
                case "nov":
                    month = "11";
                    break;
                case "dic":
                    month = "12";
                    break;
                default:
                    month = "01";
            }
            return part[0] + "-" + month + "-20" + part[2];
        }
    }

}
