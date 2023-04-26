import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class APASoftLoader {

    static final String BASE_PATH = "C:\\Users\\jiglesias\\Downloads\\";
    static final String SOURCE_FILE = "Tutores_export.csv";
    static final String TARGET_FILE = "Importar_Socios.csv";
    static final String SEP = ";";

    public static void main(String[] args) {

        // id padre id2 nif madre nif2 direccion direccion 2 telefono telefono2 fijo
        // fijo2 A B t3 t4 C D email1 email2 E F G H aa bb cc dd ee ff gg hh ii jj kk ll
        // mm
        // Nº Socio Fecha Alta Nombre Apellidos Dni Sexo Email Dirección Ciudad Teléfono
        // Fijo Móvil Provincia Código Postal Cta Corriente Fecha firma orden
        // domiciliación Notas Septiembre Octubre Noviembre Diciembre Enero Febrero
        // Marzo Abril Mayo Junio Julio Agosto Nombre Apellidos Dni Sexo Email Dirección
        // Ciudad Teléfono Fijo Móvil Provincia Código Postal Notas

        try (BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + SOURCE_FILE, StandardCharsets.UTF_8));
                PrintWriter pw = new PrintWriter(new FileWriter(TARGET_FILE, StandardCharsets.UTF_8))) {

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
                sb.append("Madrid").append(SEP); // ciudad
                sb.append(part[10]).append(SEP); // telefono
                sb.append(part[8]).append(SEP); // movil
                sb.append("MADRID").append(SEP); // provincia
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
                sb.append("Madrid").append(SEP); // ciudad
                sb.append(part[11]).append(SEP); // telefono
                sb.append(part[9]).append(SEP); // movil
                sb.append("MADRID").append(SEP); // provincia
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

}
