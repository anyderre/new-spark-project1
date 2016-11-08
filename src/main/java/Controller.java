//package Controlador;
/**
 * Created by Dany on 04/09/2016.
 *
 */

import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import static spark.Spark.*;

public class Controller {

    public static  ICRUD <Participante> participanteModel;
    public static void main(String[] args) {
        Spark.staticFileLocation("/templates");
            try{
                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

                Participante par = new Participante("Pierre Dany", "Ridore Lamothe",formatter.parse("1992-05-14"),'M',"jkdj22" , "JNNJN-MMHGMB","ridoreda1992@gmail.com", "8294480042", "8099714287" );
                participanteModel = new ParticipanteModel<>(5432, "pierre0592", "Acreser", "postgres");
                ArrayList<Participante> participantes = participanteModel.getElements(0);


                System.out.println(participantes.get(0).getNombre()+" "+participantes.get(1).getNombre()+" "+ participantes.get(2).getNombre());
            }catch (Exception ex){
                ex.getMessage();
            }

        get("/Inscripciones", (request, response)-> {
            response.type("text/html");
            HashMap model = new HashMap();

            model.put("template", "templates/Inscripciones.html");
            return new ModelAndView(model, "templates/Inscripciones.html");
        }, new VelocityTemplateEngine());

        get("/registrarParticipantes", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();

            model.put("template", "templates/registrarParticipantes.html");
            return new ModelAndView(model, "templates/registrarParticipantes.html");
        }, new VelocityTemplateEngine());


        post("/registrarParticipantes", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();
            String nombres = request.queryParams("nombres");
            String apellidos = request.queryParams("apellidos");
            String cedula = request.queryParams("cedula");
            String telRes = request.queryParams("residencial");
            String telcel = request.queryParams("celular");
            String sexo = request.queryParams("Sexo");
            String fecha = request.queryParams("birthday");
            String email = request.queryParams("email");

            try {

                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
                Date date = formatter.parse(fecha);

                Participante participante = new Participante(nombres, apellidos, date, sexo.charAt(0), null, cedula, email, telcel, telRes);

                participanteModel = new ParticipanteModel<>(5432, "pierre0592", "Acreser", "postgres");

                System.out.println("I Was there");
                participanteModel.insert(participante);
                System.out.println("I Was there again!!!");
            } catch (Exception ex){
                System.out.println("Failed!");
                System.out.println(ex.getMessage());
            }

            System.out.println(nombres+ "  " + apellidos + " " + fecha+ "  " + cedula + "  " + sexo + "  " + telcel + "  " + telRes );
            return new ModelAndView(model, "templates/registrarParticipantes.html");
        }, new VelocityTemplateEngine());





        get("/registrarEntrenadores", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();

            model.put("template", "templates/registrarEntrenadores.html");
            return new ModelAndView(model, "templates/registrarEntrenadores.html");
        }, new VelocityTemplateEngine());


        post("/registrarEntrenadores", (request, response) -> {
            response.type("text/html");
            HashMap modelEntrenadores = new HashMap();
            String nombres = request.queryParams("nombres");
            String apellidos = request.queryParams("apellidos");
            String cedula = request.queryParams("cedula");
            String telRes = request.queryParams("residencial");
            String telcel = request.queryParams("celular");
            String sexo = request.queryParams("Sexo");
            String fecha = request.queryParams("birthday");

            System.out.println(nombres+ "  " + apellidos + " " + fecha+ "  " + cedula + "  " + sexo + "  " + telcel + "  " + telRes );
            return new ModelAndView(modelEntrenadores, "templates/registrarEntrenadores.html");
        }, new VelocityTemplateEngine());


        get("/registrarTaller", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();

            model.put("template", "templates/registrarTaller.html");
            return new ModelAndView(model, "templates/registrarTaller.html");
        }, new VelocityTemplateEngine());


        post("/registrarTaller", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();
            String nombre = request.queryParams("nombre");
            String prerequisito = request.queryParams("prerequisito");
            String descripcion = request.queryParams("descripcion");

            System.out.println(nombre+ "  " + prerequisito + " " + descripcion);
            return new ModelAndView(model, "templates/registrarTaller.html");
        }, new VelocityTemplateEngine());

        get("/registrarGrupo", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();

            model.put("template", "templates/registrarGrupo.html");
            return new ModelAndView(model, "templates/registrarGrupo.html");
        }, new VelocityTemplateEngine());


        post("/registrarGrupo", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();
            String nombre = request.queryParams("nombre");
            String fechaInicio = request.queryParams("fechaInicio");
            String fechaFin = request.queryParams("fechaFin");
            String tipo = request.queryParams("tipo");
            String Entrenador = request.queryParams("entrenador");
            String cupo = request.queryParams("cupo");
            String costo = request.queryParams("costo");


            System.out.println("Grupo "+nombre+ "  " + fechaInicio + " " + fechaFin + " " + tipo + " " + Entrenador + " " + cupo + " " + costo);
            return new ModelAndView(model, "templates/registrarGrupo.html");
        }, new VelocityTemplateEngine());

        get("/registrarPrograma", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();

            model.put("template", "templates/registrarPrograma.html");
            return new ModelAndView(model, "templates/registrarPrograma.html");
        }, new VelocityTemplateEngine());


        post("/registrarPrograma", (request, response) -> {
            response.type("text/html");
            HashMap model = new HashMap();
            String nombre = request.queryParams("nombre");
            String fechaInicio = request.queryParams("fechaInicio");
            String fechaFin = request.queryParams("fechaFin");
            String tipo = request.queryParams("tipo");
            String talleres = request.queryParams("talleres");

            System.out.println("Programa "+nombre+ "  " + fechaInicio + " " + fechaFin + " " + tipo + " "  + talleres);
            return new ModelAndView(model, "templates/registrarPrograma.html");
        }, new VelocityTemplateEngine());
    }



}