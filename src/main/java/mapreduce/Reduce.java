package mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

@SuppressWarnings("rawtypes")
public class Reduce extends Reducer{
    @SuppressWarnings("unchecked")
	public void reduce(Text key, Iterable<Text> values, Context context) {

        String vertices="";

        for (Text value : values) {
            if(vertices=="")
                vertices+=value.toString();
            else
                vertices=vertices+","+value.toString();         
        }

        Text value=new Text();
        value.set(vertices);
        try {
			context.write(key, value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

