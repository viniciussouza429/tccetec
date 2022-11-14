<%@page import="br.com.projetoredatec.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciamento de Usuários</title>
        
    </head>
    <body>

       
            <h1 align="center">Etec de Fernandópolis</h1>
        <hr>
        <table align="center" border="1">
            <tr>
                <td colspan="9" align="center">Lista de usuários</td>
            </tr>

            <tr>
                <th align="center">Nome</th>
                <th align="center">Email</th>
                <th align="center">Telefone</th>
                <th align="center">Login</th>
                <th align="center">RA do aluno </th>
                <th align="center" colspan="2">Editar</th>
            </tr>

            <%
                List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
                for (Aluno aluno : alunos) {
            %>
            <tr>
                <td align="center"><%=aluno.getNomeUsuario()%></td>
                <td align="center"><%=aluno.getEmailUsuario()%></td>
                <td align="center"><%=aluno.getRaAluno()%></td>
                <td align="center"><%=aluno.getTelefoneUsuario()%></td>
                <td align="center"><%=aluno.getLoginUsuario()%></td>
                <td align="center"><a href="ExcluirAluno?idUsuario=<%=aluno.getIdUsuario()%>">Excluir</a></td>
                <td align="center"><a href="CarregarAluno?idUsuario=<%=aluno.getIdUsuario()%>">Alterar</a></td>
            </tr>

            <%
                }
            %>

            <tr>
                <td align="center" colspan="10"><a href="index.jsp" >Voltar </a></td>
            </tr>

        </table></div>
        
    </body>
</html>
