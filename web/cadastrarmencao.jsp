<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form name="cadastrarprofessor" action="CadastrarProfessor" method="POST">
            <table align="center" border="0">
                <tr>
                    <th colspan="2" align="center">Cadastro de Redações</th>
                </tr>
                
                <tr>
                    <th colspan="2" align="center">${mensagem}</th>
                </tr>
                
                <tr>
                    <td><label for="nomeUsuario" >Nome da menção:</label></td>
                    <td><input type="text" name="nomeMencao" ></td>
                </tr>
                     
                <tr>
                    <td><label for="emailUsuario" >Descrição da menção:</label></td>
                    <td><input type="text" name="descMencao"></td>
                </tr>
                
               
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="cadastrar" value="Cadastrar" >
                    </td>
                </tr>
                
                <tr>
                    <td align="center" colspan="2"><a href="index.jsp">Voltar</a></td>
                </tr>
            </table>
        </form>
             
    </body>
</html>
