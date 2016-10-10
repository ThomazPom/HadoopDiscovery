package mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, Text> {

    private Text vertexID = new Text();
    private Text vertice=new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        StringTokenizer itr = new StringTokenizer(line,"\n");
        StringTokenizer itrInside;



        while (itr.hasMoreTokens()) {
            if(itr.countTokens() > 2){

            }//ignore first line ??
            else{
                itrInside=new StringTokenizer(itr.toString());
                vertexID.set(itr.nextToken());

                while(itrInside.hasMoreTokens()){               
                    vertice.set(itrInside.nextToken());
                    context.write(vertexID, value);
                }           
            }
        }

    }

}

