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

            <div class="col-9"><h1 align="center">Etec de Fernandópolis</h1>
        <hr>
        <table class="table table-info table-striped-columns" align="center" border="1">
            <tr>
                <td colspan="10" align="center">Lista de usuários</td>
            </tr>

            <tr>
                <th align="center">Nome da truma</th>
                <th align="center" colspan="2">Editar</th>
            </tr>

            <%
                List<Turma> turmas = (List<Turma>) request.getAttribute("turmas");
                for (Turma turma : turmas) {
            %>
            <tr>
                <td align="center"><%=turma.getNomeTurma()%></td>
                <td align="center"><a class="btn btn-primary" href="ExcluirTurma?idUsuario=<%=turma.getIdUsuario()%>">Excluir</a></td>
                <td align="center"><a class="btn btn-primary" href="CarregarTurma?idUsuario=<%=turma.getIdUsuario()%>">Alterar</a></td>
            </tr>

            <%
                }
            %>

            <tr>
                <td align="center" colspan="10"><a href="index.jsp" class="btn btn-primary">Voltar </a></td>
            </tr>

        </table></div>
        
    </body>
</html>
