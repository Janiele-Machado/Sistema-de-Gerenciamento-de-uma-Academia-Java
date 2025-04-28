package Academia;

import java.sql.Date;

public class Personal extends Usuario {

    private String especialidade;

    //construtor vazio
    public Personal() {

    }

    public Personal(int id, String nome, String cpf, String email,Date dataNasc, String senha, String tipo, String especialidade) {
        super(id, nome, cpf, email, dataNasc, senha, tipo);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
