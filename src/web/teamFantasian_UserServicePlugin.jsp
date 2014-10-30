<%@ page
   import="org.jivesoftware.openfire.XMPPServer,
           de.meisterfuu.openfire.plugin.teamFantasian_UserServicePlugin,
           org.jivesoftware.util.ParamUtils,
           java.util.HashMap,
           java.util.Map"
   errorPage="error.jsp"%>


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%
	boolean save = request.getParameter("save") != null;	
	String pNameSpace = ParamUtils.getParameter(request, "pNameSpace");
	String pModule = ParamUtils.getParameter(request, "pModule");
    String pCreateUser = ParamUtils.getParameter(request, "pCreateUser");
    String pCreateUser_input = ParamUtils.getParameter(request, "pCreateUser_input");
    String pCreateUser_output = ParamUtils.getParameter(request, "pCreateUser_output");
    



  teamFantasian_UserServicePlugin plugin = (teamFantasian_UserServicePlugin) XMPPServer.getInstance().getPluginManager().getPlugin("teamFantasianUserServicePlugin");


  	
	if(plugin == null) {

	out.println("Cant find plugin ..!!");
	return;
	}



	Map<String, String> errors = new HashMap<String, String>();	


	pNameSpace = plugin.getNameSpace();
	pModule = plugin.getModule();
	pCreateUser = plugin.getCreateUser();
	pCreateUser_input = plugin.getCreateUser_input();
	pCreateUser_output = plugin.getCreateUser_output();

%>

<html>
	<head>
	  <title>Admin Console</title>
	  <meta name="pageID" content="teamFantasian_UserServicePlugin-form"/>
	</head>
	<body>
<form action="teamFantasian_UserServicePlugin.jsp?save" method="post">

<div class="jive-contentBoxHeader">Options</div>
<div class="jive-contentBox">
   
	<% if (ParamUtils.getBooleanParameter(request, "settingsSaved")) { %>
   
	<div class="jive-success">
	<table cellpadding="0" cellspacing="0" border="0">
	<tbody>
	  <tr>
	     <td class="jive-icon"><img src="images/success-16x16.gif" width="16" height="16" border="0"></td>
	     <td class="jive-icon-label">Setting Saved</td>
	  </tr>
	</tbody>
	</table>
	</div>
   
	<% } %>
   	
   <br>
	<p>Options</p>
   
	<table cellpadding="3" cellspacing="0" border="0" width="100%">
	<tbody>


	  <tr>
	  	<td>Name Space</td>
	  	<td><input type="text" name="pNameSpace" value="<%= pNameSpace %>"></td>
	  </tr>

             
	  <tr>
	  	<td>Module</td>
	  	<td><input type="text" name="pModule" value="<%= pModule %>"></td>
	  </tr>

	  <tr>
	  	<td>Create User (Method,Input,Output)</td>
	  	<td><input type="text" name="pCreateUser" value="<%= pCreateUser %>"></td>
	  	<td><input type="text" name="pCreateUser_input" value="<%= pCreateUser_input %>"></td>
	    <td><input type="text" name="pCreateUser_output" value="<%= pCreateUser_output %>"></td>
	  </tr>




	</tbody>
	</table>
</div>
<input type="submit" value="Submit" />"/>
</form>

</body>
</html>
