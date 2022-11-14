<%@page import="br.com.projetoredatec.model.Professor"%>
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
                <td colspan="10" align="center">Lista de usuários</td>
            </tr>

            <tr>
                <th align="center">Nome</th>
                <th align="center">Email</th>
                  <th align="center">RM do professor </th>
                <th align="center">Telefone</th>
                <th align="center">Login</th>
                <th align="center" colspan="2">Editar</th>
            </tr>

            <%
                List<Professor> professores = (List<Professor>) request.getAttribute("professores");
                for (Professor professor : professores) {
            %>
            <tr>
                <td align="center"><%=professor.getNomeUsuario()%></td>
                <td align="center"><%=professor.getEmailUsuario()%></td>
                <td align="center"><%=professor.getRmProfessor()%></td>
                <td align="center"><%=professor.getTelefoneUsuario()%></td>
                <td align="center"><%=professor.getLoginUsuario()%></td>
                <td align="center"><a href="ExcluirProfessor?idUsuario=<%=professor.getIdUsuario()%>">Excluir</a></td>
                <td align="center"><a href="CarregarProfessor?idUsuario=<%=professor.getIdUsuario()%>">Alterar</a></td>
            </tr>

            <%
                }
            %>

            <tr>
                <td align="center" colspan="10"><a href="index.jsp">Voltar </a></td>
            </tr>

        </table></div>
        
    </body>
</html>
