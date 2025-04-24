package Academia;

public class Personal extends Usuario {
    
        private String especialidade;
        
        public Personal(int id, String nome, String cpf, String email, String dataNasc, String senha, String tipo, String especialidade) {
        super(id, nome, cpf, email, dataNasc, senha, tipo);
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setDataNasc(dataNasc);
        setSenha(senha);
        setTipo(tipo);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
}
