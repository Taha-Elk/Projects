<?php
$host="localhost";
$user="root";
$mdp="";
$bdd="radeef_releve";
$connexion=new mysqli($host, $user, $mdp, $bdd);



  
if(isset($_POST['username']) && isset($_POST['password']))
{
$username = $_POST['username'];	
$password = $_POST['password'];	

session_start();
$_SESSION['username']=$username;

$requete="SELECT `num_releveur`,`mdp_releveur` FROM `releveur`";
$result=$connexion->query($requete);
$tab=[];
while ($ligne=$result->fetch_assoc()){
	$tab[$ligne['num_releveur']] = $ligne['mdp_releveur'];
}

$trouve=false;
foreach($tab as $key=> $value){
	if (($username == $key) && ($password == $value))
	{
		$trouve=true;
		break;
	}
}
	if($trouve)
	{
	header("location: indexationn.php");
	}
	else{ 
	echo "<p class='erreur'><b>Erreur, veuillez réessayer</b></p>";
	}
	}
	?>
	
		




<!DOCTYPE html>
<html>
  <head>
   <meta charset="utf-8">
   <title>Projet1 RADEEF</title>
   <link href="index.css" rel="stylesheet"> 
  </head>
  <body>
    <div class="image">
      <img src="logo.PNG">
    </div>
	<div class="container">
	 <div class="section">
       <h1>Login Releveur</h1>
	   
        <form action="#" method="post">
         <div class="domaine">
	       <label><B>Identifiant releveur</b></label>
		   <br>
	       <input type="text" name="username" size="15" required>
	       <br><br>
   		   <label><b>Mot de passe (Radeef)</b></label>
		   <br>
	       <input type="password" name="password" size="15" required><br><br>
	     </div>
	     <div class="bouton">
	       <input type="submit" value="Login">
	     </div>
	    </form>	 
	 </div>
    </div>	 
  </body>
 </html>