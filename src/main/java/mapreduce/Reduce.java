package mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Reduce{
    @SuppressWarnings("unchecked")
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String vertices="";

        for (Text value : values) {
            if(vertices=="")
                vertices+=value.toString();
            else
                vertices=vertices+","+value.toString();         
        }

        Text value=new Text();
        value.set(vertices);
        context.write(key, value);

    }

}

