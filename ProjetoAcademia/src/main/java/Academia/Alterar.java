package Academia;

import java.sql.Date;

public class Alterar {

    public void alterarAluno(Aluno aluno, int id, String nome, String cpf, String email, String dataNasc,
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

    public void alterarPersonal(Personal personal, int id, String nome, String cpf, String email, Date dataNasc, 
            String senha, String tipo, String especialidade, double salario, double bonus_por_aluno) {
        
        personal.setNome(nome);
        personal.setCpf(cpf);
        personal.setEmail(email);
        personal.setDataNasc(tipo);
        personal.setSenha(senha);
        personal.setTipo(tipo);
        personal.setBonus_por_aluno(bonus_por_aluno);
        personal.setEspecialidade(especialidade);
        personal.setSalario(salario);
        
    }
}
