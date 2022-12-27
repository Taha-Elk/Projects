<?php
$host="localhost";
$user="root";
$mdp="";
$bdd="radeef_releve";
$connexion=new mysqli($host, $user, $mdp, $bdd);



$numero_du_releveur=$_POST['numero_du_releveur'];
$numero_du_compteur=$_POST['numero_du_compteur'];
$adresse=$_POST['adresse'];
$ancienne_date_de_releve=$_POST['ancienne_date_de_releve'];
$nouvelle_date_de_releve=$_POST['nouvelle_date_de_releve'];
$numero_de_tournet=$_POST['numero_de_tournet'];
$proprietaire=$_POST['proprietaire'];
$ancien_index=$_POST['ancien_index'];
$nouveau_index=$_POST['nouveau_index'];
$remarque=$_POST['remarque'];

$requete="INSERT INTO `releves`(`date_releve`, `num_compteur`, `index_compteur`, `remarque`, `num_releveur`) VALUES ('$nouvelle_date_de_releve','$numero_du_compteur','$nouveau_index','$remarque','$numero_du_releveur')";
$result=$connexion->query($requete);

session_start();
$page=$_SESSION['page'];

header("location: indexationn.php?page=".$page);
?>