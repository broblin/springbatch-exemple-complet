
Pour lancer la base h2 :
LaunchDatabaseAndConsole

Pour lancer SpringBatch:
AuteurLauncher

Bon à savoir :
ne pas oublier de de mettre scope="step" si on veut injecter un paramètre provenant de jobParameters
inspiré de spring batch in action


Notion vu dans ce POC (accent mis sur l'étape d'insertion des livres) :

1) DecompressTaskLet de sbia, voir si libre de droit ou si on peut faire mieux (pas de classe toute faite :https://jira.springsource.org/browse/BATCH-1750)
p41

2) validation des paramètres p50 ou p81

3) flux en cas où les paramètres ne sont pas bons p65 (voir validation des paramètres)
voir : https://code.google.com/p/springbatch-in-action/source/browse/trunk/sbia/ch11/src/main/resources/com/manning/sbia/ch11/job-with-deciders.xml?r=122

4) skip (chapitre 2 p52) + un listener qui logue ou sauve les lignes ne pouvant être traité en base (chapitre 9)
voir aussi en cas de pb : http://stackoverflow.com/questions/7638924/spring-batch-skiplistener-not-called-when-exception-occurs-in-reader

5) au cas où le batch échoue (chapitre 4 p102) :
http://www.dzone.com/snippets/spring-batch-job-execution

6) combiner plusieurs processors avec un qui valide fonctionellement une ligne (chapitre 8) : p171
on prendra comme exemple un prix negatif.

Pour aller plus loin :

5) retry pour les exceptions hasardeuse (lock de table ...) (chapitre 9)

6) spring batch admin + sauvegarde en base de l'état en BD (schéma fourni par spring batch)

7) possibilité de lancer le job via une classe fournie par spring batch (p48 du livre sbia)