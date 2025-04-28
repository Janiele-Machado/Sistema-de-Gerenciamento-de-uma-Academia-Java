package Academia;

public class Alterar {
    public void alterarAluno(Aluno aluno,int id, String nome, String cpf, String email, String dataNasc,
        String senha, String tipo, String status, String matricula, String Objetivo) {

        aluno.setMatricula(matricula);
        aluno.setObjetivo(Objetivo);
        aluno.setStatus(status);

        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setDataNasc(dataNasc);
        aluno.setSenha(senha);
        aluno.setTipo(tipo);
    }
}
