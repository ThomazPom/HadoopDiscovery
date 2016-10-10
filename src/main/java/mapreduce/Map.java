package mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<Text, Text, Text, Text> {

    private Text vertexID = new Text();
    private Text vertice=new Text();

    public void map(Text key, Text value, Context context) throws IOException, InterruptedException {
    	String[] mynode = value.toString().split("|");
    	int myprofondeur = Integer.parseInt(mynode[2]);
    	
    	
    	
    	if(mynode[1].equals("GRIS")){
    		String[] childnodes = mynode[0].split(",");
    		
    		for (String idchild : childnodes) {
    		
    			
    			context.write(new Text(idchild), new Text("\t|GRIS|"+(myprofondeur+1)));
    		}
    		
    		context.write(key, new Text( value.toString().replace("GRIS", "NOIR")));
    	}
    	else{
    		context.write(key, value);
    	}
    	
    	
    		/*SI NODE.COULEUR=="GRIS":
 			POUR CHAQUE FILS DANS NODE.CHILDREN:
 			FILS.COULEUR="GRIS"
 			FILS.PROFONDEUR=NODE.PROFONDEUR+1
 			RENVOYER (FILS.ID;FILS)
			NODE.COULEUR="NOIR"
			RENVOYER (NODE.ID;NODE)*/
    	
    }
}