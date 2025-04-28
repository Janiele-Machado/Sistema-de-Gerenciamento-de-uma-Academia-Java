package Academia;

public class Alterar {
    public void alterarAluno(Aluno aluno,int id, String nome, String cpf, String email, String dataNasc,
        String senha, String tipo, String status, String matricula, String Objetivo) {

        aluno.setMatricula(matricula);
        aluno.setObjetivo(Objetivo);
        aluno.setStatus(status);
}
