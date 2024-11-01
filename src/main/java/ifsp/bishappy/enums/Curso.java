package ifsp.bishappy.enums;

public enum Curso {

    INFORMATICA("Informática"),
    MECANICA("Mecânica"),
    ELETRONICA("Eletrônica");

    private String curso;

    private Curso(String curso) {
        this.curso = curso;
    }

    public String getCurso() {
    	return curso;
    }
}
