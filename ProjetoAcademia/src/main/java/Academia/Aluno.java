package Academia;

/**
 *
 * @author Janiele
 */
public class Aluno extends Usuario {

    private String status;
    private String matricula;
    private String objetivo;

    public Aluno(int id, String nome, String cpf, String email,
                 String dataNasc, String senha, String tipo) {
        super(id,nome,cpf,email,dataNasc,senha,tipo);
    }
    
    //construtor vazio
    public Aluno(){
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

}
