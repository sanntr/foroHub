package com.alura.challenge.foro.domain.model.curso;

public enum CategoriaCurso {
    PROGRAMACION_WEB("Programación Web"),
    BASES_DE_DATOS("Bases de Datos"),
    DESARROLLO_MOVIL("Desarrollo Móvil"),
    INTELIGENCIA_ARTIFICIAL("Inteligencia Artificial"),
    REDES_Y_SEGURIDAD("Redes y Seguridad"),
    SISTEMAS_OPERATIVOS("Sistemas Operativos"),
    MATEMATICAS_Y_ESTADISTICA("Matemáticas y Estadística"),
    FISICA_Y_ELECTRONICA("Física y Electrónica"),
    INGENIERIA_DE_SOFTWARE("Ingeniería de Software"),
    DISENO_Y_UI_UX("Diseño y UX/UI"),
    ADMINISTRACION_Y_PROYECTOS("Administración y Gestión de Proyectos"),
    ANUNCIOS_Y_NOVEDADES("Anuncios y Novedades"),
    DUDAS_GENERALES("Dudas Generales"),
    RECURSOS_Y_TUTORIALES("Recursos y Tutoriales"),
    PROYECTOS_DE_LA_COMUNIDAD("Proyectos de la Comunidad");

    private final String textoAmigable;

    CategoriaCurso(String textoAmigable) {
        this.textoAmigable = textoAmigable;
    }

    public String getTextoAmigable() {
        return textoAmigable;
    }

    @Override
    public String toString() {
        return textoAmigable;
    }
}
