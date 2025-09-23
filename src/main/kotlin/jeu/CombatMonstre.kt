package jeu

import item.Utilisable
import joueur
import monstre.IndividuMonstre

class CombatMonstre(
    var monstreJoueur : IndividuMonstre,
    var monstreSauvage : IndividuMonstre
) {
    var round : Int = 1
    /**
     * Vérifie si le joueur a perdu le combat.
     *
     * Condition de défaite :
     * - Aucun monstre de l'équipe du joueur n'a de PV > 0.
     *
     * @return `true` si le joueur a perdu, sinon `false`.
     */
    fun gameOver() : Boolean{
        var verif = true
        for (monstre in joueur.equipeMonstre){
            if (monstre.pv>0){
                verif = false
            }
        }
        return verif
    }

    fun joueurGagne() : Boolean{
        if (monstreSauvage.pv <= 0){
            println("${joueur.nom} a gagné !")
            var gainExp = monstreSauvage.exp * 0.20
            monstreJoueur.exp += gainExp
            println("${monstreJoueur.nom} gagne {$gainExp} exp")
            return true
        }
        else{
            if(monstreSauvage.entraineur == joueur){
                println("${monstreSauvage.nom} a été capturé !")
                return true
            }
            else{
                return false
            }
        }
    }

    fun actionAdversaire(){
        if(monstreSauvage.pv > 0){
            monstreSauvage.attaquer(monstreJoueur)
        }


    }

    fun actionJoueur() : Boolean{
        if(gameOver()== true){
            return false
        }
        else{
            println("Choisis entre (1,2,3)")
            var choixAction = readln().toInt()
            if (choixAction==1){
                monstreJoueur.attaquer(monstreSauvage)
            }
            else if(choixAction==2){
                println(joueur.sacAItems)
                println("Saisir le nb de l'item")
                var indexChoix : Int = readln().toInt()
                var objetChoisi = joueur.sacAItems[indexChoix]

                if(objetChoisi is Utilisable){
                    var captureReussie = objetChoisi.utiliser(monstreSauvage)
                    if(captureReussie){
                        return false
                    }
                    else{
                        println("Objet non utilisable")
                    }
                }
            }
            else if(choixAction==3){
                
            }

        }


    }



}