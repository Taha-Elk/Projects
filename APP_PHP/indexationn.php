<?php
$host="localhost";
$user="root";
$mdp="";
$bdd="radeef_releve";
$connexion=new mysqli($host, $user, $mdp, $bdd);

$getpage = isset($_GET["page"]) ? $_GET["page"] : NULL;
if ($getpage=="" || $getpage=="1"){
  $page=1;
  $page0=0;
}
else{
  $page=$getpage;
  $page0=$getpage-1;
}

session_start();
$username=$_SESSION['username'];
$_SESSION['page']=$page;

$requete0="SELECT `num_releveur`,`association`.`num_compteur`, `adresse_compteur`, `clients`.`num_tournet`,`proprietaire` FROM (`clients` JOIN `association` ON `clients`.`num_compteur`=`association`.`num_compteur`) WHERE `num_releveur`=$username";
$result0=$connexion->query($requete0);
$num_lines=mysqli_num_rows($result0);

$requete="SELECT `num_releveur`,`association`.`num_compteur`, `adresse_compteur`, `clients`.`num_tournet`,`proprietaire` FROM (`clients` JOIN `association` ON `clients`.`num_compteur`=`association`.`num_compteur`) WHERE `num_releveur`=$username limit $page0,1";
$result=$connexion->query($requete);



while ($ligne=$result->fetch_assoc()){
	$requete1="SELECT `date_releve`,`index_compteur`,`num_compteur` FROM `releves` WHERE `num_compteur`=".$ligne['num_compteur']." ORDER BY `date_releve`DESC limit 1";
	$result1=$connexion->query($requete1);
	while ($ligne1=$result1->fetch_assoc()){
	?>
	
	
	
<!DOCTYPE html>
<html>
<head>
   <title>Projet1 RADEEF</title>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="indexationn.css" rel="stylesheet"> 
</head>


<body>

    <div class="entete">
        <div class="image">
            <img src="logo.PNG">
        </div>
        <div class="logoutbut">
            <h1><a class="grA" href="index.php" >Log out</a></h1>
        </div>
    </div>
	
    <div class="container">
	    <div class="section">
            <h1>Infos de Relève</h1>
            <form action="sauvegardes.php" method="post">
                <div class="domaine">
	                <div class="minidomaine1">
	                    <div class="numero_du_releveur">
			                <b>numéro du releveur&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="numero_du_releveur" value="<?php echo $ligne['num_releveur'];?>" class="a" readonly>
		                </div>
		                <br><br>
		                <div class="numero_du_compteur">
		                    <b>numéro du compteur&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="numero_du_compteur" value="<?php echo $ligne['num_compteur'];?>" class="a" readonly>
		                </div>
		                <br><br>
		                <div class="adresse">
	                        <b>adresse&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="adresse" value="<?php echo $ligne['adresse_compteur'];?>" class="a" readonly>
		                </div>
		                <br><br>
		                <div class="ancienne_date_de_releve">
	                        <b>ancienne date de releve&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="ancienne_date_de_releve" value="<?php echo $ligne1['date_releve'];?>" class="a" readonly>
	   	                </div>
		                <br><br>
		                <div class="nouvelle_date_de_releve">
	                        <b>nouvelle date de releve&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="nouvelle_date_de_releve" value="<?php echo date("Y-m-d H:i:s");?>" class="a" readonly>
		                </div>
	                </div>
                    <div class="minidomaine2">	
	                    <br><br><br>
		                <div class="numero_de_tournet">
	                        <b>numéro de tournet&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="numero_de_tournet" value="<?php echo $ligne['num_tournet'];?>" class="a" readonly>
		                </div>
		                <br><br>
	             	    <div class="proprietaire">
	                        <b>propriétaire&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="proprietaire" value="<?php echo $ligne['proprietaire'];?>" class="a" readonly>
		                </div>
		                <br><br>
	                    <div class="ancien_index">
                            <b>ancien index&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="ancien_index" value="<?php echo $ligne1['index_compteur'];?>" class="a" readonly> 
					    </div>
	                    <br><br>
		                <div class="nouveau_index">
	                        <b>nouveau index&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="text" name="nouveau_index">
	           	        </div>
	                    <br><br>
		                <div class="remarque">
	                        <b>remarque&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><textarea name="remarque" cols="22" rows="3"></textarea>
		                </div>
	                </div>
	            </div>
	            <div class="conteneur">
	                <div class="bouton12">
	                    <div class='bouton1 boutons'>
	                        <?php if ($page>1){echo "<b><a class='grB' href='indexationn.php?page=".($page-1)."' >&lt;&lt;&nbsp;&nbsp;précédent</a></b>";}?>
	                    </div>
	                    <br><br>
	                    <div class="bouton2 boutons">	
                            <?php if ($page<$num_lines){echo "<b><a class='grB' href='indexationn.php?page=".($page+1)."' >suivant&nbsp;&nbsp;&gt;&gt;</a></b>";}?>
	                    </div>
	                </div>    
                    <div class="bouton3">	 
		                <input type="submit" value="Enregistrer">
                    </div>
	            </div>
	        </form> 
		</div>	
    </div>
</body>
</html>
<?php }}?>