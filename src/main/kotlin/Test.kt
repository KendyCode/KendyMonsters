package jeu

import item.*
import monstre.*
import org.example.dresseur.Entraineur
import kotlin.random.Random

class MachineLoot {

    private val prix = 100

    fun jouer(joueur: Entraineur) {
        // Vérifie si le joueur a assez d'argent
        if (joueur.argents < prix) {
            println("Vous n’avez pas assez d’argent pour jouer (100 pièces nécessaires).")
            return
        }

        // Retire le prix et lance la machine
        joueur.argents -= prix
        println("Vous insérez $prix pièces...")
        println("La machine tourne...")
        Thread.sleep(1000)

        // Tirage aléatoire
        val tirage = Random.nextInt(1, 101)

        when {
            tirage <= 50 -> { // 50% de chance d’avoir un item commun
                val item = Item(1, "Potion", "Restaure quelques PV")
                joueur.sacAItems.add(item)
                println("Vous obtenez : ${item.nom}")
            }
            tirage in 51..85 -> { // 35% de chance d’avoir un item rare
                val item = MonsterKube(10, "Super Kube", "Permet une capture plus facile", 40.0)
                joueur.sacAItems.add(item)
                println("Vous obtenez un item rare : ${item.nom}")
            }
            tirage in 86..95 -> { // 10% de chance d’avoir un monstre
                val espece = EspeceMonstre( id = 1,
                    nom = "Flamkip",
                    type = "Feu",
                    baseAttaque = 12,
                    baseDefense = 9,
                    baseVitesse = 10,
                    baseAttaqueSpe = 14,
                    baseDefenseSpe = 11,
                    basePv = 52,
                    modAttaque = 10.0,
                    modDefense = 8.5,
                    modVitesse = 8.0,
                    modAttaqueSpe = 11.0,
                    modDefenseSpe = 9.5,
                    modPv = 24.0,
                    description = "Flingué",
                    particularites = "Son corps brille légèrement quand il est motivé.",
                    caracteres = "Brave, loyal, enthousiaste")
                val monstre = IndividuMonstre(1000, espece.nom, espece, joueur, 500.0)
                joueur.equipeMonstre.add(monstre)
                println("Vous obtenez un nouveau monstre : ${monstre.nom} !")
            }
            else -> { // 5% de chance de rater
                println("Rien du tout BAHAHHAHAHAHHA... pas de chance !")
            }
        }

        println("Argents restants : ${joueur.argents}")
    }
}

fun main() {
    val joueur = Entraineur(
        id = 1,
        nom = "Léo",
        argents = 300,
        equipeMonstre = mutableListOf(),
        boiteMonstre = mutableListOf(),
        sacAItems = mutableListOf()
    )

    val machine = MachineLoot()

    println("=== Machine de Loot ===")

    while (true) {
        println("\n1. Tenter votre chance (100 pièces)")
        println("2. Voir l’inventaire")
        println("3. Quitter")

        when (readln()) {
            "1" -> machine.jouer(joueur)
            "2" -> {
                println("Items : ${joueur.sacAItems.map { it.nom }}")
                println("Monstres : ${joueur.equipeMonstre.map { it.nom }}")
                println("Argents : ${joueur.argents}")
            }
            "3" -> {
                println("Merci d’avoir joué !")
                return
            }
            else -> println("Choix invalide.")
        }
    }
}
