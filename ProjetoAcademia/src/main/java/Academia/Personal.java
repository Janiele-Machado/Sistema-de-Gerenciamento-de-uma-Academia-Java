package Academia;

import java.sql.Date;

public class Personal extends Usuario {

    private String especialidade;
    private double salario; 
    private double bonus_por_aluno;
    private int qtd_aluno;
    //construtor vazio
    public Personal() {

    }

    public Personal(int id, String nome, String cpf, String email,Date dataNasc, String senha, String tipo, 
            String especialidade,double salario,double bonus_por_aluno,int qtd_aluno) {
        super(id, nome, cpf, email, dataNasc, senha, tipo);
        this.especialidade = especialidade;
        this.bonus_por_aluno = bonus_por_aluno;
        this.qtd_aluno = qtd_aluno;
        this.salario = salario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonus_por_aluno() {
        return bonus_por_aluno;
    }

    public void setBonus_por_aluno(double bonus_por_aluno) {
        this.bonus_por_aluno = bonus_por_aluno;
    }

    public int getQtd_aluno() {
        return qtd_aluno;
    }

    public void setQtd_aluno(int qtd_aluno) {
        this.qtd_aluno = qtd_aluno;
    }

}
