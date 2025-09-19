package monstre
import kotlin.random.Random
import org.example.dresseur.Entraineur

class individuMonstre(
    var id : Int,
    var nom : String,
    var espece : EspeceMonstre,
    var entraineur: Entraineur?= null,
    expInit : Double){

    var niveau : Int = 1
    var attaque : Int = espece.baseAttaque + listOf(-2, 2).random()
    var defense : Int = espece.baseDefense + listOf(-2, 2).random()
    var vitesse : Int = espece.baseVitesse + listOf(-2, 2).random()
    var attaqueSpe : Int = espece.baseAttaqueSpe + listOf(-2, 2).random()
    var defenseSpe : Int = espece.baseDefenseSpe + listOf(-2, 2).random()
    var pvMax : Int = espece.basePv + listOf(-5, 5).random()
    var potentiel : Double = Random.nextDouble(0.5,2.000001)
    var exp : Double = 0.0
    /**
     *  @property pv  Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv : Int = pvMax
        get() = field
        set(nouveauPv) {
            field=nouveauPv
        }


}