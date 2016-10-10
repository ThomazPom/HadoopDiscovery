package mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer{

	public void reduce(Text key, Iterable<Text> values, Context context) {

		
    	
    	
/*H_CHILDREN=""; H_PROF=-1; H_COULEUR="BLANC";
POUR CHAQUE VALEUR:
 SI VALEUR.CHILDREN.LENGTH()>H_CHILDREN.LENGTH():
 H_CHILDREN=VALEUR.CHILDREN
 SI VALEUR.PROFONDEUR>H_PROF:
 H_PROF=VALEUR.PROFONDEUR
 SI VALEUR.COULEUR>H_COULEUR:
 H_COULEUR=VALEUR.COULEUR
NODE=NOUVEAU NOEUD
NODE.COULEUR=H_COULEUR
NODE.CHILDREN=H_CHILDREN
NODE.PROFONDEUR=H_PROF
RENVOYER(CLEF;NODE)*/
    }
}

