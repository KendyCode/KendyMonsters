
import org.example.dresseur.Entraineur
import monstre.EspeceMonstre

var joueur = Entraineur(1, "Sacha", 100)
var rival = Entraineur(2,"Regis",200)

var especeSpringleaf = EspeceMonstre(
    id = 1,
    nom = "Springleaf",
    type = "Graine",
    baseAttaque = 9,
    baseDefense = 11,
    baseVitesse = 10,
    baseAttaqueSpe = 12,
    baseDefenseSpe = 14,
    basePv = 60,
    modAttaque = 6.5,
    modDefense = 9.0,
    modVitesse = 8.0,
    modAttaqueSpe = 7.0,
    modDefenseSpe = 10.0,
    modPv = 34.0,
    description = "Petit monstre espiègle rond comme une graine, adore le soleil.",
    particularites = "Sa feuille sur la tête indique son humeur.",
    caracteres = "Curieux, amical, timide"
)

fun main() {



}

/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */
fun changeCouleur(message: String, couleur:String=""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}
