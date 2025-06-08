/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas_view;
import Academia.Usuario;

/**
 *
 * @author samue
 */
public class Sessao_usuario {
    private static Usuario usuarioLogado;

    // Define o usuário logado (pode ser Aluno, Personal, Adm, etc.)
    public static void setUsuarioLogado(Usuario usuario) {
        Sessao_usuario.usuarioLogado = usuario;
    }

    // Retorna o usuário logado
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    // Limpa a sessão (ex: ao deslogar)
    public static void limparSessao() {
        usuarioLogado = null;
    }
}
    
    

