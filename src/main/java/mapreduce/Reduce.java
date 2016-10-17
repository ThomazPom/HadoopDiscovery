package mapreduce;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer{

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		ArrayList<String> fils = new ArrayList<String>();
		Iterator<Text> iterator = values.iterator();
		String color = "BLANC";
		int profondeur = -1;
		while(iterator.hasNext())
		{
			String value = iterator.next().toString();
			String[] split = value.split("\\|");
			fils.addAll(Arrays.asList(split[0]));
		
			if(split[1]=="GRIS" && color == "BLANC")
			{
				color="GRIS";
			}
			if(split[1]=="NOIR" && color != "NOIR")
			{
				color="NOIR";
			}
			int vprofondeur = Integer.parseInt(split[2]);
			if (vprofondeur>profondeur)
			{
				profondeur=vprofondeur;
			}
		}
		context.write(key, String.join(",", fils)+"|"+color+ "|"+profondeur );
		
    	
    	
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

